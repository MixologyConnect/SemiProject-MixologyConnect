let timer;
let mode = 0;
let page = 0;

function thumbnails() {
    if(!timer) {
        timer = setTimeout(() => {
            $.ajax({
                url : "list",
                type : "post",
                data : {"mode": "update",
                        "no" : ++page},
                dataType : "JSON",
                success : function(result) {
                    const e = $("#contents");
                    for (let i of result) {
                        let li = document.createElement("li");
                        li.innerHTML = `<a href='detail?no=` + i.cocktailNo + `'>
                                        <img src='..` + i.imagePath + `'>
                                        <div></div>
                                        <div><p>` + i.cocktailName + `</p></div>
                                        </a>`;
                        e.append(li);
                    }
                }
            });
            timer = null;
        }, 1000);
    }
}

$("#search > img").click(function() {
    const e = $("#contents");
    let ingredients = [];
    $("[class='radio-ingredient']:checked").each(function() { ingredients.push($(this).val());});
    console.log(ingredients);
    if (!ingredients.length) {
        e.empty();
        thumbnails();
        mode = 0;
    }
    $.ajax({
        url : "list",
        type : "post",
        data : {"mode": "search",
                "ingredients": ingredients + "",
                "alcohol": $("[name='alcohol']:checked").val(),
                "sugar": $("[name='sugar']:checked").val()},
        dataType : "json",
        success: function(result) {
            e.empty();
            for (let i of result) {
                let li = document.createElement("li");
                li.innerHTML = `<a href='detail?no=` + i.cocktailNo + `'>
                                <img src='..` + i.imagePath + `'>
                                <div></div>
                                <div><p>` + i.cocktailName + `</p></div>
                                </a>`;
                e.append(li);
                mode = 1;
                page = 0;
            }
        }
    });
});


(() => {
    thumbnails();
})();

window.addEventListener("scroll", function(e) {
    if(getScrollY() >= document.documentElement.scrollHeight - window.innerHeight - 30 && mode == 0) thumbnails();
});
