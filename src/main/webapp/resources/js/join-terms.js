const all = document.getElementById("all-check"); // 전체 선택 체크박스
const checkList = document.getElementsByName("checkbox"); //취미 체크박스
        

    // 전체 선택 클릭 시 전체 선택 체크박스로 값 변경
    all.addEventListener("click",function(){
        for(let i=0; i<checkList.length; i++){
            checkList[i].checked = all.checked;
        }
    })
  
    // 체크 박스 선택시 전체 선택 여부 확인
    this.addEventListener("click",function(e){

        for(let i=0; i<checkList.length; i++){
            
            if(e.target == checkList[i]){
                //전부 선택 안 되어 있을 시 전체 선택 체크박스 해제
                if(!this.checked && all.checked){
                    //전체 선택이 체크 되어 있으면서 체크 박스가 해제 되어 있는 경우
                    all.checked=false;
                }

                //전부 선택이 되어 있을 시 전체 선택 체크박스 체크하기
                let flag =true;
                for(let j=0; j<checkList.length; j++){ //전부 체크 되었는 지 확인 하기 위한 for문
                    
                    if(!checkList[j].checked){ //하나라도 체크가 되어 있지않을 때
                        flag = false;
                    }

                } 
                //전체 선택 체크 박스가 체크 되어 있지 않으면서
                //선택이 되어 있는 경우
                if(!all.checked && flag){
                    all.checked=true;
                }
            }
        }
    })
    // 버튼 클릭시
    function nextBtn(){
        let flag= true;

        
        
        if(!checkList[0].checked||!checkList[1].checked){ //하나라도 체크가 되어 있지않을 때
            
            alert("약관을 모두 동의해 주세요");
            return false;
        }else{
            return true;
        }
        
    }
    

