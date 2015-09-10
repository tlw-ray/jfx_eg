package com.tlw.jfx.treeview;

import java.util.Arrays;
import java.util.List;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @author liwei.tang@magustek.com
 * @since 2015年8月14日
 */
public class A02Model extends Application {

	private final Node rootIcon = new ImageView(new Image(getClass().getResourceAsStream("/com/sun/java/swing/plaf/windows/icons/Directory.gif")));
	private final Image depIcon = new Image(getClass().getResourceAsStream("/com/sun/java/swing/plaf/windows/icons/File.gif"));
	List<Employee> employees = Arrays.<Employee> asList(
			new Employee("Ethan Williams", "Sales Department"), 
			new Employee("Emma Jones", "Sales Department"), 
			new Employee("Michael Brown", "Sales Department"), 
			new Employee("Anna Black", "Sales Department"), 
			new Employee("Rodger York", "Sales Department"), 
			new Employee("Susan Collins", "Sales Department"), 
			new Employee("Mike Graham", "IT Support"), 
			new Employee("Judy Mayer", "IT Support"), 
			new Employee("Gregory Smith", "IT Support"), 
			new Employee("Jacob Smith", "Accounts Department"), 
			new Employee("Isabella Johnson", "Accounts Department"));
	SimpleStringProperty ssp=new SimpleStringProperty("MyCompany Human Resources");
	TreeItem<SimpleStringProperty> rootNode = new TreeItem<SimpleStringProperty>(ssp, rootIcon);

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		rootNode.setExpanded(true);
		for (Employee employee : employees) {
			TreeItem<SimpleStringProperty> empLeaf = new TreeItem<SimpleStringProperty>(employee.name);
			boolean found = false;
			for (TreeItem<SimpleStringProperty> depNode : rootNode.getChildren()) {
				if (depNode.getValue().equals(employee.department)) {
					depNode.getChildren().add(empLeaf);
					found = true;
					break;
				}
			}
			if (!found) {
				TreeItem<SimpleStringProperty> depNode = new TreeItem<SimpleStringProperty>(employee.department, new ImageView(depIcon));
				rootNode.getChildren().add(depNode);
				depNode.getChildren().add(empLeaf);
			}
		}

		stage.setTitle("Tree View Sample");
		VBox box = new VBox();
		final Scene scene = new Scene(box, 400, 300);
		scene.setFill(Color.LIGHTGRAY);

		TreeView<SimpleStringProperty> treeView = new TreeView<SimpleStringProperty>(rootNode);

		box.getChildren().add(treeView);
		stage.setScene(scene);
		stage.show();
		
		new Thread(){
			public void run(){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.print("change....");
				employees.get(0).setName("abc");
			}
		}.start();
	}

	public static class Employee {

		private final SimpleStringProperty name;
		private final SimpleStringProperty department;

		private Employee(String name, String department) {
			this.name = new SimpleStringProperty(name);
			this.department = new SimpleStringProperty(department);
		}

		public String getName() {
			return name.get();
		}

		public void setName(String fName) {
			name.set(fName);
		}

		public String getDepartment() {
			return department.get();
		}

		public void setDepartment(String fName) {
			department.set(fName);
		}
	}
}