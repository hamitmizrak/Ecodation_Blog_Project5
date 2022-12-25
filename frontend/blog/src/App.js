
import './App.css';
import ListRegister from './component/blog/ListRegister'
import Header from './component/Header';
import Footer from './component/Footer';
import {BrowserRouter as Router,Route,Switch } from 'react-router-dom';
import CreateOrUpdateRegister from './component/blog/CreateOrUpdateRegister';
import DetailPageRegister from './component/blog/DetailPageRegister';

import './internationalization/i18nlanguage.js'

// Dil secenegi
import { withTranslation } from 'react-i18next';

function App(props) {
  return (
    <>
      <Router> 
        <Header logo="fa-brands fa-react" menu1={props.t('about')} menu2={props.t('register')} menu3={props.t('contact')} />
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

// export default 
//  Higher Order Component: monad componenti başka bir componentin içine  ekleyip oradanda yeni sonuclar elde etmek
export default withTranslation()(App)
