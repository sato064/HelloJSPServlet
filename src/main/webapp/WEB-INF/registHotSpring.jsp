<%@ page import="model.Sample" %> 
<%@ page import="java.util.ArrayList"%> 
<%@ page import = "java.util.List" %> 
<% List<Sample> sampleList = (ArrayList<Sample>)request.getAttribute("sampleList"); %> 
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <body>
    <h1 align="center">登録するぞ〜！</h1>
    <form action="./RegistHotSpring" method="post">
      <input type="text" placeholder="名前" name="name" required/><br>
      <input type="number" placeholder="星" min="1" max="5" name="star" required/><br>
      <input type="text" placeholder="コメント" name="comment"/><br>
      <a href="./index.jsp">戻る</a>
      <input type="submit" value="登録" name="regist" /><br>
    </form>
  </body>
</html>
