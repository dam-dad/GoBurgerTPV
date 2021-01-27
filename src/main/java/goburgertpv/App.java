package goburgertpv;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import controllers.MainController;
import controllers.TPVController;

public class App extends Application{
	
	private static Stage primaryStage;
	private static MainController mainController;
	private TPVController tpvController;
	

	public void start(Stage primaryStage) throws Exception {
		
		
		
		App.primaryStage = primaryStage;
		
		mainController = new MainController();
		tpvController=new TPVController();
		
//		Scene escena = new Scene(mainController.getView());
		Scene escena=new Scene(tpvController.getView());
		
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
