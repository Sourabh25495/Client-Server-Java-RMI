package javarmi;
import java.rmi.*;
import java.util.*;

public interface Interface extends Remote{
	public ArrayList<JavaRMI> queryStudent(String FirstName)throws RemoteException;
} 
