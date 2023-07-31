const bookMarkBtn = document.getElementById("bookBtnImg")

bookMarkBtn.addEventListener("click", function(){

    // 현재 머물고 있는 페이지 주소의 쿼리스트링을 가져옴
    const params = new URL(location.href).searchParams;

    const boardNo = params.get("no")

    console.log(boardNo);

    $.ajax({

        url : contextPath + "/myPage/bookMarkList",
        data : {"boardNo" : boardNo},
        type : "GET",
        dataType : "JSON" ,

        
        success : function(bookMark){
            console.log(bookMark)
        } ,
        
        error : function(req, status, error){
            console.log("댓글 삭제 실패")
            console.log(req.responseText)
            
        }
        
        
    })
    
})