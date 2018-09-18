<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Customer</title>
 <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>


<%@ include file="header.jsp" %>

<div class="card m-5">
    <div class="card-header">
        Edit Customer Details
    </div>
    <div class="m-3">
        <form class="row m-2" action="editprofile.do" method="post">
            <div class="col-md-4 form-group">
                <label for="exampleInputEmail1">Customer ID</label>
                <input type="number" name="custId" value="${sessionScope.customer.customerId}" readonly class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Account ID">
            </div>
            <div class="col-md-4 form-group">
                <label for="exampleInputEmail1">Name*</label>
                <input type="text" name="custName" required value="${sessionScope.customer.customerName}" class="form-control" id="exampleInputEmail81" aria-describedby="emailHelp" placeholder="Name">
            </div>
            <div class="col-md-4 form-group">
                <label for="exampleInputEmail1">DOB</label>
                <input type="date" name="custDOB" required readonly value="${sessionScope.customer.dateOfBirth}" class="form-control" id="exampleInputsEmai8l1" aria-describedby="emailHelp" placeholder="Date of Birth">
            </div>
            <div class="col-md-4 form-group">
                <label for="exampleInputEmail1">Email*</label>
                <input type="email" name="custEmail" required value="${sessionScope.customer.email}" class="form-control" id="examxpleInputEmai8l1" aria-describedby="emailHelp" placeholder="Email">
            </div>
            <div class="col-md-4 form-group">
                <label for="exampleInputEmail1">Address*</label>
                <input type="text" name="custAddress" required value="${sessionScope.customer.address}" class="form-control" id="exampleInputEmai8l1" aria-describedby="emailHelp" placeholder="Address">
                <br>
                <button type="submit" class="btn btn-primary btn-block">Edit Profile</button><br>
                <c:if test="${requestScope.success == false}">
                    <div class="alert alert-danger" role="alert">
						<b>Customer not found!!!!</b>
					</div>
					</c:if>
					<c:if test="${requestScope.success == true}">
                    <div class="alert alert-success" role="alert">
						<b>Done editing</b>
					</div>
					</c:if>
                * - Mandatory fields
            </div>
        </form>
    </div>
</div>





<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>