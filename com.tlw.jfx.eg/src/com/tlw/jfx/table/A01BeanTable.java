package com.tlw.jfx.table;

import javafx.application.Application;
import javafx.beans.property.adapter.JavaBeanBooleanPropertyBuilder;
import javafx.beans.property.adapter.JavaBeanStringPropertyBuilder;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.stage.Stage;
import javafx.util.Callback;

import com.tlw.jfx.bean.Person;

/**
 * @author liwei.tang@magustek.com
 * @since 2015年6月9日
 */
public class A01BeanTable extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage stage) throws Exception {
		Person[] persons=Person.createPersons();
		ObservableList<Person> personObList=FXCollections.observableArrayList(persons);
		TableView<Person> personTable=new TableView<Person>(personObList);
		
		//name column
		TableColumn<Person, String> nameColumn = new TableColumn<Person, String>("Name");
		nameColumn.setPrefWidth(100);
		nameColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Person,String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Person, String> param) {
				Person person=param.getValue();
				ObservableValue<String> nameOV;
				try {
					nameOV = JavaBeanStringPropertyBuilder.create().bean(person).name("namex").build();
					return nameOV;
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
					return null;
				}
			}
		});
		
		//alive column
		TableColumn<Person, Boolean> aliveColumn=new TableColumn<Person, Boolean>("Alive");
		
		aliveColumn.setPrefWidth(50);
		
		aliveColumn.setCellFactory(new Callback<TableColumn<Person,Boolean>, TableCell<Person,Boolean>>() {
			@Override
			public TableCell<Person, Boolean> call(TableColumn<Person, Boolean> param) {
				CheckBoxTableCell<Person, Boolean> tableCell=new CheckBoxTableCell<Person, Boolean>();
				return tableCell;
			}
		});
		
		aliveColumn.setCellValueFactory(new Callback<CellDataFeatures<Person, Boolean>, ObservableValue<Boolean>>(){
			@Override
			public ObservableValue<Boolean> call(CellDataFeatures<Person, Boolean> param) {
				Person person=param.getValue();
				ObservableValue<Boolean> aliveOV;
				try {
					aliveOV = JavaBeanBooleanPropertyBuilder.create().bean(person).name("alive").build();
					return aliveOV;
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
					return null;
				}
			}
		});
		
		ObservableList<TableColumn<Person, ?>> columns=personTable.getColumns();
		columns.addAll(nameColumn, aliveColumn);
		
		Scene scene=new Scene(personTable);
		stage.setScene(scene);
		stage.show();
	}

}
