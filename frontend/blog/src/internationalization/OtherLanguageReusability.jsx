//rcc==> React Class Component(State olan)
//rfc==<React Function Component(State olmayan)
//rsf==> React Stateless Component(State olmayan)

//for react libraries
import React from 'react'
import OtherLanguageServices from './OtherLanguageServices';

//Dil seçeneği (language chooise)
import { withTranslation } from 'react-i18next';

//FUNCTION
function OtherLanguageReusability(props) {

    //Flag (Bayrak)
    const internationalizationLanguage = language => {
        //destructing
        //function olduğu için this.props demiyoruz.
        const { i18n } = props;
        i18n.changeLanguage(language);

        //Service calling
        OtherLanguageServices.httpHeaderLanguageServices(language);
    } //end internationalizationLanguage

    //RETURN
    return (
        <>
            <a className="nav-link dropdown-toggle" href="#" id="dropdownIdRegister" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Diller</a>
            <div className="dropdown-menu" aria-labelledby="dropdownIdRegister">
                <a className="dropdown-item" href="#" onClick={() => internationalizationLanguage('tr')}>TR</a>
                <a className="dropdown-item" href="#" onClick={() => internationalizationLanguage('en')}>EN</a>
            </div>
        </>
    )
} // end function OtherLanguageReusability

//export default Register 
//Higher Order Component: monad component(Başka bir componetin içine ekleyip oradan sonuçlar almak)
export default withTranslation()(OtherLanguageReusability);
