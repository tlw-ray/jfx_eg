package com.tlw.jfx.canvas;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class A03Interacting extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	Canvas canvas=new Canvas(400,300);
	GraphicsContext gc=canvas.getGraphicsContext2D();

	@Override
	public void start(Stage primaryStage) throws Exception {

		reset();
		
		canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, e->{
			gc.clearRect(e.getX()-2, e.getY()-2, 5, 5);
		});
		
		canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, e->{
			if(e.getClickCount()==2)reset();
		});
		
		Group groupRoot=new Group(canvas);
		Scene scene=new Scene(groupRoot);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private void reset(){
		gc.setFill(Color.BLUE);
		gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		gc.setFill(Color.WHITE);
		gc.setFont(Font.font("宋体", 20));
		gc.fillText("Please drag mouse !\nDouble click to reset !", 20, 20);
	}
	
}
