package goburgertpv.utils;

import javafx.scene.control.Button;

public class CustomButton extends Button {
	 int WIDTH=140;
	 int HEIGHT=180;
	
	public CustomButton(String s) {
		super();
		this.setText(s);
		this.setMaxWidth(WIDTH);
		this.setMaxHeight(HEIGHT);
		this.setPrefWidth(WIDTH);
		this.setPrefHeight(HEIGHT);
		
	}

	public int getWIDTH() {
		return WIDTH;
	}

	public int getHEIGHT() {
		return HEIGHT;
	}
	

}
