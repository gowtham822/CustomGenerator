package com.tcs.customGen;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;


public class CustomIdGenerator implements IdentifierGenerator {
	 
	@Autowired
	 private DataSource dataSource;

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) {
		
		String prefix = "AMAZON";
		
		String suffix = "";
		 
		Connection con= DataSourceUtils.getConnection(dataSource);
		
		try {
			Statement s = con.createStatement();
			
			String sql1 = "CALL get_next_user_id(@next_value);";
			
			s.execute(sql1);
			
			String sql2 = "SELECT @next_value";
			
			ResultSet e = s.executeQuery(sql2);
			
			while(e.next())
			{
				int a = e.getInt(1);
				
				suffix = String.valueOf(a);
			}
			
			

		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		 
		
		
		
		return prefix+suffix;
		
		
	}

}
