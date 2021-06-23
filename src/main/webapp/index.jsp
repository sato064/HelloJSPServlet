<%@ page import="model.Sample" %> 
<%@ page import="java.util.ArrayList"%> 
<%@ page import = "java.util.List" %> 
<% List<Sample> sampleList = (ArrayList<Sample>)request.getAttribute("sampleList"); %> 
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <body>
    <h1 align="center">Hello JSP/Servlet!</h1>
    <a href="./RegistHotSpring">温泉の登録</a>
  </body>
</html>
