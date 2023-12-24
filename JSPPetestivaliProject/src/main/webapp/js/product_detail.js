/**
 * 
 */

 window.onload=function(){
	let subimgArr=document.querySelectorAll('.detail_sub_image .col-2 img')
	let mainimg=document.querySelector('.customimage')
	const realmain=mainimg.src;
	let boundary=document.querySelector('.detail_sub_image'); //서브이미지를 전체 감싸고 있는 div
	
	if(subimgArr.length>1){
	subimgArr.forEach(function(subimg){
			
			
			subimg.addEventListener('mouseover',function(){
				if(this.src===subimgArr[0].src){
					mainimg.src=realmain;
					
				}
				else{mainimg.src=this.src;}
				
				
			})
			
			boundary.addEventListener('mouseout', function(event) {
			      const bounds = boundary.getBoundingClientRect();
			      const x = event.clientX;
			      const y = event.clientY;

			      if (x < bounds.left || x > bounds.right || y < bounds.top || y > bounds.bottom) {
			    	  mainimg.src = realmain;
			      }
			    });
			
			
	})
	
	}
}