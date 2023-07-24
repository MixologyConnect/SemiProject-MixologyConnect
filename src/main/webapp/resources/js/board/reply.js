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











