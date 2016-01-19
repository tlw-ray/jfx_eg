package com.tlw.jfx.subscribe;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author liwei.tang@magustek.com
 * @since 2015年12月25日
 */
public class A02SubScribe extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	public static class SubscribeService{
		List<DataGeneratorService> dataGenerators=new ArrayList<DataGeneratorService>();
		
	}
	
	public static class DataGeneratorService{
		//数据生成服务
		public ScheduledService<String> service;
		public DataGeneratorService(){
			service=new ScheduledService<String>(){
				@Override
				protected Task<String> createTask() {
					Task<String> task=new Task<String>(){
						@Override
						protected String call() throws Exception {
							return Math.random()+"";
						}
					};
					return task;
				}
			};
			service.setPeriod(Duration.seconds(1));
			service.start();
		}
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
	}

}
