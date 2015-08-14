package com.tlw.jfx.ui;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class A04ToggleButton extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		ToggleGroup tg=new ToggleGroup();
		
		ToggleButton tb1=new ToggleButton("tb1");
		tb1.setToggleGroup(tg);
		tb1.setUserData(Color.LIGHTGREEN);
		tb1.setStyle("-fx-base: lightgreen");
		ToggleButton tb2=new ToggleButton("tb2");
		tb2.setToggleGroup(tg);
		tb2.setUserData(Color.LIGHTBLUE);
		tb2.setStyle("-fx-base: lightblue");
		ToggleButton tb3=new ToggleButton("tb3");
		tb3.setToggleGroup(tg);
		tb3.setUserData(Color.SALMON);
		tb3.setStyle("-fx-base: salmon");
		
		Rectangle rect=new Rectangle();
		rect.setHeight(50);
		rect.setFill(Color.WHITE);
		rect.setStroke(Color.DARKGRAY);
		rect.setStrokeWidth(2);
		rect.setArcHeight(10);
		rect.setArcWidth(10);
		rect.setWidth(50);
		rect.setHeight(50);
		
		FlowPane flowPane=new FlowPane();
		flowPane.getChildren().addAll(tb1, tb2, tb3, rect);
		
		Scene scene=new Scene(flowPane, 400, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		tg.selectedToggleProperty().addListener(
			(ObservableValue<? extends Toggle> ov, Toggle ot, Toggle nt)->{
				if(nt==null){
					rect.setFill(Color.WHITE);
				}else{
					rect.setFill((Color)tg.getSelectedToggle().getUserData());
				}
			}
		);
	}

	public static void main(String[] args) {
		launch(args);
	}

}
