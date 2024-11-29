<%@ page import="java.util.Map" %>
<%@ page import="java.util.Objects" %>
<%@ page import="uz.pdp.ecommercejsp.entity.Basket" %>
<%@ page import="uz.pdp.ecommercejsp.entity.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Savatcha</title>
    <link rel="stylesheet" href="/static/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <div class="card shadow">
        <div class="card-header bg-dark text-white">
            <h3 class="text-center">Savatcha</h3>
        </div>
        <div class="card-body">
            <%
                Basket basket = (Basket) Objects.requireNonNullElse(session.getAttribute("basket"), new Basket());
                Integer sum = 0;
                if (basket.getMap().isEmpty()) {
            %>
            <div class="alert alert-info text-center">
                Savatcha bo‘sh!
            </div>
            <% } else {
                for (Map.Entry<Product, Integer> entry : basket.getMap().entrySet()) {
                    Product product = entry.getKey();
                    Integer amount = entry.getValue();
            %>
            <div class="row align-items-center mb-4 border-bottom pb-3">
                <div class="col-md-3">
                    <img src="/file/<%= product.getPhotoUrl() %>" class="img-fluid rounded" alt="Rasm topilmadi!"
                         style="height: 200px; object-fit: cover;">
                </div>
                <div class="col-md-5">
                    <h5 class="mb-1"><%= product.getName() %></h5>
                    <p class="mb-1 text-muted">Narxi: <strong><%= product.getPrice() %> UZS</strong></p>
                    <h6 class="mb-0">Jami: <%= amount %> x <%= product.getPrice() %> =
                        <strong><%= amount * product.getPrice() %> UZS</strong>
                    </h6>
                </div>
                <div class="col-md-4 text-end">
                    <div class="d-flex justify-content-end align-items-center">
                        <form action="/basket" method="post" class="d-inline-block me-2">
                            <input type="hidden" name="operator" value="minus">
                            <input type="hidden" name="productId" value="<%= product.getId() %>">
                            <button class="btn btn-outline-dark btn-sm">-</button>
                        </form>
                        <span class="fs-5 mx-3"><%= amount %></span>
                        <form action="/basket" method="post" class="d-inline-block ms-2">
                            <input type="hidden" name="operator" value="plus">
                            <input type="hidden" name="productId" value="<%= product.getId() %>">
                            <button class="btn btn-outline-dark btn-sm">+</button>
                        </form>
                    </div>
                </div>
            </div>
            <% sum += amount * product.getPrice(); } %>
            <div class="row mt-4">
                <div class="col-md-12 text-end">
                    <h4 class="fw-bold">Jami: <span class="text-success"><%= sum %> UZS</span></h4>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-md-12 text-end">
                    <form action="/order" method="post">
                        <button class="btn btn-dark btn-lg">Buyurtma</button>
                    </form>
                </div>
            </div>
            <% } %>
        </div>
    </div>
</div>
</body>
</html>



<%--

<%@ page import="java.util.Map" %>
<%@ page import="java.util.Optional" %>
<%@ page import="java.util.Objects" %>
<%@ page import="uz.pdp.ecommercejsp.entity.Basket" %>
<%@ page import="uz.pdp.ecommercejsp.entity.Product" %>&lt;%&ndash;
  Created by IntelliJ IDEA.
  User: User
  Date: 18/11/2024
  Time: 12:33
  To change this template use File | Settings | File Templates.
&ndash;%&gt;
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Savatcha</title>
    <link rel="stylesheet" href="/static/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="card m-2">
        <div class="row">
            <%
                Basket basket = (Basket) Objects.requireNonNullElse(session.getAttribute("basket"), new Basket());
                Integer sum = 0;
                for (Map.Entry<Product, Integer> entry : basket.getMap().entrySet()) {
                    Product product = entry.getKey();
                    Integer amount = entry.getValue();
            %>
            <div class="col-3">
                <img src="/file/<%= product.getId() %>" class="card-img-top" alt="rasm topilmadi!"
                     style="height: 200px; object-fit: cover;">
            </div>

            <div class="col-7 offset-2 d-flex flex-column justify-content-center">
                <h2><%= product.getName() %></h2>
                <p>Narxi: <strong><%= product.getPrice() %> UZS</strong></p>
                <h4><%= product.getName() %> * <%= amount %> = <%= amount * product.getPrice() %> UZS</h4>

                <div class="d-flex align-items-center">
                    <form action="/basket" method="post" class="me-2">
                        <input type="hidden" name="operator" value="minus">
                        <input type="hidden" name="productId" value="<%= product.getId() %>">
                        <button class="btn btn-dark">-</button>
                    </form>
                    <span class="fs-5 mx-3"><%= amount %></span>
                    <form action="/basket" method="post" class="ms-2">
                        <input type="hidden" name="operator" value="plus">
                        <input type="hidden" name="productId" value="<%= product.getId() %>">
                        <button class="btn btn-dark">+</button>
                    </form>
                </div>
            </div>

            <div class="w-100 my-3"></div>
            <% sum += amount * product.getPrice(); } %>

            <div class="col-12">
                <h1 class="text-end">Jami: <%= sum %> UZS</h1>
            </div>
            <div class="col-12 text-end mt-3">
                <form action="/order" method="post">
                    <button class="btn btn-dark">Buyurtma</button>
                </form>
            </div>
        </div>
    </div>
</div>


</body>
</html>
--%>
