package com.tlw.jfx.ui;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class A07TextField extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Label labelName=new Label("用户名:");
		Label labelDesc=new Label("密码:");
		
		TextField textFieldName=new TextField();
		textFieldName.setPromptText("请输入名称...");
		
		PasswordField textFieldDesc=new PasswordField();
		textFieldDesc.setPromptText("Please input desc...");
		
		Button buttonOK=new Button("ok");
		
		GridPane gridPane=new GridPane();
		gridPane.setPadding(new Insets(10, 10, 10, 10));
		gridPane.setHgap(5);
		gridPane.setVgap(5);
		gridPane.add(labelName, 0, 0);
		gridPane.add(textFieldName, 1, 0);
		gridPane.add(labelDesc, 0, 1);
		gridPane.add(textFieldDesc, 1, 1);
		gridPane.add(buttonOK, 0, 2);
		
		GridPane.setColumnSpan(buttonOK, 2);
		GridPane.setHalignment(buttonOK, HPos.CENTER);
		
		Scene scene=new Scene(gridPane, 400, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
