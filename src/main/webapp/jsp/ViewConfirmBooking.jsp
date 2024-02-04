<%@page import="java.util.List"%>
<%@page import="in.co.adspace.bean.BookingBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>confirmbooking</title>
</head>
<body>
<body>
<%@include file="/jsp/Header.jsp" %>

<div class="relative overflow-x-auto shadow-md sm:rounded-lg">
<%
    
    List<BookingBean> list = (List<BookingBean>)request.getAttribute("list");
    String success = (String) request.getAttribute("success");
    String confirm = (String) request.getAttribute("confirm");
    String noncon = (String) request.getAttribute("noncon");
    String cancle = (String) request.getAttribute("cancle");
    String noncan = (String) request.getAttribute("noncan");



    
%>
<div style="text-align: center;">
<font style="color: green; text-align: center;"><%=(success !=null)?success:"" %></font>
<font style="color: green; text-align: center;"><%=(confirm !=null)?confirm:"" %></font>

<font style="color: green; text-align: center;"><%=(noncon !=null)?noncon:"" %></font>
<font style="color: green; text-align: center;"><%=(cancle !=null)?cancle:"" %></font>
<font style="color: green; text-align: center;"><%=(noncan !=null)?noncan:"" %></font>
</div>
    <table class="w-full text-sm text-left rtl:text-right text-gray-500 dark:text-gray-400 mx-">
        <thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
            <tr>
                <th scope="col" class="px-6 py-3">space name</th>
                <th scope="col" class="px-6 py-3">Location</th>
                <th scope="col" class="px-6 py-3">Type</th>
                <th scope="col" class="px-6 py-3">Email</th>
                <th scope="col" class="px-6 py-3">Contact No.</th>
                <th scope="col" class="px-6 py-3">Company</th>
                <th scope="col" class="px-6 py-3">Duration</th>
                <th scope="col" class="px-6 py-3">Price</th>
               
            </tr>
        </thead>
        <tbody>
        <% if (list != null && !list.isEmpty()) { %>
            <% for (BookingBean booking : list) { %>
                <tr class="bg-white border-b dark:bg-gray-800 dark:border-gray-700 hover:bg-gray-50 dark:hover:bg-gray-600">
                    <th scope="row" class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                        <%= booking.getSpacename() %> 
                    </th>
                    <td class="px-6 py-4">
                        <%= booking.getLocation() %> 
                    </td>
                    <td class="px-6 py-4">
                        <%= booking.getType() %> 
                    </td>
                    <td class="px-6 py-4">
                        <%= booking.getEmail() %> 
                    </td>
                    <td class="px-6 py-4">
                        <%= booking.getContactno() %> 
                    </td>
                    <td class="px-6 py-4">
                        <%= booking.getCompany() %> 
                    </td>
                    <td class="px-6 py-4">
                        <%= booking.getDuration() %> 
                    </td>
                    <td class="px-6 py-4">
                        <%= booking.getPrice() %> 
                    </td>
                  
                </tr>
            <% } %>
        <% } else { %>
            <tr>
                <td colspan="9" class="text-center">No records found</td>
            </tr>
        <% } %>
        </tbody>
    </table>
</div>
<%@include file="/jsp/Footer.jsp" %>
</body>
</body>
</html>