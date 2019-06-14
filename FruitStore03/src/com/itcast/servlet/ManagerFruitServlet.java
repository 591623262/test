package com.itcast.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.itcast.dao.SelectFruitList;
import com.itcast.pojo.Fruit;

public class ManagerFruitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ManagerFruitServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ManagerFruitServlet ����������...");
		// ��ȡ���ݿ��ˮ����Ϣ
		@SuppressWarnings("unchecked")
		List<Fruit> fruitList = new SelectFruitList().selectFruitList();
		request.setAttribute("fruitList", fruitList);
		request.setAttribute("xinxi", "--��ӭʹ��ˮ������ϵͳ--");
		request.setAttribute("welcome", "--��ӭ����,�װ����û�" + request.getParameter("name") + "--");
		// ת����managerFruitҳ��
		request.getRequestDispatcher("/source/managerFruit.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
