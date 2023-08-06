/* 게시글 글자 수 세기 */
document.getElementById("boardContent").addEventListener("input", function () {
    let length = this.value.length;
    console.log(length);

    let interval;

    document.getElementById("counter").innerText = length;
    if (length <= 499 && length >= 0) {
        document.getElementById("counter").style.color = "black";

    } else {
        document.getElementById("counter").style.color = "red"



        document.getElementById("counter").innerText = 500;
    }

})

document.getElementById("title").addEventListener("input", function () {

    let length = this.value.length;

    let interval;

    if (length <= 20 && length >= 0) {
        this.style.color = "black";

    } else {
        this.innerText = 20;

    }


})



const inputImage = document.getElementsByClassName("inputImage");
const preview = document.getElementsByClassName("preview");
const deleteImage = document.getElementsByClassName("delete-image");




// 게시글 수정 시 삭제된 이미지 레벨(위치)를 저장할 input 요소
const deleteList = document.getElementById("deleteList");


// 게시글 수정 시 삭제된 이미지의 레벨(위치)를 기록해둘 Set 생성
const deleteSet = new Set(); // 순서 X, 중복 허용 X (여러번 클릭 시 중복 값 저장 방지)


$(document).ready(() => {
    /* 값이 있을 때만 삭제 버튼 띄우기 */
    let imgs = $('.preview');
    console.log(imgs.length)

    for (let j = 0; j < imgs.length; j++) {
        if (imgs[j].currentSrc !== '') {
            deleteImage[j].style.display = "block";
        } else {
            deleteImage[j].style.display = "none";
        }
    }
})



for (let i = 0; i < inputImage.length; i++) {
    // 페이지 로드 시와 input 요소의 값이 변할 때마다 체크

    inputImage[i].addEventListener("input", function () {
        if (inputImage[i].value.trim() !== '') {
            // 값이 있으면 deleteImage를 보여줌
            deleteImage[i].style.display = 'block';
        } else {
            // 값이 없으면 deleteImage를 숨김
            deleteImage[i].style.display = 'none';
        }
    });

    // 미리보기 삭제 버튼이 클릭 되었을 때의 동작
    deleteImage[i].addEventListener("click", function () {
        if (preview[i].getAttribute("src") != "") {
            preview[i].removeAttribute("src");
            inputImage[i].value = "";
            deleteSet.add(i);

        }
        if (inputImage[i].value.trim() === "") {
            deleteImage[i].style.display = "none";
        }
    })

    // 파일이 선택 되었을 때
    inputImage[i].addEventListener("change", function () {

        if (this.files[0] != undefined) {
            const reader = new FileReader();
            reader.readAsDataURL(this.files[0]);

            reader.onload = function (e) {
                preview[i].setAttribute("src", e.target.result);
            }
            deleteSet.delete(i);
        } else {
            preview[i].removeAttribute("src");
        }
    });


}

/* 유효성 검사 */
function writeValidate() {

    const boardTitle = document.getElementById("boardTitle")
    const boardContent = document.getElementById("boardContent")
    if (boardTitle.value.trim().length == 0) {
        alert("제목을 입력해주세요");
        boardTitle.value = "";
        boardTitle.focus();
        return false;
    }

    if (boardContent.value.trim().length == 0) {
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
    success: function (data) { $('#mc-nav').html(data); },
    error: function () { console.log('이거 뜨면 실패입니다… 조훈한테 문의하세요'); }
});

$.ajax({
    url: 'https://gist.githubusercontent.com/abs013r/0d6ff4139684cf842192a2d312266a83/raw/6e629f95c437670fc573560fd8559829a25b30c8/MCfooter.html',
    type: 'GET',
    success: function (data) { $('#mc-footer').html(data); },
    error: function () { console.log('이거 뜨면 실패입니다… 조훈한테 문의하세요'); }
});




