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

$("#sub-nav > a").hover(function() {
    $("header").css("borderColor", "rgb(0, 220, 244)");
}, function () {
    $("header").css("borderColor", "lightgray");
});

function getContextPath() {
    var hostIndex = location.href.indexOf( location.host ) + location.host.length;
    return location.href.substring( hostIndex, location.href.indexOf("/", hostIndex + 1) );
};

function receiveMessage(receiver) {
    $.ajax({
        url: getContextPath() + "/chat/receive",
        type: "post",
        data: { "receiver" : 0 },
        dataType: "JSON",
        success: function(result) {
            if (result == "") return;
            if (receiver == result[0].sender.memberNo) return;
            const e = $("#community-input > input");
            const message = document.createElement("div");
            message.className = "message message-others";
            message.innerHTML = `<span>` + result[0].sender.memberName + `</span>
                                 <span>` + result[0].message + `</span>`
            const box = $("#community-message");
            box.append(message);
            box.scrollTop(box[0].scrollHeight);
            if ($("#community-checkbox").prop("checked") == true) {
                const a = $("#community-alert")
                a.css("display", "flex");
                a.text(Number(a.text()) + 1);
            }
        }
    })
}

function sendMessage(sender) {
    const e = $("#community-input > input");
    const msg = e.val();
    if (msg == "") return;
    $.ajax({
        url: getContextPath() + "/chat/send",
        type: "post",
        data: { "sender" : sender,
                "message" : msg },
        dataType: "JSON",
        success: function(result) {
            const message = document.createElement("div");
            message.className = "message message-me";
            message.innerHTML = `<span>` + e.val() + `</span>`
            e.val("");
            const box = $("#community-message");
            box.append(message);
            box.scrollTop(box[0].scrollHeight);
        }
    });
}

setInterval(() => {
    receiver = $("#loginMemberNo").val();
    if (receiver != "") receiveMessage(receiver);
}, 1000);

$("#community-input > input").on("keyup",function(key){ 
    if (key.keyCode==13) sendMessage($("#loginMemberNo").val());
}); 

$("#community-checkbox").change(function() {
    if ($("#community-checkbox").prop("checked") == false) {
        const a = $("#community-alert")
        a.css("display", "none");
        a.text("");
    }
});

$("#search-box").focus(function() {
    $("#search-box").css({ "width": "600px",
                           "height": "60px",
                           "border-color": "rgb(0, 220, 244)",
                           "filter": "drop-shadow(0 0 10px rgba(0, 220, 244, 0.2))" });
});

$("#search-box").blur(function() {
    $("#search-box").css({ "width": "",
                           "height": "",
                           "border-color": "",
                           "filter": "" });
});

(function(){

    const column = document.querySelector(".columnContents")

    $.ajax({
        url : contextPath + "/column/columnList",
    
        type : "post",
        dataType : "json",

        success : function(columnList){
            console.log(columnList);

            for(let column of columnList){

                console.log(column.boardTitle)

            }
            
        },
        error : function(columnList){
            console.log("에러발생")
            console.log(columnList)
        }

    })


})();

function searchValidate() {
    if ($("#search-box").val() == "") return false;
    return true;
}