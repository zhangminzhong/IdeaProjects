<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 16-9-30
  Time: 下午4:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title></title>
</head>
<body>
     <form action="test/toPerson8.do" method="post" enctype="multipart/form-data">
        name: <input name="name" type="text"> <br>
        age: <input name="age" type="text">  <br>
        address: <input name="address" type="text">  <br>
        birthday: <input name="birthday" type="text">   <br>
        pic:<input name="pic" type="file"><br>
         <input name="tijiao" type="submit" value="提交" >   <br>
     </form>
</body>
</html>