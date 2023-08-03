let currentModal;

function showOverlay(b) {
    if (b) $("#overlay").css({"pointer-events": "auto",
                              "opacity": "100%"});
    else $("#overlay").css({"pointer-events": "none",
           "opacity": "0"});
}

function showModal(m) {
    if (typeof currentModal != "undefined") currentModal.css({"position": "fixed",
                                                              "pointer-events": "none",
                                                              "opacity": "0"});
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