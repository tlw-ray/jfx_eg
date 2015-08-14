package com.tlw.jfx.canvas;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;

public class A02Gradients extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Canvas canvas=new Canvas(400, 300);
		GraphicsContext gc=canvas.getGraphicsContext2D();
		gc.setLineWidth(5);
		gc.setStroke(Color.RED);
		
		gc.strokeLine(40, 10, 10, 40);
		
		gc.beginPath();
		gc.moveTo(80, 80);
		gc.bezierCurveTo(150, 20, 150, 150, 75, 150);
		gc.closePath();
		
		Color firstColor=Color.YELLOW;
		Color secondColor=Color.RED;
		Color thirdColor=Color.GREEN;
		Color fourthColor=Color.AQUA;
		
		//填充
	    gc.setFill(new RadialGradient(0, 0, 0.5, 0.5, 0.1, true,
	               CycleMethod.REFLECT,
	               new Stop(0.0, firstColor),
	               new Stop(1.0, secondColor)));
	    gc.fill();
	    
	    //描边
	    LinearGradient lg = new LinearGradient(0, 0, 1, 1, true,
                CycleMethod.REFLECT,
                new Stop(0.0, firstColor),
                new Stop(1.0, secondColor));
		gc.setStroke(lg);
		gc.setLineWidth(20);
		gc.stroke();
		
		//阴影
	    gc.applyEffect(new DropShadow(20, 20, 0, firstColor));
	    gc.applyEffect(new DropShadow(20, 0, 20, secondColor));
	    gc.applyEffect(new DropShadow(20, -20, 0, thirdColor));
	    gc.applyEffect(new DropShadow(20, 0, -20, fourthColor));
		
		Group groupRoot=new Group(canvas);
		Scene scene=new Scene(groupRoot);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
