<!--

 This component and its source code representation are copyright protected
 and proprietary to The Trivera Group, Inc., Worldwide D/B/A Trivera Technologies
 
 This component and source code may be used for instructional and
 evaluation purposes only. No part of this component or its source code
 may be sold, transferred, or publicly posted, nor may it be used in a
 commercial or production environment, without the express written consent
 of the Trivera Group, Inc.
 
 Copyright (c) 2011 The Trivera Group, LLC.
 http://www.triveratech.com   http://www.triveragroup.com
 </p>
 @author The Trivera Group Tech Team.

-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
  <title>Add a new DVD</title>
</head>
<body>
<!-- todo declare a form (action and method parameter) -->
<form action="AddDVD.form" method="post">
  <table>
    <tr>
      <!-- todo for each property on the DVD (id, title, actors and releaseYear)
           add a row with a label and an input field bound to the appropriate command property
      -->
      <td>
        DVD id
      </td>
      <td>
        <spring:bind path="command.id">
          <input name="id" value="${status.value}"/>
          
        </spring:bind>
      </td>
    </tr>
    <tr>
      <td>
        Title
      </td>
      <td>
        <spring:bind path="command.title">
          <input name="title" value="${status.value}"/>
          
        </spring:bind>
      </td>
    </tr>

    <tr>
      <td>
        Actors
      </td>
      <td>
        <spring:bind path="command.actors">
          <input name="actors" value="${status.value}"/>
         
        </spring:bind>
      </td>
    </tr>


    <tr>
      <td>
        Release Year
      </td>
      <td>
        <spring:bind path="command.releaseYear">
          <input name="releaseYear" value="${status.value}"/>
          
        </spring:bind>
      </td>
    </tr>
    <tr>
      <td>
        <input type="submit"/>
      </td>
    </tr>
  </table>
</form>
</body>
</html>