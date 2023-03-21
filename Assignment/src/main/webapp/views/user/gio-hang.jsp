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
    <div ng-repeat="product in userProducts">
        <div class="card mb-2 border">
            <div class="card-body">
                <div class="row align-items-center">
                    <div class="col-1">
                        <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                    </div>
                    <div class="col-1">
                        <img src="img/{{product.image}}" class="img-fluid d-flex" alt="Ảnh sản phẩm">
                    </div>
                    <div class="col-md-3 col-7">
                        <a href="#/product/{{product.id}}" ng-click="getProductDetail($event, product.id)"
                           class="text-decoration-none text-black" scroll-to-top>{{product.name}}</a>
                    </div>
                    <div class="col-md-2 col-3">
                        <a class="text-decoration-none text-black">{{ getNameByID(product.category)
                            }}</a>
                    </div>

                    <div class="col-md-1 col-2">
                        <span class="text-center text-truncate">${{product.price}}</span>
                    </div>

                    <div class="col-md-2 col-3">
                        <div class="input-group">

                            <input type="number" class="form-control" id="quantity-input" name="quantity"
                                   ng-model="product.quantity">

                        </div>
                    </div>
                    <div class="col-md-1 col-2">
                        <span class="text-center text-truncate text-danger">${{product.price * product.quantity}}</span>
                    </div>
                    <div class="col-md-1 col-2">
                        <button class="btn btn-success border-1"
                                ng-click="deleteToCart($event, product.id)">Xoá</button>
                    </div>
                </div>
            </div>

        </div>
    </div>
    <div class="row">
        <button class="col-2 offset-9 btn text-white btn-success float-end">
            Mua hàng
        </button>
    </div>
</div>