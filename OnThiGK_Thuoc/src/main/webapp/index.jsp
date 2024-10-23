<%--
  Created by IntelliJ IDEA.
  User: DANG KHOI
  Date: 10/23/2024
  Time: 1:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quan li thuoc</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;

        }

        td {
            width: 50%;
            text-align: center;

        }

        table, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <td>
            <h1>Quan li thuoc</h1>
        </td>
    </tr>
    <tr>
        <td>
            <a href="controller?action=showThuoc">Danh sach thuoc </a>|
            <a href="controller?action=showLoaiThuoc">Danh sách loại thuốc </a>|
            <a href="controller?action=showThemThuoc">Thêm thuốc mới</a>
        </td>
    </tr>
</table>
</body>
</html>