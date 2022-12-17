
import './App.css';
import ListRegister from './component/blog/ListRegister'
import Header from './component/Header';
import Footer from './component/Footer';
import {BrowserRouter as Router,Route,Switch } from 'react-router-dom';
import UpdateRegister from './component/blog/UpdateRegister';
import DetailPageRegister from './component/blog/DetailPageRegister';

function App() {
  return (
    <>
      <Router>
        <Header logo="fa-brands fa-react" menu1="About" menu2="Register" menu3="Contact" />
        <div className="container">
          <Switch>
            <Route path="/" exact component={ListRegister}></Route>
            <Route path="/register"  component={ListRegister}></Route>
            <Route path="/register-add/:id"  component={UpdateRegister}></Route>
            <Route path="/register-view/:id"  component={DetailPageRegister}></Route>
          </Switch>
        </div>
        <Footer special="@Copy; Bütün Haklar Saklıdır" />
      </Router>
    </>
  );
}

export default App;
