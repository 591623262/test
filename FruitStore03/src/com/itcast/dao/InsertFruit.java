package com.itcast.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.itcast.pojo.Fruit;
import com.itcast.utils.DBConnection;
import com.itcast.utils.DBReplease;

public class InsertFruit {
	public int insertFruit(Fruit fruit) {
		//ͨ���������ȡ���ݿ�����
		int i=-1;
		Connection connection=new DBConnection().getConnection();	
		String insertSQL = "insert into fruit (id,name,price,unit) values ("+fruit.getId()+",'" + fruit.getName()
				+ "','" + fruit.getPrice() + "','" + fruit.getUnit() + "')";
		PreparedStatement preparedStatement=null;
		try {
			preparedStatement=connection.prepareStatement(insertSQL);
			 i=preparedStatement.executeUpdate();
			System.out.println("ˮ����Ϣ�������ж���...");
			
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
