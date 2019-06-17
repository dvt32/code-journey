import axios from 'axios'
import Auth from './Auth'

class Api {
  constructor () {
    this.instance = axios.create({
      baseURL: process.env.REACT_APP_API_URL
    })
    this.instance.defaults.headers.post['Content-Type'] = 'application/json'
  }

  setInterseptor (props) {
    this.instance.defaults.headers.common['Authorization'] = 'Bearer ' +
      Auth.getToken()
    this.instance.interceptors.response.use(
      (response) => response,
      (error) => {
        Auth.removeToken()
        // Do something with response error
        props.history.push('/')
        return Promise.reject(error)
      })
    return this
  }

  async login (data) {
    const res = this.instance.post('/oauth/token',
      data,
      {
        auth: {
          username: 'admin',
          password: 'admin'
        },
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded'
        }
      })
    return res
  }

  async fetchTopics () {
    let res = await this.instance.get('/topics/')
    return res
  }

  async postTopic (topic) {
    let res = await this.instance.post('/replies/reply-with-topic', topic)
    return res
  }

  async fetchTopicById (topicId) {
    let res = await this.instance.get(`/topics/id/${topicId}/`)
    return res
  }

  async fetchRepliesByTopicId (topicId) {
    let res = await this.instance.get(`/replies/id/${topicId}/`)
    return res
  }

  async createReply (reply) {
    let res = await this.instance.post(`/replies/`, reply)
    return res
  }

  async getNumberOfUsers() {
    let res = await this.instance.get('/users')
    return res
  }

  async getListOfModerators() {
    let res = await this.instance.get('/users/mods')
    return res
  }

  async getListOfAdmins() {
    let res = await this.instance.get('/users/admins')
    return res
  }

  async getTopThreeMostRepliedToTopics() {
    let res = await this.instance.get('/topics/top-3-most-replied-to')
    return res
  }

  async getTopThreeMostViewedTopics() {
    let res = await this.instance.get('/topics/top-3-most-viewed')
    return res
  }

  async getTopThreeMostRepliedToTopicsInRange(startDateString, endDateString) {
    let res = await this.instance.get('/topics/top-3-most-replied-to?startDate=' + startDateString + "&endDate=" + endDateString);
    return res
  }

  async getTopThreeMostViewedTopicsInRange(startDateString, endDateString) {
    let res = await this.instance.get('/topics/top-3-most-viewed?startDate=' + startDateString + "&endDate=" + endDateString);
    return res
  }

}

export default new Api()
