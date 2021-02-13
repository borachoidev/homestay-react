import React from 'react';
import './Home.css'

function Home(props) {
  return <div>



  <div className="back-ground"  style ={ { backgroundImage: "url('https://a0.muscache.com/airbnb/static/business_travel/traveler_landing/hero-business-traveler-home-ece30e2ee02a07c38b2cad542ab026c1.jpg')" } }>
  <div className="text-center" > 
      <div className="page-container">
        <div className="text-contrast" >
        <br></br>
        <h1 id="mainTitle" className="text-jumbo space-1">이제, 홈스테이도 라온나드리와! </h1>
        <h3 className="space-6 space-top-1">Book unique homes and experience a city like a local.</h3>
          <div className="landing-enroll-app">
            <div><button type="button" className="btn btn-primary btn-large"><span ><a id="raon-link"target="_blank" href="http://www.raonnadri.tk/">라온나드리 자세히보기 >></a></span></button></div>
            <br></br>
          </div>
        </div>
      </div>
    </div>
    </div> 
  <div class="site-content">
	<div class="title"><span>라온홈스테이 각 지의 호스트들은<br></br> 꼼꼼한 검증 절차를 거치며 🕵️‍♂️,<br></br></span> <br></br>호스트가 되고 싶으신 분들은 <br></br>어렵지 않은 신청 절차를 경험하실 수 있습니다 📗.</div>
  </div>



    </div>
  
  
}


export default Home;
