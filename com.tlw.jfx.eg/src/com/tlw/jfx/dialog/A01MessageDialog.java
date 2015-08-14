package com.tlw.jfx.dialog;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @author liwei.tang@magustek.com
 * @since 2015年4月29日
 */
public class A01MessageDialog extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Button button=new Button("MessageBox");
		
		button.addEventHandler(ActionEvent.ACTION, e->{
			Dialog dialog=new Dialog("aa", primaryStage, new Scene(new Button("tst"), 200,200)); 
			dialog.showDialog();
		});
		
		Scene scene=new Scene(button, 400, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
	
	static class Dialog extends Stage {
	    public Dialog( String title, Stage owner, Scene scene) {
	        setTitle( title );
	        initStyle(StageStyle.UTILITY);//仅仅有关闭按钮的窗体
	        initModality( Modality.APPLICATION_MODAL );
	        initOwner( owner );
	        setResizable( false );
	        setScene( scene );
//	        icon.setImage( new Image( getClass().getResourceAsStream( iconFile ) ) );
	    }
	    public void showDialog() {
	        sizeToScene();
	        centerOnScreen();
	        showAndWait();
	    }
	}
}
