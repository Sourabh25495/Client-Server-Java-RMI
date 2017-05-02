
package javarmi;
import java.rmi.*;
import java.util.*;
import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javarmi.*;

public class Client {
	
	public static void main(String args[]) {
		//Change the path of policy file
            System.setProperty("java.security.policy","/Users/sourabhkulkarni/Desktop/Server/Server.policy");
            
		
		ArrayList<JavaRMI> result_list = new ArrayList<JavaRMI>();
                ArrayList<JavaRMI> student_list = new ArrayList<JavaRMI>();
		
		Scanner input = new Scanner(System.in);
		
		try {
			System.out.println("\n\nProject 2 : JAVA RMI Student Query");
			System.out.println("==================================");
			
			System.out.println("\nClient Side Code Starts");
			//Specify the IP address of that of the Server
			Registry reg=LocateRegistry.getRegistry("127.0.0.1",5000);
			Interface stub = (Interface) reg.lookup("studentrecord");

			
			while(true) {
				System.out.println("\nPlease Enter the First Name of student for query of Last Name:");
				String first_name = input.nextLine();
				result_list = stub.queryStudent(first_name);
				
				if(result_list.isEmpty()) {
					System.out.println("\nNo Student in the class with the given First Name: " + first_name);
				}
				else {
					System.out.println("\nNo Students in the class Matching to the given First Name: " + first_name + "\n");
					
					for(JavaRMI temp: result_list) {
                                            
                                             String name=temp.getFirstName().trim();
                                         if(name.equals(first_name)){
                                         System.out.println(temp.getFirstName()+" "+temp.getLastName());}
                                        
                                           
						
					}
				}
				
				System.out.println("\nDo you want to query for another name? Type 'Yes' or 'No'...");
				String choice = input.nextLine();
				if(choice.equalsIgnoreCase("Yes")) {
					continue;
				}
				else {
					break;
				}
			}
			
			System.out.println("\nClient Side Code Ends");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}