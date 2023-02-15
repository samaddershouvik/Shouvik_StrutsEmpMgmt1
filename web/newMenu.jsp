<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
    <head>
        <title>Employee Management</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <meta name="theme-color" content="#712cf9">

        <!-- Custom styles for this template -->
        <link href="css/header.css" rel="stylesheet">
        <!--<link href="css/carousel.css" rel="stylesheet">-->
    </head>
    <header class="sticky-top p-3 text-bg-dark">
        <div class="container">
            <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                    <img src="images/flower-logo.jpg" width="75" height="75"></img>
                </a>

                <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                    <li><button class="btn btn-link px-2 text-white" id="land" onclick="fetchContent('land', 'landing')">Home</button></li>
                    <li><button class="btn btn-link px-2 text-white" id="insertEmp" onclick="fetchContent('insertEmp', 'landing')">Add Employee</button></li>
                    <!--<li><a class="nav-link px-2 text-white" href="Home">Show Employee</a></li>-->
                    <li><button class="btn btn-link px-2 text-white" id="showEmp" onclick="fetchContent('showEmp', 'landing')">Show Employee</button></li>
                    <li><button class="btn btn-link px-2 text-white" id="searchEmp" onclick="fetchContent('searchEmp', 'landing')">Search Employee</button></li>
                    <li><a class="nav-link px-2 text-white" href="API">API Request</a></li>
                </ul>

                <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search">
                    <input type="search" class="form-control form-control-dark text-bg-dark" placeholder="Search..." aria-label="Search">
                </form>

                <div class="text-end">
                    <% if (request.getSession().getAttribute("Loggedin") == null) {%>

                    <a href="login.jsp">
                        <button type="button" class="btn btn-outline-light me-2" >Login</button>
                    </a>
                    <a href="PreSignup">
                        <button type="button" class="btn btn-warning">Sign-up</button>
                    </a>
                    <%
                        }
                    else {%>

                    <a href="logout.jsp">
                        <button type="button" class="btn btn-outline-light me-2" >Log Out</button>
                    </a>
                    <%
                        }
                    %>


                </div>
            </div>
        </div>
    </header>