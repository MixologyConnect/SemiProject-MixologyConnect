let mode;

function verifyEmail2() {
    const a = $("#modal-findID-alert");
    const e1 = $("#modal-findID-inputName");
    const e2 = $("#modal-findID-inputEmail");
    const v1 = e1.val();
    const v2 = e2.val();
    if (!v1.trim().length) {
        $(this).focus;
        a.text("이름을 입력해 주세요.");
        return;
    }
    if (!v2.trim().length) {
        $(this).focus;
        a.text("이메일을 입력해 주세요.");
        return;
    }
    $.ajax({
        url: "member/findID",
        type: "post",
        data: {"name": v1,
               "email": v2},
        success: function(result) {
            if (result == false ? false : true) {
                showModal("findID", false);
                showModal("confirmEmail", true);
                $.ajax({
                    url: "email/verify",
                    type: "post",
                    data: {"serv": "findID", "email": v2},
                    success: function(value) {
                        vrfCode = value;
                    },
                    error: function(e) {
                        $("#modal-confirmEmail-alert").text("메일 서버 연결에 실패했습니다. 잠시 후 다시 시도해 주세요.");
                    }
                });
                mode = "findID";
                id = result;
            }
            else a.text("일치하는 이름과 이메일이 없습니다.");
        },
        error: function(e) {
            a.text("아이디 찾기에 실패했습니다. 잠시 후 다시 시도해 주세요.");
        }
    });
}