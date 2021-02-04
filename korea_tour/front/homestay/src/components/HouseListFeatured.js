import React, { useEffect, useState } from 'react';
import axios from 'axios';
import Grid from "@material-ui/core/Grid";
import HouseListSort from "./HouseListSort";
import HouseCard from "./HouseCard";
import NavBar from "./NavBar";
import Pagination from "./Pagination";
import CssBaseline from "@material-ui/core/CssBaseline";
import Container from "@material-ui/core/Container";

const HouseListFeatured = () =>{

  const [contents,setContents] = useState(null);
  const [loading,setLoading] = useState(false);


useEffect(() =>{
  // async를 사용하는 함수 따로 선언
  const fatchData = async ()=> {
      setLoading(true);
      try {
          const response = await axios.get(
              'http://localhost:9003/homestays/price/1'
          );
          setContents(response.data.list);
          console.log(response.data.list);
          
      } catch (e) {
          console.log(e);
      }
      setLoading(false);
  };
  fatchData();
}, []); 

if (loading) {
  return <p>대기중....</p>;
}
//articles 값이 설정되지 않았을때
if (!contents) {
return null;
}
// articles 값이 유효할때
//<p>{contents[0].homeStayNum}</p>
return (
<div>
   
    {
    <Grid container spacing={3}>
      <Grid item xs={12}>
        <HouseListSort />
      </Grid>

      {contents.map(content => (
           <Grid item xs={6} sm={4} md={4} key={content}>
             <HouseCard src={content.photoName} title={content.title}
             addr1={content.addr1} price={content.price} countOfReview={content.countOfReview}
             avgOfStar={content.avgOfStar} homeStayNum={content.homeStayNum} />
             
        </Grid>
        
        ))}
      
    </Grid>
    }
    <Pagination />
     </div>
  );
}

export default HouseListFeatured;