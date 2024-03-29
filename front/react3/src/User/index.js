import * as React from 'react';
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import { useState } from 'react';
import axios from 'axios';

export default function UserAuth() {

  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const onUserChangeLocation = (event) => {
    setUsername(event.target.value)
  }
  const onPasswordChangeLocation = (event) => {
    setPassword(event.target.value)
  }

  return (
    <div>
      <Box
        component="form"
        sx={{
          '& > :not(style)': { m: 1, width: '25ch' },
        }}
        noValidate
        autoComplete="off"
      >

        <Grid><TextField id="outlined-basic" onChange={onUserChangeLocation} label="username" variant="outlined" /></Grid>

        <Grid> <TextField id="outlined-basic" onChange={onPasswordChangeLocation} label="password" variant="outlined" /></Grid>

        <Button variant="contained" color="success" onClick={() => {


      axios.put('http://localhost:8080/user',{"username": username,"password": password,"role": "ROLE_USER","enabled": 1});


          alert('clicked=' + username + " " + password);
     
        }


        }>Rekisteröi</Button>
      </Box>

    </div>
  );
}