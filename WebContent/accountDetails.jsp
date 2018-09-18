<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accounts </title>
 <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>

<%@ include file="header.jsp" %>



<div class="row m-0">
    <div class="col-md-6 mt-5 ml-1 mr-0 mb-5">
        <div class="card">
            <div class="card-header">
                Customer Details
            </div>
            <div class="m-0">
                <table class="table table-bordered m-0">
                    <thead>
                    <tr>
                        <th scope="col">Customer ID</th>
                        <th scope="col">Name</th>
                        <th scope="col">DOB</th>
                        <th scope="col">Email</th>
                        <th scope="col">Address</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th scope="row">${sessionScope.customer.customerId }</th>
                        <td>${sessionScope.customer.customerName }</td>
                        <td>${sessionScope.customer.dateOfBirth }</td>
                        <td style="font-size: 14px">${sessionScope.customer.email }</td>
                        <td style="font-size: 14px">${sessionScope.customer.address }</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div><br>
        <div class="card">
            <div class="card-header">
                Account Details
            </div>
            <div class="m-0">
                <table class="table table-bordered m-0">
                    <thead>
                    <tr>
                        <th scope="col">Account ID</th>
                        <th scope="col">Account Type</th>
                        <th scope="col">Balance</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th scope="row">${sessionScope.customer.account.accountId}</th>
                        <td>${sessionScope.customer.account.accountType}</td>
                        <td>${sessionScope.customer.account.balance}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="col-md-5 mt-5 ml-0" hidden>
        <div class="card">
            <div class="card-header">
                Transaction Details
            </div>
            <div class="m-0">
                <table class="table table-bordered m-0">
                    <thead>
                    <tr>
                        <th scope="col">Description & Date</th>
                        <th scope="col">Credit</th>
                        <th scope="col">Debit</th>
                        <th scope="col">Balance</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td scope="row">Nasjadsakjdkasksakhjkasfkdha sauh dushau 30 May 1256</td>
                        <td>1255</td>
                        <td></td>
                        <td>1254445455598</td>
                    </tr>
                    <tr>
                        <td scope="row">Ndsnjdsvasjkdha sauh dushau</td>
                        <td></td>
                        <td>4554</td>
                        <td>125556565598</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>




<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>