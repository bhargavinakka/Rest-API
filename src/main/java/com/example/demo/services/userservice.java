package com.example.demo.services;

import java.util.List;

import com.example.demo.payload.userspayload;

public interface userservice {
	userspayload addusers(userspayload up);
	userspayload updateusers(userspayload up,int id);
	void deleteusers(int id);
	List<userspayload>getallusers();
	userspayload getusersbyid(int id);
}
