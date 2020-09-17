package com.example.take;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.take.GetUsers;
//import com.example.take1.InsertUserDAO;
import com.example.take.User;

@RestController
@RequestMapping(value="/getData")
public class UserController {
	
//	@Autowired
//	private InsertUserDAO insertUserDAO;
//	
	@Autowired
	private GetUsers getUsers;
	
//	public String addUser(User user) throws Exception
//	{
//		user.setUserId(01);
//		user.setUsername("Kevin");
//		return insertUserDAO.insertNewUserDAO(user);
//	}
	
	@GetMapping
	public String getUser() throws Exception
	{
		String msg = getUsers.fetchUsers();
		System.out.println(msg);
		return "IN Controller";
		
	}


}
