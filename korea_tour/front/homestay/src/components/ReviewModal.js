import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './HouseDetailCss/Review.css';
import './HouseDetailCss/ReviewList.css';
import ReviewPhotos from './ReviewPhotos';
import { URL } from '_utils/api';
import { useParams } from 'react-router-dom';
import store from '_store/Store';
import Button from '@material-ui/core/Button';


function ReviewModal({ history }) {
    const [content, setContent] = useState(null);
    const [loading,setLoading] = useState(false);
    const [error, setError] = useState(null);

    const goGo = () => {
        window.location.href=window.location.href;
    };
    let { houseNum } = useParams();

    const postUrl = `${URL}/${houseNum}/insertanswerofreview`;

    const userNum = store.getState().userReducer.num;
    console.log("유저넘은??"+userNum);
    const userName = store.getState().userReducer.name;
    console.log("유저Name??"+userName);
    const userAvatar = store.getState().userReducer.avatar;
    console.log("유저Avatar??"+userAvatar);
    useEffect( () => {
        const getReviews = async () => {
            try {
                setContent(null);
                setError(null);
                setLoading(true);
                const response = await axios.get(
                    `${URL}/${houseNum}/allreview`
                );
                setContent(response.data.reviews);
                
            } catch(e) {
                setError(e);
            }
            setLoading(false);
        };
        getReviews();
    }, []);

    if (error) return <p>에러가 발생했습니다.!!</p>;
    if (!content) return null;

    console.log(content);
    
    // for(let i=0; i<content.length; i++){
    //     console.log(content[i].relevel)
    // }

    return (
        <>
        <div id="reviewModal__box">
            {
                content.map((i)=>{
                    return (
                       <div className="modalReviewBox">
                           
                            {i.relevel==0?
                            <div key={i.homeStayReviewNum} className="modal__review-box">
                                <div className="review-writer-box">
                                    <div className="profile-box">
                                        <div className="profile-img"><img src={i.loginPhoto}/></div>
                                        <div className="writer-writeday">
                                            <p><b>{i.loginId}</b></p>
                                            <span className="guest-writeday">{i.writeday}</span>
                                            
                                        </div>
                                    </div>

                                    <div className="room-img"><ReviewPhotos reviewNum={i.homeStayReviewNum}/></div> 
                                    
                                </div>
                                
                                <div className="review-text-box">
                                    {i.content} 
                                </div>
                                {i.dap==0&&i.userNum==userNum?
                                    <div className="create-reanswer">
                                        <form action={postUrl} method="POST" target="iframe1">
                                            <input type="text" name="content" className="reanswer-box" required placeholder="답글 작성란"/>
                                            <input type="hidden" name="userNum" value={userNum} />
                                            <input type="hidden" name="homeStayNum" value={houseNum} />
                                            <input type="hidden" name="regroup" value={i.regroup} />
                                            <input type="hidden" name="loginNum" value={userNum} />
                                            <input type="hidden" name="loginId" value={userName} />
                                            <input type="hidden" name="loginPhoto" value={userAvatar} />
                                            <Button type="submit" variant="contained" onClick={()=>{ alert("답글 작성 완료!!"); goGo() }}>답글달기</Button>
                                            <iframe id="iframe1" name="iframe1" ></iframe>
                                        </form>
                                    </div>
                                :null}
                            </div>
                                        :
                                        i.relevel==1?
                                        <div className="modal__review-box-relevel">
                                            <div className="review-writer-box">
                                                <div className="profile-box">
                                                    <div className="profile-img"><img src={i.loginPhoto}/></div>
                                                    <div className="writer-writeday">
                                                        <p><b>{i.loginId}</b></p>
                                                        <span className="host-writeday">{i.writeday}</span>
                                                        
                                                    </div>
                                                </div>
                                            </div>
                                            <div className="review-text-box">
                                                {i.content} 
                                            </div>
                                        </div>
                                        :null}

                        </div>
                        
                        )
                    }


                )
            }
            
        </div>
        
        </>
    );
}

export default ReviewModal;