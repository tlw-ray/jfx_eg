package com.tlw.jfx.animation;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class A01TimeLine extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		final Circle circle=new Circle(20, Color.GREEN);
		circle.setLayoutX(200);
		circle.setLayoutY(150);
		
		Group root=new Group();
		root.getChildren().add(circle);
		
		Scene scene=new Scene(root, 400, 300);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		//变化周期
		Duration duration=Duration.seconds(2);
		
//		//结束时回调
		EventHandler<ActionEvent> onFinished=e->{};
		
		//变化属性
		KeyValue keyValueX=new KeyValue(circle.scaleXProperty(), 2);
		KeyValue keyValueY=new KeyValue(circle.scaleYProperty(), 2);
		
		//关键帧
		KeyFrame keyFram=new KeyFrame(duration, onFinished, keyValueX, keyValueY);
		
		//时间线
		Timeline timeline=new Timeline();
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.setAutoReverse(true);
		timeline.getKeyFrames().add(keyFram);
		timeline.play();
		
		//动画帧￼监听
		AnimationTimer animationTimer=new AnimationTimer(){
			@Override
			public void handle(long now) {
			}
		};
		animationTimer.start();
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
