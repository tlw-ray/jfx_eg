package com.tlw.jfx.animation;

import javafx.animation.FadeTransition;
import javafx.animation.FadeTransitionBuilder;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class B01TransitionFade extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Rectangle rect=new Rectangle(50,50,100,100);
		rect.setArcHeight(40);
		rect.setArcWidth(40);
		rect.setFill(Color.BLUE);
		
		Group root=new Group();
		root.getChildren().add(rect);
		
		Scene scene=new Scene(root, 400, 300);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		FadeTransition fadeTransition=FadeTransitionBuilder.create()
				.duration(Duration.seconds(0.5))
				.node(rect)
				.fromValue(1)
				.toValue(0.2)
				.cycleCount(Timeline.INDEFINITE)
				.autoReverse(true)
				.build();
		
		fadeTransition.play();
	}

}
