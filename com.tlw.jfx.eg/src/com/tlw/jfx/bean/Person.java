package com.tlw.jfx.bean;

import java.time.LocalDate;

/**
 * @author liwei.tang@magustek.com
 * @since 2015年6月9日
 */
public class Person {
	
	public static Person[] createPersons(){
		int count=100;
		Person[] persons=new Person[count];
		for(int i=0;i<count;i++){
			Person person=new Person();
			person.namex="Name"+i;
			person.alive=i%2==1;
			person.birthday=LocalDate.now();
			persons[i]=person;
		}
		return persons;
	}
	
	String namex;
	boolean alive;
	LocalDate birthday;

	public String getNamex() {
		return namex;
	}
	public void setNamex(String namex) {
		this.namex = namex;
	}
	public boolean isAlive() {
		return alive;
	}
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "Person [namex=" + namex + ", alive=" + alive + ", birthday=" + birthday + "]";
	}
	
}
