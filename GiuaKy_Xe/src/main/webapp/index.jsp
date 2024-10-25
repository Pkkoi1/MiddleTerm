<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Xe</title>
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
<table style="text-align: center">
    <tr>
        <th>
            21042951-PhamDangKhoi
        </th>
    </tr>
    <tr>
        <td>
            <a href="controller?action=showTypeVehicle">Danh sách các loại xe </a>|
            <a href="controller?action=showVehicles">Danh sách xe </a>|
            <a href="controller?action=addVehicle">Thêm xe mới</a>
        </td>
    </tr>
</table>
</body>
</html>