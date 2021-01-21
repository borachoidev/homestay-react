'use strict';
const date = new Date();
const currentYear = date.getFullYear();
const currMonth = date.getMonth() + 1;
const currDate = date.getDate();
let day = currDate;
let month = currMonth;

writeCalendar(currentYear, currMonth);
parseAreaBased(month, day);
document.querySelector('.pre-month').addEventListener('click', () => {
  if (month == 1) {
    month = 1;
  } else {
    month = month - 1;
  }

  writeCalendar(currentYear, month);
});
document.querySelector('.next-month').addEventListener('click', function () {
  if (month == 12) {
    month = 12;
  } else {
    month = month + 1;
  }

  writeCalendar(currentYear, month);
});
/* ----- functions ---- */
//eventEndDate 구하기
function getEndDate(year, month) {
  let endDate;
  switch (month) {
    case 4:
    case 6:
    case 9:
    case 11:
      endDate = 30;
      break;
    case 2:
      if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
        endDate = 29;
      } else {
        endDate = 28;
      }
      break;
    default:
      endDate = 31;
      break;
  }

  return endDate;
}

function getEventDate(month, day) {
  if (day == undefined) day = '1';
  month = parseInt(month);

  let eventDate =
    currentYear +
    '' +
    (month > 9 ? month : '0' + month) +
    '' +
    (day > 9 ? day : '0' + day);
  return eventDate;
}

function writeCalendar(year, month) {
  let endDate = getEndDate(year, month);

  //월의 날자수 구하기

  let p = '';
  for (let i = 0; i < endDate; i++) {
    p += `<span class='cal-date'>${i + 1}</span>`;
  }
  document.querySelector('.current-month').innerHTML = month + '월';
  document.querySelector('.cal-dates').innerHTML = p;
  const caldates = document.querySelectorAll('.cal-date');
  for (const date of caldates) {
    date.addEventListener('click', () => {
      day = date.innerHTML;
      parseAreaBased(month, day);
    });
  }
}

//api 데이터
function parseAreaBased(month, day) {
  let eventDate;
  if (month == 'all' || month == undefined) {
    month = date.getMonth() + 1;
    eventDate = getEventDate(month, day);
  } else {
    eventDate = getEventDate(month, day);
  }
  console.log(eventDate);
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
    '&' + encodeURIComponent('numOfRows') + '=' + encodeURIComponent('10'); /**/
  queryParams +=
    '&' + encodeURIComponent('pageNo') + '=' + encodeURIComponent('1'); /**/
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
    '&' + encodeURIComponent('arrange') + '=' + encodeURIComponent('R'); /**/
  queryParams +=
    '&' + encodeURIComponent('listYN') + '=' + encodeURIComponent('Y');

  queryParams +=
    '&' +
    encodeURIComponent('eventStartDate') +
    '=' +
    encodeURIComponent(eventDate);
  queryParams +=
    '&' +
    encodeURIComponent('eventEndDate') +
    '=' +
    encodeURIComponent(eventDate);

  /**/
  console.log(url + queryParams);
  xhr.open('GET', url + queryParams);
  xhr.onreadystatechange = function () {
    if (this.readyState == 4) {
      xmlStr = this.responseText;
      var xmlParser, xmlDoc;
      xmlParser = new DOMParser();
      xmlDoc = xmlParser.parseFromString(xmlStr, 'text/xml');

      let list = xmlDoc.getElementsByTagName('item');

      let s = '';
      if (list.length > 6) {
        s += `<a href='/festival/detail?contentId=${
          list[6].getElementsByTagName('contentid')[0].childNodes[0].nodeValue
        }`;
        s += `&areaCode=${
          list[6].getElementsByTagName('areacode')[0].childNodes[0].nodeValue
        }&pageNum=1&month=undefined'>`;
        s += "<div class='fes-main-card'>";
        s += ` <img src='${
          list[6].getElementsByTagName('firstimage')[0].childNodes[0].nodeValue
        }' class='fes-main-img'/>`;

        s += `<span class='fes-title'>${
          list[6].getElementsByTagName('title')[0].childNodes[0].nodeValue
        }</span></div></a>`;
      } else {
        s += `<a href='/festival/detail?contentId=${
          list[0].getElementsByTagName('contentid')[0].childNodes[0].nodeValue
        }`;
        s += `&areaCode=${
          list[0].getElementsByTagName('areacode')[0].childNodes[0].nodeValue
        }&pageNum=1&month=undefined'>`;
        s += "<div class='fes-main-card'>";
        s += ` <img src='${
          list[0].getElementsByTagName('firstimage')[0].childNodes[0].nodeValue
        }' class='fes-main-img'/>`;

        s += `<span class='fes-title'>${
          list[0].getElementsByTagName('title')[0].childNodes[0].nodeValue
        }</span></div></a>`;
      }
      document.querySelector('.festival-main').innerHTML = s;
      let l = '';

      for (let i = 1; i < 4; i++) {
        l += `<a href='/festival/detail?contentId=${
          list[i].getElementsByTagName('contentid')[0].childNodes[0].nodeValue
        }`;
        l += `&areaCode=${
          list[i].getElementsByTagName('areacode')[0].childNodes[0].nodeValue
        }&pageNum=1&month=undefined'>`;
        l += "<div class='fes-card'>";
        l += ` <img src='${
          list[i].getElementsByTagName('firstimage')[0].childNodes[0].nodeValue
        }' class='fes-img'/>`;
        l += `<span class ='fes-date'>${
          list[i].getElementsByTagName('eventstartdate')[0].childNodes[0]
            .nodeValue
        } ~${
          list[i].getElementsByTagName('eventenddate')[0].childNodes[0]
            .nodeValue
        }</span>`;
        l += `<span class='fes-title'>${
          list[i].getElementsByTagName('title')[0].childNodes[0].nodeValue
        }</span></div></a>`;
      }

      document.querySelector('.festival-list').innerHTML = l;
    }
  };

  xhr.send(null);
}
