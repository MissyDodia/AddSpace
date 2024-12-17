<%@page import="in.co.adspace.bean.SpaceBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Booking</title>
    <link rel="stylesheet" href="css/signup.css">
        <link rel="stylesheet" href="css/booking.css">
        
    

</head>
<body>
<%@include file="/jsp/Header.jsp" %>
<%
String book = (String)request.getAttribute("book");
String err = (String)request.getAttribute("err");

%>
<div class="container" style="width: 480px; margin-left: 35em;">
 
 <h1>Booking Space</h1>
    <form class="max-w-md mx-auto" action="BookSpaceCtl" method="post" >
    
    <font style="color: green;"><%=(book != null)?book:"" %></font>
<font style="color: red;"><%=(err !=null)?err:"" %>
</font>
       
       
        <% SpaceBean sbean = (SpaceBean) request.getAttribute("sbean");
        UserBean userbean = (UserBean) session.getAttribute("userbean");
        %>
<div style="height: 0px;">
			   <input class="id" size="50" type="hidden" name="spaceid" value="<%= (sbean != null && sbean.getId() > 0) ? sbean.getId() : "" %>"><br><br>
<input class="id" size="50" type="hidden" name="price" value="<%= (sbean != null && sbean.getPrice() != null) ? sbean.getPrice() : "" %>"><br><br>
    </div>      
        <div class="relative z-0 w-full mb-5 group">
            <input type="text" name="spacename" id="floating_spacename" class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-white dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" placeholder=" " value="<%= (sbean != null && sbean.getSpacename() != null) ? sbean.getSpacename() : "" %>" />
            <label for="floating_spacename" class="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:start-0 rtl:peer-focus:translate-x-1/4 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6">Space Name</label>
        </div>

        <div class="relative z-0 w-full mb-5 group">
            <input type="text" name="location" id="floating_location" class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-white dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" placeholder=" " value="<%= (sbean != null && sbean.getLocation() != null) ? sbean.getLocation() : "" %>" />
            <label for="floating_location" class="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:start-0 rtl:peer-focus:translate-x-1/4 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6">Location</label>
        </div>

    
        <div class="relative z-0 w-full mb-5 group">
            <input type="text" name="type" id="floating_type" class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-white dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" placeholder=" " required />
            <label for="floating_type" class="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:start-0 rtl:peer-focus:translate-x-1/4 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6">Type(Why need)</label>
        </div>

 <div class="relative z-0 w-full mb-5 group">
            <input type="text" name="email" id="floating_type" class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-white dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" placeholder=" " value="<%=userbean.getEmail()%>" />
            <label for="floating_type" class="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:start-0 rtl:peer-focus:translate-x-1/4 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6">email</label>
        </div>
 <div class="relative z-0 w-full mb-5 group">
            <input type="tel" name="phone" id="floating_type" class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-white dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" placeholder=" " value="<%=userbean.getPhone()%>" />
            <label for="floating_type" class="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:start-0 rtl:peer-focus:translate-x-1/4 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6">Contact.no.</label>
        </div>
        <%
    String companyValue = (sbean != null && sbean.getCompany() != null) ? sbean.getCompany() : "";
%>

<div class="relative z-0 w-full mb-5 group">
    <input type="text" name="company" id="floating_company" class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-white dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" placeholder=" " value="<%= companyValue %>" />
    <label for="floating_company" class="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:start-0 rtl:peer-focus:translate-x-1/4 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6">Company</label>
</div>

        <!-- ... (previous code) ... -->

<div class="grid md:grid-cols-2 md:gap-6">
    <div class="relative z-0 w-full mb-5 group">
        <label for="fromDate">From Date</label>
        <input datepicker type="text" name="fromDate" id="fromDate" class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-white dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" placeholder="Select From Date" required />
    </div>
    <div class="relative z-0 w-full mb-5 group">
        <label for="toDate">To Date</label>
        <input datepicker type="text" name="toDate" id="toDate" class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-white dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" placeholder="Select To Date" required />
    </div>
</div>

<script>
    // Concatenate "from" and "to" dates before form submission
    document.getElementById("yourFormId").addEventListener("submit", function() {
        var fromDate = document.getElementById("fromDate").value;
        var toDate = document.getElementById("toDate").value;
        var concatenatedDates = fromDate + " to " + toDate;
        document.getElementById("duration").value = concatenatedDates;
    });
</script>

<!-- ... (remaining code) ... -->

       

        <button type="submit" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">Book-space</button>
    </form>
</div>

<%@include file="/jsp/Footer.jsp" %>
 
</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/2.2.1/flowbite.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
<script src="../path/to/flowbite/dist/datepicker.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/2.2.1/datepicker.min.js"></script>








</html>