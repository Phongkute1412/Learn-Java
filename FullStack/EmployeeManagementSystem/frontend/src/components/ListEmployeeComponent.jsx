import React, { useState, useEffect } from "react";
import { deleteEmployee, listEmployees } from "../services/EmployeeService";
import { useNavigate } from "react-router-dom";

const ListEmployeeComponent = () => {
  const navigate = useNavigate();
  const [employees, setEmployees] = useState([]);
  const [searchTerm, setSearchTerm] = useState("");

  const [pagination, setPagination] = useState({
    page: 0,
    size: 10,
    totalPages: 0,
    sortBy: "id",
    sortDir: "asc",
  });

  useEffect(() => {
    getAllEmployees(pagination.page);
  }, [pagination.page]);

  function paginate(pageNumber) {
    setPagination({
      ...pagination,
      page: pageNumber,
    });
  }

  function getAllEmployees(page = 1) {
    listEmployees(page, pagination.size, pagination.sortBy, pagination.sortDir)
      .then((response) => {
        setEmployees(response.data.content);
        setPagination({
          ...pagination,
          size: response.data.size,
          totalPages: response.data.totalPages,
          sortBy: response.data.sortBy,
          sortDir: response.data.sortDir,
        });
      })
      .catch((error) => {
        console.log(error);
      });
  }

  function addEmployee() {
    navigate("/add-employee");
  }

  function updateEmployee(id) {
    navigate(`/update-employee/${id}`);
  }

  function removeEmployee(id) {
    deleteEmployee(id)
      .then((response) => {
        getAllEmployees();
      })
      .catch((error) => {
        console.log(error);
      });
  }

  const filteredEmployees = employees.filter(
    (employee) =>
      employee.firstName.toLowerCase().includes(searchTerm.toLowerCase()) ||
      employee.lastName.toLowerCase().includes(searchTerm.toLowerCase()) ||
      employee.email.toLowerCase().includes(searchTerm.toLowerCase()) ||
      employee.department.name.toLowerCase().includes(searchTerm.toLowerCase())
  );

  return (
    <div className="container">
      <h2 className="text-center p-2 m-0">List of Employees</h2>
      <div id="search" className="d-flex align-center"></div>
      <div
        style={{
          display: "flex",
          justifyContent: "space-between",
          alignItems: "center",
        }}
      >
        <button
          className="btn mb-2"
          style={{
            backgroundColor: "#5161ce",
            color: "white",
          }}
          onClick={addEmployee}
        >
          Add Employee
        </button>

        <div>
          <input
            className="form-control me-2 mb-2"
            type="search"
            placeholder="Search"
            aria-label="Search"
            value={searchTerm}
            onChange={(e) => setSearchTerm(e.target.value)}
          />
        </div>
      </div>

      <table className="table table-bordered table-striped">
        <thead>
          <tr>
            <th className="col-id">Id</th>
            <th className="col-firstName">First Name</th>
            <th className="col-lastName">Last Name</th>
            <th className="col-email">Email</th>
            <th className="col-department">Department</th>
            <th className="col-project">Project</th>
            <th className="col-actions">Actions</th>
          </tr>
        </thead>
        <tbody>
          {filteredEmployees.map((employee) => (
            <tr key={employee.id}>
              <td>{employee.id}</td>
              <td>{employee.firstName}</td>
              <td>{employee.lastName}</td>
              <td>{employee.email}</td>
              <td>{employee.departmentName}</td>
              <td>{employee.project}</td>
              <td>
                <button
                  className="btn btn-info"
                  onClick={() => updateEmployee(employee.id)}
                >
                  Update
                </button>
                <button
                  className="btn btn-danger"
                  onClick={() => removeEmployee(employee.id)}
                  style={{ marginLeft: "10px" }}
                >
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>

      {pagination.totalPages > 0 && (
        <nav aria-label="..." className="d-flex justify-content-center">
          <ul className="pagination">
            <li
              className={`page-item ${
                pagination.totalPages === 0 || pagination.page === 0
                  ? "disabled"
                  : ""
              }`}
            >
              <a
                className="page-link"
                onClick={() =>
                  pagination.totalPages > 0 && paginate(pagination.page - 1)
                }
              >
                Previous
              </a>
            </li>
            {[...Array(pagination.totalPages)].map((number) => (
              <li
                key={number}
                className={`page-item ${
                  pagination.page === number ? "active" : ""
                }`}
              >
                <a className="page-link" onClick={() => paginate(number)}>
                  {number + 1}
                </a>
              </li>
            ))}
            <li
              className={`page-item ${
                pagination.totalPages === 0 ||
                pagination.page === pagination.totalPages - 1
                  ? "disabled"
                  : ""
              }`}
            >
              <a
                className="page-link"
                onClick={() =>
                  pagination.totalPages > 0 && paginate(pagination.page + 1)
                }
              >
                Next
              </a>
            </li>
          </ul>
        </nav>
      )}
    </div>
  );
};

export default ListEmployeeComponent;
