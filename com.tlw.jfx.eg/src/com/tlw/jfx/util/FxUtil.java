package com.tlw.jfx.util;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author liwei.tang@magustek.com
 * @since 2015年9月17日
 */
public class FxUtil extends Application{

	public static void main(String[] args) throws InterruptedException {
		 Application.launch(FxViewer.class, new String[0]);
		
//	    System.out.printf("About to launch FX App\n");
//	    Thread t = new Thread("JavaFX Init Thread") {
//	        public void run() {
//	            Application.launch(FxViewer.class, new String[0]);
//	        }
//	    };
//	    t.setDaemon(true);
//	    t.start();
//	    System.out.printf("FX App thread started\n");
//	    Thread.sleep(500);

	}

	public static void show(int width, int height) {
//		Application app = new Application() {
//			@Override
//			public void start(Stage primaryStage) throws Exception {
//				Button button = new Button("hi");
//				Scene scene = new Scene(button, width, height);
//				primaryStage.setScene(scene);
//			}
//		};
		Thread t = new Thread("JavaFX Init Thread") {
			public void run() {
				Application.launch(FxViewer.class);
			}
		};
		t.setDaemon(true);
		t.start();
		System.out.printf("FX App thread started\n");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
