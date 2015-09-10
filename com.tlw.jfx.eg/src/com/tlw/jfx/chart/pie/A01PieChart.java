package com.tlw.jfx.chart.pie;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @author liwei.tang@magustek.com
 * @since 2015年9月10日
 */
public class A01PieChart extends Application {

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(new PieChart.Data("Grapefruit", 13), new PieChart.Data("Oranges", 25), new PieChart.Data("Plums", 10), new PieChart.Data("Pears", 22), new PieChart.Data("Apples", 30));
		final PieChart chart = new PieChart(pieChartData);
		chart.setTitle("Imported Fruits");
		
		//设置Pie的柄的长度
//		chart.setLabelLineLength(30);
		//设定图例的位置
//		chart.setLegendSide(Side.LEFT);
		//Pie的排布是否按照字母顺序
//		chart.setClockwise(false);
		//设定起始角
//		chart.setStartAngle(90);
		//设定样式
//		chart.setStyle("-fx-background:red");
		
		final Label caption = new Label("");
		caption.setTextFill(Color.DARKORANGE);
		caption.setStyle("-fx-font: 24 arial;");

		for (final PieChart.Data data : chart.getData()) {
		    data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED,
		        new EventHandler<MouseEvent>() {
		            @Override public void handle(MouseEvent e) {
		                caption.setTranslateX(e.getSceneX());
		                caption.setTranslateY(e.getSceneY());
		                caption.setText(String.valueOf(data.getPieValue()) + "%");
		             }
		        });
		}
		
		Group group=new Group();
		group.getChildren().addAll(chart, caption);
		
		Scene scene = new Scene(group);
		stage.setScene(scene);
		stage.setTitle("Imported Fruits");
		stage.show();
	}

}
