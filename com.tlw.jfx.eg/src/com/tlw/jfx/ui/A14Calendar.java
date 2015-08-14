package com.tlw.jfx.ui;

import java.time.LocalDate;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

public class A14Calendar extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		DatePicker datePicker=new DatePicker();
		datePicker.setValue(LocalDate.now());
		Scene scene=new Scene(datePicker);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
