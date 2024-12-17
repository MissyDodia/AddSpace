<%@page import="in.co.adspace.bean.PaymentBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
 <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<title>Payment list</title>
</head>
<body>
<%@include file="/jsp/Header.jsp" %>

<%
List<PaymentBean> paylist = (List<PaymentBean>)request.getAttribute("paylist");
String err  = (String)request.getAttribute("err");

%>


<table class="w-max	 mx-8 content-around text-sm text-left rtl:text-right text-gray-500 dark:text-gray-400 " style="margin-left: 18em;">
        <thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
            <tr>
                <th scope="col" class="px-6 py-3">CardHolder Name</th>
                <th scope="col" class="px-6 py-3">CardNumber</th>
                <th scope="col" class="px-6 py-3">Cvv</th>
                <th scope="col" class="px-6 py-3">Email</th>
                <th scope="col" class="px-6 py-3">ExpirationDate</th>
                <th scope="col" class="px-6 py-3">SpaceName</th>
                
                <th scope="col" class="px-6 py-3">Price</th>
                
            </tr>
        </thead>
        <tbody>
        <% if (paylist != null && !paylist.isEmpty()) { %>
            <% for (PaymentBean pbean : paylist) { %>
                <tr class="bg-white border-b dark:bg-gray-800 dark:border-gray-700 hover:bg-gray-50 dark:hover:bg-gray-600">
                    <th scope="row" class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                        <%= pbean.getCardholderName() %> 
                    </th>
                    <td class="px-6 py-4">
                        <%= pbean.getCardNumber() %> 
                    </td>
                    <td class="px-6 py-4">
                        <%= pbean.getCvv() %> 
                    </td>
                    <td class="px-6 py-4">
                        <%= pbean.getEmail() %> 
                    </td>
                    <td class="px-6 py-4">
                        <%= pbean.getExpirationDate() %> 
                    </td>
                    <td class="px-6 py-4">
                        <%= pbean.getSpacename() %> 
                    </td>
                    <td class="px-6 py-4">
                        <%= pbean.getPrice() %> 
                    </td>
                    <%}} %>
               </tr>
        </tbody>
    </table>
    </div>
    <footer>
    <%@include file="/jsp/Footer.jsp" %>
    </footer>
</body>
</html>