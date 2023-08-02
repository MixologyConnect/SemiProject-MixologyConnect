// 전체 선택 
const all = document.getElementById("all")
const feedList = document.getElementsByName("feed")

all.addEventListener("click", function(){
    for(let i=0; i<feedList.length; i++){
        feedList[i].checked = all.checked;
    }
    allcheck();
})


const value = ""
for(let i=0; i<feedList.length; i++){
    if(feedList[i].checked){

        value = feedList[i].checked.value
        console.log(value)
    }
}


this.addEventListener("click", function(e){
    for(let i=0; i<feedList.length; i++){
        if(e.target == feedList[i]){

            if(!this.checked && all.checked){
                all.checked = false;
            }

            let flag = true;
            for(let j=0; j<feedList.length; j++){

                if(!feedList[j].checked){
                    flag = false;
                }

           }

           if(!all.checked && flag){
                all.checked = true;
           }
        }
    }
})

const checkbox = document.getElementById("checkbox")

var postCheck = document.getElementsByName("feed")
var boardNum = ""

function allcheck(){


    for(let i=0; i<postCheck.length; i++){
        if(postCheck[i].checked){
            console.log(postCheck[i].value)
        }
    }
}

const length = $("input:checkbox[name=feed]").length
const checked = $("input:checkbox[name=feed]:checked").length












