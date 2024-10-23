<%@ page import="java.util.Set" %>
<%@ page import="fit.edu.de1.models.LoaiThuoc" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: DANG KHOI
  Date: 10/23/2024
  Time: 2:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh Sách Loại Thuốc</title>
</head>
<%
    List<LoaiThuoc> list = (List<LoaiThuoc>) request.getAttribute("loaiThuocList");
%>
<body>
<h1 style="text-align: center">Danh sach loai thuoc</h1>
<form>
    <table width="70%" align="center" border="1">
        <tr>
            <th>STT</th>
            <th>Ten loai</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        <%
            int i = 1;
            for (LoaiThuoc loaiThuoc : list) {
        %>
        <tr>
            <td><%= i++%>
            </td>
            <td><%= loaiThuoc.getTenLoai() %>
            </td>
            <td><a href="controller?action=showUpdateLoaiThuoc&id=<%= loaiThuoc.getMaLoai()%>">Update</a>
            </td>
            <td><a href="controller?action=deleteLoaiThuoc&id=<%= loaiThuoc.getMaLoai()%>">Delete</a>
            </td>
        </tr>
        <%
            }
        %>
    </table>
    <%--    <a href="controller?action=showLoaiThuoc">Them loai thuoc</a>--%>
</form>
</body>
</html>
