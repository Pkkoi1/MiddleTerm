<%@ page import="iuh.fit.enums.Roles" %>
<%@ page import="java.util.Set" %>
<%@ page import="iuh.fit.models.Candidate" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: DANG KHOI
  Date: 10/24/2024
  Time: 5:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Report1</title>
</head>
<body>
<form action="controller" method="get" style="margin: 10px">
    <input type="hidden" name="action" value="viewRoles">
    <%
        Roles[] roles = Roles.values();
        List<Candidate> list = (List<Candidate>) request.getAttribute("listCandidate");
    %>
    <select name="role">
        <option value="ALL">ALL</option>
        <% for (Roles role : roles) { %>
        <option value="<%= role.getValue() %>"><%= role.name() %>
        </option>
        <% } %>
    </select>
    <input type="submit" value="View">View
</form>

<table width="70%" align="center" border="1">
    <tr>
        <th>STT</th>
        <th>Tên ứng viên</th>
        <th>Email</th>
        <th>Điện thoại</th>
        <th>Chi tiết</th>
    </tr>
    <tr><%
          if(list != null) {
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
    <% }
    } %>
</table>
</body>
</html>
