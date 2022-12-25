import axios from "axios";


//Language
class OtherLanguageServices {

    //language Flag button
    headerLanguageServices(language) {
        //postman Accept-Language:tr
        //postman Accept-Language:en
        axios.defaults.headers['accept-language'] = language;
    }
}

export default new OtherLanguageServices()