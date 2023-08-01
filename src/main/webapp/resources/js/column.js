/* 삭제 버튼 실행 */
(function(){

    const deleteBtn = document.getElementById("deleteBtn");

    if(deleteBtn != null){
        deleteBtn.addEventListener("click", function(){

            let url = "columnDelete";

            const params = new URL(location.href).searchParams;

            const no = "?no=" + params.get("no");
            const type = "&type=" + params.get("type");

            url += no + type;

            if(confirm("정말 삭제하시겠습니까?")){
                location.href = url;
            }

        })
    }

})();

(function(){
    const goToBtn = document.getElementById("goToBtn");

    if(goToBtn != null){
        goToBtn.addEventListener("click",function(){

            const pathname = location.pathname;

            let url = pathname.substring(0, pathname.indexOf("/",1));

            url += "/column/columnList?"

            const params = new URL(location.href).searchParams;

            const type = "type=" + params.get("type");
            let cp;
            if(params.get("cp") != ""){
                cp = "cp=" + params.get("cp");
            }else{
                cp = "cp=1";
            }

            url += type + "&" + cp;

            if(params.get("title") != null){
                const title = "&title=" + params.get("title");
                const query = "&query=" + params.get("query");

                url += key + query;
            }

            location.href = url;

        })

    }
})();