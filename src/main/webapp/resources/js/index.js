(function(){

    $.ajax({
        url: getContextPath() + "/board/Top4Board",
        type:"post",
        dataType : "JSON",
    
        success : function(Top4Board){
            let l = 0;
            for (let i of Top4Board) {
                if (l == 4) break;
                let li = document.createElement("li");
                li.innerHTML = `<li><a>
                                <img src="` + getContextPath() + i.thumbnail + `">
                                <div>` + i.boardTitle + `</div>
                                </a></li>`;
                $(".contents-board").append(li);
                l++;
            }
        },
    
        error : function(){
            console.log("오류발생")
        }
    })
})();

(function(){
    const column = document.querySelector(".columnContents")
    $.ajax({
        url : contextPath + "/column/columnList",
        data : {"type":3},
        type : "post",
        dataType : "json",
        success : function(columnList){
            let l = 0;
            for (let i of columnList) {
                if (l == 4) break;
                let li = document.createElement("li");
                li.innerHTML = `<li><a>
                                <img src="` + getContextPath() + i.thumbnail + `">
                                <div>` + i.boardTitle + `</div>
                                </a></li>`;
                $(".contents-column").append(li);
                l++;
            }
        },
        error : function(columnList){
            console.log("에러발생")
            console.log(columnList)
        }
    })
})();