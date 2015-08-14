package com.tlw.jfx.layout;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class A05VBox extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox vbox=new VBox();
		vbox.setStyle("-fx-background-color:gray");
		for(int i=0;i<5;i++){
			Button button=new Button("Button"+i);
			vbox.getChildren().add(button);
		}
		
		Group groupRoot=new Group(vbox);
		Scene scene=new Scene(groupRoot, 400, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		vbox.prefWidthProperty().bind(scene.widthProperty());
		vbox.prefHeightProperty().bind(scene.heightProperty());
	}

	public static void main(String[] args) {
		launch(args);
	}

}
