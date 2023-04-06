package com.dmt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dmt.model.Room;
import com.dmt.service.RoomService;

@Controller
public class RoomController {

	@Autowired
	RoomService roomS;

	@RequestMapping("/show-room")
	public String voidShowRoom(HttpServletRequest request) {
		try {
			String startDateString = "2023-04-11";
			String endDateString = "2023-04-12";
			List<Room> list = roomS.findAvailableRooms(startDateString, endDateString);
			request.setAttribute("room", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Room";
	}

}
