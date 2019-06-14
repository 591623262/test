package com.itcast.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itcast.dao.UpdateFruit;
import com.itcast.pojo.Fruit;

//���и��µķ������˵�Servlet����UpdateFruitServlet
public class UpdateFruitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateFruitServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("�������˳��� UpdateFruitServlet ����������, ���ڼ��ظ���ˮ����Ϣģ��...");
		try {
			//��ȡ�û�����ĸ���ˮ������Ϣ
			String idString=request.getParameter("updateId");
			int id = Integer.parseInt(idString);
			String name = request.getParameter("updateName");
			String priceString=request.getParameter("updatePrice");
			double price = Double.parseDouble(priceString);
			String unit = request.getParameter("updateUnit");
			Fruit fruit = new Fruit(id, name, price, unit);
			//���и���ˮ������
			int i = new UpdateFruit().updateFruit(fruit);
			//�Ը��½�������ж�
			if (i != -1)
				System.out.println("���³ɹ�...");
		} catch (Exception e) {
			e.printStackTrace();
		}
		//�ض��򵽹���ˮ���ķ�������Java����ManagerFruitServlet
		response.sendRedirect("managerFruitServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
