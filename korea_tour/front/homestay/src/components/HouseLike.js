import React, { useEffect, useState } from 'react';
import axios from 'axios';
import FavoriteIcon from '@material-ui/icons/Favorite';
import FavoriteBorderIcon from '@material-ui/icons/FavoriteBorder';
import store from '_store/Store';
import { URL } from '_utils/api';
import { useParams } from 'react-router-dom';

function HouseLike(props) {

    

  let { houseNum } = useParams();

    const userNum = store.getState().userReducer.num;

    const [likeBtn, setLikeBtn] = useState(0);
    const [loading,setLoading] = useState(false);
    const [error, setError] = useState(null);

    useEffect( () => {
        const getReviews = async () => {
            try {
                setLikeBtn(null);
                setError(null);
                setLoading(true);
                const response = await axios.get(
                    `${URL}/${houseNum}/mark?userNum=${userNum}`
                );
                setLikeBtn(response.data);
            } catch(e) {
                setError(e);
            }
            setLoading(false);
        };
        getReviews();
    }, []);

    console.log("좋아요 체크 "+likeBtn);

    const addLike = async () => {
        try {
          const response = await axios.post(
            `${URL}/mark?homeStayNum=${houseNum}&userNum=${userNum}`
          ).then(res=>{console.log(res)});
    
          
        } catch (e) {
          console.log(e);
        }
      };
    
      const DeleteLike = async () => {
        try {
          const response = await axios.delete(
            `${URL}/mark?homeStayNum=${houseNum}&userNum=${userNum}`
          );
          console.log("삭제성공");
           
        } catch (e) {
          console.log(e);
          
        }
      };

   


    return (
        <div>
            <span>
              { userNum === 0
                ? <span className="favorite" onClick={ ()=>{ alert("로그인을 해주세요!!") } }><FavoriteBorderIcon /></span>
                :
                    likeBtn === 0
                    ? <span className="favorite" onClick={ ()=>{ setLikeBtn(1);addLike();alert("즐겨찾기 추가했습니다!!") } }><FavoriteBorderIcon /></span>
                    : <span className="favorite" onClick={ ()=>{ setLikeBtn(0);DeleteLike();alert("즐겨찾기 삭제했습니다..") } }><FavoriteIcon color="error" /></span>
              }
            </span>
        </div>
    );
}

export default HouseLike;