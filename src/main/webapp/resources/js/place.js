var map = null;

$.getScript("https://oapi.map.naver.com/openapi/v3/maps.js?ncpClientId=cz1labzu75&submodules=geocoder", function() {
    map = new naver.maps.Map("map", {center: new naver.maps.LatLng(37, 127), zoom: 15})
});

function searchPlace(place) {
    let e = $("#place-content");
    let x;
    let y;
    e.empty();
    $.ajax({
        url: "place",
        type: "post",
        data: {"keyword": place + "칵테일 바"},
        dataType: "JSON",
        success: function(result) {
            result = JSON.parse(result);
            let latLng;
            let mapXSum = 0;
            let mapYSum = 0;
            for (let i of result.items) {
                let li = document.createElement("li");
                li.innerHTML = `<img>
                                <h2 class='title'>` + i.title + `</h2>
                                <p class='category'>` + i.category + `</p>
                                <p>`+ i.address + `</p>
                                <a href='` + i.link + `'>` + i.link + `</a>`;
                e.append(li);
                mapXSum += Number(i.mapx);
                mapYSum += Number(i.mapy);
                let marker = new naver.maps.Marker({
                    position: new naver.maps.LatLng(naver.maps.TransCoord.fromTM128ToLatLng(new naver.maps.Point(i.mapx, i.mapy))),
                    map: map,
                    title: i.title,
                    icon: {
                        content: `<div style='color: red;'>` + i.title + `</div>`,
                        size: new naver.maps.Size(38, 58),
                        anchor: new naver.maps.Point(19, 58)
                    }
                });
            }
            map.setCenter(naver.maps.TransCoord.fromTM128ToLatLng(new naver.maps.Point(mapXSum/5, mapYSum/5)));
        },
        error: function() {
            console.log("에러가 발생했습니다.")
        }
    });
}

$("#place-search").click(function() {
    searchPlace($("#place-input").val());
});