package com.itcast.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itcast.pojo.Customer;
import com.itcast.utils.DBReplease;

public class SelectCustomer {
	public Customer selectCustomer(Connection connection, String selectName, String selectPassword) {
		//��ʼ���û���Ϣ����
		List<Customer> customerList=new ArrayList<Customer>();
		String sql = "select * from customer";
		ResultSet resultSet = null;
		PreparedStatement preparedStatement=null;
		int id;
		String name;
		String password;
		String sex;
		String address;
		String telephone;
		try {
			// ʹ��preparedStatement����������ݿ����
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			System.out.println("���ڲ����û�...");
			//����ѭ�������û���Ϣ
			while(resultSet.next()) {
				id=resultSet.getInt("id");
				name=resultSet.getString("name");
				System.out.println("�û�id= "+id+" ���û�����Ϊ"+name);
				password=resultSet.getString("password");
				sex=resultSet.getString("sex");
				address=resultSet.getString("address");
				telephone=resultSet.getString("telephone");
				//����ѯ�����û���Ϣ�����û���Ϣ����
				customerList.add(new Customer(id,name,password,sex,address,telephone));
			}
			int i=0;	//��i����ѭ���ж�
			int nameFlag=-1;	//�����û����ж�
			for(i=0;i<customerList.size();i++) {
				//�����û���������ƥ��,ƥ��ɹ����¼�ɹ�
				if((customerList.get(i).getName().equals(selectName))&&(customerList.get(i).getPassword().equals(selectPassword))) {
					System.out.println("�û����ҳɹ�, ��¼�ɹ�!");
					return customerList.get(i);
				}
				//�����ƥ����û����ֳɹ�,����м�¼
				if(customerList.get(i).getName().equals(selectName)) {
					nameFlag=i;
				}
			}
			//������м�¼���ֵ�nameFlag�м�¼,�򷵻��������
			if(nameFlag!=-1) {
				customerList.get(nameFlag).setPassword(null);
				System.out.println("�������!");
				return customerList.get(nameFlag);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// ���л�����Դ����
			new DBReplease(resultSet, connection);
		}
		// �ڿ���̨��ӡ����ͻ���Ϣ
		System.out.println("��ѯʧ��!");
		return null;
	}
}
