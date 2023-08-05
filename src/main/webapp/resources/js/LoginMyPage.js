// 전체 선택 
const all = document.getElementById("all")
const feedList = document.getElementsByName("feed")



// 전체 선택 함수
all.addEventListener("click", function(){
    for(let i=0; i<feedList.length; i++){
        feedList[i].checked = all.checked;

            // arr.push(feedList[i].value)
            // console.log(arr)
        
    }
    // arr = [];

})





// 삭제 버튼 클릭 함수
function deletePost(){

    const query = 'input[name="feed"]:checked';
    const selectedEls = document.querySelectorAll(query);

    // 선택된 목록에서 value 찾기
    var result = []
    selectedEls.forEach((el) => {
        result.push($(el).val());
    });

    console.log(result)

    $.ajax({

        url : contextPath + "/myPage/deletePost",
        data : {"result" : result},
        type : "get",
        traditional: true,
        dataType : "json",

        success : function(result){
            if(result){
                if(confirm("삭제하시겠습니까?")){

                    alert("삭제 완료~!")
                    location.reload();
                }
            }else{
                alert("삭제 실패...")
            }
        },
        error : function(result){
            console.log("에러")
        }

    })


}








this.addEventListener("click", function(e){
    for(let i=0; i<feedList.length; i++){
        if(e.target == feedList[i]){

            if(!this.checked && all.checked){
                all.checked = false;
            }

            let flag = true;
            for(let j=0; j<feedList.length; j++){

                if(!feedList[j].checked){
                    flag = false;
                }

           }

           if(!all.checked && flag){
                all.checked = true;
           }
        }
    }
})



/*
팔로우 리스트 
const followerVeiw = document.getElementById("followerView");
const followWrap1 = document.querySelector(".follow-wrap1");
const folloingView = document.getElementById("folloingView");
const folloingwrap = document.querySelector(".folloing-wrap2");

followerVeiw.addEventListener("click", function () {
    
    if (followWrap1.style.display === "block") {
        $(followWrap1).stop().slideUp(200);
        
    } else {
        $(followWrap1).stop().slideDown(200);
    }
});

 팔로잉 리스트 
folloingView.addEventListener("click", function () {
   
    if (folloingwrap.style.display === "block") {
        $(folloingwrap).stop().slideUp(200);
    } else {
        $(folloingwrap).stop().slideDown(200);
    }
});

*/

// 즉시 실행 함수
(function(){
    const followerVeiw = document.getElementById("followerView");


    if(followerVeiw.length > 0){ // 목록에 썸네일 이미지가 있을 경우에만 이벤트 추가
     
        const followModal = document.querySelector('.follow-modal');
        const followWrap = document.querySelector(".follow-wrap1");
        const modalClose = document.getElementById("modal-close");


        for(let th of thumbnail){
            th.addEventListener("click", function(){
                modalImage.setAttribute("src", th.getAttribute("src") );
               
                /* on/off 스위치 */
                // classList.toggle("클래스명") : 클래스가 없으면 추가(add)
                //                                클래스가 있으면 제거(remove)
               
                modal.classList.toggle('show'); // add
            });
        }


        // X버튼
        modalClose.addEventListener("click", function(){
           
            modal.classList.toggle('hide'); // hide 클래스 추가


            setTimeout(function(){ // 0.45초 후 동작
                modal.classList.toggle('hide'); // hide 클래스 제거


                modal.classList.toggle('show'); // remove
            }, 450);
        });




    }


})();
















// function folderDeleteClick(){
//     var checkBoxArr = []; 
//     $("input:checkbox[name='folderCheckname']:checked").each(function() {
//     checkBoxArr.push($(this).val());     // 체크된 것만 값을 뽑아서 배열에 push
//     console.log(checkBoxArr);
//   })
  
//     $.ajax({
//         type  : "POST",
//         url    : "<c:url value='/folderDelete.do'/>",
//         data: {
//         checkBoxArr : checkBoxArr        // folder seq 값을 가지고 있음.
//         },
//         success: function(result){
//             console.log(result);
//         },
//         error: function(xhr, status, error) {
//             alert(error);
//         }  
//      });
//   }











// // 체크된 값만 배열에 담기
// var checkArr = []
// for(let i=0; i<postCheck.length; i++){
//     postCheck[i].addEventListener("click",function(){
//         // checkArr = postCheck[i].value.push;
//         if(postCheck[i].checked == false){
//             // checkArr.push($(this).val());
//             // console.log(checkArr)

//             checkArr.prop()
//         }

//         if(postCheck[i].checked == true){
//             checkArr.push($(this).val());
//             console.log(checkArr)
//         }
//     })
        
// }



// var checkArr = []
// for(let i=0; i<postCheck.length; i++){


//     if(postCheck.checked == true){
//         postCheck[i].addEventListener("click", function(){

//             console.log("dd")
//         })
//     }

    // postCheck[i].addEventListener("click",function(){
    //     // checkArr = postCheck[i].value.push;
    //     if(postCheck[i].checked == false){
    //         // checkArr.push($(this).val());
    //         // console.log(checkArr)

    //         checkArr.prop()
    //     }

    //     if(postCheck[i].checked == true){
    //         checkArr.push($(this).val());
    //         console.log(checkArr)
    //     }
    // })
        








