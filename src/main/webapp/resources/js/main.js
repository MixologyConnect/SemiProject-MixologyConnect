(() => {
    applyTheme();
})();

document.getElementById("theme-switch").addEventListener("click",() => {
    if (localStorage.getItem("theme") == "dark") localStorage.setItem("theme", "light");
    else localStorage.setItem("theme", "dark");
    applyTheme();
})

function applyTheme() {
    if (localStorage.getItem("theme") == "dark") {
        document.documentElement.classList.add("dark");
    } else if (localStorage.getItem("theme") == "light") {
        document.documentElement.classList.remove("dark");
    } else if (window.matchMedia("(prefers-color-scheme: dark)").matches) {
        localStorage.setItem("theme", "dark");
        document.documentElement.classList.add("dark");
    }
    document.body.style.display = "block";
    setTimeout(() => {
        document.body.style.transitionDuration = "0.8s";
    }, 1000);
}

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
                       "width": "100%",
                       "top": "-" + scrollY + "px"});
        return;
    }
    $("body").css({"position": "",
                   "width": "",
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
        $("#sub-nav").css({"opacity": "",
                           "pointer-events": ""});
        $("#title").css({"pointer-events": "auto",
                         "filter": "opacity(100%)"});
        $(".account-image").css({"height": "",
                                 "transform": "none"});
        $("#logout-button").css({"transform": ""});
        $(".account-text").css({"pointer-events": "auto",
                                        "filter": "opacity(100%)"});
    } else {
        $("nav").css({"filter": "opacity(0%)",
                      "pointer-events": "none"});
        $("header").css({"height": "120px",
                         "transform": "translateY(-50px)",
                         "box-shadow": "0 0 20px 4px rgba(0, 0, 0, 0.1)"});
        $("#sub-nav").css({"opacity": "100%",
                          "pointer-events": "auto"});
        $("#title").css({"pointer-events": "none",
                         "filter": "opacity(0%)"});
        $(".account-image").css({"height": "40px",
                                 "transform": "translate(24px, -14px)"});
        $("#logout-button").css({"transform": "translateX(25px)"});
        $(".account-text").css({"pointer-events": "none",
                                        "filter": "opacity(0%)"});
    }
});

$("nav > a").hover(function() {
    $("header").css("borderColor", "rgb(0, 220, 244)");
    $("nav").css("borderColor", "rgb(0, 220, 244)");
}, function () {
    $("header").css("borderColor", "lightgray");
    $("nav").css("borderColor", "lightgray");
});

$("#sub-nav").hover(function() {
    $("header").css("borderColor", "rgb(0, 220, 244)");
}, function () {
    $("header").css("borderColor", "lightgray");
});

function receiveMessage() {
    $.ajax({
        url: "chat/receive",
        dataType: "json",
        success: function(result) {
            
        }
    })
}

function sendMessage() {
    const e = $("#community-input > input");
    const message = document.createElement("div");
    message.className = "message message-me";
    message.innerHTML = `<span>` + e.val() + `</span>`
    $("#community-message").append(message);
    e.val("");
}

setInterval(() => {
    $.ajax({
        url: "",
        data: {"" : ""},
        success: function(result) {

        }
    })
}, 1000);