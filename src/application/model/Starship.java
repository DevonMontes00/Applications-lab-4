package application.model;

import java.util.ArrayList;

public class Starship {

	private String shipName;
	private String shipRegistry;
	private String shipClass;
	private ArrayList<CrewMember> crewMemberAL;
	
	public Starship(String shipName, String shipRegistry, String shipClass)
	{
		this.shipName = shipName;
		this.shipRegistry = shipRegistry;
		this.shipClass = shipClass;
		this.crewMemberAL = new ArrayList<CrewMember>();
	}
	
	/**
	 * Getter for ship name
	 * 
	 * @author iog693
	 * @return Ship name
	 */
	public String getShipName()
	{
		return shipName;
	}
	
	/**
	 * Setter for ship name
	 * 
	 * @author iog693
	 * @param A string for the new ship name
	 */
	public void setShipName(String shipName)
	{
		this.shipName = shipName;
	}
	
	/**
	 * Getter for ship registry
	 * 
	 * @author iog693
	 * @return ship registry
	 */
	public String getShipRegistry()
	{
		return shipRegistry;
	}
	
	/**
	 * Setter for ship registry
	 * 
	 * @author iog693
	 * @param A string for new ship registry
	 */
	public void setShipRegistry(String shipRegistry)
	{
		this.shipRegistry = shipRegistry;
	}
	
	/**
	 * Getter for ship class
	 * 
	 * @author iog693
	 * @return ship class
	 */
	public String getShipClass()
	{
		return shipClass;
	}
	
	/**
	 * Setter for ship class
	 * 
	 * @author iog693
	 * @param A string for new ship class
	 */
	public void setShipClass(String shipClass)
	{
		this.shipClass = shipClass;
	}
	
	/**
	 * Getter for crewMemberAL
	 * 
	 * @author iog693
	 * @return crewMemberAL
	 */
	public ArrayList<CrewMember> getCrewMemberAL()
	{
		return crewMemberAL;
	}
	

	/**
	 * Setter for crewMemberAL
	 * 
	 * @author iog693
	 * @param ArrayList of crewmember objects
	 */
	public void setCrewMemberAL()
	{
		this.crewMemberAL = new ArrayList<CrewMember>();
	}
	
	/**
	 * To string function of Starship object
	 * 
	 * @author iog693
	 * @return String format of starship object
	 */
	public String toString()
	{
		String info = shipName + " [" + shipRegistry + "], Class: " + shipClass + ", Crew: " + crewMemberAL.size();
		return info;
	}
	
	/**
	 * Adds a member to the CrewMemberAL
	 * 
	 * @author iog693
	 * @param CrewMember object
	 */
	public void addMember(CrewMember m)
	{
		crewMemberAL.add(m);
	}
	
	/**
	 * Removes a member from the CrewMemberAL
	 * 
	 * @author iog693
	 * @param CrewMember object
	 */
	public void removeMember(CrewMember m)
	{
		crewMemberAL.remove(m);
	}
}

