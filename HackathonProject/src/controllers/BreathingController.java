package controllers;

import java.util.Timer;
import java.util.TimerTask;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BreathingController{
	
    @FXML private TextField txtBreathing, txtTime;
    
    int secondsPassed = 0;
    int numcount = 1;
    Timer myTimer = new Timer(); 
	TimerTask task = new TimerTask() {
		public void run() {
			secondsPassed++;
			txtTime.setText(String.format("00:%02d", 30-secondsPassed));
			if(secondsPassed%3==0) {
				if(numcount%2 == 0) {
					txtBreathing.setText("Breathe in");
					numcount++;
				}
				else {
					txtBreathing.setText("Breathe out");
					numcount++;
				}
			}
			if(secondsPassed == 30) {
				txtBreathing.setText("Good Job!");
				myTimer.cancel();
			}
		}
	};

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
			primaryStage.setTitle("Grounded");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(IOException e) {
			System.out.println(e.toString());
		}
	}
	
    @FXML
    void startTimer(ActionEvent event)  {
    	txtBreathing.setText("Breathe in");
    	txtTime.setText("00:30");
		start();
    }
    
	public void start() {
		myTimer.scheduleAtFixedRate(task, 1000, 1000);
		
	}
}
