import React, { useState } from 'react';
import IconButton from '@material-ui/core/IconButton';
import AddIcon from '@material-ui/icons/Add';
import RemoveIcon from '@material-ui/icons/Remove';

function AddPerson(props) {
  const [count, setCount] = useState(0);
  return (
    <div>
      <IconButton
        color="primary"
        aria-label="remove"
        component="span"
        onClick={() => {
          setCount(count == 0 ? 0 : count - 1);
        }}
      >
        <RemoveIcon />
      </IconButton>
      <span>{count}</span>

      <IconButton
        color="primary"
        aria-label="add"
        component="span"
        onClick={() => {
          setCount(count == props.maxValue ? count : count + 1);
        }}
      >
        <AddIcon />
      </IconButton>
    </div>
  );
}

export default AddPerson;
