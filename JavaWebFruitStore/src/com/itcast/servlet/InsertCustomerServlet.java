package com.itcast.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itcast.dao.InsertCustomer;
import com.itcast.pojo.Customer;

//��������û��ķ������˵�Servletģ��InsertCustomerServlet
public class InsertCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsertCustomerServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("��������û���...");
		// ��ȡ�û���������Ϣ
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String address = request.getParameter("address");
		String telephone = request.getParameter("telephone");
		// �����û�������Ϣ�Ĳ���
		int i = new InsertCustomer().insertCustomer(new Customer(name, password, sex, address, telephone));
		// �Բ�����Ϣ�Ľ�������ж�
		if (i != -1) {
			System.out.println("�û���Ϣ����ɹ�!");
		} else {
			System.out.println("�û���Ϣ����ʧ��!");
		}
		request.setAttribute("welcome", "�û�" + name + "ע��ɹ�!");
		// ת����ˮ���������
		request.getRequestDispatcher("managerFruitServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
