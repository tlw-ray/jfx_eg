package com.tlw.jfx.bind;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * @author liwei.tang@magustek.com
 * @since 2015年8月14日
 */
public class A04CombiningBothApproaches {

	public static void main(String[] args) {
	       IntegerProperty num1 = new SimpleIntegerProperty(1);
	       IntegerProperty num2 = new SimpleIntegerProperty(2);
	       IntegerProperty num3 = new SimpleIntegerProperty(3);
	       IntegerProperty num4 = new SimpleIntegerProperty(4);
	       NumberBinding total = Bindings.add(num1.multiply(num2),num3.multiply(num4));
	       System.out.println(total.getValue());
	       num1.setValue(2);
	       System.err.println(total.getValue());
	}

}
