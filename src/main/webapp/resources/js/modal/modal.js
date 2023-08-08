let currentModal;

function showOverlay(b) {
    if (b) $("#overlay").css({"pointer-events": "auto",
                              "opacity": "100%"});
    else $("#overlay").css({"pointer-events": "none",
           "opacity": "0"});
}

function showModal(m) {
    if (typeof currentModal != "undefined") {
        currentModal.css({"position": "fixed",
                          "pointer-events": "none",
                          "opacity": "0"});
        document.querySelectorAll("#" + currentModal.attr("id") + " input[type='text'], #" + currentModal.attr("id") + " input[type='password']").forEach(input => {
            input.value = "";
        });
    }
    if (typeof m != "undefined") {
        preventScroll(true);
        showOverlay(true);
        currentModal = $("#modal-" + m);
        refreshModal(m);
        currentModal.css({"position": "relative",
                          "pointer-events": "auto",
                          "opacity": "100%"});
        return;
    }
    currentModal.css({"position": "fixed",
                      "pointer-events": "none",
                      "opacity": "0"});
    document.querySelectorAll("#" + currentModal.attr("id") + " input[type='text'], #" + currentModal.attr("id") + " input[type='password']").forEach(input => {
        input.value = "";
    });
    preventScroll(false);
    showOverlay(false);
    //switch (m + ":" + b) {}
}

function refreshModal(m) {
    const modal = $("#modal");
    if (typeof m == "undefined") {
        modal.width(300);
        modal.height(400);
        return;
    }
    const modalContent = $("#modal-" + m);
    modal.width(modalContent.width());
    modal.height(modalContent.height());
}

function confirmVrfCode2() {
    const e = $("#modal-confirmEmail-inputVrfcode");
    const a = $("#modal-confirmEmail-alert");
    if (e.val() == vrfCode) {
        e.css("display", "none");
        const modalBtn = $("#modal-confirmEmail-button");

        modalBtn.text("로그인 창으로");

        switch (mode) {
        case "findID" :
            a.html("인증에 성공했습니다.<br>당신의 아이디는 " + id + " 입니다.");
            break;
        case "findPW" :
            a.html("인증에 성공했습니다.<br>다음 임시 비밀번호로 로그인하여 주세요.<br>" + pw);
             modalBtn.click(function(){
                showModal("login");
            }); 
        }
    }
    else a.text("인증 번호가 일치하지 않습니다.");
}