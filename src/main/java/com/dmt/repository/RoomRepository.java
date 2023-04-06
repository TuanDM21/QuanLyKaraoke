package com.dmt.repository;

import java.util.List;

import com.dmt.model.Room;

public interface RoomRepository {
	List<Room> findAvailableRooms(String startDate, String endDate) throws Exception;
}
