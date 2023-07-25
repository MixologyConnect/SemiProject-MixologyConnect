function getScrollY() {
    var scrollY = window.scrollY || document.documentElement.scrollTop;
    return scrollY
}

window.addEventListener('scroll', function() {
    if (getScrollY() <= 0) {
        $("nav").css({"transform": "none",
                      "filter": "opacity(100%)",
                      "pointer-events": "auto"});

        $("header").css({"height": "120px",
                         "transform": "translateY(0px)"});

        $("#title").css({"pointer-events": "auto",
                         "filter": "opacity(100%)"});

        $("#account > label").css({"pointer-events": "auto",
                                   "filter": "opacity(100%)"});
    } else {
        $("nav").css({"transform": "translateY(-45px)",
                      "filter": "opacity(0%)",
                      "pointer-events": "none"});

        $("header").css({"height": "120px",
                         "transform": "translateY(-50px)"});

        $("#title").css({"pointer-events": "none",
                         "filter": "opacity(0%)"});

        $("#account > label").css({"pointer-events": "none",
                                   "filter": "opacity(0%)"});
    }
});

$("header, nav").hover(function() {
    $("nav").css({"transform": "none"
    , "filter": "opacity(100%)"});

}, function () {
    if (getScrollY() == 0) {
        $("nav").css({"transform": "translateY(-45px)"
                    , "filter": "opacity(0%)"});
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