
<%@ page import="java.util.*" %>
<%@ page import="uz.pdp.ecommercejsp.repo.ProductRepo" %>
<%@ page import="uz.pdp.ecommercejsp.entity.Product" %>
<%@ page import="uz.pdp.ecommercejsp.DB" %>
<%@ page import="uz.pdp.ecommercejsp.entity.Basket" %>
<%@ page import="uz.pdp.ecommercejsp.entity.User" %>
<%@ page import="uz.pdp.ecommercejsp.entity.Category" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <link rel="stylesheet" href="/static/bootstrap.min.css">
</head>
<body class="bg-light">
<%
    List<Product> products = ProductRepo.findAll();
    String categoryId = request.getParameter("categoryId");
    if (categoryId != null) {
        List<Product> tempProducts = ProductRepo.findAll();
        products = tempProducts.stream().filter(item -> item.getCategoryId().equals(Integer.parseInt(categoryId))).toList();
    }
    Basket basket = (Basket) Objects.requireNonNullElse(session.getAttribute("basket"), new Basket());
    User user = (User) session.getAttribute("user");
%>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="/home.jsp">Online Shop</a>
        <div class="d-flex">
            <% if (user != null) { %>
            <a href="order.jsp" class="btn btn-outline-light me-2">My Orders</a>
            <form action="/auth/logout" method="post">
                <button class="btn btn-danger me-2">Logout</button>
            </form>
            <div class="d-flex align-items-center">
                <img src="/user/file/<%= user.getId() %>" height="40" width="40" class="rounded-circle me-2" alt="User">
                <span class="text-white"><%= user.getPhone() %></span>
            </div>
            <% } else { %>
            <a href="/auth/login.jsp" class="btn btn-outline-light">Login</a>
            <% } %>
        </div>
    </div>
</nav>

<!-- Main Content -->
<div class="container-fluid mt-4">
    <div class="row">
        <!-- Categories Section -->
        <div class="col-md-3">
            <div class="card">
                <div class="card-header bg-dark text-white text-center">
                    <h5>Categories</h5>
                </div>
                <div class="list-group list-group-flush">
                    <form action="/home.jsp">
                        <button class="list-group-item list-group-item-action">All</button>
                    </form>
                    <% for (Category category : DB.categories) { %>
                    <form action="/home.jsp">
                        <input type="hidden" name="categoryId" value="<%= category.getId() %>">
                        <button class="list-group-item list-group-item-action"><%= category.getName() %></button>
                    </form>
                    <% } %>
                </div>
            </div>
        </div>

        <!-- Products Section -->
        <div class="col-md-9">
            <div class="d-flex justify-content-end mb-3">
                <a href="basket.jsp" class="btn btn-dark">
                    Savatcha (<%= basket.getMap().size() %>)
                </a>
            </div>
            <div class="row g-3">
                <% for (Product product : products) { %>
                <div class="col-md-4">
                    <div class="card h-100">
                        <img src="/file/<%=product.getPhotoUrl() %>" class="card-img-top" alt="Product Image" style="height: 200px; object-fit: cover;">
                        <div class="card-body text-center">
                            <h5 class="card-title"><%= product.getName() %></h5>
                            <p class="card-text">Price: <strong><%= product.getPrice() %> UZS</strong></p>
                            <% if (basket.getMap().containsKey(product)) { %>
                            <form action="/basket/delete" method="post">
                                <input type="hidden" name="productId" value="<%= product.getId() %>">
                                <input type="hidden" name="categoryId" value="<%= categoryId != null ? categoryId : "non" %>">
                                <button class="btn btn-danger w-100">Remove</button>
                            </form>
                            <% } else { %>
                            <form action="/basket/add" method="post">
                                <input type="hidden" name="productId" value="<%= product.getId() %>">
                                <input type="hidden" name="categoryId" value="<%= categoryId != null ? categoryId : "non" %>">
                                <button class="btn btn-dark w-100">Add to Basket</button>
                            </form>
                            <% } %>
                        </div>
                    </div>
                </div>
                <% } %>
            </div>
        </div>
    </div>
</div>

</body>
</html>
