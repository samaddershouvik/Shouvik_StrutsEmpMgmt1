
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">        
        <title>Employee Management</title>      
        <link href="css/bootstrap.min.css" rel="stylesheet" >
        
        <!-- Custom styles for this template -->
        <link href="css/menu_css.css" rel="stylesheet">
        <link href="css/product.css" rel="stylesheet">
        <link href="css/signin.css" rel="stylesheet">
    </head>
    <body class="text-center bg-dark">
        
        <jsp:include page="menu.jsp"></jsp:include>
        
        <main class="form-signin w-100 m-auto">

            <form action="SaveEmployee" method="Post">

            <c:set var="emp" value="${Emp}"/>

                <img class="mb-4" src="https://media.licdn.com/dms/image/C560BAQE3Ty3P2DurNw/company-logo_200_200/0/1647870000891?e=2147483647&v=beta&t=Dv0eGi-fum00vHvCb3XAtTX1Tu5_jwnOwk7Jof59Vdo" alt="" width="72" height="57">
                <h1 class="h3 mb-3 fw-normal">Please edit employee data</h1>
                <div class="form-floating">
                    <input type="text" class="form-control" placeholder="first name" name="employeeId" value="${emp.getEmployeeId()}" readonly>
                    <label for="floatingInput">Employee Id</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="name@example.com" name="name" value="${emp.getName()}" >
                    <label for="floatingInput">Name</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" placeholder="name@example.com" name="address" value="${emp.getAddress()} ">
                    <label for="floatingInput">Address</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" placeholder="name@example.com" name="phone" value="${emp.getPhone()}" >
                    <label for="floatingInput">Phone Number</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" placeholder="name@example.com" name="gender" value="${emp.getGender()}" >
                    <label for="floatingInput">Gender</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" placeholder="name@example.com" name="age" value="${emp.getAge()}" >
                    <label for="floatingInput">Age</label>
                </div>
                <div class="form-floating">
                    <select name="departmentId" class="form-select" id="departmentId">
                        <option value="${emp.getDepartmentId()}"  hidden>${emp.getDepartmentName()}</option>
                        <c:forEach var="dept" items="${DeptList}">
                            <option value="${dept.getDepartmentId()}">${dept.getDepartmentName()}</option>
                        </c:forEach>
                    </select>
                    <label for="floatingInput">Department Name</label>
                </div>
                <div class="form-floating">
                    <select name="roleId" class="form-select" id="roleId">
                        <option value=${emp.getRoleId()} hidden>${emp.getRoleName()}</option>
                        <c:forEach var="role" items="${RoleList}">
                            <option value="${role.getRoleId()}">${role.getRoleName()}</option>
                        </c:forEach>
                    </select>
                    <label for="floatingInput">Role Name</label>
                </div>
                <p></p>
                <div class="form-floating">
                    <input type="text" class="form-control" placeholder="name@example.com" name="basicSalary" value="${emp.getBasicSalary()}">
                    <label for="floatingInput">Basic Salary</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" placeholder="name@example.com" name="carAllaowance" value="${emp.getCarAllaowance()}">
                    <label for="floatingInput">Car Allowance</label>
                </div>
                <p>
                    <input type="hidden" >
                </p>
                <button class="w-100 btn btn-lg btn-primary" type="submit">Save</button>
                <p class="mt-5 mb-3 text-muted">&copy; 2017–2022</p>
            </form>
        </main>
    </body>
</html>
