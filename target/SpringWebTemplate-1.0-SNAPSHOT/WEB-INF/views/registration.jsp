<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<%--
  Created by IntelliJ IDEA.
  User: trina2
  Date: 5/8/17
  Time: 1:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Please click to register</title>
    <style>
        .error
        {
            color: #ff0000;
            font-weight: bold;
        }
    </style>
</head>
<body>


<div class="container">
    <!-- Example row of columns -->
    <div class="row">
        <div class="col-md-4">
            <h3> Please fill out the form below to register: </h3>
            <h4> *DISCLAIMER* You must live in the United States to register.</h4>

            <form:form name="summary" method="post" action="/confirmation" onsubmit="return validateForm();">

            <%--new stuff--%>
               <form:errors path="*" cssClass="error" />
                <%--<form:form name="summary" method="post" action="/addUser">--%>
            <table align=""> <!--centering table-->
                <tr>
                    <td>First Name:</td>

                    <%--test to do spring validation/client side--%>
                    <td><spring:message code="validName" text="First Name" /></td>
                    <td><form:input path="firstName" /></td>
                    <td><form:errors path="firstName" cssClass="error" /></td>
                    <%--<td><input type="text" name="fName" required></td>--%>
                        <%--required will prompt user to fill something out (name in this case) that they might've missed--%>
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
                    <td>Country:</td>
                        <td><input type="radio" name="country" value="United States" checked>United States</td>

                </tr>
            </table>
        </div>

        <table> <!--reopening table tag for submit button-->
            <tr>

                <td colspan="2">
                    <input type="submit" value="Submit"/>
                </td>
            </tr>
        </table>
        </form:form>


        <script>
//            client side validation requirement
            function validateForm() {

                var zCode = document.forms ["summary"] ["zCode"].value;


//                5 or 9 digit zip code requirement
                if (zCode.length < 5 || zCode.length > 9 || zCode.length === 6 || zCode.length === 7 || zCode.length === 8 ) {
                    alert("Please enter a US Zip Code (5 or 9 digits only)");
                    return false;
                }
                return true;

            }
        </script>
    </div>
</div>
</body>
</html>
