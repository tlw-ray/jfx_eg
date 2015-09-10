package com.tlw.jfx.bind;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 * @author liwei.tang@magustek.com
 * @since 2015年8月27日
 */
public class C03Bind2Enum {

	private static enum MyEnum{
		ONE, TWO
	}
	
	public static void main(String[] args) {
		SimpleObjectProperty<MyEnum> sop=new SimpleObjectProperty<MyEnum>(MyEnum.ONE);
		
		BooleanBinding bb=Bindings.equal(MyEnum.TWO, sop);
		
		bb.addListener(new ChangeListener<Boolean>(){
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				System.out.println("New value="+newValue);
			}
		});
		
		System.out.println(bb.get());
		
		sop.set(MyEnum.TWO);
		System.out.println(bb.get());
	}

}
