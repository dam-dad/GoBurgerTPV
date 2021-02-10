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
	private static TPVController tpvController;
	private static ConfiguracionController configuracionController;
	private static Scene escena;

	public void start(Stage primaryStage) throws Exception {
			
		App.primaryStage = primaryStage;
		
		configuracionController=new ConfiguracionController();
		tpvController=new TPVController();
		mainController = new MainController();
		

		
		escena = new Scene(mainController.getView());

		
		primaryStage.setScene(escena);
		primaryStage.setTitle("GoBurgerTPV");
		primaryStage.getIcons().add(new Image("/images/logoMini.png"));
		primaryStage.show();
		
	}
	

	
	
	public static Stage getPrimaryStage() {
		return primaryStage;
	}




	public static void setPrimaryStage(Stage primaryStage) {
		App.primaryStage = primaryStage;
	}




	public static MainController getMainController() {
		return mainController;
	}




	public static void setMainController(MainController mainController) {
		App.mainController = mainController;
	}




	public static TPVController getTpvController() {
		return tpvController;
	}




	public static void setTpvController(TPVController tpvController) {
		App.tpvController = tpvController;
	}




	public static ConfiguracionController getConfiguracionController() {
		return configuracionController;
	}




	public static void setConfiguracionController(ConfiguracionController configuracionController) {
		App.configuracionController = configuracionController;
	}




	public static Scene getEscena() {
		return escena;
	}




	public static void setEscena(Scene escena) {
		App.escena = escena;
	}




	public static void main(String[] args) {
		launch(args);
	}
}
