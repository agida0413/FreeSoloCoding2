/**
 * 
 */

/**
 * 
 */

window.onload = function() {
    let commentSections = document.querySelectorAll('.comment-section');

    commentSections.forEach(function(commentSection) {
        let replyBtns = commentSection.querySelectorAll('.replyBtn');
        let deleteBtns = commentSection.querySelectorAll('.deleteBtn');
        let modifyBtns = commentSection.querySelectorAll('.modifyBtn');
        let addReplies = commentSection.querySelectorAll('.addreply');
        let dPasswords = commentSection.querySelectorAll('.dpassword');
        let modifyReplies = commentSection.querySelectorAll('.modifyreply');

        replyBtns.forEach(function(replyBtn) {
            replyBtn.addEventListener('click', function(event) {
                let parentComment = event.target.closest('.comment');
                let parentIndex = Array.from(parentComment.parentElement.children).indexOf(parentComment);

                addReplies[parentIndex].style.display = (addReplies[parentIndex].style.display === "none") ? "block" : "none";
                dPasswords[parentIndex].style.display = "none";
                modifyReplies[parentIndex].style.display = "none";
            });
        });

        deleteBtns.forEach(function(deleteBtn) {
            deleteBtn.addEventListener('click', function(event) {
                let parentComment = event.target.closest('.comment');
                let parentIndex = Array.from(parentComment.parentElement.children).indexOf(parentComment);

                dPasswords[parentIndex].style.display = (dPasswords[parentIndex].style.display === "none") ? "block" : "none";
                addReplies[parentIndex].style.display = "none";
                modifyReplies[parentIndex].style.display = "none";
            });
        });

        modifyBtns.forEach(function(modifyBtn) {
            modifyBtn.addEventListener('click', function(event) {
                let parentComment = event.target.closest('.comment');
                let parentIndex = Array.from(parentComment.parentElement.children).indexOf(parentComment);

                modifyReplies[parentIndex].style.display = (modifyReplies[parentIndex].style.display === "none") ? "block" : "none";
                addReplies[parentIndex].style.display = "none";
                dPasswords[parentIndex].style.display = "none";
            });
        });
    });
};