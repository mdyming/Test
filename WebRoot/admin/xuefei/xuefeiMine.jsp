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

<script language="JavaScript" src="<%=path %>/js/public.js"
	type="text/javascript"></script>

<script language="javascript">
            
        </script>
</head>

<body leftmargin="8" topmargin="8" background='<%=path %>/img/allbg.gif'>
	<table width="70%" border="0" cellpadding="2" cellspacing="1"
		bgcolor="#D1DDAA">
		<tr bgcolor="#E7E7E7">
			<td height="14" colspan="14" background="<%=path %>/img/tbg.gif">&nbsp;</td>
		</tr>
		<tr align="center" bgcolor="#FAFAF1" height="22">
			<td width="4%">序号</td>
			<td width="10%">年度</td>
			<td width="10%">金额</td>
			<td width="10%">缴费时间</td>
		</tr>
		<c:forEach items="${requestScope.xuefeiList}" var="xuefei"
			varStatus="sta">
			<tr align='center' bgcolor="#FFFFFF"
				onMouseMove="javascript:this.bgColor='red';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<td bgcolor="#FFFFFF" align="center">${sta.index+1}</td>
				<td bgcolor="#FFFFFF" align="center">${xuefei.niandu}</td>
				<td bgcolor="#FFFFFF" align="center">${xuefei.jine}</td>
				<td bgcolor="#FFFFFF" align="center">${xuefei.shijian}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
