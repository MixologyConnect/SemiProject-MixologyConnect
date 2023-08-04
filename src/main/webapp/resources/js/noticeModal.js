(function(){

    $.ajax({
        url : contextPath + "/manager/noticeModal",
        data : {},
        type : "post",
        dataType : "JSON",
        success : function(notice){

            const div1 = document.createElement("div");
            div1.setAttribute("id","overlayy");
            
            const div2 = document.createElement("div");
            div2.setAttribute("id","modall");
            div1.append(div2);
            
            const div3 = document.createElement("div");
            div3.setAttribute("class","main_imagen");
            div2.append(div3);

            const img = document.createElement("img");
            img.setAttribute("id","test");

       
            img.setAttribute("src",contextPath+notice.imageList[0].imageRename);
            div3.append(img);

            const h3 = document.createElement("h3");
            h3.setAttribute("id","main_image_text");
            h3.innerText = notice.boardTitle;
            div3.append(h3);
            
            const p = document.createElement("p");
            p.setAttribute("id","content");
            p.innerText = notice.boardContent;
            div3.append(p);

            const button1 = document.createElement("button");
            button1.setAttribute("id","today");
            button1.innerText = "오늘 하루 보지 않기";
            div3.append(button1);

            const button2 = document.createElement("button");
            button2.setAttribute("id","close");
            button2.setAttribute("onclick","true")
            button2.innerText = "닫기";
            div3.append(button2);

            div2.append(div3);
            div1.append(div2);
            const body = document.querySelector("body")
            body.append(div1); 

        },

        error : function(request,status,error){

            console.log("에러 발생");
            console.log("상태코드 : " + request.status);

            console.log(request.responseText);

            console.log(error);
        }

        
    })
    
})();

window.onload = function(){

    document.getElementById("close").addEventListener("click",function(){
        
        alert("HIIIII!!");
        document.getElementById("overlayy").style.display = "none";
        
    })
} 
