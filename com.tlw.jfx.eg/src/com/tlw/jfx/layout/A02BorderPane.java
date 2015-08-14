package com.tlw.jfx.layout;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class A02BorderPane extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderStroke borderStroke=new BorderStroke(Color.BLUE, BorderStrokeStyle.DASHED, null, new BorderWidths(2));
		Border border=new Border(borderStroke);
		
		Button b1=new Button("b1");
		Button b2=new Button("b2");
		Button b3=new Button("b3");
		Button b4=new Button("b4");
		Button b5=new Button("b5");
		Button b6=new Button("b6");
		
		HBox hboxTop=new HBox();
		hboxTop.setBorder(border);
		hboxTop.setStyle("-fx-background-color: #336699;");
		hboxTop.getChildren().addAll(b1,b2,b3);
		
		VBox vboxLeft=new VBox();
		vboxLeft.setStyle("-fx-background-color: #996633;");
		vboxLeft.setBorder(border);
		vboxLeft.getChildren().addAll(b4,b5,b6);
		
		BorderPane borderPane=new BorderPane();
		borderPane.setTop(hboxTop);
		borderPane.setCenter(new Button("center"));
		borderPane.setLeft(vboxLeft);
		borderPane.setRight(new Button("right"));
		borderPane.setBottom(new Button("bottom"));
		
		Scene scene=new Scene(borderPane, 400, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
