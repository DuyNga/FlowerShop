<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="component/header.jsp"></jsp:include>
<div class="container">
    <div class="row shopping-cart">
        <!-- <h5> Shopping Cart</h5> -->
        <table class="table table-bordered table-striped">
            <thead>
            <tr>
                <th>Remove</th>
                <th>Image</th>
                <th>Flower Name</th>
                <th>Quantity</th>
                <th>Unit Price</th>
                <th>Total</th>
            </tr>
            </thead>
            <tbody id="tblMyCart">
            <c:forEach items="${myCart}" var="item">
                <tr class="item" id="item_${item.flower.id}">
                    <td><input class="check" type="checkbox" value="${item.flower.id}" id="optionsCheckbox"></td>
                    <td class="muted center_text"><a href="flower?id=${item.flower.id}"><img src="<c:url value="resources/images/${item.flower.imageName}" />" class="flower-image"></a></td>
                    <td>${item.flower.flowerName}</td>
                    <td><input class="qty" type="number" placeholder="1" class="input-mini" value="${item.qty}" min="1" flowerid="${item.flower.id}"></td>
                    <td class="price format-money">${item.price}</td>
                    <td class="total format-money">${item.price * item.qty}</td>
                </tr>
            </c:forEach>
            <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td><strong id="sum"></strong></td>
            </tr>
            </tbody>
        </table>
    </div>
    <div class="row shopping-cart">
        <div class="col-sm-5 left">
            <button type="button" class="btn btn-outline-primary" id="btnRemove">
                <span class="fa fa-check-circle"></span> Remove
            </button>
        </div>
        <div class="col-sm-2">
            <button type="button" class="btn btn-outline-primary" id="btnContinueShopping">
                <span class="fa fa-forward"></span> Continue shopping
            </button>
        </div>
        <div class="col-sm-5">
            <button type="button" class="btn btn-outline-primary" id="btnCheckout">
                <span class="fa fa-calendar"></span> Checkout
            </button>
        </div>
    </div>
</div>
<jsp:include page="component/footer.jsp"></jsp:include>