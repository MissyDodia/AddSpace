<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adspace</title>

 <link rel="stylesheet" href="css/index.css">
 
</head>
<body>
<%@include file="/jsp/Header.jsp"%>
<div class="container">



<div class="container">

 
<%-- 
    <%
        List<SpaceBean> spaces = (List<SpaceBean>) request.getAttribute("spaces");
        if (spaces != null && !spaces.isEmpty()) {
            for (SpaceBean space : spaces) {
    %>
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title"><%= space.getSpaceName() %></h5>
                    <p class="card-text">Location: <%= space.getLocation() %></p>
                    <p class="card-text">Area: <%= space.getArea() %></p>
                    <p class="card-text">Type: <%= space.getType() %></p>
                    <p class="card-text">Company: <%= space.getCompany() %></p>
                    <p class="card-text">Duration: <%= space.getDuration() %></p>
                    <p class="card-text">Price: <%= space.getPrice() %></p>
                    <a href="BookSpaceCtl?spaceId=<%= space.getId() %>" class="btn btn-primary">Book Space</a>
                </div>
            </div>
    <%
            }
        } else {
    %>
        <p>No available spaces.</p>
    <%
        }
    %>

</div> --%>

</div>
<%@include file="/jsp/Footer.jsp" %>

</body>
</html>