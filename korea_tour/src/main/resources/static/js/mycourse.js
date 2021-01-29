'use strict';

const link= decodeURI(document.location.href);
const contentId=link.split('=');
const id=contentId[1];

const placeBox = document.querySelector("#placeBox");
const totalCountBox = document.querySelector("#totalCount");

function myCourseList(){
    var xhr = new XMLHttpRequest();
    var url = '/mypage/coursedetail/'+id;
    xhr.open('GET', url);
    xhr.send();
    console.log(url);

    xhr.onreadystatechange = function(){
        if (this.readyState == 4) {
            let data = JSON.parse(this.responseText);
            let item = data.coursePlaceList;
            console.log(item);
            let totalCount = item.length;
            totalCountBox.innerHTML = "총"+totalCount+"건";


            let s=" ";
            for(let i=0; i<item.length; i++){
                let title = item[i].title;
                let addr = item[i].addr1;
                let firstImage = item[i].firstImage;
                let placeId = item[i].contentId;


                s+=`<div class="course-box" seq=${placeId}>`;
                s+=`<div class="image-box">`;
                s+=`<img src=${firstImage} alt=${title} onerror="this.src='/img/noimage.png'">`;
                s+=`</div>`;
                s+=`<div class="course-info__box">`;
                s+=`<div class="course-info">`;
                s+=`<p class="course-name" onclick='location.href="/tourplace/detail?contentId=${placeId}"'>${title}</p>`;
                s+=`<p class="course-start">${addr}</p>`;
                s+=`</div>`;
                s+=`<i class="fas fa-ellipsis-v course-icon" onclick="moveUp(${placeId})"></i>`;
                s+=`<i class="fas fa-ellipsis-v course-icon" onclick="moveDown(${placeId})"></i>`;
                s+=`</div>`;
                s+=`</div>`;
                
            }
            placeBox.innerHTML = s;
        }
    }
}


var mapxhr = new XMLHttpRequest();
        var mapurl = '/mypage/coursedetail/'+id;
        mapxhr.open('GET', mapurl);
        mapxhr.send();

        mapxhr.onreadystatechange = function(){
        if (this.readyState == 4) {
            var mapContainer = document.getElementById('mapBox'), // 지도를 표시할 div 
        mapOption = { 
            center: new kakao.maps.LatLng(35.56568016231779, 127.93715554020916), // 지도의 중심좌표
            level: 13 // 지도의 확대 레벨
        };

        // 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
        var map = new kakao.maps.Map(mapContainer, mapOption); 
            let mapdata = JSON.parse(this.responseText);
            let mapitem = mapdata.coursePlaceList;
            let linePath = new Array();
            for(let m=0; m<mapitem.length; m++){

            
            let mapX = mapitem[m].mapX;
            let mapY = mapitem[m].mapY;
            //console.log(mapX+","+mapY);

            //linePath 배열안에 좌표넣기
            linePath.push(new kakao.maps.LatLng(mapY, mapX));

            //마커의 위치
            var markerPosition = new kakao.maps.LatLng(mapY, mapX);
        
            // 마커를 생성합니다
            var marker = new kakao.maps.Marker({
            position: markerPosition
            });
        

            // 마커가 지도 위에 표시되도록 설정합니다
            marker.setMap(map);
	  
            }

            console.log(linePath);
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
            distanceCourse.innerText = `코스 총거리 : ${distanceKm}km`;
                    }
                }

myCourseList();




function moveUp(contentId) {
	
    var movingDiv = document.querySelector(".course-box[seq='"+contentId+"']") 

    var prevDiv = movingDiv.previousSibling;

    if(prevDiv==null){
        alert("첫번째 입니다")
    }else{
     let tempDiv=movingDiv;

     movingDiv.remove();
     
     placeBox.insertBefore(tempDiv, prevDiv);
    }
    

//	moveCourseSave();
};

function moveDown(contentId) {


    var movingDiv = document.querySelector(".course-box[seq='"+contentId+"']") 

    var nextDiv = movingDiv.nextSibling; 
    
    
    if(nextDiv==null)
    {
        alert("마지막 입니다");

    }else{
        let tempDiv=movingDiv;
    
        movingDiv.remove();
        placeBox.insertBefore(tempDiv, nextDiv.nextSibling);
    }
   

   
//	moveCourseSave();
};





















// var mapContainer = document.getElementById('mapBox'), // 지도를 표시할 div 
//       mapOption = { 
//             center: new kakao.maps.LatLng(37.39787021805673, 126.91894738515842), // 지도의 중심좌표
//             level: 13 // 지도의 확대 레벨
//       };

//       // 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
//       var map = new kakao.maps.Map(mapContainer, mapOption); 


//       var markerPosition  = new kakao.maps.LatLng(37.555188101592755, 126.97640613899671);
//       var markerPosition2  = new kakao.maps.LatLng(35.27942129788492, 129.02025765801514);
// 	  var markerPosition3  = new kakao.maps.LatLng(35.0649564575427, 126.82415007526825);
//       // 마커를 생성합니다
//       var marker = new kakao.maps.Marker({
//       position: markerPosition
//       });
//       var marker2 = new kakao.maps.Marker({
//       position: markerPosition2
// 	  });
// 	  var marker3 = new kakao.maps.Marker({
//       position: markerPosition3
//       });

//       // 마커가 지도 위에 표시되도록 설정합니다
//       marker.setMap(map);
// 	  marker2.setMap(map);
// 	  marker3.setMap(map);
	  
// /////////////////////
// var linePath = [
// 	new kakao.maps.LatLng(37.555188101592755, 126.97640613899671),
// 	new kakao.maps.LatLng(35.27942129788492, 129.02025765801514),
//     new kakao.maps.LatLng(35.0649564575427, 126.82415007526825)
    
   
// ];

// // 지도에 표시할 선을 생성합니다
// var polyline = new kakao.maps.Polyline({
//     path: linePath, // 선을 구성하는 좌표배열 입니다
//     strokeWeight: 5, // 선의 두께 입니다
//     strokeColor: 'red', // 선의 색깔입니다
//     strokeOpacity: 0.7, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
//     strokeStyle: 'solid' // 선의 스타일입니다
// });

// // 지도에 선을 표시합니다 
// polyline.setMap(map);

// var distance = polyline.getLength();
// var distanceKm = (distance/1000).toFixed(1);
// // console.log(distanceKm+"km");

// let distanceCourse = document.querySelector(".count-box__distance-text");

// function write(){
// 	distanceCourse.innerText = `코스 총거리 : ${distanceKm}km`;
// }

// write();




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
    history.back()
}

