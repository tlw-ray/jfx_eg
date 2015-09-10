package com.tlw.jfx.chart.area;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

/**
 * @author liwei.tang@magustek.com
 * @since 2015年9月10日
 */
public class A01AreaChart extends Application {
	 
    public static void main(String[] args) {
        launch(args);
    }
    @Override 
    public void start(Stage stage) {
        stage.setTitle("Area Chart Sample");
        final NumberAxis xAxis = new NumberAxis(1, 31, 1);
        
        //Using the corresponding methods
        xAxis.setLowerBound(1);
        xAxis.setUpperBound(30);
        xAxis.setTickUnit(1);
        xAxis.setMinorTickCount(0);
        
//        final NumberAxis yAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis(0, 27, 5);
//        yAxis.setMinorTickLength(yAxis.getTickLength());

        
        final AreaChart<Number,Number> ac = 
            new AreaChart<Number,Number>(xAxis,yAxis);
        ac.setTitle("Temperature Monitoring (in Degrees C)");
 
        XYChart.Series seriesApril= new XYChart.Series();
        seriesApril.setName("April");
        seriesApril.getData().add(new XYChart.Data(1, 4));
        seriesApril.getData().add(new XYChart.Data(3, 10));
        seriesApril.getData().add(new XYChart.Data(6, 15));
        seriesApril.getData().add(new XYChart.Data(9, 8));
        seriesApril.getData().add(new XYChart.Data(12, 5));
        seriesApril.getData().add(new XYChart.Data(15, 18));
        seriesApril.getData().add(new XYChart.Data(18, 15));
        seriesApril.getData().add(new XYChart.Data(21, 13));
        seriesApril.getData().add(new XYChart.Data(24, 19));
        seriesApril.getData().add(new XYChart.Data(27, 21));
        seriesApril.getData().add(new XYChart.Data(30, 21));
        
        XYChart.Series seriesMay = new XYChart.Series();
        seriesMay.setName("May");
        seriesMay.getData().add(new XYChart.Data(1, 20));
        seriesMay.getData().add(new XYChart.Data(3, 15));
        seriesMay.getData().add(new XYChart.Data(6, 13));
        seriesMay.getData().add(new XYChart.Data(9, 12));
        seriesMay.getData().add(new XYChart.Data(12, 14));
        seriesMay.getData().add(new XYChart.Data(15, 18));
        seriesMay.getData().add(new XYChart.Data(18, 25));
        seriesMay.getData().add(new XYChart.Data(21, 25));
        seriesMay.getData().add(new XYChart.Data(24, 23));
        seriesMay.getData().add(new XYChart.Data(27, 26));
        seriesMay.getData().add(new XYChart.Data(31, 26));
        
        Scene scene  = new Scene(ac,800,600);
        ac.getData().addAll(seriesApril, seriesMay);
        stage.setScene(scene);
        stage.show();
    }
}

