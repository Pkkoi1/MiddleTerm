<%@ page import="iuh.fit.giuaKy_xe.models.Xe" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.text.Format" %>
<%@ page import="java.text.DecimalFormat" %><%--
  Created by IntelliJ IDEA.
  User: DANG KHOI
  Date: 10/25/2024
  Time: 6:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Xe</title>
    <%
        Set<Xe> list = (Set<Xe>) request.getAttribute("listVehicle");
        Format formatter = new DecimalFormat("#,###");
    %>
</head>
<body>
<div style="align-content: center; align-items: center">
    <h1>Danh sách xe</h1>
    <a href="controller?action=showTypeVehicle">Danh sách loại xe</a>
    <table width="70%" align="center" border="1">
        <tr>
            <th>STT</th>
            <th>Tên xe</th>
            <th>Loại</th>
            <th>Giá</th>
            <th>Năm sản xuất</th>
        </tr>
        <% int i = 1;
            for (Xe xe : list) { %>
        <tr>
            <td><%= i++ %>
            </td>
            <td><%= xe.getTenXe() %>
            </td>
            <td><%= xe.getMaLoai().getTenLoai() %>
            </td>
            <td><%= formatter.format(xe.getGia()) %>
            </td>
            <td><%= xe.getNamSx() %>
            </td>
        </tr>
        <% } %>
    </table>
</div>
</body>
</html>
