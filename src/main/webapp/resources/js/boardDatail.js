
  $(document).ready(function(){
    console.log(likeMember)

    if(likeMember==boardNo){
        const img = document.getElementById("likeBtnImg");
        img.src = contextPath + "/resources/images/heart-fill.svg";
    }
    if(likeMember!=boardNo){
        const img = document.getElementById("likeBtnImg");
        img.src = contextPath + "/resources/images/heart.svg";
    }
  })  
    
    
    
    /* 좋아요 누르면 하트 채워지기 */
    
//    var cnt = 1;
    
    function likeBtnClick() {
        
        if(loginMemberNo==""){
            alert("로그인후 이용해주세요.")
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



// 팔로우 관련-------------------------------------

// follow 버튼 클릭 시 
function followBtnClick() {
    
    if(loginMemberNo==""){
        alert("로그인후 이용해주세요.")
    }else{

        
        let followCheck = document.getElementById('followCheck');
      
    
        if(followCheck.getAttribute("name")==0) {
            
            followCheck.removeAttribute("name")
            followCheck.setAttribute("name",1)
        }else {
            followCheck.removeAttribute("name")
            followCheck.setAttribute("name",0)
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
                        followBtn.removeAttribute("onclick")
                        followBtn.setAttribute("onclick","followCansle()");
                        followBtn.innerHTML="";
                        followBtn.innerHTML="UNFOLLOW";
                    }
        
                },
                error : function(follow){
                   
                    console.log("오류발생")
                }


        })


    }
}

function followCansle(){
    
    if(loginMemberNo==""){
        alert("로그인후 이용해주세요.")
    }else{

        let followCheck = document.getElementById('followCheck');
      
    
        if(followCheck.getAttribute("name")==0) {
            
            followCheck.removeAttribute("name")
            followCheck.setAttribute("name",1)
        }else {
            followCheck.removeAttribute("name")
            followCheck.setAttribute("name",0)
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
                    if(follow.dFollowResult == 1){
                        const followBtn = document.getElementById("followBtn");
                        followBtn.removeAttribute("onclick")
                        followBtn.setAttribute("onclick","followBtnClick()");
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