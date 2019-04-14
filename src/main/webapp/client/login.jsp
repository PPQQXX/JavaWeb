<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<body>
	model2思想实现用户注册 MVC
	<form action="ControllerServlet" method="post">
		用户注册
				<div>
					姓名：
					<input type="text" name="name" value="${formBean.name}" />
					<!-- //value用来保存输入的用户名，错误时不用再次输入 -->
					<span>${formBean.errors.name}</span>
				</div>

				<div>
					密码：
					<input type="password" name="password" />
					<span>${formBean.errors.password}</span>
				</div>
				
				<div>
					确认密码:
					<input type="password" name="password2" />
					<span>${formBean.errors.password2}</span><!-- //错误时提示 -->
				</div>
				
				<div>
					邮箱:
					<input type="text" name="email" value="${formBean.email }" />
					<span>${formBean.errors.email}</span>

				</div>
				<div id="bt">
					<input type="reset" value="重置 " />
					<input type="submit" value="注册" />
				</div>
	    </form>
</body>
</html>
