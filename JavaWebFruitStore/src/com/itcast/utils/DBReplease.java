package com.itcast.utils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
//�ͷ���Դ����������
public class DBReplease {
	public DBReplease(Connection connection) {
		if(connection!=null)
			try {
				connection.close();
				System.out.println("���ݿ����ӹرճɹ�..");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public DBReplease(ResultSet resultSet,Connection connection) {
		if(resultSet!=null)
			try {
				resultSet.close();
				System.out.println("������رճɹ�..");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(connection!=null)
			try {
				connection.close();
				System.out.println("���ݿ����ӹرճɹ�..");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
