function initMap() {
    let map = new naver.maps.Map('map', {center: new naver.maps.LatLng(37, 127), zoom: 15})
}

function searchPlace(place) {
    let e = $("#place-content");
    e.empty();
    $.ajax({
        url: "place",
        type: "post",
        data: {"keyword": place + "칵테일 바"},
        dataType: "JSON",
        success: function(result) {
            result = JSON.parse(result);
            for (let i of result.items) {
                let li = document.createElement("li");
                li.innerHTML = `<img>
                                <h2 class='title'>` + i.title + `</h2>
                                <p class='category'>` + i.category + `</p>
                                <p>`+ i.address + `</p>
                                <a href='` + i.link + `'>` + i.link + `</a>`;
                e.append(li);
            }
        },
        error: function() {
            console.log("에러가 발생했습니다.")
        }
    });
}

$("#place-search").click(function() {
    searchPlace($("#place-input").val());
});

(() => {
    initMap()
    searchPlace("강남 ");
})();