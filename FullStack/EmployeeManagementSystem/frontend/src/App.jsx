import { BrowserRouter, Route, Routes } from "react-router-dom";
import { ErrorBoundary } from "react-error-boundary";
import ErrorFallback from "./components/common/ErrorFallback";

import {
  HeaderComponent,
  FooterComponent,
  ListEmployeeComponent,
  EmployeeComponent,
  ListDepartmentComponent,
  DepartmentComponent,
} from "./components";

import "./App.css";

const Layout = ({ children }) => (
  <>
    <HeaderComponent />
    {children}
    <FooterComponent />
  </>
);

const AppRoutes = () => (
  <Routes>
    {/* // http://localhost:3000 */}
    <Route path="/" element={<ListEmployeeComponent />}></Route>

    {/* // http://localhost:3000/employees */}
    <Route path="/employees" element={<ListEmployeeComponent />}></Route>

    {/* // http://localhost:3000/departments */}
    <Route path="/departments" element={<ListDepartmentComponent />}></Route>

    {/* // http://localhost:3000/add-employee */}
    <Route path="/add-employee" element={<EmployeeComponent />}></Route>

    {/* // http://localhost:3000/add-department */}
    <Route path="/add-department" element={<DepartmentComponent />}></Route>

    {/* // http://localhost:3000/edit-employee/1 */}
    <Route path="/edit-employee/:id" element={<EmployeeComponent />}></Route>

    {/* // http://localhost:3000/edit-department/1 */}
    <Route
      path="/edit-department/:id"
      element={<DepartmentComponent />}
    ></Route>
  </Routes>
);

function App() {
  return (
    <ErrorBoundary FallbackComponent={ErrorFallback}>
      <BrowserRouter>
        <Layout>
          <AppRoutes />
        </Layout>
      </BrowserRouter>
    </ErrorBoundary>
  );
}

export default App;
