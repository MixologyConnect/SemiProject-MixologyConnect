const modal = $("#modal");
let currentModal;

function showOverlay(b) {
    if (b) $("#overlay").css({"pointer-events": "auto",
                              "opacity": "100%"});
    else $("#overlay").css({"pointer-events": "none",
           "opacity": "0"});
}

function showModal(m, b) {
    preventScroll(b);
    showOverlay(b);
    const modalContent = $("#modal-" + m);
    if (b) {
        currentModal = modalContent;
        modal.width(modalContent.width());
        modal.height(modalContent.height());
        currentModal.css({"position": "relative",
                          "pointer-events": "auto",
                          "opacity": "100%"});
    } else {
        modal.width(300);
        modal.height(400);
        currentModal.css({"position": "fixed",
                          "pointer-events": "none",
                          "opacity": "0"});
    }
    switch (m + ":" + b) {
        case "login:true" : $(".account-text").css("color", "rgb(0, 220, 244)"); break;
        case "login:false" : $(".account-text").css("color", ""); break;
    }
}

$("#account-cbox").change(function() {
    if ($(this).prop("checked")) showModal("login", true);
    else showModal("login", false);
});

$("#modal-login > a").click(function() {
    showModal("login", false);
    showModal("contract", true);
});

$("#modal-contract-button").click(function() {
    if ($(".modal-contract-checks:checked").length >= 2) {
        showModal("contract", false);
        showModal("signup", true);
    }
})

function verifyEmail() {
    let email = $("#modal-signup-email").val();
    $.ajax({
        url: "email/verify",
        type: "post",
        data: {"serv": "signUp",
               "email": email},
        error: function(e) {
            alert("오류가 발생했습니다. 잠시 후 다시 시도해 주세요.");
        }
    });
}