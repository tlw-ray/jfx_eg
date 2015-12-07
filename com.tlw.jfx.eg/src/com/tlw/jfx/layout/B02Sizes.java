package com.tlw.jfx.layout;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author liwei.tang@magustek.com
 * @since 2015年9月28日
 */
public class B02Sizes extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	public static void showSizes(Control control){
		System.out.println(control);
		System.out.println("Min: "+control.getMinWidth()+"\t"+control.getMinHeight());
		System.out.println("Pref: "+control.getPrefWidth()+"\t"+control.getPrefHeight());
		System.out.println("Max: "+control.getMaxWidth()+"\t"+control.getMaxHeight());
		
	}
	
	double ddd=100;

	@Override
	public void start(Stage arg0) throws Exception {
		
		TextField tf=new TextField();
		Spinner<Integer> sp=new Spinner<Integer>(0, 100, 10);
		
		Button button=new Button("show");
		
		button.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				System.out.println(ddd+sp.getLayoutX());
				sp.setLayoutX(sp.getLayoutX()+50);
				sp.setLayoutY(sp.getLayoutY()+50);
			}
		});
		
//		Bindings.createDoubleBinding(new Callable<Double>(){
//			@Override
//			public Double call() throws Exception {
//				System.out.println(sp.getLayoutX());
//				return null;
//			}
//		}, sp.layoutXProperty());
		
//		sp.layoutBoundsProperty().addListener(new ChangeListener<Bounds>(){
//			@Override
//			public void changed(ObservableValue<? extends Bounds> observable, Bounds oldValue, Bounds newValue) {
//				System.out.println(newValue);
//			}
//		});
		
//		FlowPane pane=new FlowPane();
//		BorderPane pane=new BorderPane();
		sp.setLayoutX(50);
		sp.setLayoutY(50);
		
		Pane pane=new Pane();
		pane.getChildren().addAll(tf, sp, button);
		Scene scene=new Scene(pane);
		arg0.setScene(scene);
		arg0.show();
		
		showSizes(tf);
		showSizes(sp);
	}

}
