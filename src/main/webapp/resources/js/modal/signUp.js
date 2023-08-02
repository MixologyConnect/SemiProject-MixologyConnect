let vrfCode;

function verifyEmail() {
    const e = $("#modal-signup-email");
    const email = e.val();
    const s = e.next().next();
    s.text("잠시만 기다려 주세요...");
    $.ajax({
        url: "email/verify",
        type: "post",
        data: {"serv": "signUp", "email": email},
        success: function(value) {
            vrfCode = value;
            s.text("해당 이메일 주소로 인증 번호를 전송했습니다.");
            $(".modal-signup-vrfcode-hide").css("display", "block")
        },
        error: function(e) {
            alert("오류가 발생했습니다. 잠시 후 다시 시도해 주세요.");
        }
    });
}

function confirmVrfCode() {
    const e = $("#modal-signup-vrfcode");
    const s = e.next().next();
    if (e.val() == vrfCode) {
        s.text("인증에 성공했습니다.");
        s.css("color", "rgb(0, 220, 244)");
        return;
    }
    s.text("인증 번호가 일치하지 않습니다.");
}

function signValidate() {
    const e2 = $("#modal-signup-vrfcode");
    for (let i of $("#modal-signup small")) {
        const e = $(i).prev().prev();
        const id = e.attr("id");
        if (id == "modal-signup-email" || id == "modal-signup-vrfcode") continue;
        if ($(i).text().length) {
            e.focus();
            return false;
        }
    }
    if (e2.css("display") == "none") return false;
    if (e2.next().next().css("color") == "rgb(255, 255, 255)") {
        e2.focus();
        return false;
    }
    return true;
}

$("#modal-signup > table input").on("input", function() {
    const e = $(this);
    const v = e.val();
    const s = e.next().next();
    if (!v.trim().length) {
        s.text("");
        return;
    }
    switch (e.attr("name")) {
    case "memberName":
        if (/^[가-힣]{2,10}$/.test(v)) {
            s.text("");
            return;
        }
        s.text("유효하지 않은 이름입니다.");
        return;
    case "memberId":
        if (/^(?=.*[A-Za-z]{3})[A-Za-z\d]{5,}$/.test(v)) {
            $.ajax({
                url: "member/idDupCheck", 
                type: "get",
                data: {"memberId": v},
                success : function(result) {
                    if (result == 0) {
                        s.text("");
                        return;
                    }
                    s.text("이미 사용 중인 아이디입니다.");
                    return;
                }
            });
            return;
        }
        s.text("유효하지 않은 아이디입니다.");
        return;
    case "memberPw":
        if (/^[\w!@#_-]{6,30}$/.test(v)) {
            s.text("");
            return;
        }
        s.text("유효하지 않은 비밀번호입니다.");
        return;
    case "memberPwConfirm":
        if (v == $("input[name='memberPw']").val()) {
            s.text("");
            return;
        }
        s.text("비밀번호가 일치하지 않습니다.");
        return;
    case "memberTel":
        if (/^0(1[01679]|2|[3-6][1-5]|70)\d{3,4}\d{4}$/.test(v)) {
            s.text("");
            return;
        }
        s.text("유효하지 않은 전화번호입니다.");
        return;
    case "memberEmail":
        if (/^[\w\-\_]{4,}@[\w\-\_]+(\.\w+){1,3}$/.test(v)) {
            s.text("");
            return;
        }
        s.text("유효하지 않은 이메일입니다.");
    }
});