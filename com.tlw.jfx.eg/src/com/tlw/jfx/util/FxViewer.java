package com.tlw.jfx.util;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * @author liwei.tang@magustek.com
 * @since 2015年9月17日
 */
public class FxViewer extends Application {
	
	public static void main(String[] args) {
		FxViewer.launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene scene=new Scene(new Button("Hello"));
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void show(Parent parent, int width, int height){
		
	}

}
