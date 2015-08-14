package com.tlw.jfx.css;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class A01ImportCss extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Button button=new Button("Button1");
		button.getStyleClass().add("button1");
		
		Pane pane=new Pane(button);
		
		Scene scene=new Scene(pane, 400, 300);
		scene.getStylesheets().add("css1.css");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
