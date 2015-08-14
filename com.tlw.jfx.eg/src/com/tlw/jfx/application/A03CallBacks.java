package com.tlw.jfx.application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class A03CallBacks extends Application {

	
	
	@Override
	public void init() throws Exception {
		System.out.println("init...");
	}

	@Override
	public void stop() throws Exception {
		System.out.println("stop...");
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println("start...");
		Group root=new Group();
		Scene scene=new Scene(root, 400, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
