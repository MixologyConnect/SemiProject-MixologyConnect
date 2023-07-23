
function myInfoValidate(){
    const memberName = document.getElementsByName("memberName")
    const memberTel = document.getElementsByName("memberTel");

    // 이름 정규식
    const nameRegExp=/^[가-힣]{2,10}$/;
    // 전화전호 정규식
    const telRegExp=/^0(1[01679]|2|[3-6][1-5]|70)\d{3,4}\d{4}$/;

    // 이름 미작성 시 : 이름을 입력해주세요.
   if(memberName[0].value.trim().length == 0){
        alert("이름을 입력해주세요");
        memberName[0].focus(); 
        return false;
    }

    // 이름 유효성 검사
    if(!regExp1.test(memberName[0].value)){
        alert("한글 2~10글자를 입력하세요");
        memberName[0].focus(); 
        return false;
    }

    // 전화번호 미작성 시: "전화번호를 입력해주세요(-제외)"
    if(memberTel[0].value.trim().length == 0){
        alert("전화번호를 입력해주세요(-제외");
        memberTel[0].focus(); 
        return false;
    }

       // 전화번호 유효성검사 
   if(!regExp2.test(memberTel[0].value)){
        return printAlert(memberTel[0],"전화번호 형식이 올바르지 않습니다.");
    }

    return true;

}

function printAlert(el,message){ // 매개변수 el은 요소
    alert(message);
    el.focus();
    return false;
}

// 비밀번호 제출시 유효성검사
function changePwValidate(){
    const currentPw = document.getElementsByName("currentPw");
    const newPw = document.getElementsByName("newPw");
    const newPwconfirm = document.getElementsByName("newPwconfirm");
    
    const regExp3 = /^[a-zA-z0-9!@#\-_]{6,30}$/;
    //const regExp3 = /^[\w!@#_-]{6,30}$/;

    // 미작성시
    if(currentPw[0].value.trim().length==0){
        return printAlert(currentPw[0], "현재 비밀번호를 입력해주세요");
    }
    if(newPw[0].value.trim().length==0){
        return printAlert(newPw[0], "새 비밀번호를 입력해주세요");
    }
    if(newPwconfirm[0].value.trim().length==0){
        return printAlert(newPwconfirm[0], "새 비밀번호 확인을 입력해주세요");
    }
    // 새 비밀번호 유효성
    if(!regExp3.test(newPw[0].value)){
        return printAlert(newPw[0], "영어, 숫자,특수문자(!,@,#,-,_)6~30사이로 작성해주세요");

    }

    //새 비밀번호와 새 비밀번호 확인이 일치 하지 않는 경우
    if(newPw[0].value != newPwconfirm[0].value){
        return printAlert(newPwconfirm[0], "새 비밀번호가 일치하지 않습니다");
    }

    return true;
}





// --------------------------------------------------------------------

//다음 우편번호 API 
function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                document.getElementById("sample6_extraAddress").value = extraAddr;
            
            } else {
                document.getElementById("sample6_extraAddress").value = '';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('sample6_postcode').value = data.zonecode;
            document.getElementById("sample6_address").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("sample6_detailAddress").focus();
        }
    }).open();
}