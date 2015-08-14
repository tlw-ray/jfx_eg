package com.tlw.jfx.layout;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class A07GridPane extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Label label=new Label("Label:");
		TextField textField=new TextField();
		Button button=new Button("GO");
		TextArea textArea=new TextArea();
		
		//去除默认的滚动条
		textArea.setPrefWidth(100);
		textArea.setPrefHeight(100);
		
		//布局
		GridPane gridPane=new GridPane();
		gridPane.add(label, 0, 0);
		gridPane.add(textField, 1, 0);
		gridPane.add(button, 2, 0);
		gridPane.add(textArea, 0, 1);
		
		//约束
		GridPane.setColumnSpan(textArea, 3);
		GridPane.setHgrow(textField, Priority.ALWAYS);
		GridPane.setVgrow(textArea, Priority.ALWAYS);
		
		Group groupRoot=new Group(gridPane);
		Scene scene=new Scene(groupRoot, 400, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		gridPane.prefWidthProperty().bind(scene.widthProperty());
		gridPane.prefHeightProperty().bind(scene.heightProperty());
	}

	public static void main(String[] args) {
		launch(args);
	}

}
