package com.tlw.jfx.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class A05CheckBox extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		CheckBox cb1=new CheckBox("false");
		CheckBox cb2=new CheckBox("true");
		cb2.setSelected(true);
		CheckBox cb3=new CheckBox("true/false");
		cb3.setIndeterminate(true);
		
		FlowPane flowPane=new FlowPane();
		flowPane.getChildren().addAll(cb1, cb2, cb3);
		
		Scene scene=new Scene(flowPane, 400, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
