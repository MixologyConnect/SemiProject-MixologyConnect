

function noticeImgValidate(){
    const inputImage = document.getElementById("input-image");

    const del = document.getElementById("delete");

    if(inputImage.value == "" && del.value == 0){
        alert("이미지가 선택되지 않았습니다.");
        return false;
    }
    return true;
}



const inputImage = document.getElementsByClassName("inputImage");
const preview = document.getElementsByClassName("preview");
const deleteImage = document.getElementsByClassName("delete-image");

const deleteList = document.getElementById("deleteList");

const deleteSet = new Set(); 

for(let i=0; i <inputImage.length; i++){

    inputImage[i].addEventListener("change", function(){
        if(this.files[0] != undefined){ 
            const reader = new FileReader();
            reader.readAsDataURL(this.files[0]);

            reader.onload = function(e){ 
                preview[i].setAttribute("src", e.target.result);

                deleteSet.delete(i);

            }
        } else{ 
            preview[i].removeAttribute("src");

        }

    });

    deleteImage[i].addEventListener("click",function(){

        if(preview[i].getAttribute("src") != ""){
            
            preview[i].removeAttribute("src");
    
            inputImage[i].value = "";
    
            deleteSet.add(i);

        }

    })
}