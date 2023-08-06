const result = document.getElementById("memberResult"); // 회원 input
const result2 = document.getElementById("boardResult") // 게시글 input

(function(){
    $.ajax({
        url : "manager",
        data : {},
        success : function(){

        },
        error : function(request,staus,error){
            console.log("에러 발생");

            console.log("상태코드 : " + request.status);

            console.log(request.responseText);

            console.log(error);

        }
    })

})()


/* ajax */
document.getElementById("member-btn").addEventListener("click", function() {
    const input = document.getElementById("searchMember"); // 회원 아이디 검색
    const table = document.getElementById("resultMember"); // 회원 tbody

    $.ajax({
        url : "manager/selectMember",
        data : {"memberId" : input.value},
        type : "post",
        dataType : "JSON",
        
        success : function(member){
            
            console.log(member);
            
            if(member.memberNo != 0){
                $('#resultMember > *').remove();
                const tr = document.createElement("tr");
                
                const input = document.createElement("input")
                input.setAttribute("type", "checkbox");
                input.setAttribute("id", "chk1");

                const td1 = document.createElement("td");
                td1.append(input);

                const td2 = document.createElement("td");
                const div1 = document.createElement("div")
                div1.innerText= member.memberNo;
                td2.append(div1);

                const td3 = document.createElement("td");
                const div2 = document.createElement("div")
                div2.innerText= member.memberId;
                td3.append(div2);
                
                
                const td4 = document.createElement("td");
                const div3 = document.createElement("div")
                div3.innerText= member.memberName;
                td4.append(div3);

                const td5 = document.createElement("td");
                const div4 = document.createElement("div")
                div4.innerText= member.memberTel;
                td5.append(div4);


                const td6 = document.createElement("td");
                const div5 = document.createElement("div")
                div5.innerText= member.memberAddress;
                td6.append(div5);

                const td7 = document.createElement("td");
                const div6 = document.createElement("div")
                div6.innerText= member.secessionFlag;
                td7.append(div6);

                

                tr.append(td1, td2, td3, td4, td5, td6, td7)
                table.append(tr);

                result.value = member.memberId; // 회원 input에 들어가는 거

                
            }else{

                $('#resultMember > *').remove();
                
                const tr = document.createElement("tr");
                
                const td1 = document.createElement("td");
                td1.setAttribute("colspan","7");
                const div1 = document.createElement("div")
                div1.innerText= "일치하는 회원이 없습니다.";
                td1.append(div1);

                tr.append(td1);
                table.append(tr);



            }
        },
        error : function(request,staus,error){
            console.log("에러 발생");

            console.log("상태코드 : " + request.status);

            console.log(request.responseText);

            console.log(error);

        }


    })

});



function banMember(){
    if(confirm("정말로 탈퇴처리 하시겠습니까?")){
        
        $.ajax({
            url : "manager/secession",
            data : {"memberId" : result.value},
            type : "POST",
            success : function(){
                
            },
            error : function(){
                console.log("에러발생");
            }
            
        })
        
        const chk1 = $('input:checkbox[id="chk1"]').is(":checked")
        
        if(chk1 == true){
            
            
            const memberStatus = $("#resultMember > tr > td:last-of-type > div")
            let memberStd = memberStatus.text();
            if(memberStd == 'Y') memberStatus.text("N");
            else memberStatus.text("Y");

            const memberBan = document.getElementById("memberban");
            if(memberBan.innerHTML=="회원 탈퇴"){
                memberBan.innerHTML = "";
                memberBan.innerHTML = "회원 복구";
                
            }else{
                memberBan.innerHTML = "";
                memberBan.innerHTML = "회원 탈퇴";
    
            }

        }else{
            alert("회원 선택 후 클릭해주세요.")
        }
        
    }
}
    

    

document.getElementById("board-btn").addEventListener("click",function(){

    const input = document.getElementById("searchBoard"); // board 검색
    const result = document.getElementById("resultBoard"); // tbody
    const no = document.getElementById("noBoard");

    
    $.ajax({
        url : "manager/selectBoard",
        data : {"searchBoard": input.value},
        type : "POST",
        dataType : "JSON",
        success : function(board){
            if(board.boardNo != 0){
                $('#resultBoard > *').remove();
                const tr = document.createElement("tr");
                
                const input = document.createElement("input")
                input.setAttribute("type", "checkbox");
                input.setAttribute("id", "chk2");

                const td1 = document.createElement("td");
                td1.append(input);

                const td2 = document.createElement("td");
                const div1 = document.createElement("div")
                div1.innerText= board.boardNo;
                td2.append(div1);

                const td3 = document.createElement("td");
                const div2 = document.createElement("div")
                div2.innerText= board.boardTitle;
                td3.append(div2);
                
                
                const td4 = document.createElement("td");
                const div3 = document.createElement("div")
                div3.innerText= board.memberId;
                td4.append(div3);

                const td5 = document.createElement("td");
                const div4 = document.createElement("div")
                div4.innerText= board.memberTel;
                td5.append(div4);

                const td6 = document.createElement("td");
                const div5 = document.createElement("div")
                div5.innerText= board.boardSt;
                td6.append(div5);


                tr.append(td1, td2, td3, td4, td5, td6)
                result.append(tr);

                result2.value = board.boardTitle;

            }else{

                $('#resultBoard > *').remove();

                const tr = document.createElement("tr");
                
                const td1 = document.createElement("td");
                td1.setAttribute("colspan","6");
                const div1 = document.createElement("div")
                div1.innerText= "조회된 게시글이 없습니다.";
                td1.append(div1);

                tr.append(td1);
                result.append(tr);



            }

        },
        error : function(request,staus,error){
            console.log("에러 발생");

            console.log("상태코드 : " + request.status);

            console.log(request.responseText);

            console.log(error);

        }
    })

});

function deleteBoard(){
    if(confirm("정말로 게시글을 삭제하시겠습니까?")){
        
        $.ajax({
            url : "manager/boardDelete",
            data : {"boardTitle" : result2.value},
            type : "POST",
            success : function(){
                
            },
            error : function(){
                console.log("에러발생")
            }
        })
        

        const chk2 = $('input:checkbox[id="chk2"]').is(":checked")
        
        if(chk2 == true){
            
            
            const boardStatus = $("#resultBoard > tr > td:last-of-type > div")
            let boardSt = boardStatus.text();
            if(boardSt == 'Y') boardStatus.text("N");
            else boardStatus.text("Y");

            const deleteBoard = document.getElementById("deleteBoard");
            if(deleteBoard.innerHTML=="게시글 삭제"){
                deleteBoard.innerHTML = "";
                deleteBoard.innerHTML = "게시글 복구";
                
            }else{
                deleteBoard.innerHTML = "";
                deleteBoard.innerHTML = "게시글 삭제";
    
            }


        }else{
            alert("게시글 선택 후 클릭해주세요.");
        }
        

        


    }
}