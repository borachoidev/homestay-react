'use strict';

// let modal = document.querySelector("#modal");

// function modalOpen(){
//     modal.style.display="block";
    
// }

// function modalClose(){
//     modal.style.display="none";
// }

// window.onclick = function(event) {
//     if (event.target == modal) {
//         modal.style.display = "none";
//     }
// }
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