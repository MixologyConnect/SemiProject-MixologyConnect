/* 게시글 글자 수 세기 */
document.getElementById("detail").addEventListener("input", function() {
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



    

// 미리보기 관련 요소 모두 얻어오기 
const inputImage = document.getElementsByClassName("inputImage")[0];
const preview = document.getElementsByClassName("preview")[0];
const deleteImage = document.getElementsByClassName("delete-image")[0];

const deleteList = document.getElementById("deleteList");

const deleteSet = new Set(); 

inputImage.addEventListener("change",function(){
    if(this.files[0] != undefined){
        const reader = new FileReader();
        reader.readAsDataURL(this.files[0])

        reader.onload =function(e){
            preview.setAttribute("src", e.target.result);
            deleteSet.delete(0);
        }
    }else{
        preview.removeAttribute("src");
    }
})

deleteImage.addEventListener("click", function(){
    if(preview.getAttribute("src") !=""){
        preview.removeAttribute("src");
        inputImage.value=""
        deleteSet.add(0);
    }
})

// 유효성 검사
function writeValidate(){
    const boardTitle = document.getElementsByName("boardTitle")[0];
    const boardContent = document.querySelector("[name='boardContent']");

    if(boardTitle.value.trim().length == 0){
        alert("컬럼 제목을 입력해주세요");
        boardTitle.value = "";
        boardTitle.focus();
        return false;
    }

    if(boardContent.value.trim().length == 0){
        alert("컬럼 내용을 입력해주세요");
        boardContent.value = "";
        boardContent.focus();
        return false;
    }

    deleteList.value = Array.from(deleteSet);

    return true;
}