
const result = document.getElementById("result1");
const test = document.getElementsByName("memberId");

console.log("asdf5");

function banMember(){
    const member = $("#resultMember > tr > td:nth-of-type(3) > div").text();

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

    var memberStd =  $("#resultMember > tr > td:last-of-type > div").text();
    if(memberStd == 'Y'){
        memberStd = 'N';
    }else{
        memberStd = 'Y';
    }
}

/* ajax */
document.getElementById("member-btn").addEventListener("click", function() {
    const input = document.getElementById("searchMember");
    const table = document.getElementById("resultMember");

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
                input.setAttribute("name", "chk1");

                const td1 = document.createElement("td");
                td1.append(input);

                const td2 = document.createElement("td");
                const div1 = document.createElement("div")
                div1.innerText= member.memberNo;
                td2.append(div1);

                const td3 = document.createElement("td");
                const div2 = document.createElement("div")
                div2.setAttribute("id","good")
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

document.getElementById("board-btn").addEventListener("click",function(){

    const input = document.getElementById("searchBoard");
    const result = document.getElementById("resultBoard");
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
                input.setAttribute("name", "chk2");

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

