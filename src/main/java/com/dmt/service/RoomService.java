package com.dmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmt.model.Room;
import com.dmt.repository.RoomRepository;

@Service
public class RoomService {

	@Autowired
	RoomRepository roomR;

	public List<Room> findAvailableRooms(String startDate, String endDate) throws Exception {
		return roomR.findAvailableRooms(startDate, endDate);
	}

}
