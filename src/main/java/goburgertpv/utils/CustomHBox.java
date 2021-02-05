package goburgertpv.utils;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class CustomHBox extends HBox {
	
	public CustomHBox() {
		super();
		HBox.setHgrow(this, Priority.ALWAYS);
		this.setAlignment(Pos.CENTER);
	}
	

}
