package com.tlw.jfx.treeview;

import javafx.application.Application;
import javafx.beans.property.adapter.JavaBeanStringProperty;
import javafx.beans.property.adapter.JavaBeanStringPropertyBuilder;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.Stage;

/**
 * @author liwei.tang@magustek.com
 * @since 2015年8月17日
 */
public class B02PropertyChange extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Person person=new Person();
		JavaBeanStringProperty nameProperty=JavaBeanStringPropertyBuilder.create().bean(person).name("name").build();
		
		TreeItem<String> treeItem=new TreeItem<>();
		treeItem.valueProperty().bind(nameProperty);
		TreeView<String> treeView=new TreeView<>(treeItem);
		
		Scene scene=new Scene(treeView);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		new Thread(){
			public void run(){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				nameProperty.setValue("abc");
				System.out.println("changed: "+person);
			}
		}.start();
	}

	public static class Person{
		String name="person";

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Person [name=" + name + "]";
		}
		
	}
}
