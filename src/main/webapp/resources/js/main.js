let scrollY;

function getScrollY() {
    var scrollY = window.scrollY || document.documentElement.scrollTop;
    return scrollY;
}

function preventScroll(b) {
    if (typeof b == 'undefined') return scrollY ? true : false;
    if (b) {
        scrollY = getScrollY()
        $('body').css({'position': 'fixed',
                       'top': '-' + scrollY + 'px'});
        return;
    }
    $('body').css({'position': '',
                   'top': ''});
    window.scrollTo(0, scrollY);
    scrollY = null;
}

window.addEventListener('scroll', function(e) {
    if (getScrollY() <= 0 && preventScroll() == false) {
        $('nav').css({'filter': 'opacity(100%)',
                      'pointer-events': 'auto'});
        $('header').css({'height': '120px',
                         'transform': 'translateY(0px)'});
        $('#title').css({'pointer-events': 'auto',
                         'filter': 'opacity(100%)'});
        $('#account > label > img').css('transform', 'none');
        $('#account > label > p').css({'pointer-events': 'auto',
                                       'filter': 'opacity(100%)'});
    } else {
        $('nav').css({'filter': 'opacity(0%)',
                      'pointer-events': 'none'});
        $('header').css({'height': '120px',
                         'transform': 'translateY(-50px)'});
        $('#title').css({'pointer-events': 'none',
                         'filter': 'opacity(0%)'});
        $('#account > label > img').css('transform', 'translate(23px, -13px)');
        $('#account > label > p').css({'pointer-events': 'none',
                                       'filter': 'opacity(0%)'});
    }
});

$('nav > a').hover(function() {
    $('header').css('borderColor', 'rgb(0, 220, 244)');
    $('nav ').css('borderColor', 'rgb(0, 220, 244)');
}, function () {
    $('header').css('borderColor', 'lightgray');
    $('nav').css('borderColor', 'lightgray');
});

$('#login').change(function() {
    if ($(this).prop('checked')) {
        preventScroll(true);
        $('#overlay').css({'pointer-events': 'auto',
                           'opacity': '100%'});
        $('#modal-account').css({'pointer-events': 'auto',
                                 'opacity': '100%'});
        $('#account > label > p').css('color', 'rgb(0, 220, 244)');
    } else {
        preventScroll(false);
        $('#overlay').css({'pointer-events': 'none',
                           'opacity': '0'});
        $('#modal-account').css({'pointer-events': 'none',
                                 'opacity': '0'});
        $('#account > label > p').css('color', '');
    }
})