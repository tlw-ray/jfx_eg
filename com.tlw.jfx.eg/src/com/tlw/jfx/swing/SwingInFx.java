package com.tlw.jfx.swing;

import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.JScrollPane;
import javax.swing.JTree;

/**
 * @author liwei.tang@magustek.com
 * @since 2015年12月15日
 */
public class SwingInFx extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		JTree jtree=new JTree();
		JScrollPane jscrollPane=new JScrollPane(jtree);
		SwingNode swingNode=new SwingNode();
		swingNode.setContent(jscrollPane);
			
		Pane pane=new Pane();
		pane.getChildren().add(swingNode);
		
		Scene scene=new Scene(pane, 400, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
