 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<%@page import="Bean.Method"%>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<link rel="Stylesheet" href="Css/MartStyle.css">
    <title>Update MegaMart!</title>
  </head>
  <body>
    <p>Manipulate Product!</p>
	<%
	  int Prod_id=Integer.parseInt(request.getParameter("Product_Id"));
	   out.println(Prod_id);
		Method m=new Method();
		m.setProduct_Id(Prod_id);
		Method pinfo=m.getProduct();
	%>
<form class="mega" method="post" action="edit">
<div class="form-group">
    <label for="exampleInputEmail1">Product_Id</label>
    <input type="text" class="form-control"  name="prodId" value="<%=Prod_id %>" readonly="readonly">
  </div>
  
  <div class="form-group">
    <label for="exampleInputEmail1">Product_Name</label>
    <input type="text" class="form-control" id="proname" name="prodname" >
  </div>
  
  <div class="form-group">
    <label for="exampleInputEmail1">Product_Description</label>
    <input type="text" class="form-control" id="prodesc" name="produdes" >
  
  <div class="form-group">
    <label for="exampleInputEmail1">Product_Image</label>
    <input type="file" class="form-control" id="profile" name="prodfile" >
  </div>
  
   <div class="form-group">
    <label for="exampleInputEmail1">Product_Prize</label>
    <input type="text" class="form-control" id="propr" name="prodprize">
  </div>
  
   
  <button type="submit" class="btn btn-primary">Submit</button>
  
  <label>${requestScope['msg']}</label>
</form>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>