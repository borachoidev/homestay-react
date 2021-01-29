'use strict';

const placeMark = document.getElementById("placeMark");
const courseMark = document.getElementById("courseMark");
const totalCount = document.getElementById("totalCount");
const t1 = document.querySelector("#t1");

function getParam(key) {
    let param;
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    param = urlParams.get(key);
    return param;
  }

let perBlock = 5;
let currentPage = document.querySelector('#paging').getAttribute('currentPage');
let startPage = Math.floor((currentPage - 1) / perBlock) * perBlock + 1;
let endPage = startPage + perBlock - 1;



    function placeMarkspage(currentPage){
   
    var xhr = new XMLHttpRequest();
    var url = `/mypage/placemarks/${currentPage}`;
    xhr.open('GET', url);
    xhr.send();
    console.log(url);

    xhr.onreadystatechange = function(){
        if (this.readyState == 4) {
            
            let data = JSON.parse(this.responseText);
            let item = data.list;
            let s=" ";
            for(let i=0; i<item.length; i++){
                let titles = item[i].title;
                let addrs = item[i].addr1;
                let firstImages = item[i].firstImage;
                let contentId = item[i].contentId;
                
                
                s+="<div class='favorite-infobox'>";
                s+="<div class='image-box'>";
                s+=`<img src=${firstImages} alt=${titles} onerror="this.src='/img/noimage.png'">`;
                s+="</div>";
                s+="<div class='favorite-info__box'>";
                s+="<div class='favorite-info'>";
                s+=`<p class='favorite-name' onclick='location.href="/tourplace/detail?contentId=${contentId}"'>${titles}</p>`;
                s+="<p class='favorite-start'>"+addrs+"</p>";
                s+="</div>";
                s+="<i class='fas fa-ellipsis-v favorite-icon'></i>";
                s+="</div>";
                s+="</div>";
                s+="<hr class='hr2'>";
            }   
            t1.innerHTML=s;

                //페이징 처리
      const totalPage = data.totalPage; //

      if (endPage > totalPage) {
        endPage = totalPage;
      }
      
      let p = '';
      if (startPage > 1) {
        p += `<li class='page-list'><a href='/tourmypage/favorite?currentPage=${
          startPage - 1
        }'><i class="fas fa-chevron-left"></i></li>`;
      }
      for (let i = startPage; i <= endPage; i++) {
        p += `<li class='page-list'><a href='/tourmypage/favorite?currentPage=${i}'>${i}</a></li>`;
      }
      if (endPage < totalPage) {
        p += `<li page='${
          endPage + 1
        }' class='page-list'><a href='/tourmypage/favorite?currentPage=${
          endPage + 1
        }'><i class="fas fa-chevron-right"></i></a></li>`;
      }

      document.querySelector('#paging').innerHTML = p;

            // console.log(data);
            // console.log(data.list);
            // console.log(data.list.length);
            let placeCount = data.list.length;
            totalCount.innerText = "총"+placeCount+"건";
            placeMark.style.color="black";
            placeMark.style.fontSize="1.1em";
            courseMark.style.color="#98938d";
            courseMark.style.fontSize="1em";
        }
    }
    
};

function courseMarkForm(currentPage){
    var xhr = new XMLHttpRequest();
    var url = `/mypage/coursemarks/${currentPage}`;
    xhr.open('GET', url);
    xhr.send();
    console.log(url);

    xhr.onreadystatechange = function(){
        if (this.readyState == 4) {
            let data = JSON.parse(this.responseText);
            let item = data.list;
            let c=" ";
            for(let i=0; i<item.length; i++){
                let names = item[i].name;
                let titles = item[i].title;
                let firstImages = item[i].firstImage;
                
                let courseNum = item[i].courseNum;
                let who;
                let during;
                let how;
                console.log(`who ${item[i].who}`);
                switch (item[i].who) {
                case 'W1':
                    who = '혼자';
                    break;
                case 'W2':
                    who = '가족';
                    break;
                case 'W3':
                    who = '연인';
                    break;
                case 'W4':
                    who = '우정';
                    break;
                }
                switch (item[i].during) {
                case 'D1':
                    during = '당일치기';
                    break;
                case 'D2':
                    during = '1박2일';
                    break;
                case 'D3':
                    during = '2박3일 이상';
                    break;
                }
                switch (item[i].how) {
                case 'H1':
                    how = '뚜벅이';
                    break;
                case 'H2':
                    how = '자전거';
                    break;
                case 'H3':
                    how = '자동차';
                    break;
                case 'H4':
                    how = '기차';
                    break;
                }
                
                c+="<div class='favorite-infobox'>";
                c+="<div class='image-box'>";
                c+=`<img src=${firstImages} alt=${names} onerror="this.src='/img/noimage.png'">`;
                c+="</div>";
                c+="<div class='favorite-info__box'>";
                c+="<div class='favorite-info'>";
                c+=`<p class='favorite-name' onclick='location.href="/tourcourse/detail?courseNum=${courseNum}"'>${names}</p>`;
                c+="<p class='favorite-start'>"+titles+"</p>";
                c+="<span class='favortie-tema'>#"+who+"</span>";
                c+="<span class='favortie-tema'>#"+during+"</span>";
                c+="<span class='favortie-tema'>#"+how+"</span>";
                c+="</div>";
                c+="<i class='fas fa-ellipsis-v favorite-icon'></i>";
                c+="</div>";
                c+="</div>";
                c+="<hr class='hr2'>";
            }   
            t1.innerHTML=c;
            
            //페이징 처리
      const totalPage = data.totalPage; //

      if (endPage > totalPage) {
        endPage = totalPage;
      }
      
      let p = '';
      if (startPage > 1) {
        p += `<li class='page-list'><a href='/tourmypage/favorite?currentPage=${
          startPage - 1
        }'><i class="fas fa-chevron-left"></i></li>`;
      }
      for (let i = startPage; i <= endPage; i++) {
        p += `<li class='page-list'><a href='/tourmypage/favorite?currentPage=${i}'>${i}</a></li>`;
      }
      if (endPage < totalPage) {
        p += `<li page='${
          endPage + 1
        }' class='page-list'><a href='/tourmypage/favorite?currentPage=${
          endPage + 1
        }'><i class="fas fa-chevron-right"></i></a></li>`;
      }

      document.querySelector('#paging').innerHTML = p;
            
            
            // console.log(data);
            // console.log(data.list);
            // console.log(data.list.length);
            let courseCount = data.list.length;
            totalCount.innerText = "총"+courseCount+"건";
            courseMark.style.color="black";
            courseMark.style.fontSize="1.1em";
            placeMark.style.color="#98938d";
            placeMark.style.fontSize="1em";
        }
    
    }
}


function deleteFavorite(){
    var xhr = new XMLHttpRequest();
    var url = '/coursemarks/{courseMarkNum}';
    xhr.open('DELETE', url);
    xhr.send();
    console.log(url);

    xhr.onreadystatechange = function(){
        if (this.readyState == 4) {
            let data = JSON.parse(this.responseText);
            let item = data.list;

        }}}
courseMarkForm(currentPage);