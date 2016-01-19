package com.tlw.jfx.table;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * @author liwei.tang@magustek.com
 * @since 2015年12月25日
 * 1. create a table and fill data
 * 2. fire cell visible property.
 * 3. subscribe cell
 */
public class A04RealtimeTable extends Application {
	
	public static class Point{
		StringProperty nameProperty = new SimpleStringProperty();
		DoubleProperty valueProperty = new SimpleDoubleProperty();
		
		public String getName(){
			return nameProperty.get();
		}
		
		public Double getValue(){
			return valueProperty.get();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		TableColumn<Point, String> nameColumn=new TableColumn<Point, String>();
		nameColumn.setText("Name");
		nameColumn.setCellValueFactory(new PropertyValueFactory<Point, String>("name"));
		
		TableColumn<Point, Double> valueColumn=new TableColumn<Point, Double>();
		valueColumn.setText("Value");
		valueColumn.setCellValueFactory(new PropertyValueFactory<Point, Double>("value"));
		
		TableView<Point> tableView=new TableView<Point>();
		tableView.getColumns().add(nameColumn);
		tableView.getColumns().add(valueColumn);
		
		for(int i=0;i<100;i++){
			Point point=new Point();
			point.nameProperty.set("P"+i);
			point.valueProperty.set(i);
			tableView.getItems().add(point);
		}
		
		Scene scene = new Scene(tableView, 400, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
