<%@ page import="iuh.fit.models.Candidate" %>
<%@ page import="java.util.List" %>
<%@ page import="iuh.fit.models.Experience" %><%--
  Created by IntelliJ IDEA.
  User: DANG KHOI
  Date: 10/24/2024
  Time: 5:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Candidate Details</title>
</head>
<body>
<%
    Candidate candidate = (Candidate) request.getAttribute("candidate");
    List<Experience> listExp = (List<Experience>) request.getAttribute("listExperience");
%>
<table width="70%" align="center" border="1">
    <tr>
        <th><%= candidate.getFullName()%>
        </th>
        <th><%= candidate.getEmail()%>
        </th>
        <th><%= candidate.getPhone()%>
        </th>
    </tr>
    <tr>
        <th>STT</th>
        <th>Company</th>
        <th>From Date</th>
        <th>Role</th>
        <th>To Date</th>
        <th>Work Description</th>
    </tr>

    <% int i = 1;
        for (Experience exp : listExp) { %>
    <tr>
        <td><%= i++ %>
        <td><%= exp.getCompany()%>
        </td>
        <td><%= exp.getFromDate()%>
        </td>
        <td><%= exp.getRole()%>
        </td>
        <td><%= exp.getToDate()%>
        </td>
        <td><%= exp.getWorkDesc()%>
        </td>
    </tr>
    <% } %>

</table>
</body>
</html>
