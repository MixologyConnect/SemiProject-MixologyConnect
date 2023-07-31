const memberList = document.getElementsByName("chk1");
const result = document.getElementById("result1");
const test = document.getElementsByName("memberId");

function selectMember(){
    let str = "";
    for(let i=0; i<memberList.length; i++){
        if(memberList[i].checked){
            str += test[i].innerHTML + " ";
        }
    }

    result.innerHTML = str;
}

/* ajax */
document.getElementById("member-btn").addEventListener("click", function(){

    const input = document.getElementById("searchMember");
    console.log(input);
    const table = document.getElementById("resultMember");
    
    
    $.ajax({
        url : "manager/selectMember",
        data : {"memberId" : input.value},
        type : "post",
        dataType : "JSON",
        
        success : function(member){

            console.log(member);

            if(member != null){
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

                // var htmls = "<tr>"+"<td>" + "<input type='checkbox' name='chk1'>" +"</td>" +
                //             "<td>" + member.memberNo +"</td>" +
                //             "<td>" + member.memberId +"</td>" +
                //             "<td>" + member.memberName +"</td>" +
                //             "<td>" + member.memberTel +"</td>" +
                //             "<td>" + member.memberAddress +"</td>" +
                //             "<td>" + member.secessionFlag +"</td>" + "</tr>";
                //table.append(htmls);
                
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

