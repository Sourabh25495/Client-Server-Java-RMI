package javarmi;
import java.rmi.*; 
import java.rmi.registry.LocateRegistry;
import javarmi.Server;
import java.rmi.registry.*;
public class MyServer{  
public static void main(String args[])throws Exception{  
    System.setProperty("java.security.policy","/Users/sourabhkulkarni/Desktop/Server/Server.policy");
   
// Specify Your IP address. This is the IP address of the server , use ipconfig for windows terminal to know your ip address
System.setProperty("java.rmi.server.hostname", "127.0.0.1");  
Registry reg = LocateRegistry.createRegistry(5000);  
Remote r=new Server();
reg.bind("studentrecord",r); 
System.out.print("Started");
}}
