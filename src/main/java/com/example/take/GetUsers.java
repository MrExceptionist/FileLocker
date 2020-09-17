package com.example.take;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.take.User;

@Repository
public class GetUsers {

public String fetchUsers() {
		
		Configuration con = new Configuration().configure().addAnnotatedClass(User.class);
		
		ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		
		SessionFactory sf = con.buildSessionFactory(sr);
		
		Session s = sf.openSession(); 
		
		Transaction tx = s.beginTransaction();
		
	//	Query query = s.createQuery("FROM User");
//		tx.begin();
		
		User U1 = (User) s.get(User.class, 101);    
		
		System.out.println("Data from table:"+U1.getUserId()+U1.getUsername()+U1.getPassword()+U1.getFileName());
		//s.save(user);
		tx.commit();
		return "User added successfully";
	}

	
}
