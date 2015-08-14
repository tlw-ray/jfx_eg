package com.tlw.jfx.event;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class A01FilterAndHandler extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Circle circle=new Circle(40, 40, 30);
		Group root=new Group(circle);
		Scene scene=new Scene(root, 400, 300);
		
		circle.addEventHandler(MouseEvent.MOUSE_CLICKED, e->{System.out.println("handle:"+e);});
		circle.addEventFilter(MouseEvent.MOUSE_CLICKED, e->{System.out.println("filter:"+e);});
		
		root.addEventHandler(MouseEvent.MOUSE_CLICKED, e->{System.out.println("handle:"+e);});
		root.addEventFilter(MouseEvent.MOUSE_CLICKED, e->{System.out.println("filter:"+e);});
		
		primaryStage.setTitle("Hello Graph");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
