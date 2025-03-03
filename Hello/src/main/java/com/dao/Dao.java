package com.dao;
import java.util.ArrayList;

import java.util.List; 

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.pojo.Emp;
import com.session.SessionProvider;



public class Dao {
	
	public boolean insert(Emp emp) {
	    boolean success = false;
	    Transaction transaction = null;

	    try (Session session = SessionProvider.provideSessionFactory().openSession()) {
	        transaction = session.beginTransaction();
	        session.save(emp);
	        transaction.commit();
	        success = true;
	        System.out.println("Data inserted successfully.");
	    } catch (Exception e) {
	        if (transaction != null) transaction.rollback();
	        e.printStackTrace();
	        System.out.println("Failed to insert data.");
	    }
	    return success;
	}

	
	public List<Emp> getAllUsers() {

	    System.out.println("Fetching all users");
	    SessionFactory factory = SessionProvider.provideSessionFactory();
	    Session session = null;
	    List<Emp> empList = null;

	    try {
	        session = factory.openSession();
	        empList = session.createNativeQuery("SELECT * FROM student", Emp.class).list();
	        System.out.println("Users fetched successfully.");
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Failed to fetch users.");
	    } finally {
	        if (session != null) {
	            session.close(); 
	        }
	    }
	    return empList;
	    }

	
	public Emp getParticularUser(int id) {
	    System.out.println("Fetching user with ID: " + id);
	    Emp emp = null;

	    try (Session session = SessionProvider.provideSessionFactory().openSession()) {
	        emp = session.createNativeQuery("SELECT * FROM hello_std WHERE id = :userId", Emp.class)
	                     .setParameter("userId", id)
	                     .uniqueResult();
	        
	        if (emp != null) {
	            System.out.println("User fetched successfully.");
	        } else {
	            System.out.println("User with ID: " + id + " not found.");
	        }
	    } catch (Exception e) {
	        System.out.println("Failed to fetch user.");
	        e.printStackTrace();
	    }
	    
	    return emp; 
	}
	 public void update(Emp updatedEmp) {
	        System.out.println("Updating user with ID: " + updatedEmp.getId());
	        Transaction transaction = null;
	        try (Session session = SessionProvider.provideSessionFactory().openSession()) {
	            transaction = session.beginTransaction();
	            Emp existingEmp = session.get(Emp.class, updatedEmp.getId());
	            if (existingEmp != null) {
	                existingEmp.setName(updatedEmp.getName());
	                existingEmp.setDept(updatedEmp.getDept());
	                existingEmp.setClg(updatedEmp.getClg());
	                session.update(existingEmp);
	                transaction.commit();
	                System.out.println("User updated successfully.");
	            } else {
	                System.out.println("User with ID: " + updatedEmp.getId() + " not found.");
	            }
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	            System.out.println("Failed to update user.");
	        }
	    }
	 Emp emp=new Emp();
	 public Emp getUserById(int userId) {
	       
	        try (Session session = SessionProvider.provideSessionFactory().openSession()) {
	            emp = session.get(Emp.class, userId);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return emp;
	    }
	 public void delete(int id) {
		    Transaction transaction = null;
		    
		    try (Session session = SessionProvider.provideSessionFactory().openSession()) {
		        
		        transaction = session.beginTransaction();
		        
		        
		        Emp emp = session.get(Emp.class, id);
		        
		        
		        if (emp != null) {
		            session.delete(emp);
		            transaction.commit();
		            System.out.println("User with ID " + id + " deleted successfully.");
		        } else {
		            System.out.println("User with ID " + id + " not found.");
		        }
		    } catch (Exception e) {
		        if (transaction != null) {
		            transaction.rollback();  
		        }
		        e.printStackTrace();
		        System.out.println("Failed to delete user with ID " + id);
		    }
		}
	

		 
	 }
