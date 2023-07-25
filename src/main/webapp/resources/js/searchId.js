
function searchId(){
    const memberName = document.getElementById("inputName");
    const memberTel = document.getElementById("inputTel");
    const regExp= /^0(1[01679]|2|[3-6][1-5]|70)\d{3,4}\d{4}$/;

    if(memberName.value.length == 0){ 
        alert("이름을 입력해주세요.");
        memberName.focus();
        return false;
    }
    if(memberTel.value.length == 0){ 
        alert("전화번호를 입력해주세요. (-제외)");
        memberTel.focus();
        return false;   
    }

    if(!regExp.test(memberTel.value)){ // 유효하지 않은 경우
        alert("전화번호 형식이 올바르지 않습니다.");
        memberTel.focus();
        return false;
  
    }


    return true;

}


document.getElementById("seachIdBtn").addEventListener("click",function(){
    const memberName = document.getElementById("inputName");
    const memberTel = document.getElementById("inputTel");

    const div = document.getElementById("resultId");

    $.ajax({

        url : contextPath + "/member/searchId",
        data : {"memberName" : memberName,
                "memberTel" : memberTel},
        type : "post",
        datatype : "JSON",
        success : function(member){
            console.log(member);

            if(member != null){

                const row1 = document.createElement("span");
                row1.innerText =member.memberName + "님의";

                const row2 = document.createElement("span");
                row2.innerText ="아이디는 " + member.memberName+"입니다";

                div.append(row1, row2);


                
            }else{
                span.innerText = "일치하는 회원이 없습니다."
                
            }

        },
        error : function(request){
            console.log("회원 목록 조회 실패")
        }  
    })
})
