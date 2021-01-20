'use strict';


function ajaxReq(lnk){
            var xhr = new XMLHttpRequest();//XMLHttp 객체 만들기
            xhr.onreadystatechange = function() { //콜백함수 쓰기
               
                
            };
            
            xhr.open("GET", lnk, true); //(요청 유형, 서버주소, 비동기여부)
            xhr.send(); //POST의 경우 인자로 파라미터
      }





