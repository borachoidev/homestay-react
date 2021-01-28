'use strict';

const placeMark = document.getElementById("placeMark");
const courseMark = document.getElementById("courseMark");
const totalCount = document.getElementById("totalCount");
const t1 = document.querySelector("#t1");

placeMark.addEventListener('click', e => {
    var xhr = new XMLHttpRequest();
    var url = '/mypage/placemarks/1';
    xhr.open('GET', url);
    xhr.send();
    console.log(url);

    xhr.onreadystatechange = function(){
        if (this.readyState == 4) {
            
            let data = JSON.parse(this.responseText);
            let item = data.list;
            let s=" ";
            for(let i=0; i<item.length; i++){
                let titles = item[i].title;
                let addrs = item[i].addr1;
                let firstImages = item[i].firstImage;
                
                s+="<div class='favorite-infobox'>";
                s+="<div class='image-box'>";
                s+="<img src='"+firstImages+"' alt='"+titles+"' style='max-width:100%; height:150px'>";
                s+="</div>";
                s+="<div class='favorite-info__box'>";
                s+="<div class='favorite-info'>";
                s+="<p class='favorite-name'>"+titles+"</p>";
                s+="<p class='favorite-start'>"+addrs+"</p>";
                s+="</div>";
                s+="<i class='fas fa-ellipsis-v favorite-icon'></i>";
                s+="</div>";
                s+="</div>";
                s+="<hr class='hr2'>";
            }   
            t1.innerHTML=s;

            // console.log(data);
            // console.log(data.list);
            // console.log(data.list.length);
            let placeCount = data.list.length;
            totalCount.innerText = "총"+placeCount+"건";
            placeMark.style.color="black";
            placeMark.style.fontSize="1.1em";
            courseMark.style.color="#98938d";
            courseMark.style.fontSize="1em";
        }
    
    }
});

function courseMarkForm(){
    var xhr = new XMLHttpRequest();
    var url = '/mypage/coursemarks/1';
    xhr.open('GET', url);
    xhr.send();
    console.log(url);

    xhr.onreadystatechange = function(){
        if (this.readyState == 4) {
            let data = JSON.parse(this.responseText);
            let item = data.list;
            let c=" ";
            for(let i=0; i<item.length; i++){
                let names = item[i].name;
                let titles = item[i].title;
                let firstImages = item[i].firstImage;
                let whos = item[i].who;
                let durings = item[i].during;
                let hows = item[i].how;
                
                c+="<div class='favorite-infobox'>";
                c+="<div class='image-box'>";
                c+="<img src='"+firstImages+"' alt='"+names+"' style='max-width:100%; height:150px'>";
                c+="</div>";
                c+="<div class='favorite-info__box'>";
                c+="<div class='favorite-info'>";
                c+="<p class='favorite-name'>"+names+"</p>";
                c+="<p class='favorite-start'>"+titles+"</p>";
                c+="<span class='favortie-tema'>#"+whos+"</span>";
                c+="<span class='favortie-tema'>#"+durings+"</span>";
                c+="<span class='favortie-tema'>#"+hows+"</span>";
                c+="</div>";
                c+="<i class='fas fa-ellipsis-v favorite-icon'></i>";
                c+="</div>";
                c+="</div>";
                c+="<hr class='hr2'>";
            }   
            t1.innerHTML=c;
            
            
            
            // console.log(data);
            // console.log(data.list);
            // console.log(data.list.length);
            let courseCount = data.list.length;
            totalCount.innerText = "총"+courseCount+"건";
            courseMark.style.color="black";
            courseMark.style.fontSize="1.1em";
            placeMark.style.color="#98938d";
            placeMark.style.fontSize="1em";
        }
    
    }
}

courseMarkForm();