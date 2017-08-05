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
</head>
<body>


<div class="container">
    <!-- Example row of columns -->
    <div class="row">
        <div class="col-md-4">
            <h3> Please fill out the form below to register: </h3>
            <h4> *DISCLAIMER* You must live in the United States to register.</h4>

            <form:form name="summary" method="post" action="/confirmation" onsubmit="return validateForm();">

                <%--<form:form name="summary" method="post" action="/addUser">--%>
            <table align=""> <!--centering table-->
                <tr>
                    <td>First Name:</td>
                    <td><input type="text" name="fName" required></td>
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
                    <td>Country:</td>
                        <td><input type="radio" name="country" value="United States" checked>United States</td>
                    <%--<td><input type="text" name="country" value="US" required></td>--%>
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
            function validateForm() {

//            var fName = document.forms ["summary"] ["fName"].value;
//            var lName = document.forms ["summary"] ["lName"].value;
//            var add1 = document.forms ["summary"] ["add1"].value;
//            var add2 = document.forms ["summary"] ["add2"].value;
//            var city = document.forms ["summary"] ["city"].value;
//            var state = document.forms ["summary"] ["state"].value;
                var zCode = document.forms ["summary"] ["zCode"].value;
//                var country = document.forms ["summary"] ["country"].value;

//                validation for US zcode only
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
