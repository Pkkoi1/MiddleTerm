<%@ page import="java.util.List" %>
<%@ page import="fit.edu.de1.models.LoaiThuoc" %><%--
  Created by IntelliJ IDEA.
  User: DANG KHOI
  Date: 10/23/2024
  Time: 3:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Thêm thuốc mới</title>
</head>
<body>
<h1>Thêm thuốc</h1>
<%
    List<LoaiThuoc> list = (List<LoaiThuoc>) request.getAttribute("loaiThuocList");
%>
<form action="controller" method="post">
    <table>
        <tr>
            <td>Tên thuốc</td>
            <td><input type="text" name="tenThuoc"></td>
        </tr>
        <tr>
            <td>Giá</td>
            <td><input type="text" name="donGia"></td>
        </tr>
        <tr>
            <td>Năm sản xuất</td>
            <td><input type="text" name="namSX"></td>
        </tr>
        <tr>
            <td>Loại thuốc</td>
            <td>
                <select name="maLoai">
                    <% for (LoaiThuoc loaiThuoc : list) { %>
                    <option value="<%= loaiThuoc.getMaLoai() %>"><%= loaiThuoc.getTenLoai() %>
                    </option>
                    <% } %>
                </select>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Thêm"></td>
        </tr>
    </table>
    <input type="hidden" name="action" value="addThuoc">
</form>
</body>
</html>
