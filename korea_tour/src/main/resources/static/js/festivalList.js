'use strict';
let numOfRows = 10;
const date = new Date();
const currentYear = date.getFullYear();
let areaCode = getParam('areaCode');
let month;
let totalPage;
let pageNum = getParam('pageNum');

let eventStartDate;
let eventEndDate;

parseAreaBased(areaCode, pageNum, numOfRows, month, currentYear);
getAreaName(areaCode);
monthOnclick();
AreaOnclick();
pagination();

/* ----- functions ---- */

//eventEndDate 구하기
function getEndDate(month, currentYear) {
  let endDate = '';
  switch (month) {
    case '4':
    case '6':
    case '9':
    case '11':
      endDate = 30;
      break;
    case '2':
      if (
        (currentYear % 4 == 0 && currentYear % 100 != 0) ||
        currentYear % 400 == 0
      ) {
        endDate = 29;
      } else {
        endDate = 28;
      }
      break;
    default:
      endDate = 31;
      break;
  }
  return currentYear + (month > 10 ? month : '0' + month) + endDate;
}
function getStartDate(month, currentYear) {
  eventStartDate = currentYear + (month > 10 ? month : '0' + month) + '01';
  return eventStartDate;
}
function monthOnclick() {
  let monthList = document.querySelectorAll('.month-list');
  for (const monthBtn of monthList) {
    monthBtn.addEventListener('click', function (e) {
      month = e.target.getAttribute('month');
      console.log(`month ${month}`);
      parseAreaBased(areaCode, pageNum, numOfRows, month, currentYear);
    });
  }
}

function AreaOnclick() {
  let areaList = document.querySelectorAll('.area-list');
  for (const areaBtn of areaList) {
    areaBtn.addEventListener('click', function (e) {
      areaCode = e.target.getAttribute('area');
      if (areaCode == 'all') {
        areaCode = '';
      }
      parseAreaBased(areaCode, pageNum, numOfRows, month, currentYear);
      getAreaName(areaCode);
    });
  }
}
function pagination() {
  let pageList = document.querySelectorAll('.page-list');
  for (const page of pageList) {
    page.addEventListener('click', function (e) {
      pageNum = e.target.getAttribute('page');
      alert();
      parseAreaBased(areaCode, pageNum, numOfRows, month, currentYear);
      getAreaName(areaCode);
    });
  }
}
// parameter value 읽기
function getParam(key) {
  let param;
  const queryString = window.location.search;
  const urlParams = new URLSearchParams(queryString);
  param = urlParams.get(key);
  return param;
}

//areacode 변환
function getAreaName(areaCode) {
  let xmlStr;
  let xmlDoc;
  var xhr = new XMLHttpRequest();
  var url =
    'http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaCode'; /*URL*/
  var queryParams =
    '?' +
    encodeURIComponent('serviceKey') +
    '=' +
    'CaXsuilSjIPz3L19P%2F6ufv6lKG6DwvhRg5x2lK5lzUTP66WyVxrNQcvBdb6CxuXHRNrbDXoscBHGwPy5aQd4sw%3D%3D'; /*Service Key*/
  queryParams +=
    '&' + encodeURIComponent('MobileOS') + '=' + encodeURIComponent('ETC'); /**/
  queryParams +=
    '&' +
    encodeURIComponent('MobileApp') +
    '=' +
    encodeURIComponent('test%20App'); /**/
  queryParams +=
    '&' + encodeURIComponent('numOfRows') + '=' + encodeURIComponent('20'); /**/
  queryParams +=
    '&' + encodeURIComponent('arrange') + '=' + encodeURIComponent('Y');
  queryParams +=
    '&' + encodeURIComponent('listYN') + '=' + encodeURIComponent('Y');

  xhr.open('GET', url + queryParams);
  xhr.onreadystatechange = function () {
    if (this.readyState == 4) {
      xmlStr = this.responseText;
      var xmlParser, xmlDoc;
      xmlParser = new DOMParser();
      xmlDoc = xmlParser.parseFromString(xmlStr, 'text/xml');

      let list = xmlDoc.getElementsByTagName('item');
      let areaName;
      for (let i = 0; i < list.length; i++) {
        if (
          list[i].getElementsByTagName('code')[0].childNodes[0].nodeValue ===
          areaCode
        )
          areaName = list[i].getElementsByTagName('name')[0].childNodes[0]
            .nodeValue;
      }
      if (areaCode === '') {
        document.querySelector('.area-title').innerHTML = '전체보기';
      } else {
        document.querySelector('.area-title').innerHTML = areaName;
      }
    }
  };
  xhr.send(null);
}

//api 데이터
function parseAreaBased(areaCode, pageNum, numOfRows, month, currentYear) {
  if (month == 'all' || month == undefined) {
    eventStartDate = '';
    eventEndDate = '';
  } else {
    eventStartDate = getStartDate(month, currentYear);
    eventEndDate = getEndDate(month, currentYear);
  }

  let xmlStr;
  let xmlDoc;
  var xhr = new XMLHttpRequest();
  var url =
    'http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchFestival'; /*URL*/
  var queryParams =
    '?' +
    encodeURIComponent('serviceKey') +
    '=' +
    'CaXsuilSjIPz3L19P%2F6ufv6lKG6DwvhRg5x2lK5lzUTP66WyVxrNQcvBdb6CxuXHRNrbDXoscBHGwPy5aQd4sw%3D%3D'; /*Service Key*/
  queryParams +=
    '&' +
    encodeURIComponent('numOfRows') +
    '=' +
    encodeURIComponent(numOfRows); /**/
  queryParams +=
    '&' + encodeURIComponent('pageNo') + '=' + encodeURIComponent(pageNum); /**/
  queryParams +=
    '&' + encodeURIComponent('MobileOS') + '=' + encodeURIComponent('ETC'); /**/
  queryParams +=
    '&' +
    encodeURIComponent('MobileApp') +
    '=' +
    encodeURIComponent('test%20App'); /**/
  queryParams +=
    '&' +
    encodeURIComponent('contentTypeId') +
    '=' +
    encodeURIComponent('15'); /**/
  queryParams +=
    '&' + encodeURIComponent('arrange') + '=' + encodeURIComponent('A'); /**/
  queryParams +=
    '&' + encodeURIComponent('listYN') + '=' + encodeURIComponent('Y');
  queryParams +=
    '&' + encodeURIComponent('areaCode') + '=' + encodeURIComponent(areaCode);
  queryParams +=
    '&' + encodeURIComponent('sigunguCode') + '=' + encodeURIComponent('');
  queryParams +=
    '&' + encodeURIComponent('cat2') + '=' + encodeURIComponent('');
  queryParams +=
    '&' + encodeURIComponent('cat3') + '=' + encodeURIComponent('');
  queryParams +=
    '&' +
    encodeURIComponent('eventStartDate') +
    '=' +
    encodeURIComponent(eventStartDate);
  queryParams +=
    '&' +
    encodeURIComponent('eventEndDate') +
    '=' +
    encodeURIComponent(eventEndDate);

  /**/
  console.log(url + queryParams);
  xhr.open('GET', url + queryParams);
  xhr.onreadystatechange = function () {
    if (this.readyState == 4) {
      xmlStr = this.responseText;
      var xmlParser, xmlDoc;
      xmlParser = new DOMParser();
      xmlDoc = xmlParser.parseFromString(xmlStr, 'text/xml');
      let totalCount = xmlDoc.getElementsByTagName('totalCount')[0]
        .childNodes[0].nodeValue;

      totalPage = Math.ceil(parseInt(totalCount) / numOfRows);
      console.log(totalPage);
      let list = xmlDoc.getElementsByTagName('item');
      let n = '';
      for (let i = 0; i < list.length; i++) {
        n += `<div class='card'>`;
        n += `<img src='${
          list[i].getElementsByTagName('firstimage2')[0].childNodes[0].nodeValue
        }' class='thumbnail'/>`;
        n += `<div class='info'><span class='title'>${
          list[i].getElementsByTagName('title')[0].childNodes[0].nodeValue
        }</span>`;
        n += `<span class="date">${
          list[i].getElementsByTagName('eventstartdate')[0].childNodes[0]
            .nodeValue
        } `;
        n += `~ ${
          list[i].getElementsByTagName('eventenddate')[0].childNodes[0]
            .nodeValue
        }</span>`;
        n += `<span class='place'>${
          list[i].getElementsByTagName('addr1')[0].childNodes[0].nodeValue
        }</span>`;
        n += `</div>`;
      }
      document.querySelector('.list').innerHTML = n;
      //페이징

      for (let i = 0; i < totalPage; i++) {
        let li = document.createElement('li');
        li.classList.add('page-list');
        console.log(li);
        document.querySelector('.pagination').appendChild(li);
      }
    }
  };
  xhr.send(null);
}
