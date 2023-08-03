$("#account-cbox").change(function() {
    if ($(this).prop("checked")) showModal("login", true);
    else showModal();
});

$("#modal-login-singup").click(function() {
    showModal("login", false);
    showModal("contract", true);
});

$("#modal-login-findID").click(function() {
    showModal("login", false);
    showModal("findID", true);
});

$("#modal-login-findPW").click(function() {
    showModal("login", false);
    showModal("findPW", true);
});