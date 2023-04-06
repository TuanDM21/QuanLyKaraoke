package com.dmt.repository.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dmt.dao.ConnectDB;
import com.dmt.model.Room;
import com.dmt.repository.RoomRepository;

@Repository
public class RoomRepositoryImpl implements RoomRepository {

	@Override
	public List<Room> findAvailableRooms(String DateStart, String DateEnd) throws Exception {
		ConnectDB connect = new ConnectDB();
		connect.KetNoi();
		List<Room> rooms = new ArrayList<>();
		String sql = "SELECT * FROM room WHERE available = 1 AND ? <= endDate AND ? >= startDate";
		PreparedStatement cmd = connect.cn.prepareStatement(sql);

		Date SqlDateStart = Date.valueOf(DateStart);
		Date SqlDateEnd = Date.valueOf(DateEnd);

		cmd.setDate(1, SqlDateEnd);
		cmd.setDate(2, SqlDateStart);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			Room room = new Room();
			room.setId(rs.getInt("id"));
			room.setRoomNumber(rs.getString("roomNumber"));
			room.setRoomType(rs.getString("roomType"));
			room.setPrice(rs.getBigDecimal("price"));
			room.setMaxOccupancy(rs.getInt("maxOccupancy"));
			room.setAvailable(rs.getBoolean("available"));
			rooms.add(room);
		}
		return rooms;
	}

}
