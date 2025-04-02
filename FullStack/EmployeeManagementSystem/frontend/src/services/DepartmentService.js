import axios from "axios";

const DEPARTMENT_API_BASE_URL = "http://localhost:8080/api/departments";

export const listDepartments = (page, size, sortBy, sortDir) =>
  axios.get(
    DEPARTMENT_API_BASE_URL +
      "?page=" +
      page +
      "&size=" +
      size +
      "&sortBy=" +
      sortBy +
      "&sortDir=" +
      sortDir
  );

export const createDepartment = (department) =>
  axios.post(DEPARTMENT_API_BASE_URL, department);

export const getDepartmentById = (departmentId) =>
  axios.get(DEPARTMENT_API_BASE_URL + "/" + departmentId);

export const updateDepartment = (departmentId, department) =>
  axios.put(DEPARTMENT_API_BASE_URL + "/" + departmentId, department);

export const deleteDepartment = (departmentId) =>
  axios.delete(DEPARTMENT_API_BASE_URL + "/" + departmentId);

export const getDepartment = () => {
  // ... code của bạn ở đây ...
};
