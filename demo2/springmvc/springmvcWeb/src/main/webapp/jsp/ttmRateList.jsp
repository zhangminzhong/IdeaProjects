<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 16-9-30
  Time: 下午4:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ page import="java.net.*,java.util.*" %>
<%@ page import="com.springmvc.model.TTMRate" %>
<html>
<head>
    <title></title>
</head>
<body>
     <table width="517" border="1" align="center" cellpadding="0" cellspacing="0">
         <tr><td>当日评价汇率</td><td>Currency Pair</td><td>TTM RATE</td></tr>
         <% List<TTMRate> list = (List<TTMRate>) request.getAttribute("ttmRates");%>
         <% for (int i=0;i<list.size();i++){
             TTMRate ttmRate = list.get(i);%>
             <tr></tr><td><%=ttmRate.getValue()%></td><td><%=ttmRate.getCurrencyPair()%></td><td><%=ttmRate.getFrontDate()%></td></tr>
         <%}%>
     </table>
</body>
</html>