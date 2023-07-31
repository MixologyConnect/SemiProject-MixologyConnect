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

document.getElementById("member-btn").addEventListener("click", function(){

    const input = document.getElementById("searchMember");
    const table = document.getElementById("resultMember");
    
    
    $.ajax({
        url : "manager/manger",
        data : {"memberId" : input.value},
        type : "POST",
        dataType : "JSON",
        
        success : function(member){

            console.log("member");

            if(member != null){


            
                var htmls = "<td>" + "<input type='checkbox' name='chk1'>" +"</td>" +
                            "<td>" + member.memberNo +"</td>" +
                            "<td>" + member.memberId +"</td>" +
                            "<td>" + member.memberName +"</td>" +
                            "<td>" + member.memberTel +"</td>" +
                            "<td>" + member.memberAddress +"</td>" +
                            "<td>" + member.secessionFlag +"</td>" + "</tr>";
                table.append(htmls);
                
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