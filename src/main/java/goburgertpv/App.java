package goburgertpv;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import controllers.MainController;

public class App extends Application{
	
	private static Stage primaryStage;
	private static MainController mainController;
	

	public void start(Stage primaryStage) throws Exception {
		App.primaryStage = primaryStage;
		
		mainController = new MainController();
		
		Scene escena = new Scene(mainController.getView());
		
		primaryStage.setScene(escena);
		primaryStage.setTitle("GoBurgerTPV");
		primaryStage.show();
		
	}
	
	
	public static Stage getPrimaryStage() {
		return primaryStage;
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
