'use strict';

let keyword = document.querySelector('.keyword-title').getAttribute('keyword');
let sort = 'title';
let perBlock = 5;
let currentPage = document
  .querySelector('.pagination')
  .getAttribute('currentPage');
let startPage = Math.floor((currentPage - 1) / perBlock) * perBlock + 1;
let endPage = startPage + perBlock - 1;
searchAllbyTitle(sort, keyword, currentPage);
areaOnclick();
function areaOnclick() {
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
      searchAllbyTitle(sortCode, keyword, currentPage);
    });
  }
}

//api 데이터
function searchAllbyTitle(sort, keyword, pageNum) {
  if (pageNum == undefined) pageNum = 1;
  let url;
  var xhr = new XMLHttpRequest();
  const keywordURL = decodeURIComponent(keyword);
  if (sort == 'title') {
    url = `search/title/${pageNum}/` + keywordURL;
  } else {
    url = `search/like/${pageNum}/` + keywordURL;
  }
  /**/
  console.log(sort);
  xhr.open('GET', url);
  xhr.onreadystatechange = function () {
    if (this.readyState == 4) {
      let data = JSON.parse(this.responseText);
      let item = data.place;
      console.log(data);

      let n = '';

      for (let i = 0; i < item.length; i++) {
        const contentId = item[i].contentId;
        n += `<a href='/tourplace/detail?contentId=${contentId}'
          ><div class='card'>`;
        if (item[i].firstImage) {
          n += `<img src='${item[i].firstImage}' class='thumbnail' />`;
        } else {
          n += `<span class='thumbnail'>대표이미지 없음 🖼 </span>`;
        }
        n += `<div class='info'><span class='title' >${item[i].title}</span>`;

        n += `<span class='place'>${item[i].addr1}</span>`;
        n += `</div></div></a>`;
      }
      document.querySelector('.list').innerHTML = n;

      //페이징 처리
      const totalPage = data.totalPage; //

      if (endPage > totalPage) {
        endPage = totalPage;
      }

      if (item.length == 0) {
        document.querySelector('.list').innerHTML =
          '<span class="alert-msg">해당하는 검색 결과가 없습니다!😱</span>';
      }

      let p = '';
      if (startPage > 1) {
        p += `<li class='page-list'><a href='/search?keyword=${keyword}&currentPage=${
          startPage - 1
        }'><i class="fas fa-chevron-left"></i></li>`;
      }
      for (let i = startPage; i <= endPage; i++) {
        p += `<li class='page-list'><a href='/search?keyword=${keyword}&currentPage=${i}'>${i}</a></li>`;
      }
      if (endPage < totalPage) {
        p += `<li page='${
          endPage + 1
        }' class='page-list'><a href='/search?keyword=${keyword}&currentPage=${
          endPage + 1
        }'><i class="fas fa-chevron-right"></i></a></li>`;
      }
      document.querySelector('.pagination').innerHTML = p;
    }
  };
  xhr.send(null);
}
