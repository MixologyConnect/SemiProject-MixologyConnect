function isScrolledToTop() {
    var scrollTop = window.scrollY || document.documentElement.scrollTop;
    console.log(window.scrollY);
    return scrollTop === 0;
}

window.addEventListener('scroll', function() {
    if (isScrolledToTop()) {
        $("#navBottom").css("transform", "none");
        $("#navBottom").css("filter", "opacity(85%)");
    } else {
        $("#navBottom").css("transform", "translateY(-50px)");
        $("#navBottom").css("filter", "opacity(0%)");
    }
});

$("nav > div").hover(function() {
    $("#navBottom").css("transform", "none");
    $("#navBottom").css("filter", "opacity(85%)");
}, function () {
    if (!isScrolledToTop()) {
        $("#navBottom").css("transform", "translateY(-50px)");
        $("#navBottom").css("filter", "opacity(0%)");
    }
});

$("#navBottom > a").hover(function() {
    $("nav > div").css("borderColor", "rgb(0, 220, 244)");
}, function () {
    $("nav > div").css("borderColor", "lightgray");
});

$("#login").change(function() {
    alert("asdf");
})