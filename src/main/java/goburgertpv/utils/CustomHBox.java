package goburgertpv.utils;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class CustomHBox extends HBox {
	
	public CustomHBox() {
		super();
		this.setPadding(new Insets(5,5,5,5));
		HBox.setHgrow(this, Priority.ALWAYS);
		
	}
	

}
