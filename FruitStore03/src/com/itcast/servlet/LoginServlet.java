package com.itcast.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.itcast.pojo.Customer;
import com.itcast.server.CheckCustomer;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("LoginServlet run ...<br />");
		// ��ȡ������Ϣ�е��û���
		String name = request.getParameter("name");
		// ��ȡ������Ϣ�е��û�����
		String password = request.getParameter("password");
		// ����server���У���û���Ϣ
		Customer customer = new CheckCustomer().checkCustomer(name, password);
		// �ж��Ƿ��¼
		if (customer == null) {
			out.println("�û� " + name + "δע��, ����<b><a href=\"source/register.jsp\">&nbsp;ע��</a></b>");
		} else if (customer.getPassword() == null) {
			out.println("�û� " + name + "���������!<h4><a href=\"source/login.jsp\">&nbsp;���µ�¼</a></h4>");
		} else {
			//ת����ˮ������ɫServlet�������˳���ManagerFruitServlet
			request.getRequestDispatcher("managerFruitServlet").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
