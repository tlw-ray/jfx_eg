package com.tlw.jfx.swing;

import java.awt.BorderLayout;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author liwei.tang@magustek.com
 * @since 2015年12月15日
 */
public class FxInSwing extends JPanel {

	private static final long serialVersionUID = -2742549061974497870L;

	public static void main(String[] args) {

		JFXPanel jfxPanel=new JFXPanel();
		JFrame frame=new JFrame();
		frame.add(jfxPanel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 300);
		frame.setVisible(true);
		
		Platform.runLater(new Runnable(){
			@Override
			public void run() {
				Button hiButton=new Button("hi");
				Scene scene=new Scene(hiButton);
				jfxPanel.setScene(scene);
			}
		});
	}

}
