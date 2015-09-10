package com.tlw.jfx.bind;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 * @author liwei.tang@magustek.com
 * @since 2015年8月14日
 */
public class A01ChangeListener {

	public static void main(String[] args) {

		Bill electricBill = new Bill();

		electricBill.amountDueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				System.out.println(observable);
				System.out.println(oldValue);
				System.out.println(newValue);
				System.out.println("changed...");
			}
		});

		electricBill.setAmountDue(100.00);
	}

}
