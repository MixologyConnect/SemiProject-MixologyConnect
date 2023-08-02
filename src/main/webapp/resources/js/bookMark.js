
// 북마크 버튼 이미지
const imgPlus = document.getElementById("bookBtnImgPlus");
const imgMinus = document.getElementById("bookBtnImgMinus");

let count = 1;

// 즉시실행 함수(북마크 이미지 채워지는지 확인)
(function(){

    // bordDetail 화면 띄우자마자
    // 북마크 해 놓은 페이지에 들어오면 북마크 표시되는 함수 호출
    // bookMarkImage();



    
    console.log("내려와")


})();

// 북마크 등록 
function bookBtnClickPlus(){
    if (confirm("북마크에 등록하시겠습니까?")) {
        bookMarkInsert();
    }
    bookMarkInsert();
}

// 북마크 해제
function bookBtnClickMinus(){
    if (confirm("북마크를 삭제하시겠습니까?")) {
        deleteBookMark();
    } 
}









// function bookBtnClick(){
//     console.log("눌리나?")
// }

// function bookBtnClick(){

   

//         if(count % 2 == 0){
//             console.log("짝")
//             deleteBookMark();
//             img.src = contextPath + "/resources/images/bookmark.svg"
//         } else {
//             console.log("홀")
//             bookMarkInsert();
//             img.src = contextPath + "/resources/images/bookmark-fill.svg"
//         }
//         count += 1;
    
// }




    
/*if(img.src = contextPath + "/resources/images/bookmark.svg"){
    
    function bookBtnClick() {
        
        console.log("없음")
    
        if(count % 2 == 0){
            console.log("삭제")
            deleteBookMark();
            img.src = contextPath + "/resources/images/bookmark.svg"
        } else {
            console.log("등록")
            bookMarkInsert();
            img.src = contextPath + "/resources/images/bookmark-fill.svg"
        }
        count += 1;
    
    
    
        // if(loginMemberNo==""){
        //     alert("로그인후 이용해주세요.")
        // }
    
        
        // if(img.src = contextPath + "/resources/images/bookmark-fill.svg"){
        
        //     return false;
        // }
    
        
    }




}*/






/*if(img.src = contextPath + "/resources/images/bookmark-fill.svg"){
    // console.log("없음")

    function bookBtnClick() {
    
    
        if(count % 2 == 0){
            console.log("삭제")
            deleteBookMark();
            img.src = contextPath + "/resources/images/bookmark.svg"
        } else {
            console.log("등록")
            bookMarkInsert();
            img.src = contextPath + "/resources/images/bookmark-fill.svg"
        }
        count += 1;
    
    
    
        // if(loginMemberNo==""){
        //     alert("로그인후 이용해주세요.")
        // }
    
        
        // if(img.src = contextPath + "/resources/images/bookmark-fill.svg"){
        
        //     return false;
        // }
    
        
    }




}*/










// 북마크 버튼 누르면 데이터 삽입 함수
function bookMarkInsert(){

    const params = new URL(location.href).searchParams;
    const boardNo = params.get("no")

    console.log(boardNo)

    $.ajax({

        url : contextPath + "/myPage/bookMarkInsert",
        data : {"boardNo" : boardNo},
        type : "get",

        success : function(result){
          
            if(result > 0){
                alert("북마크 등록완료")
                let bkNum = 1;
            }else{
                alert("이미 북마크에 등록되어있습니다.")
                let bkNum = 0;
            }

           
        
            
        },
        error : function(){
            let bkNum = 0;
            
        }
        })

}




// 북마크 버튼 이미지 
function bookMarkImage(){

    const params = new URL(location.href).searchParams;
    const boardNo = params.get("no")

    // console.log(boardNo)


    $.ajax({

        url : contextPath + "/myPage/bookMarkImage",
        data : {"boardNo" : boardNo},
        type : "get",

        success : function(result){
            console.log(result)
            if(result > 0){
                console.log("성공")
            }else{
                console.log("에러")
              
            }
        },

        error : function(){
            console.log("에러")
        }



    })





}







// 북마크 해제
function deleteBookMark(){

    const params = new URL(location.href).searchParams;
    const boardNo = params.get("no")

    console.log(boardNo)

    
    

        $.ajax({
    
            url : contextPath + "/myPage/bookMarkDelete",
            data : {"boardNo" : boardNo},
            type : "get",
    
            
            success : function(result){
                if(result>0){
                    alert("북마크 삭제 완료")
                }else{
                    alert("북마크에 등록되어있지 않습니다.")
                }
    
    
            }
    
    
        })




}


// if(img.src = contextPath + "/resources/images/bookmark-fill.svg"){
//     console.log("안졸려")
//     deleteBookMark();
//     // 북마크 삽입 함수
//     img.src = contextPath + "/resources/images/bookmark.svg"
    
//     if(img.src = contextPath + "/resources/images/bookmark.svg"){

//         bookMarkInsert();
//         img.src = contextPath + "/resources/images/bookmark-fill.svg"
//     }
// } 







// // 북마크가 체크 안되어있으면 실행하는 함수
// if(img.src = contextPath + "/resources/images/bookmark.svg"){

    
// }


// // 북마크 체크 되어있으면 실행하는 함수
// if(img.src = contextPath + "/resources/images/bookmark-fill.svg"){

//     function bookBtnClick() {
     
          
//         // 북마크 삭제 함수
//         deleteBookMark()

      
    
//     }


// }



