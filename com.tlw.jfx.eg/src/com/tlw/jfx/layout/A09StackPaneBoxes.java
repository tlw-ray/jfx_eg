package com.tlw.jfx.layout;

import javafx.animation.RotateTransition;
import javafx.animation.RotateTransitionBuilder;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class A09StackPaneBoxes extends Application {

    int i = 0;
    private RotateTransition rotateTransition;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		final StackPane root = new StackPane();

        Scene scene = new Scene(root, 600, 600);
        scene.setFill(Color.CORNFLOWERBLUE);
        //create Task for generating new Rectangle after the window is opened
        Task<Object> t = new Task<Object>() {
            @Override
            protected Object call() throws Exception {
                //store colors for every new rectangle
                final Color a[] = {Color.BLUEVIOLET,
                    Color.AQUA, Color.BROWN, Color.CRIMSON, Color.BURLYWOOD,
                    Color.CADETBLUE, Color.CHARTREUSE, Color.DARKGOLDENROD,
                    Color.DARKSLATEGREY, Color.STEELBLUE,
                    Color.ORANGERED, Color.GOLD, Color.LIGHTSKYBLUE};
                
                for (i = 0; i < a.length; i++) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {

                            root.getChildren().add(new Rectangle(600 - (i * 50), 600 - (i * 50), a[i]));
                        }
                    });
                    //gap between gnerating new rectangle
                    Thread.sleep(500);
                }
                //after geberating rectangle rotate the entire root element using rotate transtion
                rotateTransition = RotateTransitionBuilder.create()
                        .node(root)
                        .duration(Duration.seconds(6))
                        .fromAngle(0)
                        .toAngle(360)
                        .cycleCount(Timeline.INDEFINITE)
                        .autoReverse(true)
                        .build();
                rotateTransition.play();
                return null;
            }
        };
        //insert task t in a new thread and start it
        new Thread(t).start();
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();

	}
	
	public static void main(String[] args) {
		launch(args);
	}


}
