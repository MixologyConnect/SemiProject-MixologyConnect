
// 게시글 목록으로 
(function(){
    const selectListBtn = document.getElementById("selectListBtn");

    if(selectListBtn != "") {
        
        selectListBtn.addEventListener("click", function(){

            const pathname = location.pathname; 

            let url = pathname.substring(0, pathname.indexOf("/", 1));
            url += "/search?"

            const params = new URL(location.href).searchParams;

            const query = "query="+ params.get("query");
    

            url += query 

            location.href = url;
            console.log(params)
        })
    }

})();