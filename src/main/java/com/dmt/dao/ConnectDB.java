package com.dmt.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
	public Connection cn;
	public void KetNoi() throws Exception
	{
		// xac dinh he quan tri co so du lieu
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    	System.out.println("Da xac dinh");
    	String url="jdbc:sqlserver://localhost:1433;databaseName=QuanLyKaraoke;user=sa;password=Password.1";
    	cn= DriverManager.getConnection(url);
    	System.out.println("Da ket noi");
	}
}
