<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<LINK rel=stylesheet type=text/css href="<%=path %>/css/login.css">

<script type='text/javascript'
	src='<%=path %>/dwr/interface/loginService.js'></script>
<script type='text/javascript' src='<%=path %>/dwr/engine.js'></script>
<script type='text/javascript' src='<%=path %>/dwr/util.js'></script>

<script language="javascript">
		function check1()
		{    
		     if(document.ThisForm.userName.value=="")
			 {
			 	alert("请输入用户名");
				document.ThisForm.userName.focus();
				return false;
			 }
			 if(document.ThisForm.userPw.value=="")
			 {
			 	alert("请输入密码");
				document.ThisForm.userPw.focus();
				return false;
			 }
			 
			 loginService.login(document.ThisForm.userName.value,document.ThisForm.userPw.value,document.ThisForm.userType.value,callback);
		}
		
		function callback(data)
		{
		    if(data=="no")
		    {
		        alert("用户名或密码错误");
		    }
		    if(data=="yes")
		    {
		        alert("通过验证,系统登录成功");
		        window.location.href="<%=path %>/loginSuccess.jsp";
		    }
		    
		}
	    </script>
</head>
<body>
	<DIV class=lo-top></DIV>
	<DIV class=lo-box>
		<DIV class=lo-main>
			<UL id=lo-ul>
				<LI><IMG src="<%=path %>/images/lo_left.gif"></LI>
				<LI>
					<P class=warning>
						<LABEL id=Label1>&nbsp;</LABEL>
					</P>
					<FORM method="post" action="111" name="ThisForm"
						style="margin-left: 11px; margin-top: 11px;">
						<table border="0" cellpadding="6" cellspacing="6">
							<tr>
								<td align="left" style="font-size: 25px;" colspan="2"><span
									style="margin-left: 15px;"></span></td>
							</tr>

							<tr>
								<td style="width: 40px; font-family: 微软雅黑" align="right">
									账号：</td>
								<td align="left"><input name="userName" type="text"
									style="width: 200px;" /></td>
							</tr>
							<tr>
								<td style="width: 40px; font-family: 微软雅黑" align="right">
									密码：</td>
								<td align="left"><input name="userPw" type="text"
									style="width: 200px;" /></td>
							</tr>
							<tr>
								<td style="width: 40px; font-family: 微软雅黑" align="right">
									类型：</td>
								<td align="left"><select class="INPUT_text" name="userType"
									style="width: 205px;">
										<option value="0">管理员</option>
										<option value="2">学生</option>
								</select></td>
							</tr>
							<tr align='center'>
								<td style="width: 40px;" align="left"></td>
								<td align="left"><input name="button" type="button"
									class="button" id="Submit" value="登 陆" style="width: 100px;"
									onclick="check1()"> <input type="reset" value="重置"
									style="width: 100px;" />&nbsp;</td>
							</tr>
						</table>


					</FORM>
				</LI>
			</UL>
		</DIV>
	</DIV>
</BODY>
</html>
