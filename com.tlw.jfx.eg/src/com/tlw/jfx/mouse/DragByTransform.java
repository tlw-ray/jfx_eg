package com.tlw.jfx.mouse;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * @author liwei.tang@magustek.com
 * @since 2015年12月7日
 */
public class DragByTransform extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	class MouseDragger{
		double baseX;
		double baseY;
		
		EventHandler<MouseEvent> press=new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				baseX=event.getX();
				baseY=event.getY();
			}
		};
		EventHandler<MouseEvent> dragged=new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				Node node=(Node) event.getSource();
				double moveX=event.getX()-baseX;
				double moveY=event.getY()-baseY;
				node.setTranslateX(node.getTranslateX()+moveX);
				node.setTranslateY(node.getTranslateY()+moveY);
			}
		};
		
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Pane pane=new Pane();
		
		Rectangle rect=new Rectangle();
		rect.setX(50);
		rect.setY(50);
		rect.setWidth(100);
		rect.setHeight(100);
		
		MouseDragger dragger=new MouseDragger();
		
		rect.setOnMousePressed(dragger.press);
		
		rect.setOnMouseDragged(dragger.dragged);
		
		pane.getChildren().addAll(rect);
		
		Scene scene=new Scene(pane, 800, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
