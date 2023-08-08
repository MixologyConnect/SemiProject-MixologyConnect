(function(){

    $.ajax({
        url: getContextPath() + "/board/Top4Board",
        type:"post",
        dataType : "JSON",
    
        success : function(Top4Board){
            console.log(Top4Board)
    
        },
    
        error : function(Top4Board){
            console.log("오류발생")
        }
    })
})()