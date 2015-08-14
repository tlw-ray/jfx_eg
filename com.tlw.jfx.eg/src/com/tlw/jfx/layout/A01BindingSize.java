package com.tlw.jfx.layout;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
//实现控件大小的绑定
public class A01BindingSize extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		int margin=20;
		Button button=new Button("Button");
		button.setLayoutX(margin);
		button.setLayoutY(margin);
		
		Group groupRoot=new Group(button);
		Scene scene=new Scene(groupRoot, 400, 300);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		button.prefWidthProperty().bind(scene.widthProperty().subtract(margin*2));
		button.prefHeightProperty().bind(scene.heightProperty().subtract(margin*2));
	}

	public static void main(String[] args) {
		launch(args);
	}

}
