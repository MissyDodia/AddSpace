<%@page import="in.co.adspace.bean.PaymentBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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