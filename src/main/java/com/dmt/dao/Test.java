package com.dmt.dao;

public class Test {

	public static void main(String[] args) {
		ConnectDB Db = new ConnectDB();
		try {
			Db.KetNoi();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
