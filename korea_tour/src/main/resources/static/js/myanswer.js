'use strict';

const totalCount = document.getElementById("totalCount");
const answerBox = document.querySelector(".count-box__answer-text");
const reanswerBox = document.querySelector(".count-box__reanswer-text");
const printBox = document.querySelector("#printBox");

function myAnswerList(){
    var xhr = new XMLHttpRequest();
    var url = '/mypage/answer/1';
    xhr.open('GET', url);
    xhr.send();
    console.log(url);

    xhr.onreadystatechange = function(){
        if (this.readyState == 4) {
            let data = JSON.parse(this.responseText);
            let item = data.myanswer;
            
            
            console.log(item);
            
             let s=" ";
             for(let i=0; i<item.length; i++){
                 let loginId = item[i].loginId;
                 let content = item[i].content;
                 let loginPhoto = item[i].loginPhoto;
                 let writeday = item[i].writeDay;
                 let title = item[i].title;
                 let contentId = item[i].contentId;
                 s+="<div class='answer-box'>";
                 s+="<div class='image-box'>";
                 s+="<img src='"+loginPhoto+"' alt='"+loginId+"'>";
                 s+="</div>";
                 s+="<div class='answer-info__box'>";
                 s+="<div class='answer-info'>";
                 s+=`<p class='answer-name' onclick='location.href="/tourplace/detail?contentId=${contentId}"'>${title}</p>`;
                 s+="<p class='answer-start'>"+content+"</p>";
                 s+="<span>"+loginId+"</span><span>|</span><span>"+writeday+"</span>";
                 s+="</div>";
                 s+="<i class='fas fa-ellipsis-v answer-icon'></i>";
                 s+="</div>";
                 s+="</div>";
                 s+="<hr class='hr2'>";
               
                
                
             }   
             printBox.innerHTML=s;
            
            
            
            
            let answerCount = item.length;
            totalCount.innerText = "총"+answerCount+"건";
            console.log(answerCount);
            answerBox.style.color="black";
            answerBox.style.fontSize="1.1em";
            reanswerBox.style.color="#98938d";
            reanswerBox.style.fontSize="1em";
        }
    
    }
}

reanswerBox.addEventListener('click', e => {
    var xhr = new XMLHttpRequest();
    var url = '/mypage/reanswer/1';
    xhr.open('GET', url);
    xhr.send();
    console.log(url);

    xhr.onreadystatechange = function(){
        if (this.readyState == 4) {
            let data = JSON.parse(this.responseText);
            let item = data.myReanswer;
            console.log(item);
            
             let c=" ";
             for(let i=0; i<item.length; i++){
                 let loginId = item[i].loginId;
                 let content = item[i].content;
                 let loginPhoto = item[i].loginPhoto;
                 let writeday = item[i].writeDay;
                 let title = item[i].title;
                 let contentId = item[i].contentId;
                 c+="<div class='answer-box'>";
                 c+="<div class='image-box'>";
                 c+="<img src='"+loginPhoto+"' alt='"+loginId+"'>";
                 c+="</div>";
                 c+="<div class='answer-info__box'>";
                 c+="<div class='answer-info'>";
                 c+=`<p class='answer-name' onclick='location.href="/tourplace/detail?contentId=${contentId}"'>${title}</p>`;
                 c+="<p class='answer-start'>"+content+"</p>";
                 c+="<span>"+loginId+"</span><span>|</span><span>"+writeday+"</span>";
                 c+="</div>";
                 c+="<i class='fas fa-ellipsis-v answer-icon'></i>";
                 c+="</div>";
                 c+="</div>";
                 c+="<hr class='hr2'>";
               
                
                
             }   
             printBox.innerHTML=c;
            
            
            
            
            let reAnswerCount = item.length;
            totalCount.innerText = "총"+reAnswerCount+"건";
            console.log(reAnswerCount);
            reanswerBox.style.color="black";
            reanswerBox.style.fontSize="1.1em";
            answerBox.style.color="#98938d";
            answerBox.style.fontSize="1em";
        }
    
    }
});





myAnswerList();