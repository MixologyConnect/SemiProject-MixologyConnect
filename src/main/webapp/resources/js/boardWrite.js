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


    

