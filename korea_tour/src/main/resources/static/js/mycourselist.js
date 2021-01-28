'use strict';

const totalCount = document.querySelector(".count-box");
const printBox = document.querySelector("#printBox");

function myAnswerList(){
    var xhr = new XMLHttpRequest();
    var url = '/mypage/courses/1';
    xhr.open('GET', url);
    xhr.send();
    console.log(url);

    xhr.onreadystatechange = function(){
        if (this.readyState == 4) {
            let data = JSON.parse(this.responseText);
            let item = data.list;
            console.log(item);
            
            let s=" ";
            for(let i=0; i<item.length; i++){
                let couseName = item[i].name;
                let addr = item[i].addr1;
                let firstImage = item[i].firstImage;
                let who = item[i].who;
                let during = item[i].during;
                let how = item[i].how; 
                
                s+="<div class='courselist-box'>";
                s+="<div class='image-box'>";
                s+="<img src='"+firstImage+"' alt='"+couseName+"'>";
                s+="</div>";
                s+="<div class='courselist-info__box'>";
                s+="<div class='courselist-info'>";
                s+="<p class='courselist-name'>"+couseName+"</p>";
                s+="<p class='courselist-start'>"+addr+"</p>";
                s+="<span>#"+during+"</span><span>#"+who+"</span><span>#"+how+"</span>";
                s+="</div>";
                s+="<i class='fas fa-ellipsis-v courselist-icon'></i>";
                s+="</div>";
                s+="</div>";
                
                s+="<hr class='hr2'>";
                
                
            }   
            printBox.innerHTML=s;
            
            
            
            
            let courseCount = item.length;
            totalCount.innerText = "총"+courseCount+"건";
            console.log(courseCount);
            
        }
    
    }
}




myAnswerList();




        // Get the modal
        var modal = document.getElementById('myModal');
 
        // Get the button that opens the modal
        var btn = document.getElementById("modalBtn");
 
                                             
 
        // When the user clicks on the button, open the modal 
        btn.onclick = function() {
            modal.style.display = "block";
        }
 
        
 
        // When the user clicks anywhere outside of the modal, close it
        window.onclick = function(event) {
            if (event.target == modal) {
                modal.style.display = "none";
            }
        }

        function getURL(){
            let uri = location.href;

            document.getElementById("urlText").innerHTML="<p>"+uri+"</p>"
        }