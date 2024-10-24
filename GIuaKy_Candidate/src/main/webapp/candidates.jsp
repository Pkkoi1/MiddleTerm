<%@ page import="iuh.fit.models.Candidate" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: DANG KHOI
  Date: 10/24/2024
  Time: 4:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ứng viên</title>
</head>
<body>
<%
    List<Candidate> list = (List<Candidate>) request.getAttribute("listCandidate");

%>
<table>
    <tr>
        <th>STT</th>
        <th>Tên ứng viên</th>
        <th>Email</th>
        <th>Điện thoại</th>
        <th>Chi tiết</th>
    </tr>
    <tr>
            <%
        int i = 1;
        for (Candidate candidate : list) {
    %>
    <tr>
        <td><%= i++ %>
        </td>
        <td><%= candidate.getFullName() %>
        </td>
        <td><%= candidate.getEmail() %>
        </td>
        <td><%= candidate.getPhone() %>
        </td>
        <td><a href="controller?action=showDetail&id=<%=candidate.getId()%>">Chi tiết</a></td>
    </tr>
    <% } %>
</table>
</body>
</html>
