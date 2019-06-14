package com.itcast.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.itcast.pojo.Fruit;
import com.itcast.utils.DBConnection;
import com.itcast.utils.DBReplease;

public class UpdateFruit {
	public int updateFruit(Fruit fruit) {
		//ͨ���������ȡ���ݿ�����
		int i=-1;
		Connection connection=new DBConnection().getConnection();	
		String updateSQL = "update fruit set name=?,price=?,unit=? where id=?";
		PreparedStatement preparedStatement=null;
		try {
			preparedStatement=connection.prepareStatement(updateSQL);
			preparedStatement.setString(1,fruit.getName());
			preparedStatement.setDouble(2,fruit.getPrice());
			preparedStatement.setString(3,fruit.getUnit());
			preparedStatement.setInt(4,fruit.getId());
			 i=preparedStatement.executeUpdate();
			System.out.println("ˮ����Ϣ���½���ж���...");	
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
