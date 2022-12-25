//rfc => React Function Component.
//rcc => React Class Component.
//rsc => React Stateles Component (state olmayan).
import React from 'react';

// Dil secenegi => withTranslation
import { withTranslation } from 'react-i18next';

// Dil için ==> OtherLanguageServices
import OtherLanguageServices from "./OtherLanguageServices";

//Funksiyon komponent
function OtherLanguageReusability(props) {

    //Bayraklar
    const internationalizationLanguage = language => {
        const { i18n } = props;
        i18n.changeLanguage(language);

        //Hem java tarafından hemde frontend tarafından değişiklik yaptık.
        OtherLanguageServices.headerLanguageServices(language);
    }

    //render
    return (
        <>
            <a className="nav-link dropdown-toggle" href="#" id="dropdownIdRegister" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Diller</a>
            <div className="dropdown-menu" aria-labelledby="dropdownIdRegister">
                <a className="dropdown-item" href="#" onClick={() => internationalizationLanguage('tr')}>TR</a>
                <a className="dropdown-item" href="#" onClick={() => internationalizationLanguage('en')}>EN</a>
            </div>
        </>
    );
}
// export default UserRegister
//  Higher Order Component: monad componenti başka bir componentin içine  ekleyip oradanda yeni sonuclar elde etmek
export default withTranslation()(OtherLanguageReusability)