import axios from "axios";

const EMPLOYEE_API_BASE_URL = "http://localhost:8080/api/employees";

export const listEmployees = (page, size, sortBy, sortDir) =>
  axios.get(
    EMPLOYEE_API_BASE_URL +
      "?page=" +
      page +
      "&size=" +
      size +
      "&sortBy=" +
      sortBy +
      "&sortDir=" +
      sortDir
  );

export const createEmployee = (employee) =>
  axios.post(EMPLOYEE_API_BASE_URL, employee);

export const getEmployeeById = (employeeId) =>
  axios.get(EMPLOYEE_API_BASE_URL + "/" + employeeId);

export const updateEmployee = (employeeId, employee) =>
  axios.put(EMPLOYEE_API_BASE_URL + "/" + employeeId, employee);

export const deleteEmployee = (employeeId) =>
  axios.delete(EMPLOYEE_API_BASE_URL + "/" + employeeId);
