
document.getElementById("seachIdBtn").addEventListener("click",function(){
    const inputName = document.getElementById("inputName");
    const inputTel = document.getElementById("inputTel");

    const span = document.getElementById("resultId");

    $.ajax({

        url : contextPath + "/member/searchId",
        data : {"memberName" : memberName,
                "memberTel" : memberTel},
        type : "post",
        datatype : "JSON",
        success : function(member){
            console.log(member);

            if(member != null){

                const li1 = document.createElement("span");
                li1.innerText =member.memberName + "님의";

                const li2 = document.createElement("span");
                li2.innerText ="아이디는 " + member.memberName+"입니다";
                
            }else{
                span.innerText = "일치하는 회원이 없습니다."
                
            }

        },
        error : function(request){
            console.log("회원 목록 조회 실패")

        }
        

        
    })























})