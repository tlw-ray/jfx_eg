package com.tlw.jfx.bind;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;

/**
 * @author liwei.tang@magustek.com
 * @since 2015年8月14日
 */
public class A05InvalidationListener {

	public static void main(String[] args) {
        Bill bill1 = new Bill();
        Bill bill2 = new Bill();
        Bill bill3 = new Bill();
 
        NumberBinding total = Bindings.add(
        		bill1.amountDueProperty().add(bill2.amountDueProperty()),
        		bill3.amountDueProperty());
        total.addListener(new InvalidationListener() {
 
        @Override public void invalidated(Observable o) {
                System.out.println("The binding is now invalid.");
            }
        });

        // First call makes the binding invalid
        bill1.setAmountDue(200.00);

        // The binding is now invalid
        bill2.setAmountDue(100.00);
        bill3.setAmountDue(75.00);

        // Make the binding valid...
        System.out.println(total.getValue());

        // Make invalid... 
        bill3.setAmountDue(150.00);

        // Make valid...
        System.out.println(total.getValue());

	}

}
