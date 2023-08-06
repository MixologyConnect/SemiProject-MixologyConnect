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




// 팔로잉 팔로워 목록 리스트 

// const folloingmodal = document.querySelector('.folloing-modal');

// (function() {
//     const followerView = document.getElementById("followerView");
//     const followerModal = document.querySelector('.follower-modal');
//     const followerClose = document.querySelector(".follower-close");

//     followerView.addEventListener("click", function() {
//         followerModal.classList.toggle('show');
//     });

//     followerClose.addEventListener("click", function() {
//         followerModal.classList.toggle('hide'); // 'hide' 클래스 추가

//         setTimeout(function() {
//             followerModal.classList.remove('show'); // 'show' 클래스 제거
//             followerModal.classList.remove('hide'); // 'hide' 클래스 제거
//         }, 450);
//     });
// })();





//팔로잉 목록 리스트
const folloingView = document.getElementById("folloingView");
const folloingModal = document.querySelector('.folloing-modal');
const folloingClose = document.querySelector(".folloing-close");

function followingList(){
    folloingModal.classList.toggle('show');
    $.ajax({
        url:contextPath + "/myPage/followingList",
        data: {},
        type: "POST",
        dataType:"JSON",
        success:function(followings){
            console.log(followings);
            console.log(followings.length);
            
            

            const followingList= document.querySelector("#followingList");
            followingList.innerText="";

            for(let following of followings ){
                console.log(following);
                const followArea=document.createElement("div")
                followArea.classList.add("following-area");

                //프로필 사진 
                const fInfo = document.createElement("div");
                fInfo.classList.add("f-info");
                
                const profileImage = document.createElement("img");
                profileImage.classList.add("fprofile");
                
                if(following.profileImage != null){
                    profileImage.setAttribute("src",contextPath+following.profileImage);
                }else{
                    profileImage.setAttribute("src",contextPath+"/resources/images/user.png");
                }
                
                //회원 아이디 영역
                const span = document.createElement("span");
                span.innerHTML= following.memberId;
                
                //버튼 영역
                const btnArea = document.createElement("div");
                
                const followBtn= document.createElement("button");
                followBtn.setAttribute("type", "button");
                followBtn.setAttribute("id", "followBtn");
                followBtn.setAttribute("onclick", "unfollowBtnClick("+following.memberNo+")");
                followBtn.innerHTML="UnFollow";
                btnArea.append(followBtn);
                
                fInfo.append(profileImage, span, btnArea);
                followArea.append(fInfo);
                followingList.append(followArea)
            }
            const followingCount = document.getElementById("followingCount")
            followingCount.innerText="팔로잉 "+followings.length;
        },
        error:function(){
            console.log("에러발생")
        }
    
    })

   
};

folloingClose.addEventListener("click", function() {
    folloingModal.classList.toggle('hide'); // 'hide' 클래스 추가

    setTimeout(function() {
        folloingModal.classList.remove('show'); // 'show' 클래스 제거
        folloingModal.classList.remove('hide'); // 'hide' 클래스 제거
    }, 450);
});


function unfollowBtnClick(followingNo){
    if( confirm("정말로 팔로우 취소하시겠습니까?" )){
        $.ajax({
            url:contextPath+"/myPage/unfollow",
            type: "post",
            dataType: "JSON",
            data:{'loginMemberNo': loginMemberNo,
                'unfollowerNo': followingNo  },
            success : function(result){
                if(result > 0){
                    alert("언팔했습니다")
                    followingList();
                    

                }else{
                    alert("실패");
                }
            },
            error: function(result){
                console.log("오류발생");
            }
                
                
            })
    }
}



//팔로워 목록 리스트

const followerModal = document.querySelector('.follower-modal');
const followerClose = document.querySelector(".follower-close");

function followerList(){
    followerModal.classList.toggle('show');
    $.ajax({
        url:contextPath + "/myPage/followerList",
        data: {},
        type: "POST",
        dataType:"JSON",
        success:function(followers){
            console.log(followers);
            console.log(followers.length);
            
            

            const followerList= document.querySelector("#followerList");
            followerList.innerText="";

            for(let follower of followers ){
                console.log(follower.memberNo);
                const followArea=document.createElement("div")
                followArea.classList.add("follow-area");

                //프로필 사진 
                const fInfo = document.createElement("div");
                fInfo.classList.add("f-info");
                
                const profileImage = document.createElement("img");
                profileImage.classList.add("fprofile");
                
                if(follower.profileImage != null){
                    profileImage.setAttribute("src",contextPath+follower.profileImage);
                }else{
                    profileImage.setAttribute("src",contextPath+"/resources/images/user.png");
                }
                
                //회원 아이디 영역
                const span = document.createElement("span");
                span.innerHTML= follower.memberId;
                
                //버튼 영역
                const btnArea = document.createElement("div");
                
                const followBtn= document.createElement("button");
                followBtn.setAttribute("type", "button");
                followBtn.setAttribute("id", "followBtn");
                followBtn.setAttribute("onclick","followCancelBtnClick("+follower.memberNo+")");
                followBtn.innerHTML="Cancel";
                btnArea.append(followBtn);
                
                fInfo.append(profileImage, span, btnArea);
                followArea.append(fInfo);
                followerList.append(followArea)
            }
            const followerCount = document.getElementById("followerCount")
            followerCount.innerText="팔로워 "+followers.length;
        },
        error:function(){
            console.log("에러발생")
        }
    
    })

   
};

followerClose.addEventListener("click", function() {
    followerModal.classList.toggle('hide'); // 'hide' 클래스 추가

    setTimeout(function() {
        followerModal.classList.remove('show'); // 'show' 클래스 제거
        followerModal.classList.remove('hide'); // 'hide' 클래스 제거
    }, 450);
});



function followCancelBtnClick(cancelfollowerNo){
    if( confirm("정말 취소하시겠습니까?" )){
        $.ajax({
            url:contextPath+"/myPage/cancleFollower",
            type: "post",
            dataType: "JSON",
            data:{'loginMemberNo': loginMemberNo,
                'cancleFollower': cancelfollowerNo  },
            success : function(result){
                if(result > 0){
                    alert("취소했습니다")
                    followerList();

                }else{
                    alert("실패");
                }
            },
            error: function(result){
                console.log("오류발생");
            }
                
                
            })
    }
}








