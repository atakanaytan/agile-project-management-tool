import axios from "axios";

const setJTWTOken = token => {
        if(token){
            axios.defaults.headers.common["Authorization"] = token; 

        } else {
            delete axios.defaults.headers.common["Authorization"];
        }
};

export default setJTWTOken;