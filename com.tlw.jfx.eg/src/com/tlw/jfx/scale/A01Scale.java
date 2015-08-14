package com.tlw.jfx.scale;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * @author liwei.tang@magustek.com
 * @since 2015年6月2日
 * 图型和组件缩放
 */
public class A01Scale extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	public void start( Stage stage ) throws Exception {
		FXMLLoader loader = new FXMLLoader( getClass().getResource( "Content.fxml" ) );
		Region contentRootRegion = (Region) loader.load();

		//Set a default "standard" or "100%" resolution
		double origW = 960;
		double origH = 540;

		//If the Region containing the GUI does not already have a preferred width and height, set it.
		//But, if it does, we can use that setting as the "standard" resolution.
//		if ( contentRootRegion.getPrefWidth() == Region.USE_COMPUTED_SIZE )
//			contentRootRegion.setPrefWidth( origW );
//		else
//			origW = contentRootRegion.getPrefWidth();
//
//		if ( contentRootRegion.getPrefHeight() == Region.USE_COMPUTED_SIZE )
//			contentRootRegion.setPrefHeight( origH );
//		else
//			origH = contentRootRegion.getPrefHeight();

		//Wrap the resizable content in a non-resizable container (Group)
		Group group = new Group( contentRootRegion );
		//Place the Group in a StackPane, which will keep it centered
		StackPane rootPane = new StackPane();
		rootPane.getChildren().add( group );

		stage.setTitle( "My Slide" );
		//Create the scene initally at the "100%" size
		Scene scene = new Scene( rootPane, origW, origH );
		//Bind the scene's width and height to the scaling parameters on the group
		group.scaleXProperty().bind( scene.widthProperty().divide( origW ) );
		group.scaleYProperty().bind( scene.heightProperty().divide( origH ) );
		//Set the scene to the window (stage) and show it
		stage.setScene( scene );
		stage.show();
	}
}
