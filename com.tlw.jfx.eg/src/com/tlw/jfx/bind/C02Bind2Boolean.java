package com.tlw.jfx.bind;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 * @author liwei.tang@magustek.com
 * @since 2015年8月27日
 */
public class C02Bind2Boolean {

	public static void main(String[] args) {
		SimpleIntegerProperty ip1=new SimpleIntegerProperty(100);
		SimpleIntegerProperty ip2=new SimpleIntegerProperty(100);
		
		BooleanBinding bb=Bindings.greaterThan(ip1, ip2);
		bb.addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				System.out.println(newValue);
			}
		});
		bb.addListener(new InvalidationListener() {
			@Override
			public void invalidated(Observable observable) {
				System.out.println(observable);
			}
		});
		
		System.out.println(bb.get());
		ip2.set(100);
		ip1.set(20);
	}

}
