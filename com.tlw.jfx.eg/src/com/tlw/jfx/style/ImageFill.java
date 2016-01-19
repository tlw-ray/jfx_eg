package com.tlw.jfx.style;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * @author liwei.tang@magustek.com
 * @since 2015年12月14日
 */
public class ImageFill extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Rectangle rect=new Rectangle();
		rect.setWidth(400);
		rect.setHeight(300);
		rect.setStyle("-fx-fill:");
		Pane pane=new Pane();
		pane.getChildren().add(rect);
		Scene scene=new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
