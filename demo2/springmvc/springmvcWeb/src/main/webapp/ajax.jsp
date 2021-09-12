<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 16-10-8
  Time: 下午4:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">

    <title></title>
    <script type="text/javascript" src="jquery-1.10.2/jquery-1.10.2.js"></script>
    <script>
        $(function(){
            $("#mybutton").click(function(){
                $.ajax({
                    url:"test/ajax1.do",
                    type:"post",
                    dataType:"Text",
                    data:{
                        name:"zhangsan"
                    },
                    success:function(responseText){
                        alert(responseText);
                    },
                    error:function(){
                        alert("System error")
                    }
                });
            });
        });
    </script>
</head>
<body>
    <input id="mybutton" type="submit" value="提交"/>
</body>
</html>