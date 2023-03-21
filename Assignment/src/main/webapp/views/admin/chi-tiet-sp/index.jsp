<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 3/12/2023
  Time: 8:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<html>

<h2 class="mt-3">Quản Lý Chi Tiết Sản Phẩm</h2>

<a href="/Assignment_war_exploded/admin/chi-tiet-sp/create" class="btn btn-success mt-3">Add</a>

<c:if test="${ f:length(list) == 0 }">
    <h4 class="text-center">Không có dữ liệu</h4>
</c:if>

<c:if test="${ f:length(list) != 0 }">

    <table class="table table-bordered mt-5">
        <thead>
        <tr>
            <th>STT</th>
            <th>Mã</th>
            <th>Tên</th>
            <th>NSX</th>
            <th>Màu Sắc</th>
            <th>Dòng SP</th>
            <th>Năm SX</th>
            <th>Mô Tả</th>
            <th>Số Lượng</th>
            <th>Giá Nhập</th>
            <th>Giá Bán</th>
            <th class="col-2 text-center">Action</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="chiTietSP" items="${ list }" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${ chiTietSP.ma }</td>
                <td>${ chiTietSP.ten }</td>
                <td>${ chiTietSP.nsx }</td>
                <td>${ chiTietSP.mauSac }</td>
                <td>${ chiTietSP.dongSP }</td>
                <td>${ chiTietSP.namSX }</td>
                <td>${ chiTietSP.moTa }</td>
                <td>${ chiTietSP.soLuongTon }</td>
                <td>${ chiTietSP.giaNhap }</td>
                <td>${ chiTietSP.giaBan }</td>

                <td class="text-center">
                    <a href="/Assignment_war_exploded/admin/chi-tiet-sp/edit?id=${ chiTietSP.id }"
                       class="btn btn-primary">Update</a>
                    <a href="/Assignment_war_exploded/admin/chi-tiet-sp/delete?id=${ chiTietSP.id }"
                       class="btn btn-danger delete">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

<script>
    const deleteButton = document.querySelector(".delete");
    deleteButton.addEventListener("click", function (event) {
        event.preventDefault(); // Prevent the default behavior of the link

        // Display a confirmation dialog
        const confirmed = confirm("Bạn có muốn xóa không?");

        if (confirmed) {
            // If the user confirmed, redirect to the delete URL
            const deleteUrl = this.href;
            window.location.href = deleteUrl;
        } else {
            // If the user cancelled, do nothing
            return false;
        }
    });
</script>

