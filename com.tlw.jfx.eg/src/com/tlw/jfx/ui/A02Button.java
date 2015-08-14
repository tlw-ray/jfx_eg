package com.tlw.jfx.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class A02Button extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Button button1=new Button();
		Button button2=new Button("Accept");
		Image imageOk=new Image(getClass().getResourceAsStream("ok.jpeg"));
		Button button3=new Button("Accept", new ImageView(imageOk));
		
		FlowPane flowPane=new FlowPane();
		flowPane.getChildren().addAll(button1, button2, button3);
		
		Scene scene=new Scene(flowPane, 400, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		DropShadow shadow=new DropShadow();
		button3.setOnMouseEntered(e->{
			button3.setEffect(shadow);
		});
		
		button3.setOnMouseExited(e->{
			button3.setEffect(null);
		});
	}

	public static void main(String[] args) {
		launch(args);
	}

}
