package com.tlw.jfx.layout;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class A06FlowPane extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		FlowPane flowPane=new FlowPane();
		flowPane.setStyle("-fx-background-color: gray;");
		flowPane.setAlignment(Pos.BOTTOM_LEFT);
		for(int i=0;i<5;i++){
			Button button=new Button("Button"+i);
			flowPane.getChildren().add(button);
		}
		
		Group groupRoot=new Group(flowPane);
		Scene scene=new Scene(groupRoot, 400, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		flowPane.prefWidthProperty().bind(scene.widthProperty());
		flowPane.prefHeightProperty().bind(scene.heightProperty());
	}

	public static void main(String[] args) {
		launch(args);
	}

}
