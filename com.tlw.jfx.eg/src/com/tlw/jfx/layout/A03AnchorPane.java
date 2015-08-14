package com.tlw.jfx.layout;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class A03AnchorPane extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderStroke borderStroke=new BorderStroke(Color.BLUE, BorderStrokeStyle.DASHED, null, new BorderWidths(2));
		Border border=new Border(borderStroke);
		
		Button button=new Button("b1");
		
		AnchorPane anchorPane=new AnchorPane(button);
		anchorPane.setBorder(border);
		anchorPane.setPrefSize(400, 300);
		AnchorPane.setLeftAnchor(button, 10d);
		AnchorPane.setRightAnchor(button, 20d);
		AnchorPane.setTopAnchor(button, 30d);
		AnchorPane.setBottomAnchor(button, 40d);
		
		Scene scene=new Scene(anchorPane, 400, 300);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		anchorPane.prefWidthProperty().bind(scene.widthProperty());
		anchorPane.prefHeightProperty().bind(scene.heightProperty());
	}

	public static void main(String[] args) {
		launch(args);
	}

}
