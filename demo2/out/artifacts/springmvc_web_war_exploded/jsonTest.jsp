<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 16-10-8
  Time: 下午4:05
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

    <title>json交互测试</title>
    <script type="text/javascript" src="jquery-1.10.2/jquery-1.10.2.js"></script>
    <script>
       //请求json，输出json
       function requestJson(){
           var postData={"name":"手机","price":999};
           var postData1={s:JSON.stringify(postData)};
           $.post("requestJson/getJson1.do",postData1,function(data){
               alert(data);
           });
           /*$.ajax({
               type:"post",
               url:"requestJson/getJson.do",
               contentType: 'application/json',
               dataType:"json",
               data:JSON.stringify(postData),
               success:function(data){
                    alert(data);
               }
           });*/
       }
       //请求key/value，输出json
       function responseJson(){
           var postData={"name":"手机","price":999};

           $.ajax({
               type:"post",
               url:"requestJson/getKeyValueJson.do",
               data:"name=手机&price=999",
               success:function(data){
                   alert(data);
               }
           });
       }
    </script>
</head>
<body>
     <input type="button" onclick="requestJson()" value="请求json，输出json">
     <input type="button" onclick="responseJson()" value="请求key/value，输出json">
</body>
</html>