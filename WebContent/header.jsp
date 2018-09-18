<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>head</title>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent1" aria-controls="navbarSupportedContent1" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent1">
        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS9HIrGt0LaP-dZxOI1dUawb5qRKvP3xEOp_pfrM44AhNf9SlA0kQ" style="width: 90px; height: 70px" >
        <h2>SAFE BANK</h2>
        <marquee>Welcome to safebank net banking... Thank you for choosing us...</marquee>
    </div>
    <div class="d-flex flex-row-reverse">
      
    </div>
</nav>

<c:if test="${sessionScope.customer.customerName == null}">
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <li class="nav-item active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <li class="nav-item">
                <a class="nav-link" href="#">Community</a>
            </li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <li class="nav-item">
                <a class="nav-link" href="#">Personal</a>
            </li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <li class="nav-item">
                <a class="nav-link" href="#">About Us</a>
            </li>
        </ul>
    </div>
</nav>
</c:if>

<c:if test="${sessionScope.customer.customerName != null}">
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <li class="nav-item active">
                <a class="nav-link" href="accountDetails.jsp">Accounts <span class="sr-only">(current)</span></a>
            </li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <li class="nav-item">
                <a class="nav-link" href="fundTransfer.jsp">Fund Transfer</a>
            </li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <li class="nav-item">
                <a class="nav-link" href="editCustomer.jsp">Edit Profile</a>
            </li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <li class="nav-item">
                <a class="nav-link" href="changePassword.jsp">Change Password</a>
            </li>
        </ul>
    </div>
    <div class="d-flex flex-row-reverse">
        <div class="p-2"><a class="btn btn-danger btn-sm" href="logout.do">Logout</a> </div>
        <div class="p-2"><h6 class="p-0 m-1" style="color: white"> Welcome ${sessionScope.customer.customerName}</h6></div>&nbsp;
    </div>
</nav>
</c:if>


</body>
</html>