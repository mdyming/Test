<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>

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
            function c()
            {
                document.formAdd.submit();
            }
        </script>
</head>

<body leftmargin="8" topmargin="8" background='<%=path %>/img/allbg.gif'>
	<form action="<%=path %>/xuefeiAdd.action" name="formAdd" method="post">
		<table width="80%" border="0" cellpadding="4" cellspacing="1"
			bgcolor="#CBD8AC">
			<tr bgcolor="#EEF4EA">
				<td colspan="3" background="<%=path %>/img/wbg.gif" class='title'><span>&nbsp;</span></td>
			</tr>
			<tr align='center' bgcolor="#FFFFFF"
				onMouseMove="javascript:this.bgColor='red';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<td width="10%" bgcolor="#FFFFFF" align="right">学费年度：</td>
				<td width="90%" bgcolor="#FFFFFF" align="left"><select
					class="INPUT_text" name="niandu"
					style="height: 20px; width: 204px;">
						<option value="2022-2023">2022-2023</option>
						<option value="2023-2024">2023-2024</option>
				</select></td>
			</tr>
			<tr align='center' bgcolor="#FFFFFF"
				onMouseMove="javascript:this.bgColor='red';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<td width="10%" bgcolor="#FFFFFF" align="right">缴费金额：</td>
				<td width="90%" bgcolor="#FFFFFF" align="left"><input
					type="text" name="jine" style="width: 200px;" value="5000"
					onkeyup="value=value.replace(/[^\d]/g,'') "
					onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" />
				</td>
			</tr>
			<tr align='center' bgcolor="#FFFFFF"
				onMouseMove="javascript:this.bgColor='red';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<td width="10%" bgcolor="#FFFFFF" align="right">缴费时间：</td>
				<td width="90%" bgcolor="#FFFFFF" align="left"><input
					type="text" name="shijian" style="width: 200px;"
					value="<%=new SimpleDateFormat("yyyy-MM-dd").format(new Date())%>" />
				</td>
			</tr>
			<tr align='center' bgcolor="#FFFFFF"
				onMouseMove="javascript:this.bgColor='red';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<td width="10%" bgcolor="#FFFFFF" align="right">&nbsp;</td>
				<td width="90%" bgcolor="#FFFFFF" align="left"><input
					type="hidden" name="xueshengId"
					value="<%=request.getParameter("xueshengId") %>" /> <input
					type="button" value="提交" onclick="c()" />&nbsp; <input type="reset"
					value="重置" />&nbsp;</td>
			</tr>
		</table>
	</form>
</body>
</html>
