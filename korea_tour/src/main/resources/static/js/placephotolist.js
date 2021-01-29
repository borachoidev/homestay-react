'use strict';

placePhotoList();


// parameter value 읽기
function getParam(key) {
  let param;
  const queryString = window.location.search;
  const urlParams = new URLSearchParams(queryString);
  param = urlParams.get(key);
  return param;
}

const delBtns = document.querySelectorAll(".delete-btn");
for( const btn of delBtns){
btn.addEventListner("click",function(){
 const noticeNum=btn.parentElement.getAttribute("num");
 deleteNotice(noticeNum);
})
}


//아직 백에서 삭제 진행중
function deleteNotice(noticeNum){
    var xhr = new XMLHttpRequest();
  
    url =`notice/${noticeNum}`
  
  
    xhr.open('DELETE', url);
    xhr.onreadystatechange = function () {
      if (this.readyState == 4) {
     location.reload();
  
}
    }

const apBtns = document.querySelectorAll(".approval-btn");
for( const btn of apBtns){
btn.addEventListner("click",function(){
 const noticeNum=btn.parentElement.getAttribute("num");
 updateNotice(noticeNum);
})
}




function placePhotoList(){
    var xhr = new XMLHttpRequest();
    var url = `/admin/place/photo`;
    xhr.open('GET', url);
    xhr.send();
    console.log(url);

    xhr.onreadystatechange = function(){
        if (this.readyState == 4) {
	    let data = JSON.parse(this.responseText);
    	let item = data.photo;
            console.log(item);

        let a="";
		for(let i=0;i<item.length;i++){
			a+= `<tr class="board_list_row">`
					a+= `<td class="board_list_data">${i+1}</td>`
						a+= `<td class="board_list_data">${item[i].photoNum}</td>`
					a+=`<td class="board_list_data">${item[i].contentId}</td>`
					a+=`<td class="board_list_data"><img src="${item[i].image}"></td>`
					a+=`<td class="board_list_data">${item[i].loginId}</td>`
				    a+=`<td class="board_list_data num"  num="${item[i].photoNum}"><button type="button" class="delete-btn">삭제</button></td>`

					a+=`<td class="board_list_data num"  num="${item[i].photoNum}"><button type="button" class="approval-btn">승인</button></td>`

		}
	document.querySelector(".list_row").innerHTML=a;
	
	
           
}
}
}
}