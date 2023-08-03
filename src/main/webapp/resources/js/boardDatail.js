
  $(document).ready(function(){
    console.log(likeMember);
    console.log(writerNo);
    console.log(loginMemberNo);

    if(likeMember==boardNo){
        const img = document.getElementById("likeBtnImg");
        img.src = contextPath + "/resources/images/heart-fill.svg";
    }
    if(likeMember!=boardNo){
        const img = document.getElementById("likeBtnImg");
        img.src = contextPath + "/resources/images/heart.svg";
    }
    //내 게시글 팔로우 막기 
   
    //목록으로 돌아가기 후에 내가 팔로우한 사람 은 unfollow 뜨게하기 
    if(writerNo==followingWriter){
        let followCheck = document.getElementById('followCheck');
        const followBtn = document.getElementById('followBtn');

        followCheck.removeAttribute("name")
        followCheck.setAttribute("name",1)
        followBtn.innerText="UNFOLLOW"

    }
  })  
    
    
    
    /* 좋아요 누르면 하트 채워지기 */
    
//    var cnt = 1;
    
    function likeBtnClick() {
        
        if(loginMemberNo==""){
            if(confirm("로그인 후 이용해주세요 로그인화면으로 갑니다 슝-")){
                showModal("login", true);
            } 
        }else{
            const img = document.getElementById("likeBtnImg");
            let likeCheck = document.getElementById('likeCheck');
            img.src = contextPath + "/resources/images/heart-fill.svg";
        
            if(likeCheck.getAttribute("name")==0) {
                img.src = contextPath + "/resources/images/heart-fill.svg";
                likeCheck.removeAttribute("name")
                likeCheck.setAttribute("name",1)
            }else {
                img.src = contextPath + "/resources/images/heart.svg";
                likeCheck.removeAttribute("name")
                likeCheck.setAttribute("name",0)
            }
            // cnt++;
            
            const nameValue = likeCheck.getAttribute("name");
            console.log(nameValue);
            

            $.ajax({
                url:contextPath+"/board/like",
                type:"post",
                dataType : "JSON",
                data: {'loginMemberNo': loginMemberNo,
                        'boardNo' : boardNo,
                        'likeCheck' : likeCheck.getAttribute("name")
                    },
                success : function(like){
                    
                    if(like.likeResult == 1){
                        
                        
                        const likeResult = document.getElementById("likeResult");
                        likeResult.innerText= "";
                        likeResult.innerText= like.likeCount;
                        
                        
                    
                    }else if(like.dlikeResult ==0){
                        
                        
                        const likeResult = document.getElementById("likeResult");
                        likeResult.innerText= "";
                        likeResult.innerText= like.likeCount;
                    }
        
                },
                error : function(like){
                    img.src = contextPath + "/resources/images/heart.svg"
                    
                    console.log("오류발생")
                }
            })
            
        }

    }
   
    
   



// 팔로우 관련-------------------------------------

// follow 버튼 클릭 시 
function followBtnClick() {
    
    if(loginMemberNo==""){
        if(confirm("로그인 후 이용해주세요 로그인화면으로 갑니다 슝-")){
            showModal("login", true);
        } 
    }else{

        
        let followCheck = document.getElementById('followCheck');
        const followBtn = document.getElementById('followBtn');
    
        if(followCheck.getAttribute("name")==0) {
            
            followCheck.removeAttribute("name")
            followCheck.setAttribute("name",1)
            followBtn.innerText="UNFOLLOW"
        }else {
            followCheck.removeAttribute("name")
            followCheck.setAttribute("name",0)
            followBtn.innerText="FOLLOW"
        }
        
        const nameValue = followCheck.getAttribute("name");
        console.log(nameValue);



        $.ajax({
            url:contextPath+"/member/follow",
            type:"post",
            dataType : "JSON",
            data: {'loginMemberNo': loginMemberNo,
                    'boardNo' : boardNo,
                    'followCheck' : followCheck.getAttribute("name")
                    },
                success : function(follow){
                    if(follow.followResult == 1){
                        const followBtn = document.getElementById("followBtn");
                        followBtn.innerHTML="";
                        followBtn.innerHTML="UNFOLLOW";
                    }else if(follow.dfollowResult == 1){
                        const followBtn = document.getElementById("followBtn");
                        followBtn.innerHTML="";
                        followBtn.innerHTML="FOLLOW";

                    }
        
                },
                error : function(follow){
                   
                    console.log("오류발생")
                }


        })


    }
}

// function followCansle(){
    
//     if(loginMemberNo==""){
//         alert("로그인후 이용해주세요.")
//     }else{

//         let followCheck = document.getElementById('followCheck');
      
    
//         if(followCheck.getAttribute("name")==0) {
            
//             followCheck.removeAttribute("name")
//             followCheck.setAttribute("name",1)
//         }else {
//             followCheck.removeAttribute("name")
//             followCheck.setAttribute("name",0)
//         }
        
//         const nameValue = followCheck.getAttribute("name");
//         console.log("name: "+nameValue);


//         $.ajax({
//             url:contextPath+"/member/follow",
//             type:"post",
//             dataType : "JSON",
//             data: {'loginMemberNo': loginMemberNo,
//                     'boardNo' : boardNo,
//                     'followCheck' : followCheck.getAttribute("name")
//                     },
//                 success : function(follow){
//                     if(follow.dFollowResult == 1){
//                         const followBtn = document.getElementById("followBtn");
//                         followBtn.innerHTML="";
//                         followBtn.innerHTML="FOLLOW";
//                     }
//                 },
//                 error : function(follow){
//                     console.log("오류발생")
//                 }


//         })


//     }
// }