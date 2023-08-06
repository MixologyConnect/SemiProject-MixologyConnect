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






const folloingmodal = document.querySelector('.folloing-modal');

(function() {
    const followerView = document.getElementById("followerView");
    const followerModal = document.querySelector('.follower-modal');
    const followerClose = document.querySelector(".follower-close");

    followerView.addEventListener("click", function() {
        followerModal.classList.toggle('show');
    });

    followerClose.addEventListener("click", function() {
        followerModal.classList.toggle('hide'); // 'hide' 클래스 추가

        setTimeout(function() {
            followerModal.classList.remove('show'); // 'show' 클래스 제거
            followerModal.classList.remove('hide'); // 'hide' 클래스 제거
        }, 450);
    });
})();

(function() {
    const folloingView = document.getElementById("folloingView");
    const folloingModal = document.querySelector('.folloing-modal');
    const folloingClose = document.querySelector(".folloing-close");

    folloingView.addEventListener("click", function() {
        folloingModal.classList.toggle('show');
    });

    folloingClose.addEventListener("click", function() {
        folloingModal.classList.toggle('hide'); // 'hide' 클래스 추가

        setTimeout(function() {
            folloingModal.classList.remove('show'); // 'show' 클래스 제거
            folloingModal.classList.remove('hide'); // 'hide' 클래스 제거
        }, 450);
    });
})();














