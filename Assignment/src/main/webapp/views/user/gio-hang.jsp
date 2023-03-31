<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 3/17/2023
  Time: 9:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>


<div>
    <div>
        <c:if test="${ f:length(list) == 0 }">
            <h4 class="text-center">Không có dữ liệu</h4>
        </c:if>
        <c:if test="${ f:length(list) != 0 }">
            <c:forEach var="sanPham" items="${ list }" varStatus="status">
                <div class="card mb-2 border">
                    <div class="card-body">
                        <div class="row align-items-center">
                            <div class="col-1">
                                <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                            </div>
                            <div class="col-1">
                                <img src="${sanPham.anh}" class="img-fluid d-flex" alt="Ảnh sản phẩm">
                            </div>
                            <div class="col-md-3 col-7">
                                <a href="/Assignment_war_exploded/product-detail?id=${sanPham.id}"
                                   class="text-decoration-none text-black" scroll-to-top>${sanPham.ten}</a>
                            </div>
                            <div class="col-md-2 col-3">
                                <a class="text-decoration-none text-black">${sanPham.mauSac}</a>
                            </div>

                            <div class="col-md-1 col-2">
                                <span class="text-center text-truncate">${sanPham.giaBan}</span>
                            </div>

                            <div class="col-md-2 col-3">
                                <div class="input-group">

                                    <input type="number" class="form-control" id="quantity-input" name="quantity"
                                           value="${sanPham.soLuong}">

                                </div>
                            </div>
                            <div class="col-md-1 col-2">
                                <span class="text-center text-truncate text-danger">${sanPham.giaBan * sanPham.soLuong}</span>
                            </div>
                            <div class="col-md-1 col-2">
                                <a class="btn btn-danger border-1" style="width: 70px"
                                   href="/Assignment_war_exploded/cart-delete?id=${sanPham.id}" type="button">Xoá</a>
                                <a class="btn btn-success border-1 mt-1" style="width: 70px"
                                   href="/Assignment_war_exploded/add/bill?id=${sanPham.id}&soLuong=${sanPham.soLuong}"
                                   type="button">Mua</a>
                            </div>
                        </div>
                    </div>

                </div>
            </c:forEach>
        </c:if>

    </div>
    <div class="row">
        <button class="col-2 offset-9 btn text-white btn-success float-end">
            Mua hàng
        </button>
    </div>
</div>