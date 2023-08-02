const inputImage = document.getElementById("input-image");

if(inputImage != null){

    inputImage.addEventListener("change", function(){
        if(this.files[0] != undefined){
            const reader = new FileReader();

            reader.readAsDataURL(this.files[0]);

            reader.onload = function(e){

                const noticeImage= document.getElementById("notice-image");

                noticeImage.setAttribute("src", e.target.result);

                document.getElementById("delete").value == 0;

            }
        } 
    });
}

function noticeImgValidate(){
    const inputImage = document.getElementById("input-image");

    const del = document.getElementById("delete");

    if(inputImage.value == "" && del.value == 0){
        alert("이미지가 선택되지 않았습니다.");
        return false;
    }
    return true;
}

document.getElementById("delete-image").addEventListener("click",function(){

    const del = document.getElementById("delete");

    if(del.value == 0){

        document.getElementById("input-image").value = "";

        del.value = 1;
    }
})