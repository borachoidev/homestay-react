'use strict';

const myCoursePage = document.getElementById('mainCourseBox');
const myFavoritePage = document.getElementById('mainFavoriteBox');
const myAnswerPage = document.getElementById('mainAnswerBox');

myCoursePage.addEventListener('click', e => {
  location.href = '/mypage/courselist';
});

myFavoritePage.addEventListener('click', e => {
  location.href = '/mypage/favorite';
});

myAnswerPage.addEventListener('click', e => {
  location.href = '/mypage/answer';
});

const loginMenu = document.querySelector('.login-menu');
const loginbar = document.querySelector('.login-bar');


//  loginMenu.addEventListener('click', () => {
//      loginbar.classList.toggle('change');
//  });

function init(){
    myCoursePage();
    myFavoritePage();
    myAnswerPage();
}

init();