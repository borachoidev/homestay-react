import React from 'react';
import IconButton from '@material-ui/core/IconButton';

import AddIcon from '@material-ui/icons/Add';
import RemoveIcon from '@material-ui/icons/Remove';

function AddPerson(props) {
  return (
    <div>
      <IconButton color="primary" aria-label="remove" component="span">
        <RemoveIcon />
      </IconButton>
      <IconButton color="primary" aria-label="add" component="span">
        <AddIcon />
      </IconButton>
    </div>
  );
}

export default AddPerson;
