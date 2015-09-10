package com.tlw.jfx.bind;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author liwei.tang@magustek.com
 * @since 2015年8月14日
 */
public class B01BindTextField extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		String text="hello";
		TextField tf1=new TextField(text);
		TextField tf2=new TextField(text);
		TextField tf3=new TextField(text);
		VBox vbox=new VBox();
		vbox.getChildren().add(tf1);
		vbox.getChildren().add(tf2);
		vbox.getChildren().add(tf3);
		Scene scene=new Scene(vbox);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		//TODO how to?
	}

}
