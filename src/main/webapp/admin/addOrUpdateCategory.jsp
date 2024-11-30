<%@ page import="uz.pdp.ecommercejsp.entity.Category" %>
<%@ page import="uz.pdp.ecommercejsp.repo.CategoryRepo" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Category</title>
    <link rel="stylesheet" href="/static/bootstrap.min.css">
</head>
<%
    String categoryId = request.getParameter("categoryId");
    Category category = null;
    if (categoryId != null) {
        List<Category> categoryList = CategoryRepo.findAll();
        category = categoryList.stream().filter(item -> item.getId().equals(Integer.parseInt(categoryId))).findFirst().get();
    }
%>
<div class="container mt-5">
    <div class="card">
        <div class="card-body">
            <h3 class="card-title text-center mb-4">Category <%=category == null ? "add" : "update"%>
            </h3>
            <form action="/category/add" method="post">
                <input type="hidden" name="categoryId" value="<%=categoryId%>">
                <div class="mb-3">
                    <label for="name" class="form-label">Name</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="Category nomini kiriting"
                           value="<%=category==null?"":category.getName()%>" required>
                </div>
                <div class="text-end">
                    <button type="submit" class="btn btn-dark"><%=categoryId == null ? "Add" : "Update"%>Category
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
