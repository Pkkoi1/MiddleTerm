<%@ page import="java.util.List" %>
<%@ page import="iuh.fit.giuaKy_xe.models.Loaixe" %><%--
  Created by IntelliJ IDEA.
  User: DANG KHOI
  Date: 10/25/2024
  Time: 6:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Xe</title>
    <%
        List<Loaixe> list = (List<Loaixe>) request.getAttribute("listTypeVehicle");
    %>
</head>
<body>
<form method="post" action="controller">
    <table>
        <tr>
            <td>Tên xe</td>
            <td><input type="text" name="tenXe"></td>
        </tr>
        <tr>
            <td>Giá</td>
            <td><input type="text" name="gia"></td>
        </tr>
        <tr>
            <td>Năm sản xuất</td>
            <td><input type="text" name="namSx"></td>
        </tr>
        <tr>
            <td>Loại xe</td>
            <td>
                <select name="maLoai">
                    <% for (Loaixe loaixe : list) { %>
                    <option value="<%= loaixe.getId() %>"><%= loaixe.getTenLoai() %>
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
    <input type="hidden" name="action" value="addNewVehicle">
</form>
</body>
</html>
