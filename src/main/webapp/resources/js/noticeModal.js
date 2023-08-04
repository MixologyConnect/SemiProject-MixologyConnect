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

       /*      const button1 = document.createElement("button");
            button1.setAttribute("id","today");
            button1.innerText = "오늘 하루 보지 않기";
            button1.setAttribute("onclick","true")
            div3.append(button1);

        */  
       
            const input1 = document.createElement("input");
            input1.setAttribute("id","today");
            input1.setAttribute("type","checkbox")
            div3.append(input1);

            const label1 = document.createElement("label");
            label1.setAttribute("for","today");
            label1.setAttribute("id","todayLabel")
            label1.innerText = "오늘 하루동안 보지 않기";
            div3.append(label1)

            const button2 = document.createElement("button");
            button2.setAttribute("id","close");
            button2.setAttribute("onclick","closePop()")
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


function setCookie( name, value, exDay ) {
    var todayDate = new Date();
    todayDate.setDate( todayDate.getDate() + exDay ); 
    document.cookie = name + "=" + escape( value ) + "; path=/; expires=" + todayDate.toGMTString() + ";"
} 


/* 

window.onload = function(){

    document.getElementById("close").addEventListener("click",function(){
        
        document.getElementById("overlayy").style.display = "none";
        
    })

    document.getElementById("today").addEventListener("click",function(){

        setCookie( "popup", "done" , 1 );
        document.getElementById("overlayy").style.display = "none";
    })
}  */

window.onload = function closePop(){
    
    //function closePop(){
        
        const close = document.getElementById("close");
        
        close.addEventListener("click",function(){

            if(cookiedata.indexOf("popup=done") < 0 ){
                document.getElementById("overlayy").style.visibility = "visible";
            }else{
                document.getElementById("overlayy").style.visibility = "hidden";
            }
            if(document.getElementById("today").checked){
                setCookie("popup","done",1);
            }
            document.getElementById("overlayy").style.visibility = "hidden";
        })
    //}
    cookiedata = document.cookie;
    
}
