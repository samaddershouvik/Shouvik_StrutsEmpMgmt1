
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var='user' value='${Loggedin}'/>
    <c:if test = "${user == null}">  
        <c:redirect url = "login.jsp"/>
    </c:if>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Hugo 0.108.0">
        <title>Product example Â· Bootstrap v5.3</title>

        <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/product/">

        <!-- Favicons -->
        <link rel="apple-touch-icon" href="/docs/5.3/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
        <link rel="icon" href="/docs/5.3/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
        <link rel="icon" href="/docs/5.3/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
        <link rel="manifest" href="/docs/5.3/assets/img/favicons/manifest.json">
        <link rel="mask-icon" href="/docs/5.3/assets/img/favicons/safari-pinned-tab.svg" color="#712cf9">
        <link rel="icon" href="/docs/5.3/assets/img/favicons/favicon.ico">
        <meta name="theme-color" content="#712cf9">
        
        <link href="css/menu_css.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="css/product.css" rel="stylesheet">
        
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.2.0/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="https://cdn.datatables.net/1.13.1/css/dataTables.bootstrap5.min.css"/>
        <style>
            #example_wrapper{
                width: 100%;
                display: block;
                margin: auto;
            }
        </style>
        
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
        <h2 class="center"><u>Search List</u></h2>
        <form action="Search">
            <table class="table table-bordered table-hover">
            <tr class="table-primary">
                <th>
                    Name
                </th>
                <th>
                    Phone
                </th>
                <th>
                    Gender
                </th>
                <th>
                    Age
                </th>
                <th>
                    Department
                </th>
                <th>
                    Role
                </th>

            </tr>
            <tr>
                <td>
                    <input class="input-group" type="text" name="name">
                </td>
                <td>
                    <input class="input-group" type="text" name="phone">
                </td>
                <td>
                    <select name="gender" class="form-select" id="gender">
                        <option value="" selected>Select Gender</option>
                        <option value="male">Male</option>
                        <option value="female">Female</option>
                    </select>
                </td>
                <td>
                    <input class="input-group" type="text" name="age">
                </td>
                <td>
                    <select name="departmentId" class="form-select" id="departmentId">
                        <option value="" selected>Select department</option>
                        <c:forEach var="dept" items="${DeptList}">
                            <option value="${dept.getDepartmentId()}">${dept.getDepartmentName()}</option>
                        </c:forEach>
                    </select>
                </td>
                <td>
                    <select name="roleId" class="form-select" id="roleId">
                        <option value="" selected>Select Role</option>
                        <c:forEach var="role" items="${RoleList}">
                            <option value="${role.getRoleId()}">${role.getRoleName()}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            </table>
                    <p class="text-center">
                        <button class="btn btn-lg btn-primary" type="submit">Search</button>
                    </p>
        </form>
        <p></p>
        <table class="table table-bordered table-hover" id="example">
            <thead>
            
            <tr class="table-primary">
                <th>
                    Employee Id
                </th>
                <th>
                    Name
                </th>
                <th>
                    Address
                </th>
                <th>
                    Phone
                </th>
                <th>
                    Gender
                </th>
                <th>
                    Age
                </th>
                <th>
                    Department
                </th>
                <th>
                    Role
                </th>
                <th>
                    Basic Salary
                </th>
                <th>
                    Car Allowance
                </th>
                <th>
                    Action
                </th>
            </tr>
            </thead>
            <c:forEach var="emp" items="${EmpList}">
            <tr>
                <td>
                    ${emp.getEmployeeId()}
                </td>
                <td>
                    ${emp.getName()}
                </td>
                <td>
                    ${emp.getAddress()}
                </td>
                <td>
                    ${emp.getPhone()}
                </td>
                <td>
                    ${emp.getGender()}
                </td>
                <td>
                    ${emp.getAge()}
                </td>
                <td>
                    ${emp.getDepartmentName()}
                </td>
                <td>
                    ${emp.getRoleName()}
                </td>
                <td>
                    ${emp.getBasicSalary()}
                </td>
                <td>
                    ${emp.getCarAllaowance()}
                </td>
                <td> 
                    <a href=EditEmployee?employeeId=${emp.getEmployeeId()}>Edit</a>
                </td>
            </tr>
            </c:forEach>         
        </table> 
         
            <script src="/docs/5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.13.1/js/dataTables.bootstrap5.min.js"></script>
        <script>
            $(document).ready(function () {
                $('#example').DataTable();
            });
        </script>
            
    </body>
</html>
