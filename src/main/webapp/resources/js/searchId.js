function searchId(){

    



    $.ajax({
        url : contextPath + "/member/searchId",
        data : {"memberName" : memberName,
                "memberTel" : memberTel},
        type : "get",
        success : function(result){
            if(result>0){
                alert("mmm")

            }
        },
        error : function(req, status, error){
            console("에러발생");
            console.log(req.respinseText);
        }
    })
}