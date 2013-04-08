package com.nus.cs.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.nus.cs.domain.DebugTO;
import com.nus.cs.util.ConnectionUtil;

public class DebugDao extends JdbcDaoSupport{
	
	public  void execute(String sql, DebugTO dbTO) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		boolean success = true;
		String error = "";
		List<List<String>>table = new ArrayList<List<String>>();
		
		try {
			Connection conn = ConnectionUtil.createConnection();
				
			PreparedStatement ps = conn.prepareStatement(sql);
			System.out.println(sql);
			boolean hasResult = ps.execute();
			
			
			if(hasResult) {
				ResultSet rs = ps.getResultSet();
				ResultSetMetaData md = rs.getMetaData();
				int numOfCols = md.getColumnCount();
				
				List<String> cur;
				
				cur = new ArrayList<String>();
				for(int i=0; i<numOfCols; i++) {
					cur.add(md.getColumnName(i+1));
				}
				table.add(cur);
				
				while(rs.next()) {
					cur = new ArrayList<String>();
					for(int i=0; i<numOfCols; i++) {
						cur.add(rs.getString(i+1));
					}
					table.add(cur);
				}
				
				rs.close();
				conn.close();
			}
		}
		catch(SQLException e) {
			success = false;
			error = e.getMessage();
		}
		
		dbTO.setSuccess(success);
		dbTO.setTable(table);
		dbTO.setError(error);
	}

}
