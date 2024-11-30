
<%@ page import="java.util.ArrayList" %>
<%@ page import="uz.pdp.ecommercejsp.entity.Order" %>
<%@ page import="java.util.List" %>
<%@ page import="uz.pdp.ecommercejsp.entity.User" %>
<%@ page import="uz.pdp.ecommercejsp.repo.OrderRepo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Orders</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container my-5">
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h1 class="fw-bold">Your Orders</h1>
        <a href="/home.jsp" class="btn btn-outline-dark">
            ← Back to Home
        </a>
    </div>

    <%
        List<Order> orders = new ArrayList<>();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            List<Order> orderList = OrderRepo.findAll();
            orders = orderList.stream().filter(item -> item.getUserId().equals(user.getId())).toList();
        }
    %>

    <div class="card shadow">
        <div class="card-header bg-secondary text-white">
            <h3 class="mb-0">Order List</h3>
        </div>
        <div class="card-body">
            <table class="table table-hover">
                <thead class="table-secondary">
                <tr>
                    <th>Order ID</th>
                    <th>Date Time</th>
                    <th>Status</th>
                    <th>User ID</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <% if (orders.isEmpty()) { %>
                <tr>
                    <td colspan="5" class="text-center text-muted">No orders found.</td>
                </tr>
                <% } else {
                    for (Order order : orders) { %>
                <tr>
                    <td><%= order.getId() %></td>
                    <td><%= order.getDateTime() %></td>
                    <td><%= order.getStatus() %></td>
                    <td><%= order.getUserId() %></td>
                    <td>
                        <form action="/orderItems.jsp" method="get" class="d-inline">
                            <input type="hidden" name="orderId" value="<%= order.getId() %>">
                            <button class="btn btn-sm btn-primary">Show</button>
                        </form>
                    </td>
                </tr>
                <%  }
                } %>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
