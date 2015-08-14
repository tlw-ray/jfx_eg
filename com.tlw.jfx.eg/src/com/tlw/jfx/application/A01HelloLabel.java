package com.tlw.jfx.application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
@author liwei.tang@magustek.com
@since 2014年1月24日 上午9:21:12
一个最简单的JavaFX例子
 */
public class A01HelloLabel extends Application{

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Label label=new Label("Hello World");
		Scene scene=new Scene(label, 300, 275);
		
		primaryStage.setTitle("JavaFX Welcome!");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
