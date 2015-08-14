package com.tlw.jfx.ui;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

//TODO 这里圆形会挡住横向滚动条的事件触发

public class A09ScrollBarCustom extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Circle circle=new Circle(20, Color.GREEN);
		circle.setLayoutX(20);
		circle.setLayoutY(20);
		
		Pane pane=new Pane(circle);
		pane.setStyle("-fx-background-color:gray");
		
		ScrollBar scrollBarX=new ScrollBar();
		scrollBarX.setMax(100);
		scrollBarX.setVisibleAmount(50);
		
		ScrollBar scrollBarY=new ScrollBar();
		scrollBarY.setOrientation(Orientation.VERTICAL);
		scrollBarY.setMax(100);
		scrollBarY.setVisibleAmount(50);
		
		GridPane gridPane=new GridPane();
		gridPane.add(scrollBarX, 0, 0);
		gridPane.add(pane, 0, 1);
		gridPane.add(scrollBarY, 1, 1);
		GridPane.setHgrow(pane, Priority.ALWAYS);
		GridPane.setVgrow(pane, Priority.ALWAYS);
		
		Scene scene=new Scene(gridPane);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		circle.layoutXProperty().bind(scrollBarX.valueProperty());
		circle.layoutYProperty().bind(scrollBarY.valueProperty());
	}

	public static void main(String[] args) {
		launch(args);
	}

}
