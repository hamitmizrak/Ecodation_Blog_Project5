
import './App.css';
import ListRegister from './component/blog/ListRegister'
import Header from './component/Header';
import Footer from './component/Footer';
import {BrowserRouter as Router,Route,Switch } from 'react-router-dom';
import CreateOrUpdateRegister from './component/blog/CreateOrUpdateRegister';
import DetailPageRegister from './component/blog/DetailPageRegister';

import './internationalization/i18n'

function App() {
  return (
    <>
      <Router>
        <Header logo="fa-brands fa-react" menu1="About" menu2="Register" menu3="Contact" />
        <div className="container">
          <Switch>
            <Route path="/" exact component={ListRegister}></Route>
            <Route path="/register"  component={ListRegister}></Route>
            <Route path="/register_add/:id"  component={CreateOrUpdateRegister}></Route>
            <Route path="/register_view/:id"  component={DetailPageRegister}></Route>
            {/* <Route component={NotFound}/> */}
          </Switch>
        </div>
        <Footer special="@Copy; Bütün Haklar Saklıdır" />
      </Router>
    </>
  );
}

export default App;
