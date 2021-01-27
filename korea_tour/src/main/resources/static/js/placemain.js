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
const moveSlides=(n)=> {
  slideIndex = slideIndex + n
  showSlides(slideIndex);
}

// Thumbnail image controls
const currentSlide=(n)=> {
  slideIndex = n;
  showSlides(slideIndex);
}

const showSlides=(n)=> {

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


  
}

//submit버튼 클릭시

const moveList=()=>{
	let city=document.getElementById("mainCity").value;
     location.href = '/place/list?region='+city;
}