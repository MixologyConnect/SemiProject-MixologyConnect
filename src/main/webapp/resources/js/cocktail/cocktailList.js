let timer;
let page = 0;

function thumbnails() {
    if(!timer) {
        console.log("sdfg");
        timer = setTimeout(() => {
            $.ajax({
                url : "list",
                type : "post",
                data : {"no" : ++page},
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

(() => {
    thumbnails();
})();

window.addEventListener("scroll", function(e) {
    if(getScrollY() >= document.documentElement.scrollHeight - window.innerHeight - 30) thumbnails();
});