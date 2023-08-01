
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
    
   var cnt = 1;
    
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
            cnt++;
            
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
                error : function(data){
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




$.ajax({
url: 'https://gist.githubusercontent.com/abs013r/cb774124e29ab7e396b638939ec0bda1/raw/479c0716a7104236e2e4fdc089586b3aeef5831b/MCnav.html',
type: 'GET',
success: function(data) { $('#mc-nav').html(data); },
error: function() { console.log('이거 뜨면 실패입니다… 조훈한테 문의하세요'); }
});

$.ajax({
url: 'https://gist.githubusercontent.com/abs013r/0d6ff4139684cf842192a2d312266a83/raw/6e629f95c437670fc573560fd8559829a25b30c8/MCfooter.html',
type: 'GET',
success: function(data) { $('#mc-footer').html(data); },
error: function() { console.log('이거 뜨면 실패입니다… 조훈한테 문의하세요'); }
});
