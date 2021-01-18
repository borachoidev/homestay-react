'use strict';

//슬라이드 
let slideIndex = 0; //slide index

// HTML 로드가 끝난 후 동작
window.onload=function(){
  showSlides(slideIndex);
  let clickFirst=document.getElementById("cityList");
  clickFirst.click();
  

  // Auto Move Slide
  let sec = 5000;
  setInterval(function(){
    slideIndex++;
    showSlides(slideIndex);

  }, sec);
}


// Next/previous controls
function moveSlides(n) {
  slideIndex = slideIndex + n
  showSlides(slideIndex);
}

// Thumbnail image controls
function currentSlide(n) {
  slideIndex = n;
  showSlides(slideIndex);
}

function showSlides(n) {

  let slides = document.getElementsByClassName("mySlides");
  let dots = document.getElementsByClassName("dot");
  let size = slides.length;

  let i="";
  if ((n+1) > size) {
    slideIndex = 0; n = 0;
  }else if (n < 0) {
    slideIndex = (size-1);
    n = (size-1);
  }

  

  for (i = 0; i < slides.length; i++) {
      slides[i].style.display = "none";
  }
  for (i = 0; i < dots.length; i++) {
      dots[i].className = dots[i].className.replace(" active", "");
  }

  slides[n].style.display = "block";
  dots[n].className += " active";
}

//슬라이드 끝

//클릭이벤트

const printName=(event)=>{

 let name = event.value;
 document.getElementById("mainCity").value = (name);

let cityList = document.getElementsByClassName("city-list");

      function handleClick(event) {
        if (event.target.classList.contains === "clicked") {
          event.target.classList.remove("clicked");
        } else {
          for (let i = 0; i < cityList.length; i++) {
            cityList[i].classList.remove("clicked");
          }

          event.target.classList.add("clicked");
        }
      }

      function init() {
        for (let i = 0; i < cityList.length; i++) {
          cityList[i].addEventListener("click", handleClick);
        }
      }

      init();

paseAreaBased(name);
  
}

//submit버튼 클릭시

const moveList=()=>{
	let city=document.getElementById("mainCity").value;
     location.href = '/place/list?region='+city;
}

//api 불러오기

const paseAreaBased=(u)=> {
  var xhr = new XMLHttpRequest();
  var url = 'http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchKeyword'; /*URL*/

//요청 url을 만든다  
//만들고자 하는 url 
//serviceKey=서비스키&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=test%2520App&arrange=A&listYN=Y&eventStartDate=20210116
//param으로 보내는 key ,value는 encoding이 필요하기 때문에 
//encodeURIComponent('값') 에 값을 적어준다.
  var queryParams =  '?' +  encodeURIComponent('serviceKey') +  '=' +  'rBYqkzdDbvRy%2B75qtmMeAj36uvTFAFtjU0kjR3VImh0OcxuepKe7BvjaOowdie%2FIPYSZI4EiIwFGxJIZwCilVA%3D%3D'; /*Service Key*/
//요청변수 추가
  queryParams += '&' + encodeURIComponent('numOfRows') + '=' + encodeURIComponent('4'); /**/
  queryParams += '&' + encodeURIComponent('pageNo') + '=' + encodeURIComponent(1); /**/
  queryParams += '&' + encodeURIComponent('MobileOS') + '=' + encodeURIComponent('ETC'); /**/
  queryParams += '&' + encodeURIComponent('MobileApp') +'=' + encodeURIComponent('AppTest'); /**/
  queryParams += '&' + encodeURIComponent('contentTypeId') + '=' + encodeURIComponent('12'); /**/
  queryParams += '&' + encodeURIComponent('arrange') + '=' + encodeURIComponent('P'); /**/
  queryParams += '&' + encodeURIComponent('listYN') + '=' + encodeURIComponent('Y');
  queryParams += '&' + encodeURIComponent('keyword') + '=' + encodeURIComponent(u);
  console.log(url+queryParams)
  /* xml 파싱 */
  xhr.open('GET', url + queryParams);
 xhr.onreadystatechange = function () {
    if (this.readyState == 4) {
/*파싱이 완료되면 실행할 함수 */

//xml 텍스트를 doc으로 변환
      let xmlStr = this.responseText;
      var xmlParser, xmlDoc;
      xmlParser = new DOMParser();
      xmlDoc = xmlParser.parseFromString(xmlStr, 'text/xml');

//xml 값 가져오기 
//<totalCount>27<totalCount>의 경우
      var totalCount = xmlDoc.getElementsByTagName('totalCount')[0]
        .childNodes[0].nodeValue;

//전체에서 해당관광지의 원하는 정보만 가져오기
//contentid가 2531702의 사진을 가져올경우
      let list = xmlDoc.getElementsByTagName('item');
      for (let i = 0; i < list.length; i++){
        if (//조건
          list[i].getElementsByTagName('contentid')[0].childNodes[0]
            .nodeValue !=0
        )
          var img = list[i].getElementsByTagName('firstimage')[0].childNodes[0]
            .nodeValue;

//<div class='festival-calendar'>의 innerHTML로 img넣는다
          document.querySelector(
        '.city-place'
      ).innerHTML += `<img src='${img}'>`;
     }
    }
  };
  xhr.send(null);
}

const newSpan=(c)=>{
 let newDiv = document.createElement("div");
 newDiv.innerHTML = `<img src='${c}'>`;
 newDiv.setAttribute("class","city-place");
 let div = document.getElementById("place"); // <p "id=p"> 태그의 DOM 객체 찾기
 div.appendChild(newDiv);
}

const deleteDiv=()=>{
	let g = document.getElementById("city-place");
    if(g.length)
       {
	      var parent = document.getElementById("city-place");	// 그 엘리먼트의 부모 객체
          var div3 = document.getElementById("place")//제거하고자 하는 엘리먼트
          parent.removeChild(div3);
       }


}