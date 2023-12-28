/**
 * 
 */

 $(document).ready(function() {
	 
	    let wno = $('#selectWno').attr('data-wno');
    // 댓글 목록을 받아오는 함수
    function getComments() {
     
      

        $.ajax({
            type: 'post',
            url: '../walk/walkReplyAjaxList.do',
            data: { "wno": wno },
            success: function(json) {
                let res = JSON.parse(json);
                let replyAmount = res[0].replyAmount;
                let id = res[0].sessionID;
                let commentListHtml = '<h3 style="margin-bottom:20px;">댓글(' + replyAmount + ')</h3>';

                // 댓글 추가 입력 폼
                if (id !== null) {
                    commentListHtml += '<div class="input-group">' +
                        ' <textarea rows="4" cols="156" name="rcontent" id="rcontent" placeholder="댓글을 입력해주세요" required></textarea>' +
                        ' <div class="row" style="margin-top:5px; margin-left:1010px; margin-bottom:10px;">' +
                        ' <input type="password" size="11" name="password" id="password" placeholder="비밀번호" required>' +
                        ' <input type="button" class="btn btn-sm btn-info" value="등록" style="margin-left:5px;" id="userReplyBtn">' +
                        '</div></div><hr><div class="comment-list">';
                }
                
                if(replyAmount===0){
					commentListHtml+='댓글이 없습니다.</div>'
				}
				else{
                // 기존 댓글 목록
                for(let i=0; i<res.length; i++){
					let vo =res[i];
					commentListHtml+=' <div class="comment" data-index='+i+'>'
									+' <div class="comment-header" style="height:35px;">'
									+'<span>'
									
								if(vo.group_tab>0){
									
										for(let j=1; j<=vo.group_tab; j++){
												commentListHtml+=' &nbsp;&nbsp;&nbsp;'	
										}
											
								}	
								
							commentListHtml+=vo.userid+'</span>'
							+'<div class="comment-actions" style="float:right; height:35px;">'	
						
					if(id===vo.userid){
						commentListHtml+='<button class="modifyBtn btn btn-sm btn-info">수정</button>'
										+' <button class="deleteBtn btn btn-sm btn-info">삭제</button>'
											
					}	
					
					if(id !==vo.userid && id!==null){
						commentListHtml+='  <button class="replyBtn btn btn-sm btn-info">답글</button>'
					}
						
					commentListHtml+='</div>'+'</div>'+'<div class="mainContent">'
					
								if(vo.group_tab>0){
									
										for(let j=1; j<=vo.group_tab; j++){
												commentListHtml+=' &nbsp;&nbsp;&nbsp;'	
										}
											
								}	
					
					commentListHtml+='<span class="mc">'+vo.rcontent+'</span>'
									+'<span style="float:right;" class="dbday">'+vo.dbday+'</span><hr></div>'	
									
					
					commentListHtml+='<div style="display: none;" class="addreply">'
					
									if(vo.group_tab>0){
									
										for(let j=1; j<=vo.group_tab; j++){
												commentListHtml+=' &nbsp;&nbsp;&nbsp;'	
										}
											
								}	
					commentListHtml+='<textarea rows="4" cols="70" name="addcontent" id="addcontent" placeholder="답변을 입력해주세요" required></textarea>'	
									 +'<div class="row" style="margin-top:5px; margin-left:400px; margin-bottom:10px;">'			
									 						
										if(vo.group_tab>0){
									
										for(let j=1; j<=vo.group_tab; j++){
												commentListHtml+=' &nbsp;&nbsp;&nbsp;'	
										}
											
								}	
					commentListHtml+=' <input type="password" size="10" name="addpassword" id="addrpassword" placeholder="비밀번호" required>'
									+'<input type="submit" value="등록"></div></form></div>'
									
								
				//댓글수정
					commentListHtml+='	<div class="dpassword" style="display:none;">'
										
							if(vo.group_tab>0){
									
										for(let j=1; j<=vo.group_tab; j++){
												commentListHtml+=' &nbsp;&nbsp;&nbsp;'	
										}
											
								}	
					commentListHtml+='<input type="password" name="dpassword" placeholder="비밀번호"  required>'	
									+'	<button>삭제</button>'	
									+'</div>'	
									
				//댓글 수정 
				
					commentListHtml+='<div style="display: none;" class="modifyreply">'
					
									if(vo.group_tab>0){
									
										for(let j=1; j<=vo.group_tab; j++){
												commentListHtml+=' &nbsp;&nbsp;&nbsp;'	
										}
											
								}	
								
					commentListHtml+='<textarea rows="4" cols="70" name="upcontent" id="upcontent" required>'+vo.rcontent+'</textarea>'	
									 +'<div class="row" style="margin-top:5px; margin-left:400px; margin-bottom:10px;">'			
									 						
										if(vo.group_tab>0){
									
										for(let j=1; j<=vo.group_tab; j++){
												commentListHtml+=' &nbsp;&nbsp;&nbsp;'	
										}
											
								}
					commentListHtml+=' <input type="password" size="10" name="uppassword" id="uppassword" placeholder="비밀번호" required>'
									+'<input type="submit" value="등록"></div></form></div>'					
									
				}
 
			}
                commentListHtml += '</div>';
                   
                $('.comment-section').html(commentListHtml);
                
              
                
            }
        });
        
           $('.comment-section').on('click', '.replyBtn', function() {
            let index = $(this).closest('.comment').data('index');
            $('.addreply').eq(index).toggle();
            $('.dpassword').eq(index).hide();
            $('.modifyreply').eq(index).hide();
        });

        $('.comment-section').on('click', '.deleteBtn', function() {
            let index = $(this).closest('.comment').data('index');
            $('.dpassword').eq(index).toggle();
            $('.addreply').eq(index).hide();
            $('.modifyreply').eq(index).hide();
        });

        $('.comment-section').on('click', '.modifyBtn', function() {
            let index = $(this).closest('.comment').data('index');
            $('.modifyreply').eq(index).toggle();
            $('.addreply').eq(index).hide();
            $('.dpassword').eq(index).hide();
        });
        
        
      
      
    }
    
    
	
    
   
    function clickBtn(){
     $('.comment-section').on('click', '#userReplyBtn', function() {
    			let pwd=$('#password').val()
    			let rcontent=$('#rcontent').val()
    			
    			$.ajax({
					type:'post',
					url:'walkReplyAjaxAdd.do',
					data:{"pwd":pwd,"rcontent":rcontent,"wno":wno},
					success:function(addJson){
						let addRes=JSON.parse(addJson)
						
						  
						
						
					}
				})
    			
    			 getComments();
		});
    }

    // 댓글 받아오는 함수 호출
    getComments();
  	clickBtn();

    
});




	