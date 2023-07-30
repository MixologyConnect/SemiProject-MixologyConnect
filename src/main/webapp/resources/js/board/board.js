// 목록으로
(function(){
    const goToBtn = document.getElementById("goToBtn");

    if(goToBtn != "") {
        
        goToBtn.addEventListener("click", function(){

            const pathname = location.pathname; 

            let url = pathname.substring(0, pathname.indexOf("/", 1));
            url += "/board/boardAll?"

            const params = new URL(location.href).searchParams;

            const type = "type=" + params.get("type");
            let cp;
            
            if(params.get("cp") != ""){
            cp = "cp" + params.get("cp");
            }else {
                cp = "cp=1";
            }

            url += type + "&" + cp;

            location.href = url;
            console.log(params)
        })
    }

})();