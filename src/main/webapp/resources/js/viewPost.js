
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