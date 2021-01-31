$(document).ready(function() {
	//여기 아래 부분
	$('#summernote').summernote({
		  height: 250,                 // 에디터 높이
		  minHeight: null,             // 최소 높이
		  maxHeight: null,             // 최대 높이
		  focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
		  lang: "ko-KR",					// 한글 설정
		 

			
});
});



let noticeNum = getParam('noticeNum');

function getParam(key) {
  let param;
  const queryString = window.location.search;
  const urlParams = new URLSearchParams(queryString);
  param = urlParams.get(key);
  return param;
}

updateDetail(noticeNum);


function updateButton(noticeNum){
	const xhr = new XMLHttpRequest();
    const url =`/api/noticeupdate/${noticeNum}`;
	
 	xhr.open('POST',url);
	alert(url);
  	
    xhr.onreadystatechange = function () {
	console.log(xhr.readyState)
      if (xhr.readyState == 4) {
	
			alert("성공");
		    window.location.reload(true);
			
		}
	}
	xhr.send(null);
    }

function updateDetail(noticeNum){
  	const xhr = new XMLHttpRequest();
    const url =`/api/notice/detail/${noticeNum}`;
 	xhr.open('GET',url);
    console.log(url);
    xhr.send();
	xhr.onreadystatechange = function(){
		console.log(xhr.readyState)
        if (this.readyState == 4) {
	  	let data = JSON.parse(this.responseText);
    	let item = data.noticeDetail;
            console.log(item);

        let a="";
		{

		a+=`<input type="text" class="notice-title" id="notice-title" name="title" value="${item.title}"></input>`;
	    a+= `<textarea name="content" id="summernote" class="summernote">${item.content}</textarea>`;
		a+= `<div class="notice-buttons">`;
		a+= `<button id="subBtn" type="button">수정하기</button>`;
		a+= `<button id="bacBtn" type="button" onclick="window.location.href='/admin/notice/detail?noticeNum='+${item.noticeNum}">돌아가기</button>`;
		a+= `</div>`;

		
		}
	document.querySelector(".notice-update-sub").innerHTML=a;
  	const subBtn = document.querySelector("#subBtn");

	subBtn.addEventListener("click",function(){
		
	updateButton(noticeNum);

 })
	}
	}
	}
	
	
	



	
	
