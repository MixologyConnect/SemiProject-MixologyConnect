const bookMarkBtn = document.getElementById("bookBtnImg")

bookMarkBtn.addEventListener("click", function(){
   
    bookMarkInsert();

        
    
    
    
    
})

/* 북마크 조회 함수 */
function bookMarkList(){

    // 현재 머물고 있는 페이지 주소의 쿼리스트링을 가져옴
    const params = new URL(location.href).searchParams;

    const boardNo = params.get("no")

    console.log(boardNo);

    $.ajax({


        url : contextPath + "/myPage/bookMarkList",
        data : {"boardNo" : boardNo},
        type : "get",
        dataType : "json",

        
        success : function(bookMarkList){
            console.log(bookMarkList)

            const list = document.getElementById("list")

            for(let item of bookMarkList){

                // tr 요소 생성
                const tr = document.createElement("tr")

                // td 요소 생성 + 내용추가 * 4
                const no = document.createElement("td")
                no.innerText = item.boardNo // 게시글 번호

                const title = document.createElement("td")
                title.innerText = item.boardTitle

                const name = document.createElement("td")
                name.innerText = item.memberName

                const read = document.createElement("td")
                read.innerText = item.readCount;

                tr.append(no, title, name, read)

                list.append(tr);





            }







        } ,
        
        error : function(req, status, error){
            console.log("댓글 삭제 실패")
            console.log(req.responseText)
            
        }



    })


}


function bookMarkInsert(){

    const params = new URL(location.href).searchParams;
    const boardNo = params.get("no")

    console.log(boardNo)

    $.ajax({

        url : contextPath + "/myPage/bookMarkInsert",
        data : {"boardNo" : boardNo},
        type : "get",

        success : function(result){
            if(result > 0){
                alert("북마크 등록완료")
            }else{
                alert("북마크 등록 실패..")
            }
        
            
        },
        error : function(req, status, error){
            console.log("댓글 삭제 실패")
            console.log(req.responseText)
            
        }
        })

    }

