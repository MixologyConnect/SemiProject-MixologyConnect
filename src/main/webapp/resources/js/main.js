function getScrollY() {
    var scrollY = window.scrollY || document.documentElement.scrollTop;
    return scrollY
}

window.addEventListener('scroll', function() {
    if (getScrollY() == 0) {
        $("nav").css({"transform": "none",
                    "filter": "opacity(100%)"});
    } else {
        $("nav").css({"transform": "translateY(-45px)",
                    "filter": "opacity(0%)"});
    }
    if (getScrollY() > 166) {
        $("header").css({"height": "70px",
                        "margin-bottom": "50px"});
        $("#title").css({"filter": "opacity(0%)");
        $("#account > label").css("height", "70px")
        $("#account > label > p").text(null);
    } else {
        $("header").css({"height": "120px"
                        , "margin-bottom": "0px"});
        $("#title").css("filter", "opacity(100%)");
        $("#account > label").css("height", "120px")
        $("#account > label > p").text("LOGIN");
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