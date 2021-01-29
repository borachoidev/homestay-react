'use strict';

 let link=document.location.href;
 let contentId=link.split('=');


//출력

let id=contentId[1];
let xhr = new XMLHttpRequest();
let url = `/place/detail/`+id;
  xhr.open('GET', url);
  xhr.onreadystatechange = function () {
    if (this.readyState == 4) {
      let data = JSON.parse(this.responseText);
      let item = data.place;
      let src = item.firstImage;
      let photo = data.apiPhoto;
      let placeName = item.title;
      let addr = item.addr1;
      let overview = item.overview;
      let xpos = item.mapX;
      let ypos = item.mapY;
      
      //유저 사진
      let userPhoto = data.userPhoto;
      
      //댓글출력
      let Answer = data.tourAnswer;
      
      
      let t=" ";
      console.log(photo);
      t +=`<h1>${placeName}</h1><hr>`;
      t +=`<div id="list">관광지 목록들 출력할거에요</div>`;
      t +=`<div id=heart><div class="heart"></div></div>`;
      t +=`<i class="fas fa-star"></i>`;
      t +=`<div id="picture">`
      t +=`<img id="mainImage" src=${src} onerror="this.src='/img/noimage.png'">`;
      if(src!=null){
	   t +=`<p id="showImage" onclick='imageClick()'>이미지 더보기</p><div id=subImage>`; 
       
      for(let i = 0; i<photo.length;i++) {
	       
          t +=`<img class="sub-image" src=${photo[i].originImgUrl} onerror="this.src='/img/noimage.png'">`;
          }
      }
      t +=`</div></div><hr>`;
      t +=`<div id="placeInfo">`;
      t +=`<p>주소 : ${addr}</p><br>`;
      t +=`<p>${overview}</p></div><hr>`;
      t +=`<div id="userPhoto">user들의 사진이에여~(찡긋 ^^*)이거 진짜 출력할거임 진짜에여 ㅠㅜ 왜안나와 ㅠㅜ`;
      for(let b = 0;b<userPhoto.length;b++)
      {
          t +=`<img class="userPhoto" src="${userPhoto[b].image}">`;
      }
      t +=`</div>`;
      t +=`<hr><div id="placeMap"></div><hr>`;
      t +=`<div id="AnswerList">`;
      for(let d = 0; d<Answer.length;d++) {
          t +=`<img id="loginPhoto" src=${Answer[d].loginPhoto}>`;
          t +=`<p id="loginId">${Answer[d].loginId}</p>`;
          t +=`<p id="content">${Answer[d].content}</p>`;
          t +=`<p id="day">${Answer[d].writeDay}</p>`;
      }
      t +=`</div>`;
      
      document.querySelector('#placeDetail').innerHTML = t;
      console.log(contentId);


 //지도

var mapContainer = document.getElementById('placeMap'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(ypos, xpos), // 지도의 중심좌표
        level:3  // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// 마커가 표시될 위치입니다 
var markerPosition  = new kakao.maps.LatLng(ypos, xpos); 

// 마커를 생성합니다
var marker = new kakao.maps.Marker({
    position: markerPosition
});

// 마커가 지도 위에 표시되도록 설정합니다
marker.setMap(map);

    }
};
xhr.send();


//이미지 보이기




const imageClick=()=>{
	let subPhoto = document.getElementById("subImage");
	if (subPhoto.style.display=='block')
	 return subPhoto.style.display = 'none';
	else
	 return subPhoto.style.display = 'block';
}

/*//이미지 변경
let main = document.getElementById("mainImage");
let small = document.querySelectorAll(".sub-image");

for(let a = 0; a <small.length; a++){
	small[a].addEventListener("click", changeImage); 
}

function changeImage(){
	let smallAttr = this.getAttribute("src");
	main.setAttribute("src",smallAttr);
}*/
