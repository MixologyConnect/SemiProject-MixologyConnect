var map = null;

$.getScript("https://oapi.map.naver.com/openapi/v3/maps.js?ncpClientId=cz1labzu75&submodules=geocoder", function() {
    map = new naver.maps.Map("map", {center: new naver.maps.LatLng(37, 127), zoom: 15})
});

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
                latLng = naver.maps.TransCoord.fromTM128ToLatLng(new naver.maps.Point(i.mapx, i.mapy));
                map.setCenter(latLng);
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