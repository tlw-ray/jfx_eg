package com.tlw.jfx.ui;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class A06ChoiceBox extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		ObservableList<Object> ol=FXCollections.observableArrayList(
				"First", "Second", new Separator(), "Third");
		ChoiceBox<Object> choiceBox=new ChoiceBox<Object>(ol);
		choiceBox.setTooltip(new Tooltip("Hello!"));
		Label label=new Label();
		
		FlowPane flowPane=new FlowPane();
		flowPane.getChildren().addAll(choiceBox, label);
		
		Scene scene=new Scene(flowPane, 400, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		choiceBox.getSelectionModel().selectedIndexProperty().addListener(
			(ObservableValue<? extends Number> ov, Number oldValue, Number newValue)->{
				label.setText(ol.get(newValue.intValue()).toString());
			}
		);
	}

	public static void main(String[] args) {
		launch(args);
	}

}
