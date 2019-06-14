package com.itcast.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itcast.pojo.Fruit;
import com.itcast.utils.DBConnection;
import com.itcast.utils.DBReplease;

public class SelectFruitList {
	@SuppressWarnings("rawtypes")
	public List selectFruitList() {
		List<Fruit> fruitList = new ArrayList<Fruit>();
		//ͨ���������ȡ���ݿ�����
		Connection connection=new DBConnection().getConnection();	
		String sql = "select * from fruit";
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		int id;
		String name;
		double price;
		String unit;
		try {
			// ʹ��preparedStatement����������ݿ����
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			System.out.println("���ڲ���ˮ����Ϣ...");
			while (resultSet.next()) {
				id = resultSet.getInt("id");
				name = resultSet.getString("name");
				price = resultSet.getDouble("price");
				unit = resultSet.getString("unit");
				System.out.println("��ѯ��...");
				fruitList.add(new Fruit(id, name, price, unit));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// ���л�����Դ����
			new DBReplease(resultSet, connection);
		}
		// �ڿ���̨��ӡ����ͻ���Ϣ
		System.out.println("��ѯ���������...");
		return fruitList;
	}
}
