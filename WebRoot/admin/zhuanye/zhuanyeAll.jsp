<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
<meta http-equiv="description" content="This is my page" />

<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />

<script language="javascript">
            function a(id,mingcheng)
            {
                 var str=new Array(2);
                 str[0]=id;
                 str[1]=mingcheng;
           		 window.returnValue = str;
           		 window.close();
            }
        </script>
</head>

<body style="margin: 0px;">
	<table width="100%" border="0" cellpadding="2" cellspacing="1"
		bgcolor="#D1DDAA">
		<tr bgcolor="#E7E7E7">
			<td height="14" colspan="41" background="<%=path %>/img/tbg.gif"
				align="center" style="color: red; font-family: 微软雅黑">点击名称即可选择</td>
		</tr>
		<tr align="center" bgcolor="#FAFAF1" height="22">
			<td width="5%">序号</td>
			<td width="20%">专业名称</td>
		</tr>
		<c:forEach items="${requestScope.zhuanyeList}" var="zhuanye"
			varStatus="ss">
			<tr align='center' bgcolor="#FFFFFF"
				onMouseMove="javascript:this.bgColor='red';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<td bgcolor="#FFFFFF" align="center">${ss.index+1}</td>
				<td bgcolor="#FFFFFF" align="center"><a href="#"
					onclick="a('${zhuanye.id}','${zhuanye.mingcheng}')"
					style="color: green; font-family: 微软雅黑; font-size: 15px;">${zhuanye.mingcheng}</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
