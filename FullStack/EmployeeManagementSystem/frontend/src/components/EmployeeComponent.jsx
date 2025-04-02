import React, { useState, useEffect } from "react";
import {
  createEmployee,
  getEmployeeById,
  updateEmployee,
} from "../services/EmployeeService";
import axios from "axios";
import { useNavigate, useParams } from "react-router-dom";

const EmployeeComponent = () => {
  const { id } = useParams();
  const navigate = useNavigate();
  const [departments, setDepartments] = useState([]);

  const [employee, setEmployee] = useState({
    firstName: "",
    lastName: "",
    email: "",
    departmentName: "",
    project: "",
  });

  const [errors, setErrors] = useState({
    firstName: "",
    lastName: "",
    email: "",
    departmentName: "",
    project: "",
  });

  useEffect(() => {
    fetchDepartments();

    if (id) {
      getEmployeeById(id)
        .then((response) => {
          setEmployee({
            firstName: response.data.firstName,
            lastName: response.data.lastName,
            email: response.data.email,
            departmentName: response.data.departmentName,
            project: response.data.project,
          });
        })
        .catch((error) => {
          console.error(error);
        });
    }
  }, [id]);

  const fetchDepartments = async () => {
    try {
      const response = await axios.get(
        "http://localhost:8080/api/departments?page=0&size=1000"
      );
      setDepartments(response.data.content);
    } catch (error) {
      console.error("Error fetching departments:", error);
    }
  };

  function saveOrUpdateEmployee(e) {
    e.preventDefault();

    if (validateForm()) {
      const employeeCopy = { ...employee };

      if (id) {
        updateEmployee(id, employeeCopy)
          .then((response) => {
            navigate("/employees");
          })
          .catch((error) => {
            if (error.response && error.response.status === 400) {
              setErrors({
                ...errors,
                email: error.response.data,
              });
            } else {
              console.error(error);
            }
          });
      } else {
        createEmployee(employeeCopy)
          .then((response) => {
            navigate("/employees");
          })
          .catch((error) => {
            if (error.response && error.response.status === 400) {
              setErrors({
                ...errors,
                email: error.response.data,
              });
            } else {
              console.error(error);
            }
          });
      }
    }
  }

  function validateForm() {
    let valid = true;

    const errorsCopy = { ...errors };

    if (employee.firstName.trim()) {
      errorsCopy.firstName = "";
    } else {
      errorsCopy.firstName = "First name is required";
      valid = false;
    }

    if (employee.lastName.trim()) {
      errorsCopy.lastName = "";
    } else {
      errorsCopy.lastName = "Last name is required";
      valid = false;
    }

    if (employee.email.trim()) {
      errorsCopy.email = "";
    } else {
      errorsCopy.email = "Email is required";
      valid = false;
    }

    if (employee.departmentName.trim()) {
      errorsCopy.departmentName = "";
    } else {
      errorsCopy.departmentName = "Department is required";
      valid = false;
    }

    setErrors(errorsCopy);

    return valid;
  }

  function pageTitle() {
    if (id) {
      return <h2 className="text-center p-3 m-0">Update Employee</h2>;
    } else {
      return <h2 className="text-center p-3 m-0">Add Employee</h2>;
    }
  }
  return (
    <div className="container">
      <div className="row">
        <div className="card col-md-6 offset-md-3 offset-md-3">
          {pageTitle()}
          <div className="card-body">
            <form>
              <div className="form-group mb-2">
                <label className="form-label">First Name:</label>
                <input
                  type="text"
                  placeholder="Enter Employee First Name"
                  name="firstName"
                  value={employee.firstName}
                  className={`form-control ${
                    errors.firstName ? "is-invalid" : ""
                  }`}
                  onChange={(e) =>
                    setEmployee({
                      ...employee,
                      firstName: e.target.value,
                    })
                  }
                ></input>
                {errors.firstName && (
                  <div className="invalid-feedback"> {errors.firstName} </div>
                )}
              </div>

              <div className="form-group mb-2">
                <label className="form-label">Last Name:</label>
                <input
                  type="text"
                  placeholder="Enter Employee Last Name"
                  name="lastName"
                  value={employee.lastName}
                  className={`form-control ${
                    errors.lastName ? "is-invalid" : ""
                  }`}
                  onChange={(e) =>
                    setEmployee({
                      ...employee,
                      lastName: e.target.value,
                    })
                  }
                ></input>
                {errors.lastName && (
                  <div className="invalid-feedback"> {errors.lastName} </div>
                )}
              </div>

              <div className="form-group mb-2">
                <label className="form-label">Email:</label>
                <input
                  type="text"
                  placeholder="Enter Employee Email"
                  name="email"
                  value={employee.email}
                  className={`form-control ${errors.email ? "is-invalid" : ""}`}
                  onChange={(e) =>
                    setEmployee({
                      ...employee,
                      email: e.target.value,
                    })
                  }
                ></input>
                {errors.email && (
                  <div className="invalid-feedback"> {errors.email} </div>
                )}
              </div>

              <div className="form-group mb-2">
                <label className="form-label">Department:</label>
                <select
                  name="department"
                  value={employee.departmentName}
                  className={`form-control ${
                    errors.departmentName ? "is-invalid" : ""
                  }`}
                  onChange={(e) =>
                    setEmployee({
                      ...employee,
                      departmentName: e.target.value,
                    })
                  }
                >
                  <option value="">Select Department</option>
                  {departments.map((department) => (
                    <option
                      key={department.id}
                      value={department.departmentName}
                    >
                      {department.departmentName}
                    </option>
                  ))}
                </select>
                {errors.departmentName && (
                  <div className="invalid-feedback">
                    {" "}
                    {errors.departmentName}{" "}
                  </div>
                )}
              </div>

              <div className="form-group mb-2">
                <label className="form-label">Project:</label>
                <input
                  type="text"
                  placeholder="Enter Employee Project"
                  name="project"
                  value={employee.project}
                  className="form-control"
                  onChange={(e) =>
                    setEmployee({
                      ...employee,
                      project: e.target.value,
                    })
                  }
                ></input>
              </div>

              <button
                className="btn btn-success"
                onClick={saveOrUpdateEmployee}
              >
                Submit
              </button>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};

export default EmployeeComponent;
