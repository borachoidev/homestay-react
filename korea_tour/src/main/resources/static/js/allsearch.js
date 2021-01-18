'use strict';


$(function(){

	//사이드바 스크롤
	const scrollHeight = 162;

	function sidebar(){
		if($(window).scrollTop() > scrollHeight){
			let top = $(window).scrollTop() - scrollHeight + 20;
			document.getElementById('sidebar').style.top = top+'px';
		}else{
			document.getElementById('sidebar').style.top = '20px';
		}
	}

	sidebar();

	$(window).scroll(()=>{
		sidebar();
	});

});