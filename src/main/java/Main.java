import controladores.registro;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/Interfaz/registro.fxml"));

        Scene scene = new Scene(loader.load());

        registro controlador = loader.getController();
        controlador.registrar();

        stage.setTitle("Batalla");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        
        launch(args);

    }
}