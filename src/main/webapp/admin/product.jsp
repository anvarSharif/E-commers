
<%@ page import="java.util.List" %>
<%@ page import="uz.pdp.ecommercejsp.entity.Product" %>
<%@ page import="uz.pdp.ecommercejsp.repo.ProductRepo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
    <link rel="stylesheet" href="/static/bootstrap.min.css">

</head>
<body>


<%
    List<Product> products = ProductRepo.findAll();
%>

<div class="container m-2">
    <div class="row">
        <div class="col-3 card">
            <div class="list-group">
                <a href="/admin/category.jsp" class="btn btn-dark mb-2">Category</a>
                <a href="/admin/product.jsp" class="btn btn-dark mb-2">Product</a>
            </div>
        </div>
        <div class="col-9 card">
            <form action="/auth/logout" method="post">
                <button class="btn btn-dark">
                    Logout
                </button>
            </form>
            <div class="d-flex justify-content-between mb-3">
                <h2>Category List</h2>
                <form action="/admin/addOrUpdateProduct.jsp">
                    <button class="btn btn-success my-1 justify-content-end">
                        Add Product
                    </button>
                </form>
            </div>
            <table class="table table-striped">
                <thead class="thead-dark">
                <tr>
                    <th>Img</th>
                    <th>Name</th>
                    <th>Category ID</th>
                    <th>Price</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <% for (Product product : products) { %>
                <tr>
                    <td>
                        <img src="/file/<%= product.getPhotoUrl() %>"  alt="rasm topilmadi!" height="80"
                             width="80">
                    </td>
                    <td><%= product.getName() %>
                    </td>
                    <td><%= product.getCategoryId() %>
                    </td>
                    <td><%= product.getPrice() %>
                    </td>
                    <td>
                        <div class="d-flex">
                            <form action="/product/delete" method="post" class="mr-2">
                                <input type="hidden" name="productId" value="<%= product.getId() %>">
                                <button class="btn btn-danger">Delete</button>
                            </form>
                            <form action="/admin/addOrUpdateProduct.jsp" method="get">
                                <input type="hidden" name="productId" value="<%= product.getId() %>">
                                <button class="btn btn-dark">Update</button>
                            </form>
                        </div>
                    </td>
                </tr>
                <% } %>
                </tbody>
            </table>
        </div>
    </div>
</div>
</form>
</body>
</html>
