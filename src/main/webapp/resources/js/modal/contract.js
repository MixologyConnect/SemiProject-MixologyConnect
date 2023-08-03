$("#modal-contract-button").click(function() {
    if ($(".modal-contract-checks:checked").length >= 2) {
        showModal("contract", false);
        showModal("signup", true);
    }
});