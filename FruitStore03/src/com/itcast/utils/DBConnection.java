package com.itcast.utils;

import java.sql.Connection;
import java.sql.DriverManager;
//��ȡ���ݿ����ӹ�����
public class DBConnection {
	Connection connection = null;
	// ��ȡ���Ӷ���
	public Connection getConnection() {
		try {
			// 1.�������ݿ�����
			Class.forName("com.mysql.jdbc.Driver");
			// 2.��ȡ���ݿ�����
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test2019?"
					+ "useUnicode=true&characterEncoding=utf8&" + "useSSL=false&serverTimezone=Hongkong", "root",
					"117411");
			// 3.ͨ��Statement���󴴽�Connection���Ӷ���
			System.out.println("���ݿ����Ӽ��سɹ�..");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
