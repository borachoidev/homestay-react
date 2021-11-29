import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import './Pagination.css';



const Pagination = ({postsPerPage, totalPosts, paginate}) => {
  //const classes = useStyles();
  const pageNumbers = [];
  for (let i = 1; i <= Math.ceil(totalPosts / postsPerPage); i++) {
    pageNumbers.push(i);
  }

  return (
    <div>
    <div class="center">
      <div class="pagination">
        {pageNumbers.map(number => (
          <a class="items" key={number}>
            <a onClick={() => paginate(number)} >
              {number}
            </a>
          </a>
        ))}
      </div>
    </div>
  </div>
);
};


export default Pagination;
