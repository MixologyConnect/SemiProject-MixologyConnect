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