function searchValidate(){
    const query = document.getElementById("search");

    if(query.value.trim().length == 0){
        query.value="";
        query.focus();
        alert("검색어를 입력해주세요");

        return false;
    }

    return true;
}