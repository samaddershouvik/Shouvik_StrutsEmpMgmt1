<%-- 
    Document   : insertemployee
    Created on : Jan 27, 2023, 9:31:02 AM
    Author     : Admin
--%>


<%@page import="com.exavalu.services.RoleService"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.exavalu.services.DepartmentService"%>
<%@page import="com.exavalu.services.EmployeeService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var='user' value='${Loggedin}'/>
    <c:if test = "${user == null}">  
        <c:redirect url = "login.jsp"/>
    </c:if>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inset Employee</title>
        <link href="css/menu_css.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/product.css" rel="stylesheet">
        <link href="css/insertemp.css" rel="stylesheet">
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
        <div class="alert alert-danger" role="alert">
            ${InsertError}
        </div>
        <div class="container register-form">  
            <form action="InsertEmployee" style="color: white">
                
                <div class="form">  
                <div class="note">  
                    <h1> Registration of new Employee. </h1>  
                </div>  
                <div class="form-content">  
                    <div class="row">  
                        <div class="col-md-6">  
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Name *" name="name" required pattern="[A-Za-z\s]{1,20}" title="Name must be in range a-z and A-Z"/>  
                            </div>
                        </div>              
                        <div class="col-md-6">  
                            <div class="form-group">  
                                <input type="text" class="form-control" placeholder="Phone Number *" name="phone" required pattern="[0-9]{10,10}" title="10 digit phone number required"/>  
                            </div>
                            <p></p>
                            <div class="form-group">
                                <a><label style="font-size: 20px">Age:</label></a>
                                <input type="number" style="padding: 6px; border-radius: 15px" required name="age" min="18" max="100">
                            </div>  
                        </div>  
                    </div>  
                    <div class="row align-items-center mt-4">  
                        <div class="col" style="font-size: 20px">
                            <a>Gender:  </a>
                            <input type="radio" required name="gender" value="male"/>
                            <label>Male</label>
                            <input type="radio" name="gender" value="female"/>
                            <label>Female</label>
                        </div>  
                    </div>
                    <div class="row align-items-center mt-4">  
                        <div class="col">
                            <label style="font-size: 20px">Address *</label>
                            <input type="text" class="form-control" name="address" required>  
                        </div>  
                    </div>
                    
                    <div class="row align-items-center mt-4">  
                        <div class="col">
                            <label style="font-size: 20px">Department *</label>
                            <select name="departmentId" class="form-select" style="width: 250px" required>
                                <option value="">None</option>
                                <c:forEach var="dept" items="${DeptList}">
                                    <option value="${dept.getDepartmentId()}">${dept.getDepartmentName()}</option>
                                </c:forEach>
                            </select> 
                        </div>  
                    </div>
                    
                    <div class="row align-items-center mt-4">  
                        <div class="col">
                            <label style="font-size: 20px">Role *</label>
                            <select name="roleId" class="form-select" style="width: 250px" required>
                                <option value="">None</option>
                                <c:forEach var="role" items="${RoleList}">
                                    <option value="${role.getRoleId()}">${role.getRoleName()}</option>
                                </c:forEach>
                            </select> 
                        </div>  
                    </div>
                    
                    <div class="row align-items-center mt-4">  
                        <div class="col">
                            <label style="font-size: 20px">Basic Salary *</label>
                            <input type="number" class="form-control" name="basicSalary" style="width: 250px" required>  
                        </div>  
                    </div>
                    <div class="row align-items-center mt-4">  
                        <div class="col">
                            <label style="font-size: 20px">Car Allowance *</label>
                            <input type="number" class="form-control" name="carAllaowance" style="width: 250px" required>  
                        </div>  
                    </div>
                    
                    <div class="row justify-content-start mt-4">  
                        <div class="col">  
                            <div class="form-check">  
                                <label class="form-check-label">  
                                    <input type="checkbox" class="form-check-input">  
                                    I hereby agree to the <a href="#"> Terms and Conditions. </a>  
                                </label>  
                            </div>  
                            <button type="submit" class="btnSubmit"> Submit </button>
                        </div>  
                    </div>  
                </div>
                </div>
            </form
        </div>
    </body>
</html>
