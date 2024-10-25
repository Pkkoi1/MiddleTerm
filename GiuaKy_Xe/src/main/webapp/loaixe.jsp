<%@ page import="iuh.fit.giuaKy_xe.models.Loaixe" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Set" %>
<%@ page import="iuh.fit.giuaKy_xe.models.Xe" %>
<%@ page import="java.text.Format" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.util.HashSet" %><%--
  Created by IntelliJ IDEA.
  User: DANG KHOI
  Date: 10/25/2024
  Time: 6:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Xe</title>
    <%
        List<Loaixe> list = (List<Loaixe>) request.getAttribute("listTypeVehicle");
        Set<Xe> listVehicle = (Set<Xe>) request.getAttribute("listVehicle");
        Format formatter = new DecimalFormat("#,###");
    %>
</head>
<body>
<div style="align-content: center; align-items: center">
    <h1>Danh sách loaại xe</h1>
    <table width="70%" align="center" border="1">
        <tr>
            <th>STT</th>
            <th>Tên loại xe</th>
        </tr>
        <% int i = 1;
            for (Loaixe loaixe : list) { %>
        <tr>
            <td><%= i++ %>
            </td>
            <td><%= loaixe.getTenLoai() %>
            </td>
            <td>
                <a href="controller?action=showVehicleByType&id=<%=loaixe.getId()%>">Danh sách xe</a>
            </td>
        </tr>
        <% } %>
    </table>
    <h1>Danh sách xe</h1>
    <table width="70%" align="center" border="1">
        <tr>
            <th>STT</th>
            <th>Tên xe</th>
            <th>Loại</th>
            <th>Giá</th>
            <th>Năm sản xuất</th>
        </tr>
        <% if (listVehicle == null) {
            listVehicle = new HashSet<>();
        }
            int n = 1;
            for (Xe xe : listVehicle) { %>
        <tr>
            <td><%= n++ %>
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
