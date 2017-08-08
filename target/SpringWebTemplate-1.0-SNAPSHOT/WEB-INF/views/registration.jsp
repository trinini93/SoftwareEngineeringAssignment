<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<%--
  Created by IntelliJ IDEA.
  Programmer: Trina Chowdhury
  Date: 5/8/17
  Time: 1:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Please click to register</title>

</head>
<body>

<center>
<div class="container">
    <div class="row">
        <div class="col-md-4">
            <h3> Please fill out the form below to register: </h3>

            <form:form name="summary" method="post" action="/confirmation" onsubmit="return validateForm();">

            <table align=""> <!--centering table-->

                <tr>
                    <td>First Name:</td>

                    <td><input type="text" name="fName" required></td>

                </tr>
                <tr>
                    <td>Last Name:</td>
                    <td><input type="text" name="lName" required></td>
                </tr>
                <tr>
                    <td>Address 1:</td>
                    <td><input type="text" name="add1" required></td>
                </tr>
                <tr>
                    <td>Address 2:</td>
                    <td><input type="text" name="add2"></td>
                </tr>

                <td>City:</td>
                <td><input type="text" name="city" required></td>
                </tr>
                <tr>
                    <td>State:</td>
                    <td><input type="text" name="state" required></td>
                </tr>

                <td>Zip Code:</td>
                <td><input type="text" name="zCode" required></td>
                </tr>
                <tr>
                        <%--US only requirement--%>
                    <td>Country (US only):</td>
                    <td><input type="radio" name="country" value="United States" checked>United States</td>

                </tr>
            </table>
        </div>
        <table>
            <tr>

                <td colspan="2">
                    <input type="submit" value="Submit"/>
                </td>
            </tr>
        </table>
        </form:form>

        <p>Other Options</p>

        <a href ="/adminreport">View Admin Report</a>
        ||
        <a href ="/programmerinfo">Programmer Info</a>

        <script>
            // client side validation requirement
            function validateForm() {

                var zCode = document.forms ["summary"] ["zCode"].value;

//                5 or 9 digit zip code requirement
                if (zCode.length < 5 || zCode.length > 9 || zCode.length === 6 || zCode.length === 7 || zCode.length === 8) {
                    alert("Please enter a US Zip Code (5 or 9 digits only)");
                    return false;
                }
                return true;

            }
        </script>
    </div>
</div>
</center>
</body>
</html>
