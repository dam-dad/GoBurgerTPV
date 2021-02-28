package goburgertpv.utils;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class CustomButton extends Button {

	
	public CustomButton(Double precio,String imagePath ) {
		super();
		
		this.setPrefWidth(170);
		this.setPrefHeight(170);
		ImageView image=new ImageView(imagePath);
		
		image.setFitHeight(150);
		image.setFitWidth(150);
		this.setGraphic(image);
		this.setText(precio.toString()+" €");
		this.setContentDisplay(getContentDisplay().TOP);
	
		
	}



}
