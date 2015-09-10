package com.tlw.jfx.treeview;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * @author liwei.tang@magustek.com
 * @since 2015年8月14日
 */
public class A01Create extends Application{

    public static void main(String[] args) {
        launch(args);
    }
    
//	Image imageFile=new Image(A01Create.class.getResourceAsStream("/com/sun/java/swing/plaf/windows/icons/File.gif"));
//	Image imageDir=new Image(A01Create.class.getResourceAsStream("/com/sun/java/swing/plaf/windows/icons/Directory.gif"));

	private final Node rootIcon = new ImageView(
		new Image(getClass().getResourceAsStream("/com/sun/java/swing/plaf/windows/icons/Directory.gif"))
	);

	
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tree View Sample");        
        
        TreeItem<String> rootItem = new TreeItem<String> ("Inbox", rootIcon);
        rootItem.setExpanded(true);
        for (int i = 1; i < 6; i++) {
            TreeItem<String> item = new TreeItem<String> ("Message" + i);            
            rootItem.getChildren().add(item);
        }        
        TreeView<String> tree = new TreeView<String> (rootItem);        
        StackPane root = new StackPane();
        root.getChildren().add(tree);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }


}
