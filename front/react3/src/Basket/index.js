import * as React from 'react';

import Box from '@mui/material/Box';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import DeleteIcon from '@mui/icons-material/Delete';
import Button from '@mui/material/Button';
import axios from 'axios';
const fetch1 = require('sync-fetch');



export default function Basket() {

  let price = 0;
  const data = fetch1('http://localhost:8080/cart', {
    headers: {
      Accept: 'application/json'
    }
  }).json()
  data.forEach(item => price = price + item.price * item.amount);
  return (
    <>
      <h3>Ostoskori käyttäjälle N. N.</h3>
      {data.map((tier) => (
        <fieldset>            <Card sx={{ display: 'flex' }}>
          <Box sx={{ display: 'flex', flexDirection: 'column' }}>
            <CardContent sx={{ flex: '1 0 auto' }}>

              <image src={tier.url}></image>
              <p><b> product Title  {tier.title}</b></p>
              <p> Kpl  {tier.amount}</p>
              <p> hinta   {tier.price}</p>
              <Button variant="contained" color="error" onClick={() => {


                axios.post('http://localhost:8080/cart', { "id": tier.id, "name": "" }).then(function (response) {

                });

              
                window.location.reload(false);
              }

              }
              ><DeleteIcon size="small" /> poista</Button>

            </CardContent>
            <Box sx={{ display: 'flex', alignItems: 'center', pl: 1, pb: 1 }}>

            </Box>
          </Box>
          <CardMedia
            component="img"
            sx={{ width: 101, height: 101 }}
            image={tier.url}
            alt=""
          />
        </Card>
        </fieldset>



      ))}
      <p>Ostokori yhteensä  <b>{(price + 0.005).toFixed(2)}</b> euroa</p>
      <Button variant="contained" color="success" onClick={() => {
              axios.post('http://localhost:8080/logout');
        alert('Tuotteet tilattu');
        axios.post('http://localhost:8080/order');

      }}>Tilaa</Button>
    </>

  );
}