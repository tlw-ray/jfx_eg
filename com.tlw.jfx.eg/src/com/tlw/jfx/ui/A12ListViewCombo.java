package com.tlw.jfx.ui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.stage.Stage;

public class A12ListViewCombo extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		ObservableList<String> names=FXCollections.observableArrayList(
				"Adam", "Alex", "Alfred", "Albert",
	             "Brenda", "Connie", "Derek", "Donny", 
	             "Lynne", "Myrtle", "Rose", "Rudolph", 
	             "Tony", "Trudy", "Williams", "Zach");
		ObservableList<String> data=FXCollections.observableArrayList();
		for(int i=0;i<10;i++){
			data.add("anonym"+i);
		}
		
		ListView<String> listView=new ListView<String>(data);
		listView.setCellFactory(ComboBoxListCell.forListView(names));
		listView.setEditable(true);
		
		Scene scene=new Scene(listView);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
