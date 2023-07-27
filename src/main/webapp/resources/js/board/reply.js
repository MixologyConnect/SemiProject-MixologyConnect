

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
replyContent = document.getElementById("replyContent")


addBtn.addEventListener("click", function () {

    if (loginMemberNo == "") {
        alert("로그인 후 이용해주세요.")
        return;
    }


    if (replyContent.value.trim().length == 0) {
        alert("댓글을 작성한 후 버튼을 클릭해주세요.");
        this.value = "";
        this.focus();
        return;
    }


    $.ajax({


        url: contextPath + "/reply/insert",
        data: {
            "replyContent": replyContent.value,
            "memberNo": loginMemberNo,
            "boardNo": boardNo
        },
        type: "post",

        success: function (result) {

            if (result > 0) {
                alert("댓글이 등록되었습니다.")
                selectReplyList();
            } else {
                alert("댓글 등록을 실패하였습니다.")

            }

        },

        error: function (req, status, error) {
            console.log("댓글 등록 실패")
            console.log(req.responsText);
        }
    });

})


function deleteReply(replyNo) {

    if (confirm("댓글을 삭제하시겠습니까?")) {

        $.ajax({

            url: contextPath + "/reply/delete",
            data: { "replyNo": replyNo },
            type: "get",

            success: function (result) {

                if (result > 0) {
                    alert("댓글이 삭제되었습니다.");
                    selectReplyList();

                } else {
                    alert("삭제 실패하였습니다.")
                }
            },

            error: function (req, status, error) {
                console.log("댓글 삭제 실패")
                console.log(req.responsText);
            }
        });
    }
}

let beforeReplyRow;

function showUpdateReply(replyNo, btn) {
    const temp = document.getElementsByClassName("update-textarea");

    if (temp.length > 0) {

        if (confirm("다른 댓글 수정 중입니다. 현재 댓글을 수정하시겠습니까?")) {
            temp[0].parentElement.innerHTML = beforeReplyRow;
        } else {
            return;
        }

    }

    const replyRow = btn.parentElement.parentElement;
    beforeReplyRow = replyRow.innerHTML;
    let beforeContent = replyRow.children[1].innerHTML;
    replyRow.innerHTML = "";
    const textarea = document.createElement("textarea");
    textarea.classList.add("update-textarea");

    beforeContent = beforeContent.replaceAll("&amp;", "&");
    beforeContent = beforeContent.replaceAll("&lt;", "<");
    beforeContent = beforeContent.replaceAll("&gt;", ">");
    beforeContent = beforeContent.replaceAll("&quot;", "\"");

    beforeContent = beforeContent.replaceAll("<br>", "\n");

    textarea.value = beforeContent;
    replyRow.append(textarea);

    const replyBtnArea = document.createElement("div");
    replyBtnArea.classList.add("reply-btn-area");

    const updateBtn = document.createElement("button");
    updateBtn.innerText = "수정";
    updateBtn.setAttribute("onclick", "updateReply(" + replyNo + ", this)");

    const cancelBtn = document.createElement("button");
    cancelBtn.innerText = "취소";
    cancelBtn.setAttribute("onclick", "updateCancel(this)");

    replyBtnArea.append(updateBtn, cancelBtn);
    replyRow.append(replyBtnArea);
}

// 댓글 수정 취소
function updateCancel(btn) {
    if (confirm("댓글 수정을 취소하시겠습니까?")) {
        btn.parentElement.parentElement.innerHTML = beforeReplyRow;
    }
}


// 댓글 수정(AJAX)
function updateReply(replyNo, btn){

    const replyContent = btn.parentElement.previousElementSibling.value;

    $.ajax({
        url : contextPath + "/reply/update",
        data : {"replyNo" : replyNo,
                "replyContent" : replyContent},
        type : "post",
        success : function(result){
            if(result > 0){
                alert("댓글이 수정되었습니다.");
                selectReplyList();

            }else{
                alert("댓글 수정을 실패하였습니다.");
            }
        },

        error : function(req, status, error){
            console.log("댓글 수정 실패");
            console.log(req.responsText);
        }

    });

}

