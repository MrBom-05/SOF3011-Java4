<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 3/21/2023
  Time: 11:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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