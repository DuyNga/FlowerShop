
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="component/header.jsp"></jsp:include>
<c:if test="${error_login != null}">
    <div class="alert alert-danger" role="alert">
        <c:out value="${error_flower}"/>
    </div>
</c:if>
<div class="row shopping-cart">
    <table class="table table-bordered table-striped">
        <thead>
        <tr>
            <th>Name</th>
            <th>Description</th>
            <th>Image</th>
            <th>Price</th>
        </tr>
        </thead>
        <tbody id="tblMyCart">
        <tr class="item">
            <td>${flower.flowerName}</td>
            <td>${flower.fullDescription}</td>
            <td><img src="resources/images/${flower.imageName}" class="product-image"></td>
            <td>${flower.price}</td>
        </tr>
        </tbody>
    </table>
</div>
<jsp:include page="component/footer.jsp"></jsp:include>