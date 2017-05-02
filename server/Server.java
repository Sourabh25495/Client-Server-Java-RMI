/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarmi;

/**
 *
 * @author Snehaa29
 */
import java.net.MalformedURLException;
import java.sql.Statement;
import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server extends UnicastRemoteObject implements Interface{
    
	
	

	public Server() throws RemoteException {
		super();
	}
        
        public ArrayList<JavaRMI> queryStudent(String FirstName){  
            System.out.println("entered");
ArrayList<JavaRMI> student_list=new ArrayList<JavaRMI>();  
ArrayList<JavaRMI> result_list=new ArrayList<JavaRMI>();
	
        //@Override

    /**
     *
     * @param firstName
     * @return
     * @throws RemoteException
     */

        	String usr ="postgres";         // Your user name for postgreSQL
		String pwd ="1234";		// Your Password for postgreSQL
		String url ="jdbc:postgresql://localhost:5432/postgres";	// url for the database

		try
		{
    try {
        Class.forName("org.postgresql.Driver");
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
    }
			System.out.println("Success loading Driver!");
		
		
		
			Connection conn = DriverManager.getConnection(url, usr, pwd);
			System.out.println("Success connecting server!");

			Statement stmt=null;
                        stmt = conn.createStatement();
			ResultSet rs;
                        rs = stmt.executeQuery("SELECT * FROM stud");

			while (rs.next())
			{
                                String first_name=rs.getString("first_name");
                                String last_name=rs.getString("last_name");
                                JavaRMI student = new JavaRMI();
                                student.setFirstName(rs.getString("first_name"));
                                student.setLastName(rs.getString("last_name"));
				student_list.add(student);
				
			}
                        System.out.println("\n\n\nStudent Record");
			System.out.println("==============\n");
			for(int i=0;i<student_list.size();i++){
			
				//System.out.println(temp.getFirstName() + " " + temp.getLastName() + "\n");
                                if(student_list.contains(FirstName)) {
                            //System.out.println("entered the loop");
			
                                System.out.println("print this");
                                
			}
                        
                        
		}
                        
		}
                

		catch(SQLException e)
		{
			System.out.println("Connection URL or username or password errors!");
			e.printStackTrace();
		}
                return student_list;
    }
         
     
		
		
	}
    
