<%--

<%@ page import="java.util.ArrayList" %>
<%@ page import="uz.pdp.ecommercejsp.entity.Order" %>
<%@ page import="java.util.List" %>
<%@ page import="uz.pdp.ecommercejsp.entity.User" %>
<%@ page import="uz.pdp.ecommercejsp.repo.OrderRepo" %><%@ page import="java.util.List" %>
<%@ page import="java.util.Optional" %>
<%@ page import="uz.pdp.ecommercejsp.entity.OrderItem" %>
<%@ page import="uz.pdp.ecommercejsp.repo.OrderItemRepo" %>
<%@ page import="uz.pdp.ecommercejsp.entity.Product" %>
<%@ page import="uz.pdp.ecommercejsp.repo.ProductRepo" %>&lt;%&ndash;
  Created by IntelliJ IDEA.
  User: User
  Date: 23/11/2024
  Time: 11:28
  To change this template use File | Settings | File Templates.
&ndash;%&gt;
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>OrderItem</title>
    <link rel="stylesheet" href="/static/bootstrap.min.css">
</head>
<body><div class="container my-4">
    <div class="card">
        <a href="/order.jsp" class="btn btn-dark w-25">
            <- back
        </a>
        <div class="card-header text-center">
            <h4>Order Receipt</h4>
        </div>
        <div class="card-body">
            <%
                Integer sum = 0;
                int orderId = Integer.parseInt(request.getParameter("orderId"));
                List<Order> orderList = OrderRepo.findAll();
                Optional<Order> optionalOrder = orderList.stream().filter(order -> order.getId().equals(orderId)).findFirst();
                if (optionalOrder.isPresent()) {
                    Order order = optionalOrder.get();
                    List<OrderItem> orderItemList = OrderItemRepo.findAll();
                    List<OrderItem> orderItems = orderItemList.stream().filter(item -> item.getOrderId().equals(order.getId())).toList();
            %>
            <div class="mb-3">
                <strong>Order ID:</strong> <%= order.getId() %><br>
                <strong>Date & Time:</strong> <%= order.getDateTime() %><br>
                <strong>User ID:</strong> <%= order.getUserId() %>
            </div>
            <hr>
            <div class="mb-3">
                <% for (OrderItem orderItem : orderItems) {
                    List<Product> productList = ProductRepo.findAll();
                    Product product =productList.stream().filter(item -> item.getId().equals(orderItem.getProductId())).findFirst().get();
                    int total = product.getPrice() * orderItem.getAmount();
                    sum += total;
                %>
                <div class="d-flex justify-content-between">
                    <span><%= product.getName() %> x <%= orderItem.getAmount() %></span>
                    <span><%= total %> UZS</span>
                </div>
                <% } %>
            </div>
            <hr>
            <div class="text-center">
                <strong>Total Summa:</strong> <%= sum %> UZS
            </div>
            <% } else { %>
            <p>Order not found.</p>
            <% } %>
        </div>
    </div>
</div></body>
</html>
--%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="uz.pdp.ecommercejsp.entity.Order" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Optional" %>
<%@ page import="uz.pdp.ecommercejsp.entity.OrderItem" %>
<%@ page import="uz.pdp.ecommercejsp.repo.OrderItemRepo" %>
<%@ page import="uz.pdp.ecommercejsp.entity.Product" %>
<%@ page import="uz.pdp.ecommercejsp.repo.ProductRepo" %>
<%@ page import="uz.pdp.ecommercejsp.repo.OrderRepo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Products</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container my-5">
    <div class="card shadow">
        <div class="card-header d-flex justify-content-between align-items-center bg-secondary text-white">
            <h5 class="mb-0">Order Products</h5>
            <a href="/order.jsp" class="btn btn-outline-light btn-sm">← Back</a>
        </div>
        <div class="card-body">
            <%
                Integer sum = 0;
                int orderId = Integer.parseInt(request.getParameter("orderId"));
                List<Order> orderList = OrderRepo.findAll();
                Optional<Order> optionalOrder = orderList.stream().filter(order -> order.getId().equals(orderId)).findFirst();
                if (optionalOrder.isPresent()) {
                    Order order = optionalOrder.get();
                    List<OrderItem> orderItemList = OrderItemRepo.findAll();
                    List<OrderItem> orderItems = orderItemList.stream().filter(item -> item.getOrderId().equals(order.getId())).toList();
            %>
            <div class="mb-4">
                <p><strong>Order ID:</strong> <%= order.getId() %></p>
                <p><strong>Date & Time:</strong> <%= order.getDateTime() %></p>
                <p><strong>User ID:</strong> <%= order.getUserId() %></p>
            </div>
            <hr>
            <div class="mb-4">
                <h6 class="fw-bold">Order Items</h6>
                <ul class="list-group">
                    <% for (OrderItem orderItem : orderItems) {
                        List<Product> productList = ProductRepo.findAll();
                        Product product = productList.stream().filter(item -> item.getId().equals(orderItem.getProductId())).findFirst().get();
                        int total = product.getPrice() * orderItem.getAmount();
                        sum += total;
                    %>
                    <li class="list-group-item d-flex justify-content-between align-items-center">
                        <div>
                            <strong><%= product.getName() %></strong>
                            <span class="text-muted">x <%= orderItem.getAmount() %></span>
                        </div>
                        <span><%= total %> UZS</span>
                    </li>
                    <% } %>
                </ul>
            </div>
            <hr>
            <div class="text-center">
                <h5 class="fw-bold">Total Sum:</h5>
                <p class="fs-4 text-success"><%= sum %> UZS</p>
            </div>
            <% } else { %>
            <!-- If Order Not Found -->
            <div class="alert alert-warning text-center" role="alert">
                Order not found.
            </div>
            <% } %>
        </div>
    </div>
</div>
<!-- Footer -->
<footer class="text-center mt-5 text-muted">
    <p>&copy; 2024.11.30 My E-commerce</p>
</footer>
</body>
</html>
