import logo from './logo.svg';
import './App.css';
import Store from './store/'
import Basket from './Basket/'
import UserAuth from './User/'

import {
  BrowserRouter ,
  Route,
  Link,
  Routes

} from "react-router-dom";


function Index ()  {

return (<a href="/store">Siirry fakestoreen</a>)
}


function App() {
  return (

    <BrowserRouter>
    <Routes>

          <Route path="/" element={<Index/>}></Route>
      <Route path="/store" element={<Store/>}></Route>
      <Route path="/basket" element={<Basket/>}></Route>
      <Route path="/user" element={<UserAuth/>}></Route>
    </Routes>
  </BrowserRouter>


  );
}

export default App;
