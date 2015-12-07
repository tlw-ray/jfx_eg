package com.tlw.jfx.layout;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * @author liwei.tang@magustek.com
 * @since 2015年11月12日
 * 绑定
 */
public class C01DynamicDraw extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane pane=new Pane();
		BorderPane borderPane=new BorderPane();
		VBox vb1=new VBox();
		VBox vb2=new VBox();
		Label label=new Label("xxx");
		Button btn1=new Button("1");
		Button btn2=new Button("2");
		Button btn3=new Button("3");
		
		borderPane.setLeft(vb1);
		borderPane.setRight(vb2);
		borderPane.setCenter(label);
		borderPane.setLayoutX(100);
		borderPane.setLayoutY(100);
		
		Line line =new Line();
		line.setStartX(0);
		line.setStartY(0);
		line.setEndX(100);
		line.setEndY(100);
		line.setVisible(true);
		
		Button btn=new Button("0");
		
		borderPane.setOnMouseDragged(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				borderPane.setLayoutX(event.getSceneX());
				borderPane.setLayoutY(event.getSceneY());
			}
		});
		
		pane.getChildren().addAll(borderPane, btn, line);
		
		vb1.getChildren().add(btn1);
		vb2.getChildren().addAll(btn2, btn3);
		
		btn.layoutXProperty().bind(Bindings.add(btn1.getLayoutX()-100, borderPane.layoutXProperty()));
		btn.layoutYProperty().bind(borderPane.layoutYProperty());
		
		NumberBinding nbx=Bindings.divide(btn3.widthProperty(), 2);
		NumberBinding layoutx=Bindings.add(nbx, vb2.layoutXProperty());
		
		NumberBinding nby=Bindings.divide(btn3.heightProperty(), 2);
		NumberBinding layouty=Bindings.add(nby, btn3.layoutYProperty());
		
		line.endXProperty().bind(Bindings.add(borderPane.layoutXProperty(), layoutx));
		line.endYProperty().bind(Bindings.add(borderPane.layoutYProperty(), layouty));
		
		Scene scene=new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
