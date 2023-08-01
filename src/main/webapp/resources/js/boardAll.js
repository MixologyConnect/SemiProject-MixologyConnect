
$.ajax({
  url: 'https://gist.githubusercontent.com/abs013r/cb774124e29ab7e396b638939ec0bda1/raw/17f5e332384beed4ac8c1f344dcba1a9759807e7/MCnav.html',
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







