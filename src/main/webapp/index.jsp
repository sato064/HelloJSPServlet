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
    <a href="./ShowHotspring">温泉の情報を見る</a>
  </body>
</html>
