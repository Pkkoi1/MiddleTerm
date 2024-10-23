<%@ page import="fit.edu.de1.models.Thuoc" %>
<%@ page import="fit.edu.de1.models.LoaiThuoc" %>
<%@ page import="fit.edu.de1.dao.QuanLyThuocDao" %>
<%@ page import="fit.edu.de1.dao.QuanLyLoaiThuocDao" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: DANG KHOI
  Date: 10/23/2024
  Time: 2:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DanhSachThuoc</title>
</head>
<body>
<h1 style="text-align: center">Danh sach thuoc</h1>

<div>
    <a href="controller?action=showThuoc">Danh sach thuoc </a>|
    <a href="controller?action=showLoaiThuoc">Danh sách loại thuốc </a>|
    <a href="controller?action=showThemThuoc">Thêm thuốc mới</a>
</div>
<%
    List<Thuoc> allThuocList = (List<Thuoc>) request.getAttribute("listThuoc");
    List<LoaiThuoc> allLoaiThuocList = (List<LoaiThuoc>) request.getAttribute("loaiThuocList");

%>

<!-- Table for all Thuoc -->
<table width="70%" align="center" border="1">
    <tr>
        <th>STT</th>
        <th>Ten thuoc</th>
        <th>Gia</th>
        <th>Nam san xuat</th>
        <th>Loai Thuoc</th>
    </tr>
    <%
        int i = 1;
        for (Thuoc thuoc : allThuocList) {
    %>
    <tr>
        <td><%= i++ %>
        </td>
        <td><%= thuoc.getTenThuoc() %>
        </td>
        <td><%= thuoc.getGia() %>
        </td>
        <td><%= thuoc.getNamSx() %>
        </td>
        <td><%= thuoc.getMaLoai().getTenLoai() %>
        </td>
    </tr>
    <% } %>
</table>

<!-- Form to select LoaiThuoc -->
<form method="GET" action="controller">
    <input type="hidden" name="action" value="getDSThuocByLoaiThuoc">
    <select name="tenLoai">
        <option name="tenLoai" value="all">All</option>
        <% for (LoaiThuoc loaiThuoc : allLoaiThuocList) { %>
        <option name="tenLoai" value="<%= loaiThuoc.getMaLoai() %>"><%= loaiThuoc.getTenLoai() %>
        </option>
        <% } %>
    </select>
    <input type="submit" value="Filter">
</form>
</body>
</html>