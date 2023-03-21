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
<html>
<head>
    <title>Home</title>
    <link href="/Assignment_war_exploded/views/admin/css/styles.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"/>
    <style>
        .card {
            border: none;
        }

        footer {
            background-color: #024137;
            color: white;
        }

        .shopping-cart {
            position: relative;
            display: inline-block;
            cursor: pointer;
        }

        .shopping-cart i {
            font-size: 2rem;
            color: blue;
        }

        .shopping-cart .cart-items {
            color: red;
            padding: 0.375rem 0.75rem;
            border-radius: 50%;
            position: absolute;
            top: -8px;
            right: -8px;
            font-size: 1.125rem;
        }

        .shopping-cart .cart-dropdown {
            position: absolute;
            top: 100%;
            right: 0;
            z-index: 1000;
            display: none;
            width: 250px;
            background-color: #fff;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            padding: 1rem;
        }

        .shopping-cart:hover .cart-dropdown {
            display: block;
        }
    </style>
</head>
<body>

<div class="container">
    <!-- header -->
    <header class="d-flex align-items-center">
        <div class="col-2 mt-4">
            <img class="img-fluid" src="/Assignment_war_exploded/views/user/img/logo_hear.png" alt="Logo">
        </div>
        <form class="ms-3 col-4 mt-4 d-flex" role="search">

            <input class="form-control me-2" type="search" placeholder="Tìm kiếm" aria-label="Search">
            <button class="btn btn-outline-primary" type="submit">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search"
                     viewBox="0 0 16 16">
                    <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
                </svg>
            </button>

        </form>
        <nav class="navbar navbar-expand-lg bg-body-tertiary col-6 d-flex justify-content-end mt-4"
             ng-controller="login">
            <a class="nav-link active me-3" href="/Assignment_war_exploded/login">Đăng
                nhập</a>
            <div class="dropdown">
                <a class="nav-link active me-3" data-bs-toggle="dropdown" aria-current="page"
                   href="#">Trang Của Tôi</a>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="#purchasedProducts">Đơn Hàng</a></li>
                    <li><a class="dropdown-item" data-bs-toggle="modal" data-bs-target="#exampleModal">Đổi Mật Khẩu</a>
                    </li>
                </ul>

                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog" ng-controller="editPasswordController">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h1 class="modal-title fs-5" id="exampleModalLabel">Đổi Mật Khẩu</h1>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                        aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <div class="form-floating mb-3">
                                    <input type="password" class="form-control" ng-model="oldPassword">
                                    <label>Mật khẩu Cũ</label>
                                </div>
                                <div class="form-floating mb-3">
                                    <input type="password" class="form-control" ng-model="newPassword1">
                                    <label>Mật khẩu Mới</label>
                                </div>
                                <div class="form-floating">
                                    <input type="password" class="form-control" ng-model="newPassword2">
                                    <label>Nhập lại Mật Khẩu Mới</label>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-primary" ng-click="editPassword($event)">Lưu Thay
                                    Đổi
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="shopping-cart d-flex align-items-center">
                <a href="#cart">
                    <img src="/Assignment_war_exploded/views/user/img/icons8-shopping-cart-30.png" alt="Shopping cart">
                    <span class="cart-items ms-2"></span>
                </a>
            </div>
        </nav>
    </header>
    <!-- Navbar -->
    <div class="row mt-3 mb-3 ms-3">
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <div class="container-fluid col-12 ">
                <a class="navbar-brand col-2 fw-bold " href="#">Trang chủ</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                        data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false"
                        aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                    <div class="navbar-nav col-12">
                        <a class="nav-link active col-2" aria-current="page" href="#product">Sản phẩm</a>
                        <a class="nav-link active col-3 " aria-current="page" href="#introduce">Giới thiệu cửa
                            hàng</a>
                        <a class="nav-link active" aria-current="page" href="#event">Sự kiện</a>
                    </div>
                </div>
            </div>
        </nav>
    </div>

    <div>

        <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="/Assignment_war_exploded/views/user/img/522_attimg1_origin.jpg" class="d-block w-100"
                         alt="...">
                </div>
                <div class="carousel-item">
                    <img src="/Assignment_war_exploded/views/user/img/523_attimg1_origin.jpg" class="d-block w-100"
                         alt="...">
                </div>
                <div class="carousel-item">
                    <img src="/Assignment_war_exploded/views/user/img/525_attimg1_origin.jpg" class="d-block w-100"
                         alt="...">
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls"
                    data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls"
                    data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>

        <div class="row text-center mt-4 mb-4">
            <h2>Các sản phẩm</h2>
        </div>

        <div>
            <jsp:include page="${ view }"/>
        </div>

    </div>
</div>

<!-- Footer -->
<footer class="row mt-5 ">
    <div class="row">
        <div>
            <p class="mt-3 ms-5"><img src="/Assignment_war_exploded/views/user/img/logo_foot.png" alt="innisfree"></p>
            <div class="row col-7 ms-4 ">
                <a href="#" class="facebook col-1">
                    <img src="/Assignment_war_exploded/views/user/img/icons8-facebook-48.png" class="img-fluid" alt="">
                </a>
                <a href="#" class="instagram col-1">
                    <img src="/Assignment_war_exploded/views/user/img/icons8-instagram-48.png" class="img-fluid" alt="">
                </a>
                <a href="#" class="youtube col-1">
                    <img src="/Assignment_war_exploded/views/user/img/icons8-youtube-48.png" class="img-fluid " alt="">
                </a>
                <a href="#" class="zalo col-1">
                    <img src="/Assignment_war_exploded/views/user/img/icons8-zalo-48.png" class="img-fluid " alt="">
                </a>
                <div class="float-end">
                    <p class="float-end">ⓒ 2020 innisfree Inc. <br>All rights reserved.</p>
                </div>
            </div>
            <hr>
            <ul class="row col-11 list-unstyled ms-4">
                <li class="col-3">
                    <a class="text-decoration-none  text-white fs-6">Chính sách giao hàng và
                        thanh toán</a>
                </li>
                <li class="col-3">
                    <a class="text-decoration-none text-white ">|</a>
                    <a href="" class="text-decoration-none background: text-white  ">Chính sách bảo mật thông tin
                        khách hàng</a>
                </li>
                <li class="col-2">
                    <a href="" class="text-decoration-none text-white ">|</a>
                    <a href="" class="text-decoration-none text-white">Chính sách mua hàng</a>
                </li>
                <li class="col-2">
                    <a class="text-decoration-none text-white ">|</a>
                    <a href="" class="text-decoration-none  text-white">Chính sách trả hàng</a>
                </li>
            </ul>
            <ul class="row list-unstyled ms-4">
                <li>
                    Thời gian làm việc
                    <span>: Thứ 2 ~ Thứ 6 09:00 ~ 17:00 (trừ Thứ 7, Chủ Nhật và ngày lễ)</span>
                </li>
                <li>
                    Tư vấn khách hàng
                    <a href="tel:02838279777" class="text-decoration-none text-white">: 028 3827 9777</a>
                </li>
                <li>
                    Email
                    <span><a href="mailto:cs_vn@innisfree.com" class="text-decoration-none text-white">:
                        cs_vn@innisfree.com</a></span>
                </li>
                <li>CÔNG TY TNHH AMOREPACIFIC VIỆT NAM</li>
                <li>GIẤY CNĐKDN: 0309984165 - Ngày cấp: 05/05/2010, được sửa đổi lần thứ 21, ngày 04/04/2022</li>
                <li>Địa chỉ đăng ký kinh doanh: Lầu 4A, Toà nhà Vincom, 72 Lê Thánh Tôn, Phường Bến Nghé, Quận 1,
                    Tp. Hồ Chí Minh, Việt Nam.
                </li>
            </ul>
        </div>
    </div>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="/Assignment_war_exploded/js/bootstrap.min.js"></script>
</body>
</html>
