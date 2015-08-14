package com.tlw.jfx.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class A10ScrollPane extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Image image=new Image(getClass().getResourceAsStream("face.jpg"));
		ImageView imageView=new ImageView(image);
		ScrollPane scrollPane=new ScrollPane(imageView);
		scrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
		
		Scene scene=new Scene(scrollPane, 400, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
