package com.tlw.jfx.charts;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class A01AreaChart extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		NumberAxis xAxis=new NumberAxis();
		NumberAxis yAxis=new NumberAxis();
		AreaChart<Number, Number> areaChart=new AreaChart<Number, Number>(xAxis, yAxis);
		
		AnchorPane anchorPane=new AnchorPane(areaChart);
		AnchorPane.setTopAnchor(areaChart, 5d);
		AnchorPane.setLeftAnchor(areaChart, 5d);
		AnchorPane.setBottomAnchor(areaChart, 5d);
		AnchorPane.setRightAnchor(areaChart, 5d);
		
		Group root=new Group();
		root.getChildren().add(anchorPane);
		
		Scene scene=new Scene(root, 400, 300);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
