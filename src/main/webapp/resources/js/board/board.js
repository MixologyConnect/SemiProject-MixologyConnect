// 목록으로
(function(){
    const Btn = document.getElementById("goToBtn");

    if(Btn != "") {
        
        Btn.addEventListener("click", function(){

            const pathname = location.pathname; 

            let url = pathname.substring(0, pathname.indexOf("/", 1));
            url += "/board/boardAll?"

            const params = new URL(location.href).searchParams;

            const type = "type=" + params.get("type");
            let cp;
            
            if(params.get("cp") != null){
            cp = "cp=" + params.get("cp");
            }else {
                cp = "cp=1";
            }

            url += type + "&" + cp;

            location.href = url;
            console.log(params)
        })
    }

})();


/* 삭제 버튼 실행 */
(function(){

    const deleteBtn = document.getElementById("deleteBtn");

    if(deleteBtn != null){
        deleteBtn.addEventListener("click", function(){

            let url = "boardDelete";

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
