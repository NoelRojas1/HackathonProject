package controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.util.Random;

public class GroundingListController {
	
    @FXML private ToggleGroup grounding;
    @FXML private Button groundingSelection;
	
	@FXML
	void startGrounding(ActionEvent event) {
		
	}
	
	@FXML 
	void goBack(ActionEvent event) {
		try {
			Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("../views/Main.fxml"));
			//Load the view for the type of machine chosen
			AnchorPane center = (AnchorPane)root.getCenter();
			//Set the center of the border pane depending on the type of machine chosen
			root.setCenter(center);
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("../assets/styleSheets/application.css").toExternalForm());
			primaryStage.setTitle("Grounding");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(IOException e) {
			System.out.println(e.toString());
		}
	}
	
	private String FiveToOne() {
		String fiveToOne = "What are 5 things you can see? Look for small details such as a pattern on the \r\n"
				+ "ceiling, the way light reflects off a surface, or an object you never noticed.\r\n"
				+ "What are 4 things you can feel? Notice the sensation of clothing on your body, the \r\n"
				+ "sun on your skin, or the feeling of the chair you are sitting in. Pick up an object and \r\n"
				+ "examine its weight, texture, and other physical qualities.\r\n"
				+ "What are 3 things you can hear? Pay special attention to the sounds your mind \r\n"
				+ "has tuned out, such as a ticking clock, distant traffic, or trees blowing in the wind.\r\n"
				+ "What are 2 things you can smell? Try to notice smells in the air around you, like an \r\n"
				+ "air freshener or freshly mowed grass. You may also look around for something \r\n"
				+ "that has a scent, such as a flower or an unlit candle.\r\n"
				+ "What is 1 thing you can taste? Carry gum, candy, or small snacks for this step. Pop \r\n"
				+ "one in your mouth and focus your attention closely on the flavors.";
		
		return fiveToOne;
	}
	
	private String categories(int num) {
		String category = "";
		switch(num) {
			case 0: category = "Movies";
				break;
			case 1: category = "Sports Teams";
				break;
			case 2: category = "Animals";
				break;
			case 3: category = "Countries";
				break;
			case 4: category = "Colors";
				break;
			case 5: category = "Cities";
				break;
			case 6: category = "Books";
				break;
			case 7: category = "Cars";
				break;
			case 8: category = "Tv Shows";
				break;
			case 9: category = "Cereals";
				break;
			case 10: category = "Fruits or Vegetables";
				break;
			case 11: category = "Famous People";
				break;
		}
		String categories = "Name as many " + category + " as you can think of in 1 minute.";
		return categories;
	}
	
	//Helper method(s)
	private int randomNumberOnetoEleven() {
		Random rand = new Random();
		int randNum = rand.nextInt((11 + 1));
		
		return randNum;
	}
}
