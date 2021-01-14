'use strict';

const searchBtn = document.getElementById('searchBtn');

searchBtn.addEventListener('click', e => {
  let keyword = document.querySelector('#searchBar').value;
  location.href = '/search?' + keyword;
});
