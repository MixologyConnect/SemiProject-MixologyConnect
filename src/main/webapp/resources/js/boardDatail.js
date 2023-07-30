
/* 좋아요 누르면 하트 채워지기 */

var cnt = 1;

function likeBtnClick() {

    const img = document.getElementById("likeBtnImg");
    img.src = contextPath + "/resources/images/heart-fill.svg";

    if(cnt%2==1) {
        img.src = contextPath + "/resources/images/heart-fill.svg";
    }else {
        img.src = contextPath + "/resources/images/heart.svg";
    }
    cnt++;
}

function bookBtnClick() {

    const img = document.getElementById("bookBtnImg");
    img.src = contextPath + "/resources/images/bookmark-fill.svg";

    if(cnt%2==1) {
        img.src = contextPath + "/resources/images/bookmark-fill.svg";
    }else {
        img.src = contextPath + "/resources/images/bookmark.svg";
    }
    cnt++;
}




    const deleteList = document.getElementById("deleteList");
    const inputImage = document.getElementsByClassName("inputImage");
    const preview = document.getElementsByClassName("preview");
    const deleteImage = document.getElementsByClassName("delete-image");

    const deleteSet = new set();

    for(let i = 0; i < inputImage.length; i++){

        inputImage[i].addEventListener("change", function(){

            if(this.files[0] != undefined){
                const reader = new FileReader();
                reader.readAsDataURL(this.files[0]);

                reader.onload = function(e){
                    preview[i].setAttribute("src", e.target.result);
                }

                deleteSet.delete[i];
            }else{
                preview[i].removeAttribute("src");
            }
        });

        deleteImage[i].addEventListener("click", function(){

            if(preview[i].getAttribute("src" != "")){
                preview[i].removeAttribute("src");
                inputImage[i].value = "";
                deleteSet.add(i);
            }
        })
    }




const boardTitle = document.getElementById("title")
const boardContent = document.getElementById("detail")

function writeValidate(){

    if(boardTitle.value.trim().length == 0){
        alert("제목을 입력해주세요");
        boardTitle.value = "";
        boardTitle.focus();
        return false;
    }

        if(boardContent.value.trim().length == 0){
        alert("내용을 입력해주세요");
        boardContent.value = "";
        boardContent.focus();
        return false;
        }
    
    deleteList.value = Array.from(deleteSet);

    return true;
}










$.ajax({
url: 'https://gist.githubusercontent.com/abs013r/cb774124e29ab7e396b638939ec0bda1/raw/479c0716a7104236e2e4fdc089586b3aeef5831b/MCnav.html',
type: 'GET',
success: function(data) { $('#mc-nav').html(data); },
error: function() { console.log('이거 뜨면 실패입니다… 조훈한테 문의하세요'); }
});

$.ajax({
url: 'https://gist.githubusercontent.com/abs013r/0d6ff4139684cf842192a2d312266a83/raw/6e629f95c437670fc573560fd8559829a25b30c8/MCfooter.html',
type: 'GET',
success: function(data) { $('#mc-footer').html(data); },
error: function() { console.log('이거 뜨면 실패입니다… 조훈한테 문의하세요'); }
});
