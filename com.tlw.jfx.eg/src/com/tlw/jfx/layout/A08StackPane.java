package com.tlw.jfx.layout;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class A08StackPane extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Button button1=new Button("Button1");
		Button button2=new Button("Button2");
		button1.setPrefHeight(40);
		button1.setPrefWidth(60);
		
		StackPane stackPane=new StackPane();
		stackPane.getChildren().addAll(button1, button2);
		stackPane.setStyle("-fx-background-color:gray;");
		
		Scene scene=new Scene(stackPane, 400, 300);
		primaryStage.setScene(scene);
		primaryStage.show();

		button1.setOnAction(e->{
			stackPane.getChildren().removeAll(button1, button2);
			stackPane.getChildren().add(button2);
		});
		
		button2.setOnAction(e->{
			stackPane.getChildren().removeAll(button1, button2);
			stackPane.getChildren().add(button1);
		});
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
