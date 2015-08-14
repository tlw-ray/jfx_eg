package com.tlw.jfx.ui;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class A03RadioButton extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		ToggleGroup group=new ToggleGroup();
		RadioButton rb1=new RadioButton("rb1");
		rb1.setToggleGroup(group);
		RadioButton rb2=new RadioButton("rb2");
		rb2.setToggleGroup(group);
		RadioButton rb3=new RadioButton("rb3");
		rb3.setToggleGroup(group);
		
		FlowPane flowPane=new FlowPane();
		flowPane.getChildren().addAll(rb1, rb2, rb3);
		
		Scene scene=new Scene(flowPane, 400,300);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		group.selectedToggleProperty().addListener(
			(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) -> {
				if (group.getSelectedToggle() != null) {
					System.out.println(new_toggle);
				}
			}
		);
	}

	public static void main(String[] args) {
		launch(args);
	}

}
