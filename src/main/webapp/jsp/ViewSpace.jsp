<%@page import="in.co.adspace.bean.SpaceBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Available Spaces</title>
    
    <link rel="stylesheet" href="css/viewspace.css">
    
</head>
<body>
    <header>
        <%@ include file="/jsp/Header.jsp" %>
    </header>
<%
    UserBean userbean = (UserBean) session.getAttribute("userbean");
    String success = (String) request.getAttribute("success");
    String error = (String) request.getAttribute("error");
%>
    <section class="container" style="text-align: center;">
        <h1 class="mt-4 mb-4 text-center">Available Spaces</h1>
        <font style="color: green; text-align: center;"><%=(success != null) ? success : "" %></font>
        <font style="color: red; text-align: center;"><%=(error != null) ? error : "" %></font>
        
        <div class="row">
            <%
                String err = (String) request.getAttribute("err");
                List<SpaceBean> list = (List<SpaceBean>) request.getAttribute("list");
                if (list != null && !list.isEmpty()) {
                    for (SpaceBean space : list) {
            %>
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title"><%= space.getSpacename() %></h5>
                                <p class="card-text">Location: <%= space.getLocation() %></p>
                                <p class="card-text">Area: <%= space.getArea() %></p>
                                <p class="card-text">Type: <%= space.getType() %></p>
                                <p class="card-text">Company: <%= space.getCompany() %></p>
                                <p class="card-text">Duration: <%= space.getDuration() %></p>
                                <p class="card-text">Price: <%= space.getPrice() %></p>
                                <%
                                    if (bean != null) {
                                        String role = bean.getRole(); // Get the role once to avoid multiple method calls

                                        if ("admine".equals(role)) {
                                %>
                                            <a href="DeleteSpaceCtl?spaceId=<%=space.getId()%>" class="btn-book">Delete</a>
                                <%
                                        } else {
                                %>
                                            <a href="BookSpaceCtl?spaceId=<%=space.getId()%>" class="btn-book">Book Space</a>
                                <%
                                        }
                                    }
                                %>
                            </div>
                        </div>
            <%
                    }
                } else {
            %>
                    <div class="col-12">
                        <p class="text-danger"><%= (err != null ? err : "No records found") %></p>
                    </div>
            <%
                }
            %>
        </div>
    </section>

    <footer>
        <%@ include file="/jsp/Footer.jsp" %>
    </footer>
</body>
</html>
