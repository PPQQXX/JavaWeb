<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login success!!</title>
    </head>
    <body>
    	 <%
		    if (session.getAttribute("userBean") == null) {
	    %>
	    <jsp:forward page="register.jsp" />
	    <%
		    return;
		    }
	    %>
	    <div id="main">
		    <div id="welcome">恭喜你，登录成功</div>
             <hr />
		    <div>您的信息</div>
		    <div>
			    <ul>
				    <li>您的姓名:${userBean.name }</li>
				    <li>您的邮箱:${userBean.email }</li>
			    </ul>
		    </div>
	    </div>
 	</body>
</html>