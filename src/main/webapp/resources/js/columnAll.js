function searchValidate(){
    const columnquery = document.getElementById("search");

    if(columnquery.value.trim().length == 0){
        columnquery.value="";
        columnquery.focus();
        alert("검색어를 입력해주세요");

        return false;
    }

    return true;
}