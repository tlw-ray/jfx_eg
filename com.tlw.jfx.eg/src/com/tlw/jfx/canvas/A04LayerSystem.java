package com.tlw.jfx.canvas;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class A04LayerSystem extends Application {

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage primaryStage) throws Exception {
		Canvas layer1=new Canvas(400, 300);
		Canvas layer2=new Canvas(400, 300);
		
		GraphicsContext gc1=layer1.getGraphicsContext2D();
		gc1.setFill(Color.GREEN);
		gc1.fillOval(50, 50, 20, 20);
		
		GraphicsContext gc2=layer2.getGraphicsContext2D();
		gc2.setFill(Color.BLUE);
		gc2.fillOval(100, 100, 20, 20);
		
		Pane pane=new Pane();
		pane.getChildren().addAll(layer1, layer2);
		
		ObservableList<String> items=FXCollections.observableArrayList("Layer1(Green)","Layer2(Blue)");
		ComboBox<String> comboBox=new ComboBox<String>(items);
		comboBox.getSelectionModel().selectLast();
		
		BorderPane borderPane=new BorderPane();
		borderPane.setTop(comboBox);
		borderPane.setCenter(pane);
		
		Scene scene=new Scene(borderPane);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		comboBox.addEventHandler(ActionEvent.ACTION, e->{
			ComboBox<String> cb=(ComboBox<String>)e.getSource();
			if(cb.getSelectionModel().getSelectedIndex()==0){
				layer1.toFront();
			}else{
				layer2.toFront();
			}
		});
		
		layer1.setOnMouseClicked(e->{
			gc1.fillOval(e.getX(), e.getY(), 20, 20);
		});
		
		layer2.setOnMouseClicked(e->{
			gc2.fillOval(e.getX(), e.getY(), 20, 20);
		});
	}

	public static void main(String[] args) {
		launch(args);
	}

}
