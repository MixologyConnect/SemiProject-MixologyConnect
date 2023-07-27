
/* 경고 출력, 포커스, false 반환 */
function printAlert(el, message){
    alert(message);
    el.focus();
    return false;
}

function secssionValidate(){
    const memberPw = document.getElementById("memberPw");

    if(memberPw.value.trim().length == 0){
        return printAlert(memberPw, "비밀번호를 입력해주세요. 탈퇴안할꺼면 말구~");
    }
    if(!document.getElementById("agree").checked){
        return printAlert(agree, "약관 동의 후 탈퇴 버튼을 클릭해주세요.")
    }

    const str = "정말 탈퇴하시겠습니까?";

    confirm(str);
    if(!confirm){
        return false;
    }

    return true;

}