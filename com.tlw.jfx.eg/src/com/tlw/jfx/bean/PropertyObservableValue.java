package com.tlw.jfx.bean;

import java.time.LocalDate;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.adapter.JavaBeanStringPropertyBuilder;

/**
 * @author liwei.tang@magustek.com
 * @since 2015年6月9日
 */
public class PropertyObservableValue {

	public static void main(String[] args) {
		Person person=new Person();
		person.setNamex("Tom");
		person.setAlive(true);
		person.setBirthday(LocalDate.now());
		
		//方法1
		try {
			StringProperty namexProperty=JavaBeanStringPropertyBuilder.create().bean(person).name("namex").build();
			System.out.println(namexProperty.get());
			
			namexProperty.set("xxx");
			System.out.println(person);
			
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		
		
		
		//方法2:TODO 这里获取不到值，根据源码确实如此，所以这里不能这样调用
		SimpleStringProperty ssp=new SimpleStringProperty();
		System.out.println(ssp.get());
	}

}
