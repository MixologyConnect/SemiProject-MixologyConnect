function isScrolledToTop() {
    var scrollTop = window.scrollY || document.documentElement.scrollTop;
    console.log(window.scrollY);
    return scrollTop === 0;
}

window.addEventListener('scroll', function () {
    if (isScrolledToTop()) {
        $("#nav-bottom").css("transform", "none");
        $("#nav-top").css("filter", "opacity(100%)");
        $("#nav-bottom").css("filter", "opacity(100%)");
    } else {
        $("#nav-bottom").css("transform", "translateY(-6vh)");
        $("#nav-top").css("filter", "opacity(100%)");
        $("#nav-bottom").css("filter", "opacity(0%)");
    }
});

$("nav > div").hover(function () {
    $("#nav-bottom").css("transform", "none");
    $("#nav-bottom").css("filter", "opacity(90%)");
    $("nav > div").css("borderColor", "rgb(0, 220, 244)");
}, function () {
    $("nav > div").css("borderColor", "lightgray");
    if (!isScrolledToTop()) {
        $("#nav-bottom").css("transform", "translateY(-6vh)");
        $("#nav-bottom").css("filter", "opacity(0%)");
    }
});

$(".nav-link").hover(function () {
    $(this).parent().css("border-bottom", "rgb(0, 220, 244) solid 5px");
    //$(this).css("background-image", "linear-gradient(0deg, rgb(0, 220, 244), transparent 50%)");
}, function () {
    $(this).parent().css("border-bottom", "transparent solid 0px");
    //$(this).css("background-image", "none");
});