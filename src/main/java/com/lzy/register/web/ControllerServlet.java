package com.lzy.register.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lzy.register.dao.UserDao;
import com.lzy.register.domain.RegisterFormBean;
import com.lzy.register.domain.UserBean;

public class ControllerServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Content-type", "text/htm;charset=GBK");// 通知浏览器用解码
		response.setCharacterEncoding("GBK");// 设置httpservletResponse使用编码
		// 获取用户注册时提交的参数
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String email = request.getParameter("email");
		// 在此暂停
		/*
		 * try { Thread.sleep(10000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); };
		 */
		// response.getWriter().write(name+""+password);
		// 将参数封装到RegisterformBean中，检测 html+js 在js中直接判定
		RegisterFormBean formBean = new RegisterFormBean();
		formBean.setEmail(email);
		formBean.setName(name);
		formBean.setPassword(password);
		formBean.setPassword2(password2);
		// 判断flag的值，false就重写
		if (!formBean.validate()) {
			request.setAttribute("formBean", formBean);
			request.getRequestDispatcher("/client/login.jsp").forward(request, response);
			return;
		}
		// 参数满足要求 连接数据库保存起来 这个数据库没有严格去设定
		UserBean userBean = new UserBean();
		userBean.setName(name);
		userBean.setPassword(password);
		userBean.setEmail(email);
		// 调用UserDao进行用户添加
		boolean b = UserDao.insert(userBean);
		if (b) {
			response.getWriter().print("恭喜你注册成功，3秒钟自动跳转");
			// 将成功注册的用户信息添加到Session中
			request.getSession().setAttribute("userBean", userBean);
			// 注册成功后，3秒跳转到登录成功页面loginSuccess.jsp
			response.setHeader("refresh", "3;url=client/loginSuccess.jsp");
		}

	}
}
