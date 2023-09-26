import axios from "axios";

const RESR_API_BASE_URL = 'http://localhost:8080/api/employee/all'

export const listEmployees = () => axios.get(RESR_API_BASE_URL);

