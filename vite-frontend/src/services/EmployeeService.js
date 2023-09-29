import axios from "axios";
import { getToken } from "./AuthServices";

const REST_API_BASE_URL = 'http://localhost:8080/api/employee/all'


// Add a request interceptor
axios.interceptors.request.use(function (config) {
  config.headers['Authorization'] = getToken();

  return config;
}, function (error) {
  // Do something with request error
  return Promise.reject(error);
});

export const listEmployees = () => axios.get(REST_API_BASE_URL);

