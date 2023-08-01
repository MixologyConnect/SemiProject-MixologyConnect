

// if(cnt%2==1) {
//     img.src = contextPath + "/resources/images/bookmark-fill.svg";
// }else {
//     img.src = contextPath + "/resources/images/bookmark.svg";
// }
// cnt++;

// 북마크 버튼 이미지
const img = document.getElementById("bookBtnImg");

function bookBtnClick() {
    if(loginMemberNo==""){
        alert("로그인후 이용해주세요.")
    }else{
        bookMarkInsert();
        
        

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
                    img.src = contextPath + "/resources/images/bookmark-fill.svg";
                }else{
                    alert("북마크 등록 실패..")
                    let bkNum = 0;
                    img.src = contextPath + "/resources/images/bookmark.svg";
                }

            }catch(e){
                let bkNum = 0;
            }
        
            
        },
        error : function(){
            let bkNum = 0;
            
        }
        })

    }





function bookMarkImage(){

    const params = new URL(location.href).searchParams;
    const boardNo = params.get("no")

    console.log(boardNo)


    $.ajax({

        url : contextPath + "/myPage/bookMarkImage",
        data : {"boardNo" : boardNo},
        type : "get",

        success : function(result){
            console.log(result)
            if(result > 0){
                img.src = contextPath + "/resources/images/bookmark-fill.svg";
            }else{
                img.src = contextPath + "/resources/images/bookmark.svg";
            }
        },

        error : function(){
            console.log("에러")
        }



    })





}




