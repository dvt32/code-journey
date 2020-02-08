import Axios from "axios";
import { JPA_API_URL } from "../../Constants";

class TodoDataService {

    retrieveAllTodos(name) {
        return Axios.get(`${JPA_API_URL}/users/${name}/todos`);
    }

    retrieveTodo(name, id) {
        return Axios.get(`${JPA_API_URL}/users/${name}/todos/${id}`);
    }

    deleteTodo(name, id) {
        return Axios.delete(`${JPA_API_URL}/users/${name}/todos/${id}`);
    }

    updateTodo(name, id, todo) {
        return Axios.put(`${JPA_API_URL}/users/${name}/todos/${id}`, todo);
    }

    createTodo(name, todo) {
        return Axios.post(`${JPA_API_URL}/users/${name}/todos/`, todo);
    }

}

export default new TodoDataService();