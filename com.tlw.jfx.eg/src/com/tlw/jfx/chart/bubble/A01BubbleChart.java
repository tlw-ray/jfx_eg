package com.tlw.jfx.chart.bubble;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @author liwei.tang@magustek.com
 * @since 2015年9月10日
 */
public class A01BubbleChart extends Application {
 
    @Override public void start(Stage stage) {
        stage.setTitle("Bubble Chart Sample");
        final NumberAxis xAxis = new NumberAxis(1, 53, 4);
        final NumberAxis yAxis = new NumberAxis(0, 80, 10);
        final BubbleChart<Number,Number> blc = new BubbleChart<Number,Number>(xAxis,yAxis);
        xAxis.setLabel("Week");
        yAxis.setLabel("Product Budget");
        yAxis.setTickLabelFormatter(new NumberAxis.DefaultFormatter(yAxis,"$ ","xx"));
        xAxis.setTickLabelFill(Color.CHOCOLATE);

//        XYChart.Series series1 = new XYChart.Series();
//        series1.setName("Product 1");
//        series1.getData().add(new XYChart.Data(3, 35));
//        series1.getData().add(new XYChart.Data(12, 60));
//        series1.getData().add(new XYChart.Data(15, 15));
//        series1.getData().add(new XYChart.Data(22, 30));
//        series1.getData().add(new XYChart.Data(28, 20));
//        series1.getData().add(new XYChart.Data(35, 41));
//        series1.getData().add(new XYChart.Data(42, 17));
//        series1.getData().add(new XYChart.Data(49, 30));
//                
//        XYChart.Series series2 = new XYChart.Series();
//        series2.setName("Product 2");
//        series2.getData().add(new XYChart.Data(8, 15));
//        series2.getData().add(new XYChart.Data(13, 23));
//        series2.getData().add(new XYChart.Data(15, 45));
//        series2.getData().add(new XYChart.Data(24, 30));
//        series2.getData().add(new XYChart.Data(38, 78));
//        series2.getData().add(new XYChart.Data(40, 41));
//        series2.getData().add(new XYChart.Data(45, 57));
//        series2.getData().add(new XYChart.Data(47, 23));
        
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Product 1");
        series1.getData().add(new XYChart.Data(3, 35, 2));
        series1.getData().add(new XYChart.Data(12, 60, 1.8));
        series1.getData().add(new XYChart.Data(15, 15, 7));
        series1.getData().add(new XYChart.Data(22, 30, 2.5));
        series1.getData().add(new XYChart.Data(28, 20, 1));
        series1.getData().add(new XYChart.Data(35, 41, 5.5));
        series1.getData().add(new XYChart.Data(42, 17, 9));
        series1.getData().add(new XYChart.Data(49, 30, 1.8));
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Product 2");
        series2.getData().add(new XYChart.Data(8, 15, 2));
        series2.getData().add(new XYChart.Data(13, 23, 1));
        series2.getData().add(new XYChart.Data(15, 45, 3));
        series2.getData().add(new XYChart.Data(24, 30, 4.5));
        series2.getData().add(new XYChart.Data(38, 78, 1));
        series2.getData().add(new XYChart.Data(40, 41, 7.5));
        series2.getData().add(new XYChart.Data(45, 57, 2));
        series2.getData().add(new XYChart.Data(47, 23, 3.8));

        blc.setAlternativeColumnFillVisible(true);
        blc.setAlternativeRowFillVisible(false);
        blc.getData().addAll(series1, series2); 
        blc.setTitle("Budget Monitoring");
                       
        Scene scene  = new Scene(blc);
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}

