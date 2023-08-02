package com.example.demo.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.exceptionhandling.ResourceNotFoundException;
import com.example.demo.models.users;
import com.example.demo.payload.userspayload;
import com.example.demo.repository.user_repo;
import com.example.demo.services.userservice;
@Service
public class impli implements userservice {

	@Autowired
	user_repo repo;
	@Autowired
	ModelMapper modelmapper;
	@Override
	public userspayload addusers(userspayload up) {
		users ss=this.dto_users(up);
		users saveusers=this.repo.save(ss);
		return this.users_dto(saveusers);
		// TODO Auto-generated method stub
	}

	@Override
	public userspayload updateusers(userspayload up, int id) {
		// TODO Auto-generated method stub
		users e=this.repo.findById(id).orElseThrow(()->new ResourceNotFoundException("users", "id", id));
		e.setName(up.getName());
		e.setEmail(up.getEmail());
		e.setPassword(up.getPassword());
		users e1=this.repo.save(e);
		userspayload ep=this.users_dto(e1);
		return ep;
	}

	@Override
	public void deleteusers(int id) {
		// TODO Auto-generated method stub
		users e=this.repo.findById(id).orElseThrow(()->new ResourceNotFoundException("users","id",id));
				this.repo.delete(e);

	}

	@Override
	public List<userspayload> getallusers() {
		// TODO Auto-generated method stub
		List<users> u=(List<users>) this.repo.findAll();
		List<userspayload> emp=u.stream().map(user->this.users_dto(user)).collect(Collectors.toList());
		return emp;
	}

	@Override
	public userspayload getusersbyid(int id){
		// TODO Auto-generated method stub
		users ud=this.repo.findById(id).orElseThrow(()->new ResourceNotFoundException("users", "id", id));
		return this.users_dto(ud);
	}
	
	public users dto_users(userspayload uesrp) {
		users u=this.modelmapper.map(uesrp, users.class);
		return u;
	}
	public userspayload users_dto(users us) {
		userspayload up=this.modelmapper.map(us, userspayload.class);
		return up;
	}
//	public users dto_users(userspayload ep) {
//		users e=this.modelmapper.map(ep, users.class);
//		return e;
//	}
//	public userspayload dto_users(users uss) {
//		userspayload p=this.modelmapper.map(uss, userspayload.class);
//		return p;
//	}

}
