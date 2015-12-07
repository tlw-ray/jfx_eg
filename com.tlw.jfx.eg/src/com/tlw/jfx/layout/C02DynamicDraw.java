package com.tlw.jfx.layout;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;


/**
 * @author liwei.tang@magustek.com
 * @since 2015年11月12日
 */
public class C02DynamicDraw extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Pane pane=new Pane();
		Polyline polyline=new Polyline();
		Circle circle=new Circle();
		VBox vbox=new VBox();
		Button btn1=new Button();
		Button btn2=new Button();
		vbox.getChildren().addAll(btn1, circle, btn2);
		
		polyline.getPoints().addAll(0d, 0d, 50d, 50d, 100d, 150d);
		polyline.setVisible(true);
		polyline.setFill(Color.RED);
		
		circle.setRadius(50);
		circle.setVisible(true);
		circle.setFill(Color.BLUE);
		
		vbox.setLayoutX(150);
		vbox.setLayoutY(200);
		
		vbox.setOnMouseDragged(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				vbox.setLayoutX(event.getSceneX());
				vbox.setLayoutY(event.getSceneY());
			}
		});
		
		vbox.layoutXProperty().addListener(new ChangeListener<Number>(){
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				polyline.getPoints().set(4, newValue.doubleValue());
			}
		});
		
		vbox.layoutYProperty().addListener(new ChangeListener<Number>(){
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				polyline.getPoints().set(5, newValue.doubleValue());
			}
		});
		
		circle.layoutXProperty().addListener(new ChangeListener<Number>(){
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				polyline.getPoints().set(4, vbox.getLayoutX());
			}
		});
		
		circle.layoutYProperty().addListener(new ChangeListener<Number>(){
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				polyline.getPoints().set(5, vbox.getLayoutY());
			}
		});
		
		pane.getChildren().addAll(vbox, polyline);
		
		Scene scene=new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
