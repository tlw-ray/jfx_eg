package com.tlw.jfx.layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class A10TilePane extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		TilePane tile = new TilePane();
		tile.setPadding(new Insets(5, 0, 5, 0));
		tile.setVgap(4);
		tile.setHgap(4);
		tile.setPrefColumns(2);
		tile.setStyle("-fx-background-color: DAE6F3;");

		Button[] pages = new Button[12];
		for (int i=0; i<pages.length; i++) {
		     pages[i] = new Button(i+"");
		     tile.getChildren().add(pages[i]);
		}
		
		Scene scene=new Scene(tile);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
