'use strict';

let keyword = document.querySelector('.keyword-title').getAttribute('keyword');
let sort = 'title';
let perBlock = 5;
let currentPage;
let startPage; //= Math.floor((currentPage - 1) / perBlock) * perBlock + 1;
let endPage; // = startPage + perBlock - 1;
searchPlace(sort, keyword, currentPage);
sortOnclick();
searchOnclick();

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

      searchPlace(sortCode, keyword, currentPage);
    });
  }
}
function searchOnclick() {
  let searches = document.querySelectorAll('.search-list');
  for (const search of searches) {
    search.addEventListener('click', function (e) {
      let searchCode = e.target.getAttribute('search');

      const children = search.parentElement.children;
      for (const child of children) {
        child.classList.remove('active');
      }
      console.log(search);
      search.classList.add('active');

      if (searchCode == 'tour') {
        searchPlace(sortCode, keyword, currentPage);
      } else {
        let sort = 'time';
        searchCourse(sort, keyword, currentPage);
      }
    });
  }
}
//api 데이터
function searchPlace(sort, keyword, pageNum) {
  if (pageNum == undefined) pageNum = 1;
  let url;
  var xhr = new XMLHttpRequest();
  const keywordURL = decodeURIComponent(keyword);

  url = `search/${sort}/${pageNum}/` + keywordURL;

  console.log(sort);
  xhr.open('GET', url);
  xhr.onreadystatechange = function () {
    if (this.readyState == 4) {
      const data = JSON.parse(this.responseText);
      const item = data.place;
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
        n += `<span class='lieks'><i class="fas fa-heart"></i> ${item[i].likeCount}</span>`;
        n += `</div></div></a>`;
      }
      document.querySelector('.list').innerHTML = n;

      //페이징 처리
      const totalPage = data.totalPage; //
      currentPage = pageNum;
      startPage = Math.floor((currentPage - 1) / perBlock) * perBlock + 1;
      endPage = startPage + perBlock - 1;
      if (endPage > totalPage) {
        endPage = totalPage;
      }

      if (item.length == 0) {
        document.querySelector('.list').innerHTML =
          '<span class="alert-msg">해당하는 검색 결과가 없습니다!😱</span>';
      }

      let p = '';
      if (startPage > 1) {
        p += `<li class='page-list'  page='${
          startPage - 1
        }'><i class="fas fa-chevron-left"></i></li>`;
      }
      for (let i = startPage; i <= endPage; i++) {
        p += `<li page='${i}' class='page-list' >${i}</li>`;
      }
      if (endPage < totalPage) {
        p += `<li page='${
          endPage + 1
        }' class='page-list'><i class="fas fa-chevron-right"></i></li>`;
      }
      document.querySelector('.pagination').innerHTML = p;

      let pageList = document.querySelectorAll('.page-list');
      for (const page of pageList) {
        page.addEventListener('click', function (e) {
          pageNum = e.target.getAttribute('page');
          if (totalPage < pageNum) pageNum = totalPage;
          searchPlace(sort, keyword, pageNum);
        });
      }
      //정렬
      console.log(`${currentPage} + ${endPage}`);
      document.querySelector('.sort-course').classList.add('hide');
      document.querySelector('.sort-place').classList.remove('hide');
    }
  };
  xhr.send(null);
}

function searchCourse(sort, keyword, pageNum) {
  if (pageNum == undefined) pageNum = 1;
  let url;
  var xhr = new XMLHttpRequest();
  const keywordURL = decodeURIComponent(keyword);

  url = `courses/search/${sort}/${pageNum}?keyword=` + keywordURL;

  console.log(sort);
  xhr.open('GET', url);
  xhr.onreadystatechange = function () {
    if (this.readyState == 4) {
      const data = JSON.parse(this.responseText);
      const item = data.list;
      console.log(data);

      let n = '';

      for (let i = 0; i < item.length; i++) {
        const courseNum = item[i].courseNum;
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
            during = '2박3일';
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
        n += `<a href='/tourcourse/detail?courseNum=${courseNum}'
          ><div class='card'>`;
        if (item[i].firstImage) {
          n += `<img src='${item[i].firstImage}' class='thumbnail' />`;
        } else {
          n += `<span class='thumbnail'>대표이미지 없음 🖼 </span>`;
        }
        n += `<div class='info'><span class='title' >${item[i].name}</span>`;
        n += `<span class='content'>${item[i].content}</span>`;
        n += `<span class='place'>${item[i].addr1}</span>`;
        n += `<span class='lieks'><i class="fas fa-heart"></i> ${item[i].totalLike}</span>`;
        n += `<div class='tag-box'><span class='tag'>${who}</span><span class='tag'>${during}</span><span class='tag'>${how}</span></div>`;
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
        p += `<li class='page-list' onclick=searchCourse(sort, keyword, ${
          startPage - 1
        })><i class="fas fa-chevron-left"></i></li>`;
      }
      for (let i = startPage; i <= endPage; i++) {
        p += `<li class='page-list' onclick=searchCourse(sort, keyword, ${i}>${i}</li>`;
      }
      if (endPage < totalPage) {
        p += `<li page='${
          endPage + 1
        }' class='page-list' onclick=searchCourse(sort, keyword, ${
          endPage + 1
        }><i class="fas fa-chevron-right"></i></li>`;
      }
      document.querySelector('.pagination').innerHTML = p;
    }
    console.log(`${currentPage} + ${endPage}`);
    //정렬
    document.querySelector('.sort-place').classList.add('hide');
    document.querySelector('.sort-course').classList.remove('hide');
  };
  xhr.send(null);
}
