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
            if(result > 0){
                alert("삭제 완료~!")
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
        








