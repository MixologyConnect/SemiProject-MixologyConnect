function getScrollY() {
    var scrollY = window.scrollY || document.documentElement.scrollTop;
    return scrollY
}

window.addEventListener('scroll', function() {
    if (getScrollY() <= 0) {
        $("nav").css({"filter": "opacity(100%)",
                      "pointer-events": "auto"});

        $("header").css({"height": "120px",
                         "transform": "translateY(0px)"});

        $("#title").css({"pointer-events": "auto",
                         "filter": "opacity(100%)"});

        $("#account > label > p").css({"pointer-events": "auto",
                                       "filter": "opacity(100%)"});
    } else {
        $("nav").css({"filter": "opacity(0%)",
                      "pointer-events": "none"});

        $("header").css({"height": "120px",
                         "transform": "translateY(-50px)"});

        $("#title").css({"pointer-events": "none",
                         "filter": "opacity(0%)"});

        $("#account > label > p").css({"pointer-events": "none",
                                       "filter": "opacity(0%)"});
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
    if ($(this).prop("checked")) {
        $("#overlay").css({"pointer-events": "auto",
                           "opacity": "100%"});
        $("#account > label > p").css("color", "rgb(0, 220, 244)");
    } else {
        $("#overlay").css({"pointer-events": "none",
                           "opacity": "0"});
        $("#account > label > p").css("color", "");
    }
})