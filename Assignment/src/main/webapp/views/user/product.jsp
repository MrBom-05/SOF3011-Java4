<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 3/21/2023
  Time: 11:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>

<div class="row text-center mt-4 mb-4">
    <h2>Tất cả sản phẩm</h2>
</div>

<div class="row me-3">
    <article class="col-12">
        <div class="row">
            <div class="col-md-3 col-12">
                <c:if test="${ f:length(list) == 0 }">
                    <h4 class="text-center">Không có dữ liệu</h4>
                </c:if>
                <c:if test="${ f:length(list) != 0 }">
                    <c:forEach var="sanPham" items="${ list }" varStatus="status">
                        <div class="card ms-3">
                            <img src="${sanPham.anh}" class="card-img-top img-fluid" alt="...">
                            <div class="card-body text-center">
                                <a href="/Assignment_war_exploded/product-detail?id=${sanPham.id}"
                                   class="card-text" style="text-decoration: none;">${sanPham.ten}</a>
                                <span class="card text fw-bold">${sanPham.giaBan}</span>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>
            </div>
        </div>
    </article>
</div>

