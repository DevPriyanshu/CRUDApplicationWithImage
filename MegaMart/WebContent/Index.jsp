<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="Css/MartStyle.css">
    <title>Mega_Mart!</title>
  </head>
  <h1>Add Product</h1>
  <body>
  
<form class="mega" method="post" action="insert" enctype="multipart/form-data">
  <div class="form-group">
 
  <div class="form-group">
  <label>Enter Product Name</label>
    <input type="text" class="form-control" id="exampleInputEmail1" name="name" placeholder="Product_Name">
  </div>
  
  <div class="form-group">
  <label>Enter Product Description</label>
       <input type="text" class="form-control" id="exampleInputPassword1" name="desc" placeholder="Product_Description">
  </div>
  
  <div class="form-group">
   <label>Upload Product Image</label>
    <input type="file" class="form-control" id="exampleInputEmail1" name="image" placeholder="Product_Image">
  </div>
  
  <div class="form-group">
  <label>Enter Product Prize</label>
    <input type="type" class="form-control" id="exampleInputPassword1" name="prize" placeholder="Product_Prize">
  </div>
  <p>${requestScope['msg']}</p>
  <button type="submit" class="btn btn-primary">Submit</button>
  
</form>

 <table class="table">
  <thead>
    <tr>
   	  	 <th scope="col">Product_Id</th>
      <th scope="col">Product_Name</th>
      <th scope="col">Product_Description</th>
      <th scope="col">Product_Image</th>
      <th scope="col">Product_Prize</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
   <jsp:useBean id="pro" class="Bean.Method"></jsp:useBean>
   <c:forEach items="${pro.ShowAllProduct()}" var="p">
    <tr>
      <th>${p.getProduct_Id() }</th>
      <th>${p.getProduct_Name()}</th>
      <td>${p.getProduct_Description()}</td>
      <td><img src="${p.getProduct_Image()}" style="width:100px;height:100px;"></td>
      <td>${p.getProduct_Prize()}</td>
    <td>
      <a href="Update.jsp?Product_Id=${p.getProduct_Id()}" class="btn btn-primary">
      			Edit
      </a>
      <a href="del?Product_Id=${p.getProduct_Id()}" class="btn btn-danger">
      			Delete
      </a>
      </td>
      </tr>
  </tbody>
  </c:forEach> 

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>