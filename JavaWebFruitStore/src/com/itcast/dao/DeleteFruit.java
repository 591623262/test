package com.itcast.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.itcast.utils.DBConnection;
import com.itcast.utils.DBReplease;

public class DeleteFruit {
	public int deleteFruit(int id) {
		//ͨ���������ȡ���ݿ�����
		int i=-1;
		Connection connection=new DBConnection().getConnection();	
		String deleteSQL = "delete from fruit where id=?";
		PreparedStatement preparedStatement=null;
		try {
			
			preparedStatement=connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, id);
			 i=preparedStatement.executeUpdate();
			System.out.println("ˮ����Ϣɾ������ж���...");
			
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
