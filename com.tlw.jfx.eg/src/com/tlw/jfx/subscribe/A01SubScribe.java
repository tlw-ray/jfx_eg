package com.tlw.jfx.subscribe;

import javafx.application.Application;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author liwei.tang@magustek.com
 * @since 2015年12月25日
 */
public class A01SubScribe extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox box=new VBox();
		
		Label labelBind=new Label();
		Label labelSubScribe=new Label();
		CheckBox buttonSubScribe=new CheckBox("subScribe");
		
		box.getChildren().addAll(labelBind, labelSubScribe, buttonSubScribe);
		
		ScheduledService<String> scheduledService=new ScheduledService<String>(){
			@Override
			protected Task<String> createTask() {
				Task<String> task=new Task<String>(){
					@Override
					protected String call() throws Exception {
						String result=Math.random()+"";
						return result;
					}
				};
				return task;
			}
		};
		scheduledService.setPeriod(Duration.seconds(1));
		scheduledService.start();
		labelBind.textProperty().bind(scheduledService.lastValueProperty());
		
		buttonSubScribe.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				if(buttonSubScribe.isSelected()){
					labelSubScribe.textProperty().bind(scheduledService.lastValueProperty());
				}else{
					labelSubScribe.textProperty().unbind();
				}
			}
		});
		
		Scene scene=new Scene(box, 400, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
