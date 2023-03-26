<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<html>
<head>
    <title>Admin</title>

    <link href="/Assignment_war_exploded/views/admin/css/styles.css" rel="stylesheet"/>
    <link href="/Assignment_war_exploded/views/admin/css/admin.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
</head>
<body id="body-pd">


<header class="header" id="header">
    <div class="header_toggle"><i class='bx bx-menu' id="header-toggle"></i></div>
    <div class="header_img"><img src="" alt=""></div>
</header>
<div class="l-navbar" id="nav-bar">
    <nav class="nav">
        <div><a href="/Assignment_war_exploded/admin" class="nav_logo"> <i class='bx bx-layer nav_logo-icon'></i> <span
                class="nav_logo-name">Admin</span> </a>
            <div class="nav_list">
                <a href="/Assignment_war_exploded/admin/hoa-don/index" class="nav_link active">
                    <i class="bi bi-receipt-cutoff nav_icon"></i>
                    <span class="nav_name">Quản Lý Hóa Đơn</span> </a> <a
                    href="/Assignment_war_exploded/admin/chi-tiet-sp/index" class="nav_link">
                <i class="bi bi-box-seam nav_icon"></i>
                <span class="nav_name">Chi Tiết Sản Phẩm</span> </a> <a
                    href="/Assignment_war_exploded/admin/san-pham/index" class="nav_link">
                <i class="bi bi-box nav_icon"></i>
                <span class="nav_name">Sản Phẩm</span> </a> <a href="/Assignment_war_exploded/admin/dong-sp/index"
                                                               class="nav_link">
                <i class="bi bi-bookmark nav_icon"></i>
                <span class="nav_name">Dòng Sản Phẩm</span> </a> <a href="/Assignment_war_exploded/admin/mau-sac/index"
                                                                    class="nav_link">
                <i class="bi bi-palette nav_icon"></i>
                <span class="nav_name">Màu Sắc</span> </a> <a href="/Assignment_war_exploded/admin/nsx/index"
                                                              class="nav_link">
                <i class="bi bi-building nav_icon"></i>
                <span class="nav_name">Nhà Sản Xuất</span> </a> <a
                    href="/Assignment_war_exploded/admin/khach-hang/index" class="nav_link">
                <i class="bi bi-circle nav_icon"></i>
                <span class="nav_name">Khách Hàng</span> </a> <a href="/Assignment_war_exploded/admin/nhan-vien/index"
                                                                 class="nav_link">
                <i class="bi bi-circle-fill nav_icon"></i>
                <span class="nav_name">Nhân Viên</span> </a> <a href="/Assignment_war_exploded/admin/cua-hang/index"
                                                                class="nav_link">
                <i class="bi bi-bag nav_icon"></i>
                <span class="nav_name">Cửa Hàng</span> </a> <a href="/Assignment_war_exploded/admin/chuc-vu/index"
                                                               class="nav_link">
                <i class="bi bi-box-seam nav_icon"></i>
                <span class="nav_name">Chức Vụ</span> </a>
                <%--                <i class="bi bi-box-seam nav_icon"></i>--%>
                <%--                <span class="nav_name">Files</span> </a><a href="#" class="nav_link">--%>
                <%--                <i class='bx bx-bar-chart-alt-2 nav_icon'></i>--%>
                <%--                    <span class="nav_name">Stats</span> </a>--%>
            </div>
        </div>
        <a href="#" class="nav_link"> <i class='bx bx-log-out nav_icon'></i> <span
                class="nav_name">SignOut</span> </a>
    </nav>
</div>
<!--Container Main start-->
<div class="height-100 bg-light">
    <div class="container-fluid mt-5">
        <jsp:include page="${ view }"/>
    </div>
</div>

<c:if test="${check eq false}">
    <script>
        alert("Xóa thất bại, khi đã có một đối tượng khác dùng đối tượng này!");
    </script>
</c:if>
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="/Assignment_war_exploded/views/admin/js/input.js"></script>
<script src="/Assignment_war_exploded/views/admin/js/admin.js"></script>

</body>
</html>