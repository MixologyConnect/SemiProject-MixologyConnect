function verifyEmail3() {
    const a = $("#modal-findPW-alert");
    const e1 = $("#modal-findPW-inputID");
    const e2 = $("#modal-findPW-inputEmail");
    const v1 = e1.val();
    const v2 = e2.val();
    if (!v1.trim().length) {
        $(this).focus;
        a.text("아이디를 입력해 주세요.");
        return;
    }
    if (!v2.trim().length) {
        $(this).focus;
        a.text("이메일을 입력해 주세요.");
        return;
    }
    $.ajax({
        url: "member/findPW",
        type: "post",
        data: {"id": v1,
               "email": v2},
        success: function(result) {
            if (result) {
                showModal("findPW", false);
                showModal("confirmEmail", true);
                $.ajax({
                    url: "email/verify",
                    type: "post",
                    data: {"serv": "findPW", "email": v2},
                    success: function(value) {
                        vrfCode = value;
                    },
                    error: function(e) {
                        $("#modal-confirmEmail-alert").text("메일 서버 연결에 실패했습니다. 잠시 후 다시 시도해 주세요.");
                    }
                });
            }
            else a.text("일치하는 아이디와 이메일이 없습니다.");
        },
        error: function(e) {
            a.text("비밀번호 찾기에 실패했습니다. 잠시 후 다시 시도해 주세요.");
        }
    });
}

function confirmVrfCode3() {
    const a = $("#modal-confirmEmail-alert");
    if ($("#modal-confirmEmail-inputVrfcode").val() == vrfCode) a.text("인증에 성공했습니다.");
    else a.text("인증 번호가 일치하지 않습니다.");
}