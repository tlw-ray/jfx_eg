package com.tlw.jfx.treeview;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.Stage;

/**
 * @author liwei.tang@magustek.com
 * @since 2015年8月14日
 */
public class B01Change extends Application {
	SimpleStringProperty pstr= new SimpleStringProperty("aaa");
	SimpleStringProperty cstr= new SimpleStringProperty("bbb");
	public static void main(String[] args) {
		launch(args);
	}
	
	class Person{
		SimpleStringProperty name=new SimpleStringProperty("person");
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Person person=new Person();
		
		TreeItem<Object> ti=new TreeItem<Object>(pstr);
		TreeItem<Object> tc=new TreeItem<Object>();
		tc.valueProperty().bind(person.name);
//		person.name.bindBidirectional(other);
		
		ti.getChildren().add(tc);
		TreeView<Object> tv=new TreeView<Object>();
		tv.setRoot(ti);
		
		Scene scene=new Scene(tv);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		new Thread(){
			public void run(){
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
//				sb.append("ccc");
//				tc.setValue(sb);
//				tc.setValue(new StringBuilder("ccc"));
				person.name.set("ccc");
				System.out.println("changed...");
			}
		}.start();
	}



}
