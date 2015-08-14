package com.tlw.jfx.filechooser;

import java.io.File;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

/**
 * @author liwei.tang@magustek.com
 * @since 2015年4月29日
 */
public class A01FileChooser extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FileChooser fileChooser=new FileChooser();
		fileChooser.setSelectedExtensionFilter(new ExtensionFilter("图像文件", new String[]{"xml", "gif"}));
		fileChooser.setInitialDirectory(new File("E:"));
		System.out.println(fileChooser.getInitialFileName());
		
		Button button=new Button("...");
		button.addEventHandler(ActionEvent.ACTION, e->{
			fileChooser.showOpenDialog(primaryStage);
		});
		
		Scene scene=new Scene(button, 400, 300);
		primaryStage.setScene(scene);
		primaryStage.setTitle("FileChooser");
		primaryStage.show();
	}
}
