import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';

//i18n adında ==> i18nlanguage.js eklendi
import './internationalization/i18nlanguage'

//ROOT
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <React.Fragment>
      <App />
    </React.Fragment>
  </React.StrictMode>
); //end render


reportWebVitals();
