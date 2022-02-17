package application.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import application.Main;
import application.model.CrewMember;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PersonnelController implements EventHandler <ActionEvent> {
	
	@FXML
	private Label WelcomeBack;
	
	@FXML
	private Label MainShipRegistry;
	
	@FXML
	private Button logoutButton;
	
	@FXML
	private ImageView CommandingImage;
	
	@FXML 
	private ImageView FirstImage;
	
	@FXML
	private ImageView CommunicationsImage;
	
	@FXML
	private ImageView EngineeringImage;
	
	@FXML
	private ImageView HelmsmanImage;
	
	@FXML
	private ImageView NavigatorImage;
	
	@FXML
	private ImageView MedicalImage;
	
	@FXML
	private ImageView NurseImage;
	
	@FXML
	private Label CommandingLabel;
	
	@FXML
	private Label FirstLabel;
	
	@FXML
	private Label CommunicationsLabel;
	
	@FXML
	private Label EngineeringLabel;
	
	@FXML
	private Label HelmsmanLabel;
	
	@FXML
	private Label NavigatorLabel;
	
	@FXML
	private Label MedicalLabel;
	
	@FXML 
	private Label NurseLabel;
	
	private String username;
	
	private ArrayList<CrewMember> crewMemberAL;
	
	private ArrayList<CrewMember> personnelAL;
	
	public PersonnelController(String username) {
		this.username = username;
		this.crewMemberAL = new ArrayList<CrewMember>();
		this.personnelAL = new ArrayList<CrewMember>();
	}
	
	/**
	 * Getter for CrewMemberAL
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
	 * @param ArrayList of CrewMember objects
	 */
	public void setCrewMemberAL(ArrayList<CrewMember> al)
	{
		this.crewMemberAL = al;
	}
	
	/**
	 * Getter for Username
	 * 
	 * @author iog693
	 * @return this.username
	 */
	public String getUsername()
	{
		return this.username;
	}
	
	/**
	 * Setter for username
	 * 
	 * @author iog693
	 * @param String of new username
	 */
	public void setUsername(String u)
	{
		this.username = u;
	}
	
	/**
	 * Getter for personnelAL
	 * 
	 * @author iog693
	 * @return personnelAL
	 */
	public ArrayList<CrewMember> getPersonnelAL()
	{
		return personnelAL;
	}
	
	/**
	 * Setter for personnelAL
	 * 
	 * @author iog693
	 * @param ArrayList of CrewMember objects
	 */
	public void setPersonnelAL(ArrayList<CrewMember> al)
	{
		this.personnelAL = al;
	}
	
	/**
	 * Adds CrewMember object to crewMemberAL
	 * 
	 * @author iog693
	 * @param CrewMember object
	 */
	public void addCrewMember(CrewMember p)
	{
		crewMemberAL.add(p);
	}
	
	/**
	 * Adds CrewMember object to personnelAL
	 * 
	 * @author iog693
	 * @param CrewMember object
	 */
	public void addPersonnel(CrewMember p)
	{
		personnelAL.add(p);
	}
	
	/**
	 * Loads crewMemberAL with information from file
	 * 
	 * @author iog693
	 * @param filename of file that contains crewMember object information
	 */
	public void loadCrewMember(String fileName)
	{
		File file = new File(fileName);
		
		try 
		{
			Scanner inputStream = new Scanner(file);
			while (inputStream.hasNext())
			{
				String data = inputStream.nextLine();
				String [] dataComponents = data.split(",");
				String memberName = dataComponents[0];
				String memberRank = dataComponents[1];
				String memberPosition = dataComponents[2];
				String memberRegistry = dataComponents[3];
				String memberSpecies = dataComponents[4];
				
				CrewMember p = new CrewMember(memberName, memberRank, memberPosition, memberRegistry, memberSpecies);
				addCrewMember(p);
			}
			inputStream.close();
		}
		
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Loads personnelAL with specific crewMembers from CrewMemberAL
	 * 
	 * @author iog693
	 * @param CrewMemberAL
	 * @param shipRegistry
	 * @return personnelAL
	 */
	public ArrayList<CrewMember> loadPersonnel(ArrayList<CrewMember> CrewMemberAL, String shipRegistry)
	{
		int i;
		
		for(i = 0; i < CrewMemberAL.size(); i++)
		{
			if(shipRegistry.equals(CrewMemberAL.get(i).getMemberRegistry()))
			{
				addPersonnel(CrewMemberAL.get(i));
			}
		}
		
		return personnelAL;
	}

	/**
	 * Initializes personnel view
	 * 
	 * @author iog693
	 * @throws FileNotFoundException
	 */
	public void initialize() throws FileNotFoundException
	{
		int i;
		loadCrewMember("data/personnel.csv");
		ArrayList<CrewMember> CrewMemberAL = getCrewMemberAL();
		ArrayList<CrewMember> PersonnelAL = null;
		String username = getUsername();
		String [] name = {""};
		String lastname = "";
		String imageLocation = "";
		String [] orderOfCommand = {"Commanding Officer", "First Officer", "Communications Officer", "Chief Engineering Officer", "Helmsman", "Navigator", "Chief Medical Officer", "Nurse"};
		
		for(i = 0; i < CrewMemberAL.size(); i++)
		{
			name = CrewMemberAL.get(i).getMemberName().split(" ");
			lastname = name[name.length - 1];
			if(username.equalsIgnoreCase(lastname)) 
			{
				WelcomeBack.setText("Welcome, " + CrewMemberAL.get(i).getMemberRank() + " " + lastname);
				MainShipRegistry.setText("USS Enterprise " + CrewMemberAL.get(i).getMemberRegistry());
				PersonnelAL = loadPersonnel(CrewMemberAL,CrewMemberAL.get(i).getMemberRegistry());
			}
		}
		
		for(i = 0; i < PersonnelAL.size(); i++)
		{
			if(orderOfCommand[0].equals(PersonnelAL.get(i).getMemberPosition()))
			{
				name = PersonnelAL.get(i).getMemberName().split(" ");
				lastname = name[name.length - 1];
				CommandingLabel.setText(orderOfCommand[0] + "\n" + PersonnelAL.get(i).getMemberRank() + " " + PersonnelAL.get(i).getMemberName());
				imageLocation = "images/" + lastname.toLowerCase() + ".jpg";
				FileInputStream imageStream = new FileInputStream(imageLocation);
				Image image = new Image(imageStream);
				CommandingImage.setImage(image);
				
			}
			
			if(orderOfCommand[1].equals(PersonnelAL.get(i).getMemberPosition()))
			{
				name = PersonnelAL.get(i).getMemberName().split(" ");
				lastname = name[name.length - 1];
				FirstLabel.setText(orderOfCommand[1] + "\n" + PersonnelAL.get(i).getMemberRank() + " " + PersonnelAL.get(i).getMemberName());
				imageLocation = "images/" + lastname.toLowerCase() + ".jpg";
				FileInputStream imageStream = new FileInputStream(imageLocation);
				Image image = new Image(imageStream);
				FirstImage.setImage(image);
			}
			
			if(orderOfCommand[2].equals(PersonnelAL.get(i).getMemberPosition()))
			{
				name = PersonnelAL.get(i).getMemberName().split(" ");
				lastname = name[name.length - 1];
				CommunicationsLabel.setText(orderOfCommand[2] + "\n" + PersonnelAL.get(i).getMemberRank() + " " + PersonnelAL.get(i).getMemberName());
				imageLocation = "images/" + lastname.toLowerCase() + ".jpg";
				FileInputStream imageStream = new FileInputStream(imageLocation);
				Image image = new Image(imageStream);
				CommunicationsImage.setImage(image);
			}
			
			if(orderOfCommand[3].equals(PersonnelAL.get(i).getMemberPosition()))
			{
				name = PersonnelAL.get(i).getMemberName().split(" ");
				lastname = name[name.length - 1];
				EngineeringLabel.setText(orderOfCommand[3] + "\n" + PersonnelAL.get(i).getMemberRank() + " " + PersonnelAL.get(i).getMemberName());
				if(lastname.equals("Forge"))
				{
					lastname = "la " + lastname;
				}
				imageLocation = "images/" + lastname.toLowerCase() + ".jpg";
				FileInputStream imageStream = new FileInputStream(imageLocation);
				Image image = new Image(imageStream);
				EngineeringImage.setImage(image);
			}
			
			if(orderOfCommand[4].equals(PersonnelAL.get(i).getMemberPosition()))
			{
				name = PersonnelAL.get(i).getMemberName().split(" ");
				lastname = name[name.length - 1];
				HelmsmanLabel.setText(orderOfCommand[4] + "\n" + PersonnelAL.get(i).getMemberRank() + " " + PersonnelAL.get(i).getMemberName());
				if(lastname.equals("Sulu"))
				{
					imageLocation = "images/" + lastname.toLowerCase() + ".jpeg";
				}
				else 
				{
					imageLocation = "images/" + lastname.toLowerCase() + ".jpg";
				}
				FileInputStream imageStream = new FileInputStream(imageLocation);
				Image image = new Image(imageStream);
				HelmsmanImage.setImage(image);
			}
			
			if(orderOfCommand[5].equals(PersonnelAL.get(i).getMemberPosition()))
			{
				name = PersonnelAL.get(i).getMemberName().split(" ");
				lastname = name[name.length - 1];
				NavigatorLabel.setText(orderOfCommand[5] + "\n" + PersonnelAL.get(i).getMemberRank() + " " + PersonnelAL.get(i).getMemberName());
				imageLocation = "images/" + lastname.toLowerCase() + ".jpg";
				FileInputStream imageStream = new FileInputStream(imageLocation);
				Image image = new Image(imageStream);
				NavigatorImage.setImage(image);
			}
			
			if(orderOfCommand[6].equals(PersonnelAL.get(i).getMemberPosition()))
			{
				name = PersonnelAL.get(i).getMemberName().split(" ");
				lastname = name[name.length - 1];
				MedicalLabel.setText(orderOfCommand[6] + "\n" + PersonnelAL.get(i).getMemberRank() + " " + PersonnelAL.get(i).getMemberName());
				imageLocation = "images/" + lastname.toLowerCase() + ".jpg";
				FileInputStream imageStream = new FileInputStream(imageLocation);
				Image image = new Image(imageStream);
				MedicalImage.setImage(image);
			}
			
			if(orderOfCommand[7].equals(PersonnelAL.get(i).getMemberPosition()))
			{
				name = PersonnelAL.get(i).getMemberName().split(" ");
				lastname = name[name.length - 1];
				NurseLabel.setText(orderOfCommand[7] + "\n" + PersonnelAL.get(i).getMemberRank() + " " + PersonnelAL.get(i).getMemberName());
				imageLocation = "images/" + lastname.toLowerCase() + ".jpg";
				FileInputStream imageStream = new FileInputStream(imageLocation);
				Image image = new Image(imageStream);
				NurseImage.setImage(image);
			}
		}
	}


	@Override
	public void handle(ActionEvent e) {
	}
	
	/**
	 * Takes user back to login view
	 * 
	 * @author iog693
	 * @param e
	 */
	public void logOutButton(ActionEvent e) {
		try {
			Main.showLoginView();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
