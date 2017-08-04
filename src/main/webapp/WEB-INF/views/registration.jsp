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
<!--ref to variable name/modelName in HomeController. will bring back "Hello World", our string-->
<%--${hello}--%>


<div class="container">
<!-- Example row of columns -->
<div class="row">
<div class="col-md-4">
<h3>Please fill out the form below to register: </h3>
<form:form name="summary" method="post" action="/addUser" onsubmit="return validateForm();">

    <%--<form:form name="summary" method="post" action="/addUser">--%>
    <table align=""> <!--centering table-->
    <tr>
    <td>First Name:</td>
    <td><input type="text" name="fName" required></td><%--required will prompt user to fill something out (name in this case) that they might've missed--%>
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
    <td><input type="text" name="add2" required></td>
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
    <td><input type="text" name="country" required></td>
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
        function validateForm () {

            var fName = document.forms ["summary"] ["fName"].value;
            var lName = document.forms ["summary"] ["lName"].value;
            var add1 = document.forms ["summary"] ["add1"].value;
            var add2 = document.forms ["summary"] ["add2"].value;
            var city = document.forms ["summary"] ["city"].value;
            var state = document.forms ["summary"] ["state"].value;
            var zCode = document.forms ["summary"] ["zCode"].value;
            var country = document.forms ["summary"] ["country"].value;

            if (fName.length < 2
                || lName.length < 2
                || add1.length < 2
                || add2.length < 2
                || city.length < 2
                || state.length < 2
                || zCode.length < 2
                || country.length < 2) {
                alert("Input must be longer than 2 characters.");
                return false;
            }


            return true; //return true if passwords match, characters more than 2
        }
    </script>
</div>
</div>
</body>
</html>
