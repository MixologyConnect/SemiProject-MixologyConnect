function isScrolledToTop() {
    var scrollTop = window.scrollY || document.documentElement.scrollTop;
    return scrollTop === 0;
}

window.addEventListener('scroll', function() {
    if (isScrolledToTop()) {
        $("nav").css("transform", "none");
        $("nav").css("filter", "opacity(100%)");
    } else {
        $("nav").css("transform", "translateY(-45px)");
        $("nav").css("filter", "opacity(0%)");
    }
});

$("header, nav").hover(function() {
        $("nav").css("transform", "none");
        $("nav").css("filter", "opacity(100%)");

}, function () {
    if (!isScrolledToTop()) {
        $("nav").css("transform", "translateY(-45px)");
        $("nav").css("filter", "opacity(0%)");
    }
});

$("nav > a").hover(function() {
    $("header").css("borderColor", "rgb(0, 220, 244)");
    $("nav ").css("borderColor", "rgb(0, 220, 244)");
}, function () {
    $("header").css("borderColor", "lightgray");
    $("nav").css("borderColor", "lightgray");
});

$("#login").change(function() {
    alert(this.prop("checked"));
})