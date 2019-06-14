package com.itcast.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itcast.dao.InsertFruit;
import com.itcast.pojo.Fruit;
//���в���ˮ����Ϣ�ķ������˵�Servletģ��InsertFruitServlet
public class InsertFruitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsertFruitServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("�������˳��� InsertFruitServlet ����������, ���ڼ��ز���ˮ����Ϣģ��...");
		//��ȡ�û��������Ҫ�����ˮ����Ϣ
		try {
			String idString = request.getParameter("insertId");
			int id = Integer.parseInt(idString);
			String name = request.getParameter("insertName");
			String priceString = request.getParameter("insertPrice");
			double price = Double.parseDouble(priceString);
			String unit = request.getParameter("insertUnit");
			Fruit fruit = new Fruit(id, name, price, unit);
			//���в���ˮ����Ϣ����
			int i = new InsertFruit().insertFruit(fruit);
			//�Բ���Ľ�������ж�
			if (i != -1) {
				System.out.println("����ˮ����Ϣ�ɹ�.....");
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