<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="WEB-INF/jsp/component/header.jsp"></jsp:include>

<div class="container">
<div class="row">

  <c:forEach items="${flowers}" var="flower">
    <c:url value='shopping-cart' var="linkAddToCart">
      <c:param name="flowerId" value="${flower.id}"/>
    </c:url>
    <div class="col-lg-3 col-md-4 col-xs-6">
      <div class="card h-100">
        <a href="flower?id=${flower.id}"><img class="card-img-top" src="<c:url value="resources/images/${flower.imageName}" />" alt=""></a>
        <div class="card-body">
          <h4 class="card-title">
            <span class="flower-name">${flower.flowerName}</span>
          </h4>
          <h5>$34.99</h5>
          <p class="card-text">${flower.shortDescription}</p>
        </div>
        <div class="card-footer text-center">
          <a href="${linkAddToCart}" class="btn btn-primary btn-lg active addToCart" role="button" aria-pressed="true">Add to cart</a>
        </div>
      </div>
    </div>
  </c:forEach>

</div>
</div>

<jsp:include page="WEB-INF/jsp/component/footer.jsp"></jsp:include>