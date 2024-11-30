

<%@ page import="java.util.List" %>
<%@ page import="uz.pdp.ecommercejsp.entity.Category" %>
<%@ page import="uz.pdp.ecommercejsp.repo.CategoryRepo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin - Category Management</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css">
</head>
<body>

    <%
    List<Category> categories =CategoryRepo.findAll();
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
                <form action="/admin/addCategory.jsp">
                    <button class="btn btn-success">Add Category</button>
                </form>
            </div>
            <table class="table table-striped">
                <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <% for (Category category : categories) { %>
                <tr>
                    <td><%= category.getId() %></td>
                    <td><%= category.getName() %></td>
                    <td>
                        <div class="d-flex">
                            <form action="/category/delete" method="post" class="mr-2">
                                <input type="hidden" name="categoryId" value="<%= category.getId() %>">
                                <button class="btn btn-danger">Delete</button>
                            </form>
                            <form action="addCategory.jsp" method="get">
                                <input type="hidden" name="categoryId" value="<%= category.getId() %>">
                                <button class="btn btn-dark mx-2">Update</button>
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



</body>
</html>
