package com.itcast.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itcast.dao.DeleteFruit;
//ɾ��ˮ����Ϣ�ķ�������Servletģ��DeleteFruitServlet
public class DeleteFruitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteFruitServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("�������˳��� DeleteFruitServlet ����������, ���ڼ���ɾ��ˮ����Ϣģ��...");
		try {
			// ��ȡ�û������ɾ����ˮ��ID��ֵ
			String idString = request.getParameter("deleteId");
			int id = Integer.parseInt(idString);
			System.out.println("deleteFruitServlet ����������...");
			System.out.println("����ɾ��id=" + "��ˮ��������...");
			//����ɾ������
			int i = new DeleteFruit().deleteFruit(id);
			//��ɾ����������ж�
			if (i != -1) {
				System.out.println("ɾ��ˮ����Ϣ�ɹ�!--");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// �ض��򵽹���ˮ���ķ�������Java����ManagerFruitServlet
		response.sendRedirect("managerFruitServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
