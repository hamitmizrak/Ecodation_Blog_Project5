import axios from "axios";
const REGISTER_URL="/register/list"

//CLASS
class RegisterApiServices{
    getAllRegister(){
        return axios.get(REGISTER_URL);
    }

}

export default new RegisterApiServices();