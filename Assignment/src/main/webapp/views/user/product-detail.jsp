<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 3/17/2023
  Time: 9:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>


<div class="row">
    <div class="col-6">
        <img src="${sanPham.anh}" alt="" height="500px" width="500px">
    </div>

    <div class="col-6 justify-content-center">

        <h3>${sanPham.ten}</h3>
        <form novalidate method="POST"
              action="/Assignment_war_exploded/add-cart?id=${sanPham.id}">
            <div class="input-group mb-5 mt-5">
                <p class="mt-1 fw-bold">Số lượng</p>

                <input type="number" class="form-control ms-5" name="soLuong">

                <p class="mt-1 text-danger ms-5"> còn ${sanPham.soLuong} sản phẩm</p>
            </div>
            <h3 class="fw-bold mb-5 text-center">${sanPham.giaBan}</h3>
            <div class="row">
                <button class="col-6 offset-3 btn text-white btn-success w-50" type="submit">
                    <img src="img/icons8-shopping-cart-30.png" class="img-fluid" alt="">
                    Thêm vào giỏ hàng
                </button>
            </div>
        </form>
    </div>
</div>
<!-- Content -->
<%--<div class="row me-3">--%>
<%--    <div class="row text-center mt-3 mb-4">--%>
<%--        <h4>Các sản phẩm tương tự</h4>--%>
<%--    </div>--%>

<%--    <div class="row me-3">--%>
<%--        <article class="col-12">--%>
<%--            <div class="row">--%>
<%--                <c:if test="${ f:length(list) == 0 }">--%>
<%--                    <h4 class="text-center">Không có dữ liệu</h4>--%>
<%--                </c:if>--%>
<%--                <c:if test="${ f:length(list) != 0 }">--%>
<%--                    <c:forEach var="sp" items="${ list }" varStatus="status">--%>
<%--                        <div class="col-md-3 col-12">--%>

<%--                            <div class="card ms-3">--%>
<%--                                <img src="${sp.anh}" class="card-img-top img-fluid" alt="...">--%>
<%--                                <div class="card-body text-center">--%>
<%--                                    <a href="/Assignment_war_exploded/product-detail?id=${sp.id}"--%>
<%--                                       class="card-text" style="text-decoration: none;">${sp.ten}</a>--%>
<%--                                    <span class="card text fw-bold">${sp.giaBan}</span>--%>
<%--                                </div>--%>
<%--                            </div>--%>

<%--                        </div>--%>
<%--                    </c:forEach>--%>
<%--                </c:if>--%>
<%--            </div>--%>
<%--        </article>--%>
<%--    </div>--%>
<%--</div>--%>