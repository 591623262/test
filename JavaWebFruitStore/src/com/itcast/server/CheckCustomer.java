package com.itcast.server;
import java.sql.Connection;

import com.itcast.dao.SelectCustomer;
import com.itcast.pojo.Customer;
import com.itcast.utils.DBConnection;
public class CheckCustomer {
	//����dao���selectCustomer���в�ѯ�ͻ���Ϣ����
	public Customer checkCustomer(String name,String password) {
		Connection connection=new DBConnection().getConnection();	//ͨ���������ȡ���ݿ�����
		//ͨ��dao����в�ѯ��ȡ�û���Ϣ
		Customer customer=new SelectCustomer().selectCustomer(connection, name, password);
		return customer;
	}
}
