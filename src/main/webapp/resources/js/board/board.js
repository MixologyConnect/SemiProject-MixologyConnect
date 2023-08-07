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


(function(){
    const Btn = document.getElementById("goToBtn");
    Btn.addEventListener("click", function(){

        var referrer = document.referrer;

        console.log(document.referrer);
            if(document.referrer == "http://localhost:10005/SemiProfect_3/myPage/userPage"){
                location.href = "http://localhost:10005/SemiProfect_3/myPage/userPage";
            }
    })

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


// 즉시 실행 함수
(function(){
    const thumbnail = document.getElementsByClassName("list-thumbnail");


    if(thumbnail.length > 0){ // 목록에 썸네일 이미지가 있을 경우에만 이벤트 추가
     
        const modal = document.querySelector('.modal');
        const modalImage = document.getElementById("modal-image");
        const modalClose = document.getElementById("modal-close");


        for(let th of thumbnail){
            th.addEventListener("click", function(){
                modalImage.setAttribute("src", th.getAttribute("src") );
               
                /* on/off 스위치 */
                // classList.toggle("클래스명") : 클래스가 없으면 추가(add)
                //                                클래스가 있으면 제거(remove)
               
                modal.classList.toggle('show'); // add
            });
        }


        // X버튼
        modalClose.addEventListener("click", function(){
           
            modal.classList.toggle('hide'); // hide 클래스 추가


            setTimeout(function(){ // 0.45초 후 동작
                modal.classList.toggle('hide'); // hide 클래스 제거


                modal.classList.toggle('show'); // remove
            }, 450);
        });




    }


})();
