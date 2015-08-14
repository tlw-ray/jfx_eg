package com.tlw.jfx.image;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class A01LoadAndDisplay extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Image image = new Image("http://docs.oracle.com/javafx/"
        + "javafx/images/javafx-documentation.png");
		ImageView imageView=new ImageView(image);
		
		Pane pane=new Pane(imageView);
		pane.setStyle("-fx-background-color:gray");
		
		Scene scene=new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
