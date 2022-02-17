package application;

import java.io.IOException;

import application.view.PersonnelController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	private static Stage primaryStage;
	private static AnchorPane loginLayout;
	
	/**
	 * Starts the application
	 * 
	 * @author iog693
	 * @parm Primary stage for the app
	 */
	@Override
	public void start(Stage primaryStage) throws IOException 
	{
		Main.primaryStage = primaryStage;
		Main.primaryStage.setTitle("Federation App");
		showLoginView();
	}
	
	/**
	 * Shows Login view
	 * 
	 * @author iog693
	 * @throws IOException
	 */
	public static void showLoginView() throws IOException
	{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/Login.fxml"));
		loginLayout = loader.load();
		Scene scene = new Scene(loginLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	/**
	 * Shows Personnel View
	 * 
	 * @param username that was inputed in login view
	 * @throws IOException
	 */
	public static void showPersonnelView(String username) throws IOException
	{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/Personnel.fxml"));
		PersonnelController cc = new PersonnelController(username);
		loader.setController(cc);
		AnchorPane personnelLayout = loader.load();
		loginLayout.getChildren().setAll(personnelLayout);
	}
	
	/**
	 * Main function of the app
	 * 
	 * @author iog693
	 * @param args
	 */
	public static void main(String[] args) 
	{
		launch(args);
	}
}