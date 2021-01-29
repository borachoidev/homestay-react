'use strict';































var mapContainer = document.getElementById('mapBox'), // 지도를 표시할 div 
      mapOption = { 
            center: new kakao.maps.LatLng(37.39787021805673, 126.91894738515842), // 지도의 중심좌표
            level: 13 // 지도의 확대 레벨
      };

      // 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
      var map = new kakao.maps.Map(mapContainer, mapOption); 


      var markerPosition  = new kakao.maps.LatLng(37.555188101592755, 126.97640613899671);
      var markerPosition2  = new kakao.maps.LatLng(35.27942129788492, 129.02025765801514);
	  var markerPosition3  = new kakao.maps.LatLng(35.0649564575427, 126.82415007526825);
      // 마커를 생성합니다
      var marker = new kakao.maps.Marker({
      position: markerPosition
      });
      var marker2 = new kakao.maps.Marker({
      position: markerPosition2
	  });
	  var marker3 = new kakao.maps.Marker({
      position: markerPosition3
      });

      // 마커가 지도 위에 표시되도록 설정합니다
      marker.setMap(map);
	  marker2.setMap(map);
	  marker3.setMap(map);
	  
/////////////////////
var linePath = [
	new kakao.maps.LatLng(37.555188101592755, 126.97640613899671),
	new kakao.maps.LatLng(35.27942129788492, 129.02025765801514),
    new kakao.maps.LatLng(35.0649564575427, 126.82415007526825)
    
   
];

// 지도에 표시할 선을 생성합니다
var polyline = new kakao.maps.Polyline({
    path: linePath, // 선을 구성하는 좌표배열 입니다
    strokeWeight: 5, // 선의 두께 입니다
    strokeColor: 'red', // 선의 색깔입니다
    strokeOpacity: 0.7, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
    strokeStyle: 'solid' // 선의 스타일입니다
});

// 지도에 선을 표시합니다 
polyline.setMap(map);

var distance = polyline.getLength();
var distanceKm = (distance/1000).toFixed(1);
// console.log(distanceKm+"km");

let distanceCourse = document.querySelector(".count-box__distance-text");

function write(){
	distanceCourse.innerText = `코스 총거리 : ${distanceKm}km`;
}

write();




	  //댓글 글자 수
	function counter(){
		let content = document.getElementById('contentBox').value;
		if(content.length > 200){
			content = content.substring(0,200);
			document.getElementById('contentBox').value = content;
		}
		document.getElementById('count').innerHTML = '('+content.length+'/200)';
	}
    counter();
    
function back(){
    history.back();
}

