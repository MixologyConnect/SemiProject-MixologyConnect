
/* 취향테스트 버튼 누르면 실행 */
$(function(){

    $("#btn").on("click", function(){
        // console.log("dd")

        $(".text").hide(0)

        $(".q1").show(700)
        
        

    })

})

/* 뒤로가기 버튼(공통질문의) */
$(function(){
    $(".back-re").on("click", function(){
        $(this).parent().parent().hide(0)

        $(this).parent().parent().prev().show(700)
    })
})

/* 뒤로가기 버튼 */
$(function(){
    $(".back").on("click", function(){
        $(this).parent().parent().hide(0)

        $(".q1-soju").prev().show(700)
    })
})
/* 뒤로가기 버튼 */
$(function(){
    $(".back-3").on("click", function(){
        $(this).parent().parent().hide(0)

        $(this).parent().parent().prev().show(700)
    })
})

/* --------------------------------------------------------------------------- */



/* q1(소주) 선택지 누르면 실행 */
$(function(){

    $(".soju-btn").on("click", function(){
        // console.log("dd")


        $(".q1").hide(0)

        $(".q1-2").show(700)


    })

})

/* q1-2(소주) 선택지 누르면 실행 */
$(function(){

    $(".q2-btn").on("click", function(){ // 주량
        // console.log("dd")


        $(".q1-2").hide(0)

        $(".q1-3").show(700)

    })

})

/* q1-3(소주) 달달 선택지 누르면 실행 */
$(function(){
    let numSoju1 = Math.floor(Math.random()*3)+1;

    $(".q3-sojusweet-btn").on("click", function(){ // 달달
        // console.log("dd")


        $(".q1-3").hide(0)

        $(".loading-page").show(400)

        setTimeout(() => $(".loading-page").hide(0), 4000);
        setTimeout(() => $(".result" + numSoju1).show(500), 4500);



    })

})

/* q1-3(소주) 씁쓸 선택지 누르면 실행 */
$(function(){
    let numSoju2 = Math.floor(Math.random()*3)+4;

    $(".q3-sojucoke-btn").on("click", function(){ // 씁쓸
        // console.log("dd")


        $(".q1-3").hide(0)

        $(".loading-page").show(400)

        setTimeout(() => $(".loading-page").hide(0), 4000);
        setTimeout(() => $(".result" + numSoju2).show(500), 4500);

    })

})



//-----------------------------------------------------------------------


/* 뒤로가기 버튼(공통질문의) */
$(function(){
    $(".back-re").on("click", function(){
        $(this).parent().parent().hide(0)

        $(this).parent().parent().prev().show(700)
    })
})

/* 뒤로가기 버튼 */
$(function(){
    $(".back-beer").on("click", function(){
        $(this).parent().parent().hide(0)

        $(".q2-beer").prev().prev().show(700)
    })
})

/* 뒤로가기 버튼 */
$(function(){
    $(".back-3").on("click", function(){
        $(this).parent().parent().hide(0)

        $(this).parent().parent().prev().show(700)
    })
})






/* q1(맥주) 선택지 누르면 실행 */
$(function(){

    $(".beer-btn").on("click", function(){
        // console.log("dd")


        $(".q1").hide(0)

        $(".q2-2").show(700)

    })

})

/* q1(맥주) 주량 선택지 누르면 실행 */
$(function(){

    $(".q2-1-btn").on("click", function(){
        // console.log("dd")


        $(".q2-2").hide(0)

        $(".q2-3").show(700)

    })

})

/* q1(맥주) 흑맥 선택지 누르면 실행 */
$(function(){
    const numBeerBlack = Math.floor(Math.random()*3)+7;

    $(".q3-1-btn").on("click", function(){
        // console.log("dd")


        $(".q2-3").hide(0)

        $(".loading-page").show(400)

        setTimeout(() => $(".loading-page").hide(0), 4000);
        setTimeout(() => $(".result" + numBeerBlack).show(500), 4500);

    })

})

/* q1(맥주) 라거 선택지 누르면 실행 */
$(function(){
    let numBeerLager = Math.floor(Math.random()*3)+10;
    console.log(numBeerLager)

    $(".q3-2-btn").on("click", function(){
        // console.log("dd")


        $(".q2-3").hide(0)

        $(".loading-page").show(400)

        setTimeout(() => $(".loading-page").hide(0), 4000);
        setTimeout(() => $(".result" + numBeerLager).show(500), 4500);

    })

})



// ----------------------------------------------------------------------------------



/* 뒤로가기 버튼(공통질문의) */
$(function(){
    $(".back-re").on("click", function(){
        $(this).parent().parent().hide(0)

        $(this).parent().parent().prev().show(700)
    })
})

/* 뒤로가기 버튼 */
$(function(){
    $(".back-beer").on("click", function(){
        $(this).parent().parent().hide(0)

        $(".q2-beer").prev().prev().show(700)
    })
})

/* 뒤로가기 버튼 */
$(function(){
    $(".back-3").on("click", function(){
        $(this).parent().parent().hide(0)

        $(this).parent().parent().prev().show(700)
    })
})




/* q1(이슬톡톡) 선택지 누르면 실행 */
$(function(){

    $(".non-btn").on("click", function(){
        // console.log("dd")


        $(".q1").hide(0)

        $(".q3-2").show(700)

    })

})


/* q1(이슬톡톡) 주량 선택지 누르면 실행 */
$(function(){

    $(".q3-q-btn").on("click", function(){
        // console.log("dd")


        $(".q3-2").hide(0)

        $(".q3-3").show(700)

    })

})

/* q1(이슬톡톡) 달달 선택지 누르면 실행 */
$(function(){
    let numLessSweet = Math.floor(Math.random()*3)+13;

    $(".q3-3-1-btn").on("click", function(){
        // console.log("dd")


        $(".q3-3").hide(0)

        $(".loading-page").show(400)

        setTimeout(() => $(".loading-page").hide(0), 4000);
        setTimeout(() => $(".result" + numLessSweet).show(500), 4500);

    })

})

/* q1(이슬톡톡) 청량 선택지 누르면 실행 */
$(function(){
    let numLessCoke = Math.floor(Math.random()*3)+16;

    $(".q3-3-2-btn").on("click", function(){
        // console.log("dd")


        $(".q3-3").hide(0)

        $(".loading-page").show(400)

        setTimeout(() => $(".loading-page").hide(0), 4000);
        setTimeout(() => $(".result" + numLessCoke).show(500), 4500);

    })

})





/* 테스트 다시하기 버튼 클릭 */
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
