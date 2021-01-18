'use strict';
const date = new Date();
const currentYear = date.getFullYear();
let month;
let day;
let eventStartDate;
let eventEndDate;

parseAreaBased(month, currentYear);

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

function getStartDate(month, day, currentYear) {
  if (day == undefined) day = '01';
  eventStartDate = currentYear + (month > 10 ? month : '0' + month) + day;
  return eventStartDate;
}

function writeCalendar(year, month) {
  let mydate = new Date(year, month - 1, 1);
  let Week = mydate.getDay();
  let endDate;

  //월의 날자수 구하기
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

  //테이블 요일 출력
  tdtr += "<table class='cal'>";
  tdtr += "<thead><tr class='week'>";
  for (let i = 0; i < weeks.length; i++) {
    tdtr += '<td>' + weeks[i] + '</td>';
  }
  tdtr += '</tr>';
  tdtr += '</thead><tbody>';
  tdtr += '<tr>';
  for (let i = 0; i < myWeek; i++) {
    if (myWeek == 0) {
      break;
    }
    tdtr += '<td> </td>';
  }
  //날짜 넣기
  for (let i = 1; i <= myDay; i++) {
    myWeek++;

    tdtr +=
      "<td class='" +
      i +
      "'><span>" +
      i +
      "</span><div class='sch'></div></td>";

    if (myWeek % 7 == 0 && i != myDay) {
      tdtr += '</tr><tr>';
    }
    if (i == myDay) {
      tdtr += '</tr>';
    }
  }

  //출력
  tdtr += '</tbody></table>';
  $('#myCalendar').html(tdtr);
  printData();
  localApply();
}

//api 데이터
function parseAreaBased(month, currentYear) {
  if (month == 'all' || month == undefined) {
    month = date.getMonth() + 1;
    eventStartDate = getStartDate(month, day, currentYear);
    eventEndDate = '';
  } else {
    eventStartDate = getStartDate(month, day, currentYear);
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
    '&' + encodeURIComponent('numOfRows') + '=' + encodeURIComponent('4'); /**/
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
    '&' + encodeURIComponent('arrange') + '=' + encodeURIComponent('B'); /**/
  queryParams +=
    '&' + encodeURIComponent('listYN') + '=' + encodeURIComponent('Y');

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

      let list = xmlDoc.getElementsByTagName('item');
    }
  };

  xhr.send(null);
}
