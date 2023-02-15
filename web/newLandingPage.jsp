<%-- 
    Document   : landingPage
    Created on : 22-Dec-2022, 12:00:33 PM
    Author     : Avijit Chattopadhyay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/header.css" rel="stylesheet">
        <title>Employee Management</title>
    </head>
    <script src="https://code.jquery.com/jquery-3.6.3.js" integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM=" crossorigin="anonymous">
    </script>
    <script>
//        function submitForm()
//        {
//            signupForm.submit();
//        }
        function fetchContent(selectedId, targetId) {
            if(selectedId === 'showEmp')
            {
//                alert(selectedId);
                $.ajax({
                    url: 'Show',
                    data: {
                        [selectedId]: $("#" + selectedId).val()
                    },
                    success: function (responseText) {
    //                    alert(responseText);
                        $("#" + targetId).html(responseText);
                    }
                });
            }
            else if(selectedId === 'land')
            {
//                alert(selectedId);
                $.ajax({
                    url: 'Home2',
                    data: {
                        [selectedId]: $("#" + selectedId).val()
                    },
                    success: function (responseText) {
    //                    alert(responseText);
                        $("#" + targetId).html(responseText);
                    }
                });
            }
            else if(selectedId === 'insertEmp')
            {
//                alert(selectedId);
                $.ajax({
                    url: 'InsertEmployee2',
                    data: {
                        [selectedId]: $("#" + selectedId).val()
                    },
                    success: function (responseText) {
    //                    alert(responseText);
                        $("#" + targetId).html(responseText);
                    }
                });
            }
            else if(selectedId === 'searchEmp')
            {
//                alert(selectedId);
                $.ajax({
                    url: 'Search2',
                    data: {
                        [selectedId]: $("#" + selectedId).val()
                    },
                    success: function (responseText) {
    //                    alert(responseText);
                        $("#" + targetId).html(responseText);
                    }
                });
            }
        }
        function onSubmitButton(event) {
                        event.preventDefault();
                        var form = document.getElementById("myForm");
                        var submitBtn = document.getElementById("submitBtn");
                        var responseDiv = document.getElementById("responseDiv");


                        // Add a click event listener to the submit button
                        //                    submitBtn.addEventListener("click", function (event) {
                        document.getElementById("body").style.display = 'none';
//                        if($("#body").css('display')==='none')
//                            
                        //                    submitBtn.disabled = true;
                        // Prevent the default form submission behavior

                        //                        responseDiv.innerHTML = "";
                        submitBtn.disabled = true;

                        // Create a new XMLHttpRequest object
                        var xhr = new XMLHttpRequest();

                        // Set the request method and URL
                        xhr.open("POST", "Search2", true);

                        // Set the request headers (if needed)
                        //                xhr.setRequestHeader("Content-Type", "application/json");

                        // Set the callback function to handle the response
                        xhr.onreadystatechange = function () {
                            if (xhr.readyState === 4 && xhr.status === 200) {
                                // Do something with the response (if needed)
                                console.log(xhr.responseText);
                                responseDiv.innerHTML = xhr.responseText;
                                submitBtn.disabled = false;
                                //                        document.body.innerHTML = xhr.responseText;
                            }
                        };

                        // Get the form data and send the request
                        var formData = new FormData(form);
                        xhr.send(formData);
                    }
    </script>
    <script src="/docs/5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.13.1/js/dataTables.bootstrap5.min.js"></script>
    <script>
        $(document).ready(function () {
            $('#example').DataTable();
        });
    </script>
    <jsp:include page="newMenu.jsp"></jsp:include>
    <div id="landing">
    <jsp:include page="bodyForLandingPage.jsp"></jsp:include>
    </div>
</html>
