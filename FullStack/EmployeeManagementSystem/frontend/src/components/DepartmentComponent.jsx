import React, { useState, useEffect } from "react";
import {
  createDepartment,
  getDepartmentById,
  updateDepartment,
} from "../services/DepartmentService";
import { useNavigate, useParams } from "react-router-dom";

const DepartmentComponent = () => {
  const { id } = useParams();
  const navigate = useNavigate();
  const [departmentName, setDepartmentName] = useState("");
  const [departmentDescription, setDepartmentDescription] = useState("");

  const [errors, setErrors] = useState({
    departmentName: "",
    departmentDescription: "",
  });

  useEffect(() => {
    if (id) {
      getDepartmentById(id)
        .then((response) => {
          setDepartmentName(response.data.departmentName);
          setDepartmentDescription(response.data.departmentDescription);
        })
        .catch((error) => {
          console.error(error);
        });
    }
  }, [id]);

  function saveOrUpdateDepartment(e) {
    e.preventDefault();

    if (validateForm()) {
      const Department = { departmentName, departmentDescription };

      if (id) {
        updateDepartment(id, Department)
          .then((response) => {
            navigate("/Departments");
          })
          .catch((error) => {
            console.error(error);
          });
      } else {
        createDepartment(Department)
          .then((response) => {
            navigate("/Departments");
          })
          .catch((error) => {
            console.error(error);
          });
      }
    }
  }

  function validateForm() {
    let valid = true;

    const errorsCopy = { ...errors };

    if (departmentName.trim()) {
      errorsCopy.departmentName = "";
    } else {
      errorsCopy.departmentName = "Department name is required";
      valid = false;
    }

    setErrors(errorsCopy);

    return valid;
  }

  function pageTitle() {
    if (id) {
      return <h2 className="text-center p-3 m-0">Update Department</h2>;
    } else {
      return <h2 className="text-center p-3 m-0">Add Department</h2>;
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
                <label className="form-label">Department Name:</label>
                <input
                  type="text"
                  placeholder="Enter Department Name"
                  name="departmentName"
                  value={departmentName}
                  className={`form-control ${
                    errors.departmentName ? "is-invalid" : ""
                  }`}
                  onChange={(e) => setDepartmentName(e.target.value)}
                ></input>
                {errors.departmentName && (
                  <div className="invalid-feedback">
                    {" "}
                    {errors.departmentName}{" "}
                  </div>
                )}
              </div>

              <div className="form-group mb-2">
                <label className="form-label">Department Description:</label>
                <input
                  type="text"
                  placeholder="Enter Department Description"
                  name="departmentDescription"
                  value={departmentDescription}
                  className="form-control"
                  onChange={(e) => setDepartmentDescription(e.target.value)}
                ></input>
              </div>

              <button
                className="btn btn-success"
                onClick={saveOrUpdateDepartment}
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

export default DepartmentComponent;
