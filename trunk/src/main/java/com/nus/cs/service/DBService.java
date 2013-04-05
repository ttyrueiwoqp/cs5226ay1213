package com.nus.cs.service;

import java.util.ArrayList;
import java.util.List;

import com.nus.cs.dao.DBDao;
import com.nus.cs.domain.SomeTO;

public class DBService {
	
	private DBDao dbDao = new DBDao();
	
	public List<SomeTO> getSomeResult(String a, int b) {
		
		List<SomeTO> temp = new ArrayList<SomeTO>();
		
		for (int i = 0; i < 2; i++) {
			
			SomeTO someTO = new SomeTO();
			someTO.setX("result = ");
			someTO.setY(i+b);
			temp.add(someTO);
		}
		
		return temp;
		
		//return dbDao.getSomeResult(a, b);
		
	}
	
}