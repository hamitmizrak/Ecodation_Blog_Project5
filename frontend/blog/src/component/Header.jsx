//rcc ==> TAB
//statefull: state var, render var
import React from 'react'
import OtherLanguageReusability from '../internationalization/OtherLanguageReusability'

// Dil secenegi
import { withTranslation } from 'react-i18next';

//Stateless Function
function Header(props) {
    return (
        <>
            <React.Fragment>
                <nav className="navbar navbar-expand-sm navbar-dark bg-dark">
                    <div className="container">
                        <a className="navbar-brand" href="#"><i className={props.logo}></i></a>
                        <button className="navbar-toggler d-lg-none" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavId" aria-controls="collapsibleNavId"
                            aria-expanded="false" aria-label="Toggle navigation">
                            <span className="navbar-toggler-icon"></span>
                        </button>
                        <div className="collapse navbar-collapse" id="collapsibleNavId">
                            <ul className="navbar-nav me-auto mt-2 mt-lg-0">
                                <li className="nav-item">
                                    <a className="nav-link active" href="#" aria-current="page">{props.menu1} <span className="visually-hidden">{props.current}</span></a>
                                </li>
                                <li className="nav-item">
                                    <a className="nav-link" href="#">{props.menu3}</a>
                                </li>

                                <li className="nav-item dropdown">
                                    <a className="nav-link dropdown-toggle" href="#" id="dropdownId" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">{props.t('register_login')}</a>
                                    <div className="dropdown-menu" aria-labelledby="dropdownId">
                                        <a className="dropdown-item" href="#">{props.menu2}</a>
                                        <a className="dropdown-item" href="#">{props.t('login')}</a>
                                    </div>
                                </li>

                                <li className="nav-item dropdown">
                                    {/* i18n addedd */}
                                    <OtherLanguageReusability />
                                </li>

                            </ul>
                            <form className="d-flex my-2 my-lg-0">
                                <button className="btn btn-outline-success my-2 my-sm-0" type="submit">{props.t('search')}</button>
                            </form>
                        </div>
                    </div>
                </nav>
            </React.Fragment>
        </>
    ) //end return
} //end class

// export default UserRegister
//  Higher Order Component: monad componenti başka bir componentin içine  ekleyip oradanda yeni sonuclar elde etmek
export default withTranslation()(Header)

//defaultProps
//defaultProps NOT: default function ve/veya class adıyla aynı olması gerekiyor.
Header.defaultProps = {
    current:"Current"
}

//propTypes
//Header: Type belirlemek
// Header.propTypes={
//     current:propTypes.string.isRequired
// }