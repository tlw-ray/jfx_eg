package com.tlw.jfx.bind;

import java.util.logging.Logger;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 * @author liwei.tang@magustek.com
 * @since 2015年8月27日
 */
public class C01BindEnum {

	static enum MyEnum{
		ONE, TWO
	}
	
	public static void main(String[] args) {
		SimpleObjectProperty<MyEnum> sop=new SimpleObjectProperty<MyEnum>();
		sop.addListener(new ChangeListener<MyEnum>() {
			@Override
			public void changed(ObservableValue<? extends MyEnum> observable, MyEnum oldValue, MyEnum newValue) {
				Logger.getAnonymousLogger().info(observable.toString()+" oldValue="+oldValue+", newValue="+newValue);
			}
		});
		
		sop.addListener(new InvalidationListener() {
			@Override
			public void invalidated(Observable observable) {
				Logger.getAnonymousLogger().info(observable.toString());
			}
		});
		
		sop.setValue(MyEnum.ONE);
		sop.setValue(MyEnum.TWO);
	}

}
