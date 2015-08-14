package com.tlw.jfx.ui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class A11ListView extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		ObservableList<String> items=FXCollections.observableArrayList(
				"Single","Double","Suite","Family App");
		ListView<String> listView=new ListView<String>(items);
		Scene scene=new Scene(listView, 400, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
