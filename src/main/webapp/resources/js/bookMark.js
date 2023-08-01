const bookMarkBtn = document.getElementById("bookBtnImg")

bookMarkBtn.addEventListener("click", function(){
   
    bookMarkInsert();

    if(bkNum == 1){
        const img = document.getElementById("bookBtnImg");
        img.src = contextPath + "/resources/images/bookmark-fill.svg";
    } else{
        img.src = contextPath + "/resources/images/bookmark.svg";
    }

        
    
    
    
    
})

function bookBtnClick() {
    if(loginMemberNo==""){
        alert("로그인후 이용해주세요.")
    }else{
        const img = document.getElementById("bookBtnImg");
        img.src = contextPath + "/resources/images/bookmark-fill.svg";
    
        if(cnt%2==1) {
            img.src = contextPath + "/resources/images/bookmark-fill.svg";
        }else {
            img.src = contextPath + "/resources/images/bookmark.svg";
        }
        cnt++;

    }
    

}



function bookMarkInsert(){

    const params = new URL(location.href).searchParams;
    const boardNo = params.get("no")

    console.log(boardNo)

    $.ajax({

        url : contextPath + "/myPage/bookMarkInsert",
        data : {"boardNo" : boardNo},
        type : "get",

        success : function(result){
            try{
                if(result > 0){
                    alert("북마크 등록완료")
                    let bkNum = 1;
                }else{
                    alert("북마크 등록 실패..")
                    let bkNum = 0;
                }

            }catch(e){
                alert("북마크 등록 실패..")
                let bkNum = 0;
            }
        
            
        },
        error : function(){
            alert("북마크 등록 실패..")
            let bkNum = 0;
            
        }
        })

    }




