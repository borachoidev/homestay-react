'use strict';

//코스담기 함수
function addCourse(courseNum) {
  const xhr = new XMLHttpRequest();
  const url = '/api/courseplaces';
  xhr.open('POST', url);
  xhr.setRequestHeader('Content-type', 'application/json');

  const userNum = document.querySelector('span#num').getAttribute('data-id');
  const contentId = decodeURI(document.location.href).split('=')[1];
  const data = { userNum: userNum, courseNum: courseNum, contentId: contentId };

  console.log(data);
  xhr.send(JSON.stringify(data));

  xhr.onreadystatechange = function (e) {
    if (xhr.readyState !== XMLHttpRequest.DONE) return;

    if (xhr.status === 200) {
      location.href = `/tourmypage/courselist/detail?courseNum=${courseNum}`;
    }
  };
}

function showCourses() {
  const userNum = document.querySelector('span#num').getAttribute('data-id');
  if (userNum == 'out') return alert('로그인후 이용가능합니다');
  const xhr = new XMLHttpRequest();
  const url = `/api/place/detail/course/${userNum}`;
  xhr.open('GET', url);
  xhr.send();
  xhr.onreadystatechange = function (e) {
    if (xhr.readyState !== XMLHttpRequest.DONE) return;

    if (xhr.status === 200) {
      let data = JSON.parse(this.responseText);
      const courses = data.course;
      console.log(data);

      let p = '<div class="course-list">';
      console.log(courses.length);
      for (let i = 0; i < courses.length; i++) {
        p += `<span class="course" data-num="${courses[i].courseNum}">${courses[i].name}</span>`;
      }
      p += '</div>';

      document.querySelector('#courseList').innerHTML = p;

      const courseList = document.querySelectorAll('.course');
      for (const course of courseList) {
        course.addEventListener('click', () => {
          const courseNum = course.getAttribute('data-num');
          addCourse(courseNum);
        });
      }
    }
  };
}
