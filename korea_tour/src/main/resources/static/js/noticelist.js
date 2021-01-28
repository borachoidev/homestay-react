'use strict';
let perBlock = 5;
let currentPage = getParam("currentPage")
let startPage = Math.floor((currentPage - 1) / perBlock) * perBlock + 1;
let endPage = startPage + perBlock - 1;
myAnswerList(currentPage);

// parameter value 읽기
function getParam(key) {
  let param;
  const queryString = window.location.search;
  const urlParams = new URLSearchParams(queryString);
  param = urlParams.get(key);
  return param;
}

function myAnswerList(currentPage){
    var xhr = new XMLHttpRequest();
    var url = `/notice/${currentPage}`;
    xhr.open('GET', url);
    xhr.send();
    console.log(url);

    xhr.onreadystatechange = function(){
        if (this.readyState == 4) {
	    let data = JSON.parse(this.responseText);
    	let item = data.notices;
            console.log(item);

        let a="";
		for(let i=0;i<item.length;i++){
			a+= `<tr class="board_list_row">`
					a+= `<td class="board_list_data">${i+1}</td>`
						a+= `<td class="board_list_data">${item[i].content}</td>`
					a+=`<td class="board_list_data">홍길동</td>`
					a+=`<td class="board_list_data">2015-12-31</td>`
					a+=`<td class="board_list_data">xx</td>`
					a+=`<td class="board_list_data">xx</td>`
					a+=`<td class="board_list_data">Y</td>`
					a+=`<td class="board_list_data"><a href="#" class="btn_txt btn_type_d btn_color_a"> <span class="txt">조회</span></a></td></tr>`
		}
	document.querySelector(".listlist").innerHTML=a;
	
	 const totalPage = data.totalPage; //
      if (endPage > totalPage) {
        endPage = totalPage;
      }
     
      let p = '';
      if (startPage > 1) {
        p += `<li class='page-list'><a href='/admin/notice/list?currentPage=${
          startPage - 1
        }'><i class="fas fa-chevron-left"></i></li>`;
      }
      for (let i = startPage; i <= endPage; i++) {
        p += `<li class='page-list'><a href='/admin/notice/list?currentPage=${i}'>${i}</a></li>`;
      }
      if (endPage < totalPage) {
        p += `<li page='${
          endPage + 1
        }' class='page-list'><a href='/admin/notice/list?currentPage=${
          endPage + 1
        }'><i class="fas fa-chevron-right"></i></a></li>`;
      }
      document.querySelector('.page_nation').innerHTML = p;
    }
           
}
}

