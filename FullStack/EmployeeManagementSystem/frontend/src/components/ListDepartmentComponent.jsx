import React, { useEffect, useState } from "react";
import {
  deleteDepartment,
  listDepartments,
} from "../services/DepartmentService";
import { useNavigate } from "react-router-dom";

const ListDepartmentComponent = () => {
  const navigate = useNavigate();
  const [departments, setDepartments] = useState([]);
  const [searchTerm, setSearchTerm] = useState("");

  const [pagination, setPagination] = useState({
    page: 0,
    size: 10,
    totalPages: 0,
    sortBy: "id",
    sortDir: "asc",
  });

  useEffect(() => {
    getAllDepartments(pagination.page);
  }, [pagination.page]);

  function paginate(pageNumber) {
    setPagination({
      ...pagination,
      page: pageNumber,
    });
  }

  function getAllDepartments(page = 1) {
    listDepartments(
      page,
      pagination.size,
      pagination.sortBy,
      pagination.sortDir
    )
      .then((response) => {
        setDepartments(response.data.content);
        setPagination({
          ...pagination,
          size: response.data.size,
          totalPages: response.data.totalPages,
          sortBy: response.data.sortBy,
          sortDir: response.data.sortDir,
        });
      })
      .catch((error) => {
        console.error(error);
      });
  }

  function addDepartment() {
    navigate("/add-department");
  }

  function updateDepartment(id) {
    navigate(`/edit-department/${id}`);
  }

  function removeDepartment(id) {
    deleteDepartment(id)
      .then((response) => {
        getAllDepartments();
      })
      .catch((error) => {
        console.error(error);
      });
  }

  const filteredDepartments = departments.filter((department) =>
    department.departmentName.toLowerCase().includes(searchTerm.toLowerCase())
  );

  return (
    <div className="container">
      <h2 className="text-center p-2 m-0">List of Departments</h2>
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
          onClick={addDepartment}
        >
          Add Department
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

      <table className="table table-striped table-bordered">
        <thead>
          <tr>
            <th className="col-id">Id</th>
            <th className="col-name">Name</th>
            <th className="col-description">Description</th>
            <th className="col-actions">Actions</th>
          </tr>
        </thead>
        <tbody>
          {filteredDepartments.map((department) => (
            <tr key={department.id}>
              <td>{department.id}</td>
              <td>{department.departmentName}</td>
              <td>{department.departmentDescription}</td>
              <td>
                <button
                  className="btn btn-info"
                  onClick={() => updateDepartment(department.id)}
                >
                  Update
                </button>
                <button
                  className="btn btn-danger"
                  onClick={() => removeDepartment(department.id)}
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

export default ListDepartmentComponent;
