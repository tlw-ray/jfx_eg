package com.tlw.jfx.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class A01Label extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Image image=new Image(getClass().getResourceAsStream("search-label.png"));
		ImageView imageView=new ImageView(image);
		
		Label label1=new Label("Search");
		label1.setGraphic(imageView);
		
		//set text fill
		label1.setTextFill(Color.web("#0076a3"));
		
		//set font
		label1.setFont(new Font("Arial", 30));

		Label label2=new Label("A label that needs to wrapped.");
		label2.setWrapText(true);
		
		Label label3=new Label("Value");
		label3.setFont(new Font("Cambria", 32));
		label3.setRotate(270);
		label3.setTranslateY(50);
		label3.setOnMouseEntered(e->{
			label3.setScaleX(1.5);
			label3.setScaleY(1.5);
		});
		label3.setOnMouseExited(e->{
			label3.setScaleX(1);
			label3.setScaleY(1);
		});
		
		FlowPane pane=new FlowPane();
		pane.setStyle("-fx-background-color:gray");
		pane.getChildren().addAll(label1, label2, label3);
		
		Scene scene=new Scene(pane, 400, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
