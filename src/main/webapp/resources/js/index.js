(function(){

    $.ajax({
        url: getContextPath() + "/board/Top4Board",
        type:"post",
        dataType : "JSON",
    
        success : function(Top4Board){
            for (let i of Top4Board) {
                console.log(i);
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