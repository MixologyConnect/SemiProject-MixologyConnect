if (window.matchMedia("(prefers-color-scheme: dark)").matches) document.documentElement.classList.add("dark");
document.getElementById("theme-switch").addEventListener("click",() => {
    document.documentElement.classList.toggle("dark");
})

let scrollY;

function getScrollY() {
    var scrollY = window.scrollY || document.documentElement.scrollTop;
    return scrollY;
}

function preventScroll(b) {
    if (typeof b == "undefined") return scrollY ? true : false;
    if (b) {
        scrollY = getScrollY()
        $("body").css({"position": "fixed",
                       "top": "-" + scrollY + "px"});
        return;
    }
    $("body").css({"position": "",
                   "top": ""});
    window.scrollTo(0, scrollY);
    scrollY = null;
}

window.addEventListener("scroll", function(e) {
    if (getScrollY() <= 0 && preventScroll() == false) {
        $("nav").css({"filter": "opacity(100%)",
                      "pointer-events": "auto"});
        $("header").css({"height": "120px",
                         "transform": "translateY(0px)",
                         "box-shadow": ""});
        $("#title").css({"pointer-events": "auto",
                         "filter": "opacity(100%)"});
        $(".account-image").css("transform", "none");
        $(".account-text").css({"pointer-events": "auto",
                                        "filter": "opacity(100%)"});
    } else {
        $("nav").css({"filter": "opacity(0%)",
                      "pointer-events": "none"});
        $("header").css({"height": "120px",
                         "transform": "translateY(-50px)",
                         "box-shadow": "0 0 20px 4px rgba(0, 0, 0, 0.1)"});
        $("#title").css({"pointer-events": "none",
                         "filter": "opacity(0%)"});
        $(".account-image").css("transform", "translate(23px, -13px)");
        $(".account-text").css({"pointer-events": "none",
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

$("#account-cbox").change(function() {
    if ($(this).prop("checked")) {
        preventScroll(true);
        $("#overlay").css({"pointer-events": "auto",
                           "opacity": "100%"});
        $("#modal-account").css({"pointer-events": "auto",
                                 "opacity": "100%"});
        $(".account-text").css("color", "rgb(0, 220, 244)");
    } else {
        preventScroll(false);
        $("#overlay").css({"pointer-events": "none",
                           "opacity": "0"});
        $("#modal-account").css({"pointer-events": "none",
                                 "opacity": "0"});
        $(".account-text").css("color", "");
    }
})