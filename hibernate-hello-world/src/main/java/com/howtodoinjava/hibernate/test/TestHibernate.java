package com.howtodoinjava.hibernate.test;

import org.hibernate.Session;

import com.howtodoinjava.hibernate.test.dto.EmployeeEntity;

public class TestHibernate {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		// Add new Employee object
		EmployeeEntity emp = new EmployeeEntity();
		emp.setEmail("demo-user@mail.com");
		emp.setFirstName("demo");
		emp.setLastName("user");
		
		session.persist(emp);
		
		EmployeeEntity empNew = session.get(EmployeeEntity.class, emp.getEmployeeId());
		
		session.getTransaction().commit();
		
		System.out.println(emp.getEmployeeId() +" " + empNew.getEmployeeId());
		HibernateUtil.shutdown();
	}

}
