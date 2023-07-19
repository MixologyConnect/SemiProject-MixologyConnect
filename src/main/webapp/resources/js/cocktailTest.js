




/* 취향테스트 버튼 누르면 실행 */
$(function(){

    $("#btn").on("click", function(){
        // console.log("dd")

        $(".text").hide(0)

        $(".q1").show(700)

    })

})

/* q1 선택지 누르면 실행 */
$(function(){

    $(".q1-btn").on("click", function(){
        // console.log("dd")


        $(".q1").hide(0)

        $(".q2").show(700)


    })

})

/* 뒤로가기 버튼 */
$(function(){
    $(".back").on("click", function(){
        $(this).parent().hide(0)

        $(this).parent().prev().show(700)
    })
})

/* q2 선택지 누르면 실행 */
$(function(){

    $(".q2-btn").on("click", function(){
        // console.log("dd")


        $(".q2").hide(0)

        $(".q3").show(700)

    })

})

/* q3 선택지 누르면 실행 */
$(function(){

    $(".q3-btn").on("click", function(){
        // console.log("dd")


        $(".q3").hide(0)

        $(".q4").show(700)

    })

})

/* q4 선택지 누르면 실행 */
$(function(){

    $(".q4-btn").on("click", function(){
        // console.log("dd")


        $(".q4").hide(0)

        $(".q5").show(700)

    })

})
/* q5 선택지 누르면 실행 */
$(function(){

    $(".q5-btn").on("click", function(){
        // console.log("dd")


        $(".q5").hide(0)

        $(".q6").show(700)

    })

})
/* q6-one 선택지 누르면 실행 */
$(function(){

    $("#one").on("click", function(){
        // console.log("dd")


        $(".q6").hide(0)

        $(".loading-page").show(400)
        

        setTimeout(() => $(".loading-page").hide(0), 4000);
        setTimeout(() => $(".result").show(500), 4500);
        
    })
    
    
})

/* q6-two 선택지 누르면 실행 */
$(function(){

    $("#two").on("click", function(){
        // console.log("dd")


        $(".q6").hide(0)

        $(".loading-page").show(400)
        

        setTimeout(() => $(".loading-page").hide(0), 4000);
        setTimeout(() => $(".result-two").show(500), 4500);
        
    })
    
    
})

/* q6-three 선택지 누르면 실행 */
$(function(){

    $("#three").on("click", function(){
        // console.log("dd")


        $(".q6").hide(0)

        $(".loading-page").show(400)
        

        setTimeout(() => $(".loading-page").hide(0), 4000);
        setTimeout(() => $(".result-three").show(500), 4500);
        
    })
    
    
})

/* q6-four 선택지 누르면 실행 */
$(function(){

    $("#four").on("click", function(){
        // console.log("dd")


        $(".q6").hide(100)

        $(".loading-page").show(400)
        

        setTimeout(() => $(".loading-page").hide(0), 4000);
        setTimeout(() => $(".result-four").show(500), 4500);
        
    })
    
    
})


$(".reset").click(function(){
    location.reload();
});
    
    

































$.ajax({
    url: 'https://gist.githubusercontent.com/abs013r/cb774124e29ab7e396b638939ec0bda1/raw/c0303d21e15c1662ede56256501ed2bc02cc3551/MCnav.html', // 데이터가 있는 HTML 파일의 경로
    type: 'GET',
    success: function(data) { $('#mc-nav').html(data); },
    error: function() { console.log('이거 뜨면 실패입니다… 조훈한테 문의하세요'); }
});

$.ajax({
    url: 'https://gist.githubusercontent.com/abs013r/0d6ff4139684cf842192a2d312266a83/raw/3ac3eabdaa77b9528c3194060cfeccc5d14f0ff8/MCfooter.html', // 데이터가 있는 HTML 파일의 경로
    type: 'GET',
    success: function(data) { $('#mc-footer').html(data); },
    error: function() { console.log('이거 뜨면 실패입니다… 조훈한테 문의하세요'); }
});
