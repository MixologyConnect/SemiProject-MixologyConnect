function selectReplyList() {
    $.ajax({

        url: contextPath + "/reply/selectReplyList",
        data: { "boardNo": boardNo },
        type: "get",
        dataType: "JSON",

        success: function (rList) {
            const replyList = document.getElementById("reply-list")
            replyList.innerHTML = "";

            for (let reply of rList) {
                const replyRow = document.createElement("li");
                replyRow.classList.add("reply-row");

                const replyWriter = document.createElement("p");
                replyWriter.classList.add("reply-writer");

                // 왜 innerHTML? <br> 태그 인식을 위해서
                replyContent.innerHTML = reply.replyContent;

                // 행에 작성자, 내용 영역 추가
                replyRow.append(replyWriter, replyContent);

                // 로그인한 회원 번호와 댓글 작성자의 회원 번호가 같을 때만 추가
                if (loginMemberNo == reply.memberNo) {
                    // 버튼 영역
                    const replyBtnArea = document.createElement("div");
                    replyBtnArea.classList.add("reply-btn-area");

                    // 수정 버튼
                    const updateBtn = document.createElement("button");
                    updateBtn.innerText = "수정";
                    // 수정 버튼에 onclick 이벤트 속성 추가
                    updateBtn.setAttribute("onclick", "showUpdateReply(" + reply.replyNo + ", this)");

                    // 삭제 버튼
                    const deleteBtn = document.createElement("button");
                    deleteBtn.innerText = "삭제";
                    // 삭제 버튼에 onclick 이벤트 속성 추가
                    deleteBtn.setAttribute("onclick", "deleteReply(" + reply.replyNo + ")");

                    // 버튼 영역 마지막 자식으로 수정/삭제 버튼 추가
                    replyBtnArea.append(updateBtn, deleteBtn);

                    // 행에 버튼 영역 추가
                    replyRow.append(replyBtnArea);
                }

                // 댓글 목록(ul)에 행(li)추가
                replyList.append(replyRow);
            }
        },
        error: function () {
            console.log("에러 발생");
        }
    })
}











function selectReplyList() {
    $.ajax({

        url: contextPath + "/reply/selectReplyList",
        data: { "boardNo": boardNo },
        type: "get",
        dataType: "JSON",

        success: function (rList) {
            console.log(rList);
            const replyList = document.getElementById("reply-list")
            replyList.innerHTML = "";

            for (let reply of rList) {
                const replyRow = document.createElement("li");
                replyRow.classList.add("reply-row");

                const replyWriter = document.createElement("p");
                replyWriter.classList.add("reply-writer");

                // 왜 innerHTML? <br> 태그 인식을 위해서
                replyContent.innerHTML = reply.replyContent;

                // 행에 작성자, 내용 영역 추가
                replyRow.append(replyWriter, replyContent);

                // 로그인한 회원 번호와 댓글 작성자의 회원 번호가 같을 때만 추가
                if (loginMemberNo == reply.memberNo) {
                    // 버튼 영역
                    const replyBtnArea = document.createElement("div");
                    replyBtnArea.classList.add("reply-btn-area");

                    // 수정 버튼
                    const updateBtn = document.createElement("button");
                    updateBtn.innerText = "수정";
                    // 수정 버튼에 onclick 이벤트 속성 추가
                    updateBtn.setAttribute("onclick", "showUpdateReply(" + reply.replyNo + ", this)");

                    // 삭제 버튼
                    const deleteBtn = document.createElement("button");
                    deleteBtn.innerText = "삭제";
                    // 삭제 버튼에 onclick 이벤트 속성 추가
                    deleteBtn.setAttribute("onclick", "deleteReply(" + reply.replyNo + ")");

                    // 버튼 영역 마지막 자식으로 수정/삭제 버튼 추가
                    replyBtnArea.append(updateBtn, deleteBtn);

                    // 행에 버튼 영역 추가
                    replyRow.append(replyBtnArea);
                }

                // 댓글 목록(ul)에 행(li)추가
                replyList.append(replyRow);
            }
        },
        error: function () {
            console.log("에러 발생");
        }
    })
}


//-------------------------------------------------------------


// 댓글 등록

const addBtn = document.getElementById("addBtn");
replyContent = document.getElementById("reply-Content")


addBtn.addEventListener("click", function(){

    if(loginMemberNo == null){
        alert("로그인 후 이용해주세요.")
        return;
    }


    if(loginMemberNo == ""){ 
        alert("로그인 후 이용해주세요.");

        return;
    }

    if(replyContent.value.trim().length == 0){
        alert("댓글을 작성한 후 버튼을 클릭해주세요.");
        this.value = ""; 
        this.focus();
        return;
    }


    $.ajax({



        url : contextPath + "/reply/insert",
        data : {"replyContent" : replyContent.value,
                "memberNo" : loginMemberNo,
                "boardNo" : boardNo},
        type : "post",
        
        success : function(result) {

            if(result > 0){
                alert("댓글이 등록되었습니다.")
                selectReplyList();
            }else{
                alert("댓글 등록을 실패하였습니다.")

            }

        },

        error : function(req, status, error){
            console.log("댓글 등록 실패")
            console.log(req.responsText);
        }

    });



})








