<%@page import="java.awt.Font"%>
<%@page import="in.co.adspace.bean.SpaceBean"%>
<%@page import="java.util.List"%>
<%@page import="in.co.adspace.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Available Spaces</title>
    
    <!-- Include Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" />
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
    <section class="container mt-4">
        <h1 class="mb-4 text-center">Available Spaces</h1>
        <%-- Success/Error Messages --%>
    
    <div style="float: center;">
          <font  style=" text-align:center; color: green;" ><%=(success!=null)?success:"" %></font>
            <font style="text-align:center; color: red"><%= (error!=null)?error:""%></font><br>
</div>
        
     
        
        <div class="row">
            <%
                String err = (String) request.getAttribute("err");
                List<SpaceBean> list = (List<SpaceBean>) request.getAttribute("list");
                if (list != null && !list.isEmpty()) {
                    for (SpaceBean space : list) {
            %>
                        <div class="col-md-4 mb-4">
                            <div class="card h-100">
                                <img src="ViewSpaceCtl?action=fetchImage&spaceId=<%= space.getId() %>&imageName=image1" class="card-img-top" alt="Space Image" style="height: 200px; object-fit: cover;">
                                <div class="card-body">
                                    <h5 class="card-title"><%= space.getSpacename() %></h5>
                                    <p class="card-text">Location: <%= space.getLocation() %></p>
                                    <p class="card-text">Area: <%= space.getArea() %></p>
                                    <p class="card-text">Type: <%= space.getType() %></p>
                                    <p class="card-text">Company: <%= space.getCompany() %></p>
                                    <p class="card-text">Duration: <%= space.getDuration() %></p>
                                    <p class="card-text">Price: <%= space.getPrice() %></p>
                                    <div class="d-flex justify-content-between mt-2">
                                        <a href="#carouselModal<%= space.getId() %>" data-bs-toggle="modal" class="btn btn-primary">View Images</a>
                                        <% if (userbean != null && "admin".equals(userbean.getRole())) { %>
                                            <a href="DeleteSpaceCtl?spaceId=<%= space.getId() %>" class="btn btn-danger">Delete</a>
                                        <% } else { %>
                                            <a href="BookSpaceCtl?spaceId=<%= space.getId() %>" class="btn btn-success">Book Space</a>
                                        <% } %>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <%-- Modal for Space Images --%>
                        <div class="modal fade " style="height: 650px;" id="carouselModal<%= space.getId() %>" tabindex="-1" aria-labelledby="carouselModalLabel<%= space.getId() %>" aria-hidden="true">
                            <div class="modal-dialog modal-lg">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="carouselModalLabel<%= space.getId() %>">Images for <%= space.getSpacename() %></h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        <div id="carousel<%= space.getId() %>" class="carousel slide" data-bs-ride="carousel">
                                            <div class="carousel-inner">
                                                <div class="carousel-item active">
                                                    <img style="height: 550px;" src="ViewSpaceCtl?action=fetchImage&spaceId=<%= space.getId() %>&imageName=image1" class="d-block w-100" alt="Image 1">
                                                </div>
                                                <div class="carousel-item">
                                                    <img style="height: 550px;" src="ViewSpaceCtl?action=fetchImage&spaceId=<%= space.getId() %>&imageName=image2" class="d-block w-100" alt="Image 2">
                                                </div>
                                                <div class="carousel-item">
                                                    <img style="height: 550px;" src="ViewSpaceCtl?action=fetchImage&spaceId=<%= space.getId() %>&imageName=image3" class="d-block w-100" alt="Image 3">
                                                </div>
                                            </div>
                                            <button class="carousel-control-prev" type="button" data-bs-target="#carousel<%= space.getId() %>" data-bs-slide="prev">
                                                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                                <span class="visually-hidden">Previous</span>
                                            </button>
                                            <button class="carousel-control-next" type="button" data-bs-target="#carousel<%= space.getId() %>" data-bs-slide="next">
                                                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                                <span class="visually-hidden">Next</span>
                                            </button>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button-dark" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                    </div>
                                </div>
                            </div>
                        </div>
            <%
                    }
                } else {
            %>
                    <div class="col-12">
                        <p class="text-danger text-center"><%= (err != null ? err : "No records found") %></p>
                    </div>
            <%
                }
            %>
        </div>
    </section>
    
    <footer>
        <%@ include file="/jsp/Footer.jsp" %>
    </footer>

    <!-- Include Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
