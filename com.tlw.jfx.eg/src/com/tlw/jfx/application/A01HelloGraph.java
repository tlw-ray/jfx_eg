package com.tlw.jfx.application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class A01HelloGraph extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Circle circle=new Circle(40, 40, 30);
		Group root=new Group(circle);
		Scene scene=new Scene(root, 400, 300);
		
		primaryStage.setTitle("Hello Graph");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
