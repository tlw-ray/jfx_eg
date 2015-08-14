package com.tlw.jfx.layout;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class A04HBox extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		HBox hbox=new HBox();
		hbox.setStyle("-fx-background-color:gray");
		for(int i=0;i<5;i++){
			Button button=new Button("Button"+i);
			hbox.getChildren().add(button);
		}
		
		Group groupRoot=new Group(hbox);
		Scene scene=new Scene(groupRoot, 400, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		hbox.prefWidthProperty().bind(scene.widthProperty());
		hbox.prefHeightProperty().bind(scene.heightProperty());
	}

	public static void main(String[] args) {
		launch(args);
	}

}
