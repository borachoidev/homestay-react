'use strict';

window.onload=function(){
 let clickFirst=document.getElementById("namelist");
  clickFirst.click();
 let link= decodeURI(document.location.href);
 let prevRegion=link.split('=');
 document.getElementById("mainCity").value = (prevRegion[1]);
}

function printName(event){

 let name = event.areaCode;
 document.getElementById("mainCity").value = (name);


}

const choiceList = () =>{
	let list = document.getElementsByClassName("list");
	
 function handleClick(event) {
        if (event.target.classList.contains === "choice") {
          event.target.classList.remove("choice");
        } else {
          for (let i = 0; i < list.length; i++) {
            list[i].classList.remove("choice");
          }

          event.target.classList.add("choice");
        }
      }

      function init() {
        for (let i = 0; i < list.length; i++) {
          list[i].addEventListener("click", handleClick);
        }
      }

      init();
}


//디테일페이지 이동
const moveDetail=()=>{
	let content=document.querySelectorAll(".place-list").getAttribute('value');
     location.href = '/tourplace/detail?contentId='+content;
}

//출력
let currentPage = 1;
let code = 35;
var xhr = new XMLHttpRequest();
var url = `/places/title/`+currentPage+`/`+code;
  console.log(url);
  xhr.open('GET', url);
  xhr.onreadystatechange = function () {
    if (this.readyState == 4) {
      let data = JSON.parse(this.responseText);
      let item = data.place;
      let c=" ";
      for(let i=0; i<item.length;i++) {
	      let src = item[i].firstImage;
          let placeName = item[i].title;
          let addr = item[i].addr1;
          let contentId = item[i].contentId;

	      c += `<a href='/tourplace/detail?contentId=${contentId}'><div class="place-list">`
          c += `<img src=${src} onerror="this.src='/img/noimage.png'">`
          c += `<div class="list-content">`
          c += `<div class="placeName">${placeName}</div>`
          c += `<div class="addr">${addr}</div>`
          c += `</div></div></a>`
      }
   
      document.querySelector('#card').innerHTML = c;
      console.log(item);
      console.log(data);
    }
};
xhr.send();


//상단 슬라이드
let slideUp = (target, duration=500) => {
    target.style.transitionProperty = 'height, margin, padding';
    target.style.transitionDuration = duration + 'ms';
    target.style.boxSizing = 'border-box';
    target.style.height = target.offsetHeight + 'px';
    target.offsetHeight;
    target.style.overflow = 'hidden';
    target.style.height = 0;
    target.style.paddingTop = 0;
    target.style.paddingBottom = 0;
    target.style.marginTop = 0;
    target.style.marginBottom = 0;
    window.setTimeout( () => {
      target.style.display = 'none';
      target.style.removeProperty('height');
      target.style.removeProperty('padding-top');
      target.style.removeProperty('padding-bottom');
      target.style.removeProperty('margin-top');
      target.style.removeProperty('margin-bottom');
      target.style.removeProperty('overflow');
      target.style.removeProperty('transition-duration');
      target.style.removeProperty('transition-property');
      //alert("!");
    }, duration);
  }
let slideDown = (target, duration=500) => {
    target.style.removeProperty('display');
    let display = window.getComputedStyle(target).display;

    if (display === 'none')
      display = 'block';

    target.style.display = display;
    let height = target.offsetHeight;
    target.style.overflow = 'hidden';
    target.style.height = 0;
    target.style.paddingTop = 0;
    target.style.paddingBottom = 0;
    target.style.marginTop = 0;
    target.style.marginBottom = 0;
    target.offsetHeight;
    target.style.boxSizing = 'border-box';
    target.style.transitionProperty = "height, margin, padding";
    target.style.transitionDuration = duration + 'ms';
    target.style.height = height + 'px';
    target.style.removeProperty('padding-top');
    target.style.removeProperty('padding-bottom');
    target.style.removeProperty('margin-top');
    target.style.removeProperty('margin-bottom');
    window.setTimeout( () => {
      target.style.removeProperty('height');
      target.style.removeProperty('overflow');
      target.style.removeProperty('transition-duration');
      target.style.removeProperty('transition-property');
    }, duration);
  }
let slideToggle = (target, duration = 500) => {
  if (window.getComputedStyle(target).display === 'none') {
    return slideDown(target, duration);
  } else {
    return slideUp(target, duration);
  }
}
   
// ====  
  
let speedAnimation = 400;
let targetId = document.getElementById("target");

let slideBtnClick = (cl, sl) => 
document.querySelector(cl).addEventListener('click', () => sl(targetId, speedAnimation));



slideBtnClick('.slide-img', slideToggle);
slideBtnClick('.fa-times', slideToggle);


/*
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
*/

/*if(i.style.display == "none")
{*/
 
/*}else{
 let preant = document.getElementById("p");
 preant.removeChild(i);
}*/

/*var clickTimes = 0;

       clickTimes++;
       let n = (clickTimes%2)+1
       switch(n) {
           case 1:
              var newSpan = document.createElement("span");
              newSpan.innerHTML = name;
              newSpan.setAttribute("id",name);
              newSpan.setAttribute("th:value",name);
              newSpan.style.backgroundColor="yellow";
              var p = document.getElementById("p"); // <p "id=p"> 태그의 DOM 객체 찾기
              p.appendChild(newSpan);
               break;
           default:
         
                 // 삭제할 ID 정보 찾기
                var target = name.parentNode.getAttribute('name');
                 // 삭제할 element 찾기
                 var field = document.getElementById('name');
                 // #field 에서 삭제할 element 제거하기
                 document.getElementById('p').removeChild(field);
               break;
       }
       //Do something else
}*/


//태그 계속 추가할 수 있는것
//let newSpan = document.createElement("span");
// newSpan.innerHTML = n;
// newSpan.setAttribute("id",n);
// newSpan.setAttribute("th:value",n);
// newSpan.setAttribute("region","");
// newSpan.style.backgroundColor="yellow";
// let p = document.getElementById("p"); // <p "id=p"> 태그의 DOM 객체 찾기
// p.appendChild(newSpan);




// let n;
// let x  =document.getElementById("mainCity").value.split(" ");
//if(!document.getElementById("mainCity").value.includes(name))
// document.getElementById("mainCity").value += " "+(name);
//if(document.getElementById("mainCity").value.split(" ").indexOf(name)==1)
//n=document.getElementById("mainCity").value.replace(name,"");
//alert(n)
//const str2 = name;
//const result = [...new Set(str1.split(" ").filter(name => !str2.includes(name)))].join(" ");
//console.log(result);

//if(x.indexOf(name) == 1)
// document.getElementById("mainCity").value -= " "+(name);

