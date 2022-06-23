<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
            function check()
            {
                document.formAdd.submit();
            }
            
            function zhuanyeAll()
		    {
		       	var strUrl = "<%=path %>/zhuanyeAll.action";
				var ret = window.showModalDialog(strUrl,"","dialogWidth:700px; dialogHeight:300px; dialogLeft: status:no; directories:yes;scrollbars:yes;Resizable=no;");
			    document.getElementById("zhuanyeId").value=ret[0];
                document.getElementById("xxx").value=ret[1];
		    }
        </script>
</head>

<body leftmargin="2" topmargin="9" background='<%=path %>/img/allbg.gif'>
	<form action="<%=path %>/xueshengRes.action" name="formAdd"
		method="post">
		<table width="98%" border="0" cellpadding="2" cellspacing="1"
			bgcolor="#D1DDAA" align="center" style="margin-top: 8px">
			<tr bgcolor="#E7E7E7">
				<td height="14" colspan="3" background="<%=path %>/img/tbg.gif">&nbsp;&nbsp;</td>
			</tr>
			<tr align='center' bgcolor="#FFFFFF"
				onMouseMove="javascript:this.bgColor='red';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<td width="10%" bgcolor="#FFFFFF" align="right">专业：</td>
				<td width="90%" bgcolor="#FFFFFF" align="left"><input
					type="text" name="xxx" id="xxx" style="width: 326px;"
					readonly="readonly" /> <input type="hidden" name="zhuanyeId"
					id="zhuanyeId" readonly="readonly" value="0" style="width: 326px;" />
					<input type="button" value="选择" onclick="zhuanyeAll()" /></td>
			</tr>
			<tr align='center' bgcolor="#FFFFFF"
				onMouseMove="javascript:this.bgColor='red';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<td width="10%" bgcolor="#FFFFFF" align="right">学号：</td>
				<td width="90%" bgcolor="#FFFFFF" align="left"><input
					type="text" name="xuehao" size="60" /></td>
			</tr>
			<tr align='center' bgcolor="#FFFFFF"
				onMouseMove="javascript:this.bgColor='red';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<td width="10%" bgcolor="#FFFFFF" align="right">姓名：</td>
				<td width="90%" bgcolor="#FFFFFF" align="left"><input
					type="text" name="xingming" size="60" /></td>
			</tr>
			<tr align='center' bgcolor="#FFFFFF"
				onMouseMove="javascript:this.bgColor='red';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<td width="10%" bgcolor="#FFFFFF" align="right">&nbsp;</td>
				<td width="90%" bgcolor="#FFFFFF" align="left"><input
					type="button" value="提交" onclick="check()" />&nbsp; <input
					type="reset" value="重置" />&nbsp;</td>
			</tr>
		</table>
	</form>
</body>
</html>
