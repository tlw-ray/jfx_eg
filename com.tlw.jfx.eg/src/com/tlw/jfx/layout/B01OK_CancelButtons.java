package com.tlw.jfx.layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author liwei.tang@magustek.com
 * @since 2015年4月29日
 */
public class B01OK_CancelButtons extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Button okButton=new Button("Button");
		Button cancelButton=new Button("Cancel");
		Button centerButton=new Button("Center");
		
		HBox buttonsBox =new HBox(20);
		buttonsBox.getChildren().add(okButton);
		buttonsBox.getChildren().add(cancelButton);
		buttonsBox.setAlignment(Pos.CENTER);
		
		BorderPane borderPanel=new BorderPane();
		borderPanel.setBottom(buttonsBox);
		borderPanel.setCenter(centerButton);
		BorderPane.setMargin(centerButton, new Insets(20, 10, 10, 10)); 
		BorderPane.setMargin(buttonsBox, new Insets(10, 10, 20, 10)); 

		
		Scene scene=new Scene(borderPanel, 400, 300);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
