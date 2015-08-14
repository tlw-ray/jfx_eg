package com.tlw.jfx.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class A08ScrollBarSingle extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		ScrollBar sc=new ScrollBar();
		
		Label label=new Label("hi");
		
		FlowPane flowPane=new FlowPane();
		flowPane.getChildren().addAll(sc, label);
		
		Scene scene=new Scene(flowPane, 400, 300);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		label.textProperty().bind(sc.valueProperty().asString());
	}

	public static void main(String[] args) {
		launch(args);
	}

}
