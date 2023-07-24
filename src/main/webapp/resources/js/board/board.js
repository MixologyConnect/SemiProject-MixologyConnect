// 목록으로

(function(){
    const goToBtn = document.getElementById("goToBtn");

    if(goToBtn != null) {
        console.log(gotoBtn)
        goToBtn.addEventListener("click", function(){

            const path = location.pathname; 

            let url = path.substring(0, path.indexOf("/", 1));
            url += "/board/boardAll?"

            const params = new URL(location.href).searchParams;

            const type = "type=" + params.get("type");
            const cp = "cp" + params.get("cp");

            url += type + "&" + cp;

            location.href = url;
        })
    }

})();