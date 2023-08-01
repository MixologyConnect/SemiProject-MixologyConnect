/*********회원가입 join-signUp.js **********/ 

// 유효성 검사여부를 기록할 객체를 생성 
const checkObj = {
    "memberName"       :  false,
    "memberId"          :  false,
    "memberPw"          :  false,
    "memberPwConfirm"   :  false,
    "memberTel"         :  false,
    "memberEmail"         :  false
};

//전화번호 유효성검사 
const memberTel = document.getElementById("memberTel");
const telMessage = document.getElementById("telMessage");

// *** input 이벤트 ***
// -> 입력과 관련된 모든 동작 (key관련 mouse관련, 붙여넣기)
memberTel.addEventListener("input",function(){

    // 입력이 되지 않은 경우
    if(memberTel.value.trim().length==0){
        telMessage.innerText="전화번호를 입력해주세요(-제외)"
        // telMessage.classList.remove("error");
        // telMessage.classList.remove("comfirm");
        telMessage.classList.remove("confirm", "error");

        checkObj.memberTel = false; // 유효하지 않은 상태임을 기록
        return;
    }

    // 전화번호 정규식
    const regExp =/^0(1[01679]|2|[3-6][1-5]|70)\d{3,4}\d{4}$/;
    
    if(regExp.test(memberTel.value)){ //유효한 경우
        telMessage.innerText="유효한 전화번호 형식입니다."
        telMessage.classList.add("confirm");
        telMessage.classList.remove("error");

        checkObj.memberTel = true;
    
    }else{ // 유효하지 않은 경우
        telMessage.innerText="전화번호 형식이 올바르지 않습니다."
        telMessage.classList.add("error");
        telMessage.classList.remove("confirm");
    
        checkObj.memberTel = false; 
    }

});

// 이메일 유효성 검사
const memberEmail = document.getElementById("memberEmail");
const emailMessage = document.querySelector("#emailMessage");

memberEmail.addEventListener("input", function(){
    
    //입력이 되지 않은 경우
    if(memberEmail.value.trim().length==0){
       
        emailMessage.classList.remove("confirm", "error");
    
        checkObj.memberEmail = false; 
        emailMessage="";
        return;
    }

    // 입력된 경우 
    // const regExp =/^[\w\-\_]{4,}@[\w\-\_]+(\.\w+){1,3}$/;
    const regExp = /^[\w\-\_]{4,}@[\w\-\_]+(\.\w+){1,3}$/;

    if(regExp.test(memberEmail.value)){ //유효한 경우 
        emailMessage.innerText="유효한 형식의 이메일입니다."
        emailMessage.classList.add("confirm");
        emailMessage.classList.remove("error");

        checkObj.memberEmail = true; 


    }else{ //유효하지 않은 경우
        emailMessage.innerText=" 유효하지 않은 형식입니다."
        emailMessage.classList.add("error");
        emailMessage.classList.remove("confirm");

        checkObj.memberEmail = false; 

    }
})



// 이름 유효성 검사
const memberName = document.getElementById("memberName");
const memberNameMessage = document.getElementById("memberNameMessage")

memberName.addEventListener("input",function(){

    // 입력이 되지 않은 경우
    if(memberName.value.trim().length==0){
        memberNameMessage.innerText="이름을 입력해주세요"
        memberNameMessage.classList.remove("confirm", "error");

        checkObj.memberName = false; // 유효하지 않은 상태임을 기록
        return;
    }

    //이름 정규식
    const regExp =/^[가-힣]{2,10}$/;
    
    if(regExp.test(memberName.value)){ //유효한 경우
        checkObj.memberName = true;
        memberNameMessage.innerText="유효한 이름 형식입니다."
        memberNameMessage.classList.add("confirm");
        memberNameMessage.classList.remove("error");

    
    }else{ // 유효하지 않은 경우
        memberNameMessage.innerText="이름 형식이 올바르지 않습니다."
        memberNameMessage.classList.add("error");
        memberNameMessage.classList.remove("confirm");
    
        checkObj.memberName = false; 
    }

});

// 비밀번호 유효성 검사 
const memberPw = document.getElementById("memberPw");
const memberPwConfirm = document.getElementById("memberPwConfirm");
const pwMessage= document.getElementById("pwMessage");

memberPw.addEventListener("input",function(){

    // 입력 되지 않은 경우 
    if(memberPw.value.trim().length==0){
        pwMessage.innerText = "영어, 숫자,특수문자(!,@,#,-,_) 6~30글자 입력해주세요"
        pwMessage.classList.remove("confirm", "error");

        checkObj.memberPw = false; //유효기록 X
        
    }

    const regExp = /^[\w!@#_-]{6,30}$/
    if(regExp.test(memberPw.value)){ //비밀번호가 유효한 경우
        
        checkObj.memberPw = true; //유효기록 O

        if(memberPwConfirm.value.trim().length ==0){ // 비밀번호 유효 , 확인 작성
            pwMessage.innerText="유효한 비밀번호입니다.";
            pwMessage.classList.add("confirm");
            pwMessage.classList.remove("error");
        
            
            
        }else{ // 비밀번호 유효 , 확인 작성O
            checkPw(); //비밀번호 일치 검사 함수 호출()
        }

        

    }else{
        pwMessage.innerText="유효하지 않은 비밀번호입니다."
        pwMessage.classList.add("error");
        pwMessage.classList.remove("confirm");

        checkObj.memberPw = false; //유효기록 X
    }


})

// 비밀번호 확인 유효성 검사

// 함수명() : 함수 호출(수행)
// 함수명   : 함수에 작성된 코드 반환
memberPwConfirm.addEventListener("input", checkPw);
// -> 이벤트가 발생되었을 때 정의된 함수를 호출하겠다.

function checkPw(){ //비밀번호 일치 검사

    //비밀번호 확인/ 비밀번호가 같을 경우
    if(memberPw.value == memberPwConfirm.value){
        pwMessage.innerText="비밀번호가 일치합니다.";
        pwMessage.classList.add("confirm");
        pwMessage.classList.remove("error");

        checkObj.memberPwConfirm = true; //유효기록 o
    } else {
        pwMessage.innerText="비밀번호가 일치하지않습니다.";
        pwMessage.classList.add("error");
        pwMessage.classList.remove("confirm");
        
        checkObj.memberPwConfirm = false; //유효기록 X
    }
}

// 아이디 중복 검사 
const memberId = document.getElementById("memberId");
const idMessage = document.querySelector("#idMessage");

memberId.addEventListener("input", function(){
    
    //입력이 되지 않은 경우
    if(memberId.value.trim().length==0){
        idMessage.innerText = "아이디를 입력하세요.(영어 대소문자, 숫자 입력 가능)";
        idMessage.classList.remove("confirm", "error");
    
        checkObj.memberId = false; 
        return;
    }

    // 입력된 경우 
    const regExp = /^(?=.*[A-Za-z]{3})[A-Za-z\d]{5,}$/

    if(regExp.test(memberId.value)){ //유효한 경우 
    

        ///************아이디 중복 검사 (ajax) 진행 예정************* */

        // $.ajax( {k:V , K:V}); //JQuery ajax의 기본 형태


        
        $.ajax({
            url : "idDupCheck", 
            // 필수 속성 url
            // 현재 주소 : /community/member/signUp
            // 절대 경로 : /community/member/emailDupCheck
            // 상대 경로 : emailDupCheck

            data : { "memberId" : memberId.value },
            // data 속성 : 비동기 통신시 서버로 전달할 값 작성(JS 객체 형식)
            // -> 비동기 통신 시 input 에 입력된 값을 
            //    "memberId"이라는 key 값(파라미터)으로 전달

            type : "GET", // 데이터 전달 방식 type

            success : function(result){
                // 비동기 통신 (ajax)가 오류없이 요청/ 응답 성공한 경우

                //매개변수 result : servlet 에서 출력된 result값이 담겨 잇음
                if(result == 1){ //중복 O
                    idMessage.innerText="이미 사용 중인 아이디입니다.."
                    idMessage.classList.add("error");
                    idMessage.classList.remove("confirm");
             
                    checkObj.memberId = false; 
                    
                }else{//중복 X
                    idMessage.innerText="사용 가능한 아이디입니다."
                    idMessage.classList.add("confirm");
                    idMessage.classList.remove("error");
                    
                    checkObj.memberId = true; 
            
                }
            },

            error : function(){
                //비동기 통신(ajax) 중 오류가 발생한 경우 
                console.log("에러발생");
            }
        })

    }else{ //유효하지 않은 경우
        idMessage.innerText=" 유효하지 않은 형식입니다."
        idMessage.classList.add("error");
        idMessage.classList.remove("confirm");

        checkObj.memberId = false; 

    }
})

function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            var addr = '';
            var extraAddr = '';

            if (data.userSelectedType === 'R') addr = data.roadAddress;
            else addr = data.jibunAddress;

            if(data.userSelectedType === 'R'){
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)) extraAddr += data.bname;
                if(data.buildingName !== '' && data.apartment === 'Y') extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                if(extraAddr !== '') extraAddr = ' (' + extraAddr + ')';
                document.getElementById("sample6_extraAddress").value = extraAddr;
            } else document.getElementById("sample6_extraAddress").value = '';

            document.getElementById('sample6_postcode').value = data.zonecode;
            document.getElementById("sample6_address").value = addr;
            document.getElementById("sample6_detailAddress").focus();
        }
    }).open();
}

function signValidate(){

    
    // checkObj에 있는 모든 속성을 반복접근하여
    // false가 하나라도 있는 경우 form 태그 기본 이벤트 제거

     let str;

    for( let key in checkObj){ //객체용 향상된 for문

        
        if ( !checkObj[key] ){
            switch(key){
                case"memberName" : str ="이름이"; break;
                case"memberId" : str ="아이디가"; break;
                case"memberEmail" : str="이메일이"; break;
                case"memberPw" : str="비번이"; break;
                case"memberPwConfirm" : str="비번확인이"; break;
                case"memberTel" : str="전화번호가"; break;

            }
            str +=" 오류발생ㅜㅜ"
        // 현재 접근중인 key 의 value 가 false인 경우

            alert(str);
            document.getElementById(key).focus()
            return false; //form 태그 기본 이벤트 제거
        }

    }

    return true;

}