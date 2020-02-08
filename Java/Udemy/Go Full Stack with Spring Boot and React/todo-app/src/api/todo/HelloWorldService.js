import Axios from "axios";

class HelloWorldService {

    executeHelloWorldService() {
        return Axios.get('http://localhost:8080/hello-world');
    }

    executeHelloWorldBeanService() {
        return Axios.get('http://localhost:8080/hello-world-bean');
    }

    executeHelloWorldPathVariableService(name) {
        // let username = 'dvt32';
        // let password = '1234';
        // let basicAuthHeader = "Basic " + window.btoa(username + ":" + password);
        
        return Axios.get(
            `http://localhost:8080/hello-world/path-variable/${name}`
            // , {
            //     headers: {
            //         authorization: basicAuthHeader
            //     }
            // }
        );
    }

}

export default new HelloWorldService();