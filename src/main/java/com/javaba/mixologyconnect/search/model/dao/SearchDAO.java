package com.javaba.mixologyconnect.search.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class SearchDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public SearchDAO() {
		try {
			prop = new Properties();
			String filePath = SearchDAO.class.getResource("/com/javaba/mixologyconnect/sql/search-sql.xml").getPath();
			prop.loadFromXML(new FileInputStream(filePath));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	


}
