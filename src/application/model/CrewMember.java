package application.model;

public class CrewMember {
	private String memberName;
	private String memberPosition;
	private String memberRank;
	private String memberSpecies;
	private String memberRegistry;
	
	public CrewMember(String memberName, String memberPosition, String memberRank, String memberRegistry, String memberSpecies)
	{
		this.memberName = memberName;
		this.memberPosition = memberPosition;
		this.memberRank = memberRank;
		this.memberRegistry = memberRegistry;
		this.memberSpecies = memberSpecies;
	}
	
	/**
	 * Getter for member name
	 * 
	 *@author iog693  
	 * @return members name
	 */
	public String getMemberName()
	{
		return memberName;
	}
	
	/**
	 * Setter for member name
	 * 
	 * @author iog693
	 * @param a string for the members new name
	 */
	public void setMemeberName(String memberName)
	{
		this.memberName = memberName;
	}
	
	/**
	 * Getter for member position
	 * 
	 * @author iog693
	 * @return member position
	 */
	public String getMemberPosition()
	{
		return memberPosition;
	}
	
	/**
	 * Setter for member position
	 * 
	 * @author iog693
	 * @param a string for member's new position
	 */
	public void setMemberPosition(String memberPosition)
	{
		this.memberPosition = memberPosition;
	}
	
	/**
	 * Getter for member rank
	 * 
	 * @author iog693
	 * @return member rank
	 */
	public String getMemberRank()
	{
		return memberRank;
	}
	
	/**
	 * Setter for member rank
	 * 
	 * @author iog693
	 * @param a string for member's new rank
	 */
	public void setMemberRank(String memberRank)
	{
		this.memberRank = memberRank;
	}
	
	/**
	 * Getter for member registry
	 * 
	 * @author iog693
	 * @return member registry
	 */
	public String getMemberRegistry()
	{
		return memberRegistry;
	}
	
	/**
	 * Setter for member registry
	 * 
	 * @author iog693
	 * @param A string for new member registry
	 */
	public void setMemberRegistry(String memberRegistry)
	{
		this.memberRegistry = memberRegistry;
	}
	
	/**
	 * Getter for member species
	 * 
	 * @author iog693 
	 * @return member species
	 */
	public String getMemberSpecies()
	{
		return memberSpecies;
	}
	
	/**
	 * Setter for member species
	 * 
	 * @author iog693
	 * @param A string for new member Species
	 */
	public void setMemberSpecies(String memberSpecies)
	{
		this.memberSpecies = memberSpecies;
	}
	
	/**
	 * To string function for CrewMember object
	 * 
	 * @author iog693
	 * @return String form of CrewMember object
	 */
	public String toString()
	{
		String info = "- " + memberRank + " " + memberName + ", " + memberPosition + " (" + memberSpecies + ")";
		return info;
	}
}
