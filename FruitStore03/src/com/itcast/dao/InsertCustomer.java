package com.itcast.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.itcast.pojo.Customer;
import com.itcast.utils.DBConnection;
import com.itcast.utils.DBReplease;

public class InsertCustomer {
	public int insertCustomer(Customer customer) {
		//ͨ���������ȡ���ݿ�����
		int i=-1;
		Connection connection=new DBConnection().getConnection();	
		String insertSQL = "insert into customer (name,password,sex,address,telephone) values ('" + customer.getName()
				+ "','" + customer.getPassword() + "','" + customer.getSex() + "','" + customer.getAddress() + "','"
				+ customer.getTelephone() + "')";
		PreparedStatement preparedStatement=null;
		try {
			preparedStatement=connection.prepareStatement(insertSQL);
			 i=preparedStatement.executeUpdate();
			System.out.println("�������ж���...");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			new DBReplease(connection);
		}
		//�÷���ֵi�������ж��Ƿ����ɹ�
		return i;
	}
}
