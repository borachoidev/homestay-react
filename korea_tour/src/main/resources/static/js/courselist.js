'use strict';

let sort = 'time';
let who = getParam('who');
let how = getParam('how');
let during = getParam('during');
const perBlock = 5;
let currentPage = document.querySelector('#paging').getAttribute('currentPage');
let startPage = Math.floor((currentPage - 1) / perBlock) * perBlock + 1;
let endPage = startPage + perBlock - 1;
getCourse(sort, who, during, how, currentPage);
sortOnclick();

// parameter value 읽기
function getParam(key) {
  let param;
  const queryString = window.location.search;
  const urlParams = new URLSearchParams(queryString);
  param = urlParams.get(key);
  return param;
}

function sortOnclick() {
  let sorts = document.querySelectorAll('.sort');
  for (const sort of sorts) {
    sort.addEventListener('click', function (e) {
      let sortCode = e.target.getAttribute('value');

      const children = sort.parentElement.children;
      for (const child of children) {
        child.classList.remove('active');
      }
      console.log(sort);
      sort.classList.add('active');
      // if (sortCode == 'title') {

      // } else {
      // }
      getCourse(sortCode, who, during, how, currentPage);
    });
  }
}
//api 데이터
function getCourse(sort, who, during, how, currentPage) {
  if (currentPage == undefined) currentPage = 1;
  let url;
  var xhr = new XMLHttpRequest();
  const whoURL = decodeURIComponent(who);
  const duringURL = decodeURIComponent(during);
  const howURL = decodeURIComponent(how);

  url = `courses/custom/${sort}/${currentPage}?who=${whoURL}&during=${duringURL}&how=${howURL}`;

  /**/
  console.log(url);
  xhr.open('GET', url);
  xhr.onreadystatechange = function () {
    if (this.readyState == 4) {
      const data = JSON.parse(this.responseText);
      const item = data.list;
      console.log(data);

      let n = '';

      for (let i = 0; i < item.length; i++) {
        const contentId = item[i].contentId;
        n += `<a href='/tourplace/detail?contentId=${contentId}'
        >`;

        n += `<div class="favorite-infobox">`;
        n += `<div class="image-box">`;
        if (item[i].firstImage) {
          n += `<img src='${item[i].firstImage}' class='thumbnail' />`;
        } else {
          n += `<span class='thumbnail'>대표이미지 없음 🖼 </span>`;
        }
        n += `</div><div class="favorite-info__box">`;
        n += `<div class="favorite-info">`;
        n += `<p class="favorite-name">${item[i].name}</p>`;
        n += `<p class="favorite-start">${item[i].addr1}</p>`;
        n += `<span class='lieks'><i class="fas fa-heart"></i> ${item[i].likeCount}</span></div>`;
        n += `<i class="fas fa-ellipsis-v favorite-icon"></i></div></div></a>`;
      }
      document.querySelector('.count-box').innerHTML = n;

      //페이징 처리
      const totalPage = data.totalPage; //

      if (endPage > totalPage) {
        endPage = totalPage;
      }
      if (item.length == 0) {
        document.querySelector('.count-box').innerHTML =
          '<span class="alert-msg">해당하는 검색 결과가 없습니다!😱</span>';
      }
      let p = '';
      if (startPage > 1) {
        p += `<li class='page-list'><a href='tourcourse?who=${who}&during=${during}&how=${how}&currentPage=${
          startPage - 1
        }'><i class="fas fa-chevron-left"></i></li>`;
      }
      for (let i = startPage; i <= endPage; i++) {
        p += `<li class='page-list'><a href='tourcourse?who=${who}&during=${during}&how=${how}&currentPage=${i}'>${i}</a></li>`;
      }
      if (endPage < totalPage) {
        p += `<li page='${
          endPage + 1
        }' class='page-list'><a href='tourcourse?who=${who}&during=${during}&how=${how}&currentPage=${
          endPage + 1
        }'><i class="fas fa-chevron-right"></i></a></li>`;
      }

      document.querySelector('#paging').innerHTML = p;
    }
  };
  xhr.send(null);
}
