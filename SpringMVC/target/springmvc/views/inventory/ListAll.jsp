
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<head>
  <title>DVD Listing</title>
</head>
<body>

<p>Below is a list of the DVDs in the system</p>

<table>
  <tbody>
     <c:forEach items="${catalog}" var="dvdinfo">
      <tr>
        <td>
             <a href="details.view?dvdID=${dvdinfo.id}">${dvdinfo.title}</a>
        </td>
      </tr>
    </c:forEach>
  </tbody>
</table>

</body>
</html>