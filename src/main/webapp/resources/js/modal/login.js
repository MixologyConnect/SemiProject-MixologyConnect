$("#account-cbox").change(function() {
    if ($(this).prop("checked")) showModal("login", true);
    else showModal("login", false);
});

$("#modal-login > a").click(function() {
    showModal("login", false);
    showModal("contract", true);
});