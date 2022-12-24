//axios calling 
import axios from "axios";

// http header language
class OtherLanguageServices {

    //language Flag button calling
    httpHeaderLanguageServices(language){
        //postman Accept-Language:tr
        //postman Accept-Language:en
        axios.defaults.headers['accept-language']=language;
    }

}

export default new OtherLanguageServices();