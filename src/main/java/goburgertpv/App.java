package goburgertpv;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import controllers.ConfiguracionController;
import controllers.MainController;
import controllers.TPVController;

public class App extends Application{
	
	private static Stage primaryStage;
	private static MainController mainController;
	private TPVController tpvController;
	private ConfiguracionController configuracionController;
	

	public void start(Stage primaryStage) throws Exception {
			
		App.primaryStage = primaryStage;
		
		mainController = new MainController();
//		tpvController=new TPVController();

		
		Scene escena = new Scene(mainController.getView());
//		Scene escena=new Scene(tpvController.getView());
//		Scene escena = new Scene(configuracionController.getView());
		
		primaryStage.setScene(escena);
		primaryStage.setTitle("GoBurgerTPV");
		primaryStage.getIcons().add(new Image("/images/logoMini.png"));
		primaryStage.show();
		
	}
	
	
	public static Stage getPrimaryStage() {
		return primaryStage;
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
