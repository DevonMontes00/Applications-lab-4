 package application.view;

import java.io.IOException;
import application.Main;
import application.model.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;




public class LoginController implements EventHandler <ActionEvent> {
	
	@FXML
	private TextArea username;
	
	@FXML
	private PasswordField passphrase;
	
	@FXML
	private Button login;
	
	@FXML 
	private ImageView image;
	
	@FXML
	private Label errorText;
	
	/**
	 * Handles login button
	 * 
	 * @author iog693
	 * @param ActionEvent e
	 */
	public void handle(ActionEvent e)
	{
		String inputName = username.getText();
		String inputPass = passphrase.getText();
		User test = new User(inputName, inputPass);
		User u = test.validate(inputName, inputPass);

		
		if(u == null)
		{
			errorText.setText("Incorrect Username or Password");
		}
		else
		{
			try {
				Main.showPersonnelView(u.getUsername());
			} catch (IOException e1) {
			// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	
}