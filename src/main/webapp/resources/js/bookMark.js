// 즉시실행 함수(북마크 이미지 채워지는지 확인)
(function(){

    bookMarkImage();
    // bordDetail 화면 띄우자마자
    // 북마크 해 놓은 페이지에 들어오면 북마크 표시되는 함수 호출
    // bookMarkImage();



    
    console.log(loginMemberNo)


})();



// 북마크 버튼 이미지
const imgPlus = document.getElementById("bookBtnPlus");
// 비어있는거
const imgMinus = document.getElementById("bookBtnMinus");
// 채워져있는거


// 전체 선택 
const all = document.getElementsByClassName("allCheck")[0]
const deleteBox = document.getElementsByName("deleteBox")



// 전체 선택 함수
all.addEventListener("click", function(){
    for(let i=0; i<deleteBox.length; i++){
        deleteBox[i].checked = all.checked;

            // arr.push(feedList[i].value)
            // console.log(arr)
        
    }
    // arr = [];

})

// 체크박스 삭제 버튼 클릭 함수
function deleteClick(){

    const query = 'input[name="deleteBox"]:checked';
    const deleteEls = document.querySelectorAll(query);

    // 선택된 목록에서 value 찾기
    var result = []
    deleteEls.forEach((el) => {
        result.push($(el).val());
    });

    console.log(result);


    $.ajax({

        url : contextPath + "/myPage/deleteBookmark",
        data : {"result" : result},
        type : "get",
        traditional : true,
        dataType : "json",

        success : function(result){
            if(result>0){
                if(confirm("삭제하시겠습니까?")){

                    alert("삭제 완료~!")
                    location.reload();
                }
            }else{
                alert("삭제 실패...")
            }
        },

        error : function(){
            console.log("에러")
        }



    })

}










let count = 1;



// 북마크 등록 
function bookBtnClickMinus(){
    if(loginMemberNo == 0){
        alert("로그인 후 이용해주세요.")
        location.href = contextPath;
    }else{

        if (confirm("북마크에 등록하시겠습니까?")) {
            bookMarkInsert();
        }
    }
}

// 북마크 해제
function bookBtnClickPlus(){
    if (confirm("북마크를 삭제하시겠습니까?")) {
        deleteBookMark();
    } 
}













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
                imgPlus.style.display = 'none';
                imgMinus.style.display = 'block';
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

    console.log(boardNo)


    $.ajax({

        url : contextPath + "/myPage/bookMarkImage",
        data : {"boardNo" : boardNo},
        type : "get",

        success : function(result){
            console.log(result)
            if(result > 0){
                console.log("성공")
                imgPlus.style.display = 'none';
                imgMinus.style.display = 'block';
            }else{
                imgPlus.style.display = 'block';
                imgMinus.style.display = 'none';
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
                    imgMinus.style.display = 'none';
                    imgPlus.style.display = 'block';
                }else{
                    alert("북마크에 등록되어있지 않습니다.")
                }
    
    
            }
    
    
        })




}

// 검색 유효성 검사(검색어를 입력했는지 확인)
function searchValidate(){

    const input = document.getElementById("search-query")

    if(input.value.trim().length == 0){
        input.value = ""
        input.focus();
        return false;
    }

}


