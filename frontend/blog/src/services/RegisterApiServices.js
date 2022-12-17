import axios from "axios";
const REGISTER_URL = "/register"

//CLASS
class RegisterApiServices {

    //LIST
    getAllRegister() {
        return axios.get(REGISTER_URL + "/list");
    }

    //FIND
    getRegisterById(id) {
        return axios.get(REGISTER_URL + "/" + id);
    }

    //CREATE
    createRegister(registerDto) {
        return axios.post(REGISTER_URL, registerDto);
    }

    //UPDATE
    updateRegister(id,registerDto) {
        return axios.put(REGISTER_URL + "/" + id, registerDto);
    }

    //DELETE
    deleteRegister(id) {
        return axios.delete(`${REGISTER_URL}/${id}`);
    }

}

export default new RegisterApiServices();