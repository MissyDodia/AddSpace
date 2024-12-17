<%@page import="java.util.Iterator"%>
<%@page import="in.co.adspace.bean.BookingBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/flowbite/2.2.1/flowbite.min.css"
	rel="stylesheet" />
<link rel="stylesheet" href="css/viewspace.css">
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
 <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>
	<%@include file="/jsp/Header.jsp"%>
	<div class="flex justify-center items-center mt-0">
		<h1 class="text-center font-medium text-gray-500 dark:text-gray-400">Booking
			Details and Status</h1>
	</div>
	<%
    List<BookingBean> bookings = (List<BookingBean>) request.getAttribute("bookings");

    if (bookings != null && !bookings.isEmpty()) {
        Iterator<BookingBean> iterator = bookings.iterator();
        while (iterator.hasNext()) {
            BookingBean booking = iterator.next();
%>


	<div class="flex justify-center items-center mt-0 mb-4">

		<div
			class="w-full max-w-sm p-4 bg-white border border-gray-200 rounded-lg shadow-lg sm:p-8 dark:bg-gray-800 dark:border-gray-700 transition-transform transform hover:scale-105">

			<div class="items-baseline text-gray-900 dark:text-white">
				<strong class="text-2xl font-semibold">Space Name:</strong> <span
					class="text-3xl font-extrabold tracking-tight ml-0"><%= booking.getSpacename() %></span>
			</div>
			<p class="text-sm text-gray-500 dark:text-gray-400 mt-3">
				<strong>Location:</strong>
				<%= booking.getLocation() %><br>
			<hr>
			<strong>Type:</strong>
			<%= booking.getType() %><br>
			<hr>
			<strong>Email:</strong>
			<%= booking.getEmail() %><br>
			<hr>
			<strong>Contact No:</strong>
			<%= booking.getContactno() %><br>
			<hr>
			<strong>Company:</strong>
			<%= booking.getCompany() %><br>
			<hr>
			<strong>Duration:</strong>
			<%= booking.getDuration() %><br>
			<hr>
			<strong>Price:</strong>
			<%= booking.getPrice() %><br>
			<hr>
			<strong>Status:</strong>
			<%= booking.getStatus() %><br>
			<hr>
			<strong>Payment:</strong>
			<%= booking.getPayment() %><br>
			<hr>
			<!-- Add other fields as needed -->
			</p>
			<div class="flex justify-between mt-4">
				<%
                            if ("Confirmed".equals(booking.getStatus())) {
                        %>
				<button type="button"
					class="text-white text-xl bg-blue-600 hover:bg-blue-700 focus:ring-4 focus:outline-none focus:ring-blue-200 dark:focus:ring-blue-900 font-medium rounded-lg text-sm px-5 py-2.5 inline-flex justify-center">
          <%
                                    if ("pay".equals(booking.getPayment())) {
                                %>
					<a href="PaymentCtl?bookingid=<%=booking.getId()%>"
						style="text-decoration: none; color: white;"> Pay Now </a>
						 <%
                                    } else if ("Paid".equals(booking.getPayment())) {
                                %>
                                    <span>Payment Completed</span>
                                <%
                                    }
                                %>

				</button>
				<%
                            } else if ("Cancelled".equals(booking.getStatus())) {
                        %>
				<button type="button"
					class="text-white bg-red-600 hover:bg-red-700 focus:ring-4 focus:outline-none focus:ring-red-200 dark:focus:ring-red-900 font-medium rounded-lg text-sm px-5 py-2.5 inline-flex justify-center">
					<a href="ViewSpaceCtl" style="text-decoration: none; color: white;">
						Book Another Space </a>
				</button>
				<%
                            }
                        %>
			</div>
		</div>
	</div>
	<%
        }
    } else {
%>
	<div
		class="flex justify-center items-center h-screen bg-gradient-to-br from-blue-500 to-purple-600">
		<div
			class="w-full max-w-sm p-4 bg-white border border-gray-200 rounded-lg shadow-lg sm:p-8 dark:bg-gray-800 dark:border-gray-700 transition-transform transform hover:scale-105">
			<div class="text-gray-900 dark:text-white">No records found</div>
		</div>
	</div>
	<%
    }
%>

	<%@ include file="/jsp/Footer.jsp"%>
</body>
</html>
