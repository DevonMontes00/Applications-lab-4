package application.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class User {
	
	private String username;
	private String password;
	private ArrayList<User> userAL;
	
	public User(String username, String password)
	{
		this.username = username;
		this.password = password;
		this.userAL = new ArrayList<User>();
	}
	
	/**
	 * Getter for username
	 * 
	 * @author iog693
	 * @return username
	 */
	public String getUsername()
	{
		return username;
	}
	
	/**
	 * Setter for username
	 * 
	 * @author iog693
	 * @param String for new username
	 */
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	/**
	 * Getter for password
	 * 
	 * @author iog693
	 * @return password
	 */
	public String getPassword()
	{
		return password;
	}
	
	/**
	 * Setter for password
	 * 
	 * @author iog693
	 * @param String for new password
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	/**
	 * Getter for userAL
	 * 
	 * @author iog693
	 * @return userAL
	 */
	public ArrayList<User> getUserAL()
	{
		return userAL;
	}
	
	/**
	 * Setter for userAL
	 * 
	 * @author iog693
	 * @param ArrayList of User objects
	 */
	public void setUserAL(ArrayList<User> userAL)
	{
		this.userAL = userAL;
	}
	
	/**
	 * Adds user object to userAL
	 * 
	 * @author iog693
	 * @param user object
	 */
	public void addUser(User u)
	{
		userAL.add(u);
	}
	
	/**
	 * Loads user information into userAL
	 * 
	 * @author iog693
	 * @param filename of file that has user info
	 */
	public void loadUser(String fileName)
	{
		File file = new File(fileName);
		
		try 
		{
			Scanner inputStream = new Scanner(file);
			while (inputStream.hasNext())
			{
				String data = inputStream.nextLine();
				String [] dataComponents = data.split(",");
				String username = dataComponents[0];
				String password = dataComponents[1];
				
				User u = new User(username, password);
				addUser(u);
			}
			inputStream.close();
		}
		
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Validates input from login view to user in userAL
	 * 
	 * @author iog693
	 * @param username
	 * @param password
	 * @return User object; else null
	 */
	public User validate(String username, String password)
	{
		int i;
		loadUser("data/users.csv");
		ArrayList<User> userAL = getUserAL();
		
		for(i = 0; i < userAL.size(); i++)
		{
			if(username.equals(userAL.get(i).getUsername()))
			{
				if(password.equals(userAL.get(i).getPassword()))
				{
					return userAL.get(i);
				}
			}
		}
		
		return null;
	}
}
