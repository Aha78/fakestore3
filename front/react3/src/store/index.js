
import React from 'react';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import AppBar from '@mui/material/AppBar';
import Button from '@mui/material/Button';
import Card from '@mui/material/Card';
import { useState } from 'react';

import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import CardHeader from '@mui/material/CardHeader';
import CssBaseline from '@mui/material/CssBaseline';
import Grid from '@mui/material/Grid';

import Typography from '@mui/material/Typography';
import GlobalStyles from '@mui/material/GlobalStyles';
import Container from '@mui/material/Container';
import Pagination from '@mui/material/Pagination';
import Stack from '@mui/material/Stack';
import AddShoppingCartIcon from '@mui/icons-material/AddShoppingCart';
import EuroIcon from '@mui/icons-material/Euro';
import Popup from 'reactjs-popup';
import { Link } from 'react-router-dom';


import axios from 'axios';

const fetch = require('sync-fetch');






const defaultTheme = createTheme();





export default function Store() {
    const [page, setPage] = useState(0);


    const data = fetch('http://localhost:8080/products?page=' + page + '&size=3', {
        headers: {
            Accept: 'application/json'
        }
    }).json()


    return (

        <ThemeProvider theme={defaultTheme}>
            <GlobalStyles styles={{ ul: { margin: 0, padding: 0, listStyle: 'none' } }} />
            <CssBaseline />
            <AppBar
                position="static"
                color="default"
                elevation={0}
                sx={{ borderBottom: (theme) => `1px solid ${theme.palette.divider}` }}
            >
                <em> Fakestore  <a href="/Basket" ><AddShoppingCartIcon />Näytä ostoskori</a> </em>
                 <em> Fakestore  <a href="/logout"  >roskakori </a></em>

                 
            </AppBar>

            <Container disableGutters maxWidth="sm" component="main" sx={{ pt: 8, pb: 6 }}>

                <Typography variant="h3" align="center" color="text.secondary" component="p">
                    Fakestore api
                </Typography>
            </Container>
            {/* End hero unit */}
            <Container maxWidth="md" component="main">

                <Pagination
                    page={page}
                    count={Math.trunc(20 / 3 - 1)}
                    onChange={(event, pageNumber) => setPage(pageNumber)}

                />
                <Grid container spacing={2} alignItems="flex-end">
                    {data.map((tier) => (

                        <Grid
                            item

                            xs={12}

                            md={4}
                        >
                            <Card style={{ overflow: 'scroll', maxHeight: '380px' }}>
                                <CardHeader> {tier.title}

                                </CardHeader>
                                <CardActions>
                                    <Button onClick={
                                        function addToBasket(e) {

                                            axios.put('http://localhost:8080/cart',
                                            {

                                                "user": "",
                                                "title": tier.title,
                                                "price": tier.price,
                                                "amount": 1,
                                                "url": tier.image
                                            }

                                            )

                                        alert("Basket=" + tier.id)
                                    }}><AddShoppingCartIcon /></Button>
                                    <Popup style={{ width: '1000px' }} trigger={<button> lisätietoja</button>} position="right center">
                                        <div >
                                            <h5>{tier.title}</h5>
                                            <img src={tier.image} height="100px" width="100px" alt="" />
                                            <p>  {tier.price} <EuroIcon /></p>
                                            <p>   {tier.description}</p>

                                        </div>
                                    </Popup>
                                </CardActions>
                                <CardContent>
                                    <img src={tier.image} height="50px" width="50px" alt="" />
                                    <p style={{ width: '500px' }}> {tier.title}</p>
                                    <Typography align="left" color="text.secondary" component="p">

                                        <p>  {tier.price} <EuroIcon /></p>
                                        <p></p>
                                    </Typography>

                                </CardContent>

                            </Card>

                        </Grid>
                    ))}
                </Grid>

                <Stack spacing={2}>


                </Stack>
            </Container>


            {/* End footer */}
        </ThemeProvider>
    );
}
<footer>Antto</footer>

