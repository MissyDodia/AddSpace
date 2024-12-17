<%@page import="in.co.adspace.bean.BookingBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payment</title>
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
 <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>
<%@ include file="/jsp/Header.jsp" %>
<div class="max-w-sm mx-auto mt-20 bg-white rounded-md shadow-md overflow-hidden">
    <div class="px-6 py-4 bg-gray-900 text-white">
     <% 
            String succ = (String)request.getAttribute("success");
            String err = (String)request.getAttribute("err");
            BookingBean bookbean = (BookingBean)request.getAttribute("bookbean"); // Use correct attribute name
        %>
        <h1 class="text-lg font-bold">Credit Card</h1>
        <font style="color: green; "><%=(succ !=null)?succ:"" %></font>
                <font style="color: red; "><%=(err !=null)?err:"" %></font>
        
    </div>
    <form action="PaymentCtl" method="post">
    <div class="px-6 py-4">

        <div class="mb-4">
            <label class="block text-gray-700 font-bold mb-2" for="card-number">
                Card Number
            </label>
            <input
                class="appearance-none border border-gray-400 rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
               name="card-number" id="card-number" type="text" placeholder="" required>
        </div>

        <div class="mb-4">
            <label class="block text-gray-700 font-bold mb-2" for="expiration-date">
                Expiration Date
            </label>
            <input
                class="appearance-none border border-gray-400 rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                name="expiration-date" type="text" placeholder="MM/YY" required>
        </div>

        <div class="mb-4">
            <label class="block text-gray-700 font-bold mb-2" for="cvv">
                CVV
            </label>
            <input
                class="appearance-none border border-gray-400 rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                name="cvv" type="number" placeholder="" required>
        </div>
        

        <div class="mb-4">
            <label class="block text-gray-700 font-bold mb-2" for="cardholder-name">
                Cardholder Name
            </label>
            <input
                class="appearance-none border border-gray-400 rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
               name ="cardholder-name" type="text" placeholder="Full Name" required>
        </div>
       <div class="mb-4">
    <label class="block text-gray-700 font-bold mb-2" for="price">
        Price
    </label>
    <% if (bookbean != null) { %>
        <input class="appearance-none border border-gray-400 rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
            name="price" value="<%= bookbean.getPrice() %>" type="num">
    
</div>


            <input class="appearance-none border border-gray-400 rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                name="spacename" value="<%= bookbean.getSpacename() %>" type="hidden">
                 <input class="appearance-none border border-gray-400 rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                name="bookingid" value="<%= bookbean.getId() %>" type="hidden">
           <% } else { %>
       
    <% } %> 
            <button class="bg-blue-500 hover:bg-blue-600 text-white font-bold py-2 px-4 rounded-full">
                Pay Now
            </button>
    </div>
    </form>
</div>
</div>
<footer>
<%@ include file="/jsp/Footer.jsp" %>
</footer>
</body>
</html>