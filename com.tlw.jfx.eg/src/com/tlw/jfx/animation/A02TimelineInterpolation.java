package com.tlw.jfx.animation;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class A02TimelineInterpolation extends Application {
	
	Interpolator interpolator=Interpolator.LINEAR;

	@Override
	public void start(Stage primaryStage) throws Exception {
		Circle circle=new Circle(30, Color.RED);
		circle.setLayoutX(100);
		circle.setLayoutY(150);
		
		Group root=new Group();
		root.getChildren().add(circle);
		
		Scene scene=new Scene(root, 400, 300);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		KeyValue keyValue=new KeyValue(circle.translateXProperty(), 155, interpolator);
		Duration duration=Duration.seconds(1);
		KeyFrame keyFrame=new KeyFrame(duration, keyValue);
		
		Timeline timeline=new Timeline();
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.setAutoReverse(true);
		timeline.getKeyFrames().add(keyFrame);
		timeline.play();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
