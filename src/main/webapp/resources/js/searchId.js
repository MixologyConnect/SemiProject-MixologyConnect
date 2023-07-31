function searchId(){
    const memberName = document.getElementById("inputName");
    const memberTel = document.getElementById("inputTel");
    const regExp= /^0(1[01679]|2|[3-6][1-5]|70)\d{3,4}\d{4}$/;
    const seachIdBtn = document.getElementById("seachIdBtn");
    
    const div = document.getElementById("resultId");


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


function searchPw(){
    const memberName = document.getElementById("inputName");
    const memberId = document.getElementById("inputId");


    if(memberId.value.trim().length == 0){
        alert("아이디를 입력해주세요.");
        memberId.focun();
        return false;
    }

    if(memberName.value.trim().length == 0){
        alert("이름을 입력해주세요.");
        memberName.focun();
        return false;
    }

    return true;
}

