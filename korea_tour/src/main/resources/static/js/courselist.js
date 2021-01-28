'use strict';

let sort;
let who;
let how;
let during;
const perBlock = 5;
let currentPage = document
  .querySelector('.pagination')
  .getAttribute('currentPage');
let startPage = Math.floor((currentPage - 1) / perBlock) * perBlock + 1;
let endPage = startPage + perBlock - 1;
getCourse(sort, who, during, how, currentPage);
sortOnclick();
whoOnclick();

// parameter value 읽기
function getParam(key) {
  let param;
  const queryString = window.location.search;
  const urlParams = new URLSearchParams(queryString);
  param = urlParams.get(key);
  return param;
}

function sortOnclick() {
  let sorts = document.querySelectorAll('.sort-list');
  for (const sort of sorts) {
    sort.addEventListener('click', function (e) {
      let sortCode = e.target.getAttribute('sort');

      const children = sort.parentElement.children;
      for (const child of children) {
        child.classList.remove('active');
      }

      sort.classList.add('active');

      getCourse(sortCode, who, during, how, currentPage);
    });
  }
}
function whoOnclick() {
  let tags = document.querySelectorAll('.tag');
  for (const tag of tags) {
    tag.addEventListener('click', function (e) {
      if (e.target.getAttribute('who') != null) {
        if (who == e.target.getAttribute('who')) {
          who = '';
        } else {
          who = e.target.getAttribute('who');
        }
      }
      if (e.target.getAttribute('how') != null) {
        if (how == e.target.getAttribute('how')) {
          how = '';
        } else {
          how = e.target.getAttribute('how');
        }
      }
      if (e.target.getAttribute('during') != null) {
        if (during == e.target.getAttribute('during')) {
          during = '';
        } else {
          during = e.target.getAttribute('during');
        }
      }

      const children = tag.parentElement.children;
      for (const child of children) {
        child.classList.remove('active');
      }
      tag.classList.toggle('active');
      getCourse(sort, who, during, how, currentPage);
    });
  }
}

//api 데이터
function getCourse(sort, who, during, how, currentPage) {
  if (who == undefined) who = getParam('who');
  if (how == undefined) how = getParam('how');
  if (during == undefined) during = getParam('during');
  if (sort == undefined) sort = 'time';
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
        const courseNum = item[i].courseNum;
        n += `<a href='/tourcourse/detail?courseNum=${courseNum}'
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
        n += `<span class='lieks'><i class="fas fa-heart"></i> ${item[i].totalLike}</span></div>`;
        n += `<i class="fas fa-ellipsis-v favorite-icon"></i></div></div></a>`;
      }
      document.querySelector('.course-list').innerHTML = n;

      //페이징 처리
      const totalPage = data.totalPage; //
      endPage = startPage + perBlock - 1;
      if (endPage > totalPage) {
        endPage = totalPage;
      }
      console.log(totalPage + '|' + endPage);
      if (item.length == 0) {
        document.querySelector('.course-list').innerHTML =
          '<span class="alert-msg">해당하는 검색 결과가 없습니다!😱</span>';
      }
      let p = '';
      if (startPage > 1) {
        p += `<li class='page-list arrow'><a href='tourcourse?who=${who}&during=${during}&how=${how}&currentPage=${
          startPage - 1
        }'><i class="fas fa-chevron-left"></i></li>`;
      }
      for (let i = startPage; i <= endPage; i++) {
        if (i == currentPage) {
          p += `<li class='page-list active'><a href='tourcourse?who=${who}&during=${during}&how=${how}&currentPage=${i}'>${i}</a></li>`;
        } else {
          p += `<li class='page-list'><a href='tourcourse?who=${who}&during=${during}&how=${how}&currentPage=${i}'>${i}</a></li>`;
        }
      }
      if (endPage < totalPage) {
        p += `<li page='${
          endPage + 1
        }' class='page-list arrow'><a href='tourcourse?who=${who}&during=${during}&how=${how}&currentPage=${
          endPage + 1
        }'><i class="fas fa-chevron-right"></i></a></li>`;
      }

      document.querySelector('.pagination').innerHTML = p;
    }
  };
  xhr.send(null);
}
