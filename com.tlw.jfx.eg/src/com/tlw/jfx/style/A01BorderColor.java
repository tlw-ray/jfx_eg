package com.tlw.jfx.style;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class A01BorderColor extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Label label=new Label("Hello!");
		//set control background
		label.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, new Insets(3))));
		//set control border
		label.setBorder(new Border(new BorderStroke(Color.BROWN, BorderStrokeStyle.DOTTED, CornerRadii.EMPTY, new BorderWidths(2))));
		
		Circle circle=new Circle(50, 50, 30, Color.GRAY);
		//set shape border
		circle.setStroke(Color.RED);
		
		Group root=new Group();
		root.getChildren().addAll(label, circle);
		
		Scene scene=new Scene(root, 400, 300);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
