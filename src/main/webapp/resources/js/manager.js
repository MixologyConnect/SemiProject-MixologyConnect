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
