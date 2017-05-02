package javarmi;
import java.util.*;
import java.io.Serializable;

public class JavaRMI implements Serializable
{
	private String first_name;
	private String last_name;
	
	
	
	public String getFirstName()
	{
		return this.first_name;
	}
	
	public String getLastName()
	{
		return this.last_name;
	}
	
	public void setFirstName(String in_first_name)
	{
		this.first_name = in_first_name;
	}
	
	public void setLastName(String in_last_name)
	{
		this.last_name = in_last_name;
	}

	
}