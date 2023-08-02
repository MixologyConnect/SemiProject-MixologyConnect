/* 게시글 글자 수 세기 */
document.getElementById("boardContent").addEventListener("input", function() {
let length = this.value.length;
console.log(length);
    
let interval;

document.getElementById("counter").innerText = length ;
if(length <= 499 && length >= 0) {
    document.getElementById("counter").style.color = "black";
    
} else { 
    document.getElementById("counter").style.color = "red"
    


    document.getElementById("counter").innerText = 500;
}

})

document.getElementById("title").addEventListener("input", function() {

let length = this.value.length;

let interval;

if(length <= 20 && length >= 0){
    this.style.color = "black";
    
}else {
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



for(let i = 0; i<inputImage.length; i++){

    // 파일이 선택 되었을 때
    inputImage[i].addEventListener("change", function(){

        if(this.files[0] != undefined){ // 파일이 선택 되었을 때
            const reader = new FileReader(); // 선택된 파일을 읽을 객체 생성
            reader.readAsDataURL(this.files[0]);
            // 지정된 파일을 읽음 -> result에 저장(URL 포함) -> URL을 이용해서 이미지를 볼 수 있음

            reader.onload = function(e){ // reader가 파일을 다 읽어온 경우
               // e.target == reader
               // e.target.result == 읽어들인 이미지의 URL
               // preview[i] == 파일이 선택된 input태그와 인접한 preview 이미지 태그
               preview[i].setAttribute("src", e.target.result);

            }

            // 이미지가 성공적으로 불러와졌을 때
            // deleteSet에서 해당 레벨을 제거 (삭제 목록에서 제외)
            deleteSet.delete(i);

        }else{ // 파일이 선택되지 않았을 때 (취소)
            preview[i].removeAttribute("src"); // src 속성 제거
        }
    });

    // 미리보기 삭제 버튼(X)이 클릭 되었을 때의 동작
    deleteImage[i].addEventListener("click", function(){

        // 미리보기가 존재하는 경우에만(이전에 추가된 이미지가 있을 때만) X버튼 동작
        if(preview[i].getAttribute("src") != ""){
            // 미리보기 삭제
            preview[i].removeAttribute("src"); 
    
            // input의 값을 "" 만들기
            inputImage[i].value = "";
    
            // deleteSet에 삭제된 이미지 레벨(i) 추가
            deleteSet.add(i);

        }

    })
}

    

    
    function writeValidate(){
        
    const boardTitle = document.getElementById("boardTitle")
    const boardContent = document.getElementById("boardContent")
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


    

