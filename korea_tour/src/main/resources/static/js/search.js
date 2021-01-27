'use strict';

let keyword = document.querySelector('.keyword-title').getAttribute('keyword');

parseAreaBased(1, keyword);
// getAreaName(areaCode);

/* ----- functions ---- */

//eventEndDate 구하기

function areaOnclick() {
  let areaList = document.querySelectorAll('.area-list');
  for (const areaBtn of areaList) {
    areaBtn.addEventListener('click', function (e) {
      areaCode = e.target.getAttribute('area');
      if (areaCode == 'all') {
        areaCode = '';
      }
      const children = areaBtn.parentElement.children;
      for (const child of children) {
        child.classList.remove('active');
      }

      areaBtn.classList.add('active');
      parseAreaBased(pageNum, keyword);
      getAreaName(areaCode);
    });
  }
}
// // parameter value 읽기
// function getParam(key) {
//   let param;
//   const queryString = window.location.search;
//   const urlParams = new URLSearchParams(queryString);
//   param = urlParams.get(key);
//   return param;
// }

//areacode 변환
// function getAreaName(areaCode) {
//   let xmlStr;
//   let xmlDoc;
//   var xhr = new XMLHttpRequest();
//   var url =
//     'http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaCode'; /*URL*/
//   var queryParams =
//     '?' +
//     encodeURIComponent('serviceKey') +
//     '=' +
//     'CaXsuilSjIPz3L19P%2F6ufv6lKG6DwvhRg5x2lK5lzUTP66WyVxrNQcvBdb6CxuXHRNrbDXoscBHGwPy5aQd4sw%3D%3D'; /*Service Key*/
//   queryParams +=
//     '&' + encodeURIComponent('MobileOS') + '=' + encodeURIComponent('ETC'); /**/
//   queryParams +=
//     '&' +
//     encodeURIComponent('MobileApp') +
//     '=' +
//     encodeURIComponent('test%20App'); /**/
//   queryParams +=
//     '&' + encodeURIComponent('numOfRows') + '=' + encodeURIComponent('20'); /**/
//   queryParams +=
//     '&' + encodeURIComponent('arrange') + '=' + encodeURIComponent('Y');
//   queryParams +=
//     '&' + encodeURIComponent('listYN') + '=' + encodeURIComponent('Y');

//   console.log(url + queryParams);
//   xhr.open('GET', url + queryParams);
//   xhr.onreadystatechange = function () {
//     if (this.readyState == 4) {
//       xmlStr = this.responseText;
//       var xmlParser, xmlDoc;
//       xmlParser = new DOMParser();
//       xmlDoc = xmlParser.parseFromString(xmlStr, 'text/xml');

//       let list = xmlDoc.getElementsByTagName('item');
//       let areaName;
//       for (let i = 0; i < list.length; i++) {
//         if (item[i].code === areaCode) areaName = item[i].name;
//       }
//       if (areaCode === '') {
//         document.querySelector('.area-title').innerHTML = '전체보기';
//       } else {
//         document.querySelector('.area-title').innerHTML = areaName;
//       }
//     }
//   };
//   xhr.send(null);
// }

//api 데이터
function parseAreaBased(pageNum, keyword) {
  if (pageNum == undefined) pageNum = 1;

  var xhr = new XMLHttpRequest();
  const keywordURL = decodeURIComponent(keyword);
  var url = `search/title/${pageNum}/` + keywordURL;

  /**/
  console.log(url);
  xhr.open('GET', url);
  xhr.onreadystatechange = function () {
    if (this.readyState == 4) {
      let data = JSON.parse(this.responseText);
      let item = data.place;
      console.log(item[0].areaCode);
      console.log(data);

      // let totalCount = xmlDoc.getElementsByTagName('totalCount')[0]
      //   .childNodes[0];
      // totalPage = Math.ceil(parseInt(totalCount) / numOfRows);

      // if (totalPage < pageNum) pageNum = totalPage;

      let n = '';
      let contentId;
      for (let i = 0; i < item.length; i++) {
        contentId = item[i].contentId;
        n += `<a href='/tourplace/detail?contentId=${contentId}'
          ><div class='card'>`;
        if (item[i].firstImage) {
          n += `<img src='${item[i].firstImage}' class='thumbnail' contentid='${item[i].contentId}'/>`;
        } else {
          n += `<span class='thumbnail'>대표이미지 없음 🖼 </span>`;
        }
        n += `<div class='info'><span class='title' contentid='${item[i].contentId}'>${item[i].title}</span>`;

        n += `<span class='place'>${item[i].addr1}</span>`;
        n += `</div></div></a>`;
      }
      document.querySelector('.list').innerHTML = n;
      //   if (totalCount == 0) {
      //     document.querySelector('.list').innerHTML =
      //       '<span class="alert-msg">해당하는 조건의 축제가 없습니다!😱</span>';
      //   }
      //페이징
      //   let p = '';
      //   for (let i = 0; i < totalPage; i++) {
      //     p += `<li page='${i + 1}' class='page-list'>${i + 1}</li>`;
      //   }
      //document.querySelector('.pagination').innerHTML = p;
      //   let pageList = document.querySelectorAll('.page-list');
      //   for (const page of pageList) {
      //     page.addEventListener('click', function (e) {
      //       pageNum = e.target.getAttribute('page');
      //       if (totalPage < pageNum) pageNum = totalPage;
      //       parseAreaBased(areaCode, pageNum, numOfRows, month, currentYear);
      //       getAreaName(areaCode);
      //     });
    }
  };
  xhr.send(null);
}
