package controladores;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import Personajes.Jugador.*;
import Personajes.crearPersonaje;

import java.io.IOException;
import java.util.ArrayList;

import Pelea.Turno;

public class registro {
    @FXML
    private ImageView imagenJugador1;

    @FXML
    private ImageView imagenJugador2;

    @FXML
    private ImageView imagenJugador3;

    @FXML
    private RadioButton Mago1;

    @FXML
    private RadioButton Arquero1;

    @FXML
    private RadioButton Guerrero1;

    @FXML
    private Button botonCrear;

    @FXML
    private TextField Nombre;

    @FXML
    private ToggleGroup grupoPersonajes;

    public static ArrayList<String> nomArray = new ArrayList<>();
    public static ArrayList<String> eneArray = new ArrayList<>();

    int contadorJugadores = 0;

    public void registrar() {
        imagenJugador1.setImage(cargarImagen(Mago.imagen));
        imagenJugador2.setImage(cargarImagen(Arquero.imagen));
        imagenJugador3.setImage(cargarImagen(Guerrero.imagen));

        botonCrear.setOnAction(event -> {
            crearTodo();
        });

    }

    public void crearTodo() {
        String nombre = Nombre.getText();
        Toggle x = grupoPersonajes.getSelectedToggle();
        String clase = ((RadioButton) x).getText();
        crearPersonaje.crearJugador(nombre, clase);
        nomArray.add(nombre);
        String nombreEnemigo = crearPersonaje.crearEnemigo();
        eneArray.add(nombreEnemigo);
        contadorJugadores++;

        Nombre.clear();

        grupoPersonajes.selectToggle(null);

        if (contadorJugadores == 3) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Interfaz/VentanaBatalla.fxml"));
                Parent root = loader.load();
                Turno.turnoAtaque();
                VentanaBatalla controlador = loader.getController();
                controlador.configurarBatalla
                    (crearPersonaje.personajesMap.get(nomArray.get(0)), crearPersonaje.enemigoMap.get(eneArray.get(0)), 
                     crearPersonaje.personajesMap.get(nomArray.get(1)), crearPersonaje.enemigoMap.get(eneArray.get(1)), 
                     crearPersonaje.personajesMap.get(nomArray.get(2)), crearPersonaje.enemigoMap.get(eneArray.get(2)));

                Stage stage = (Stage) botonCrear.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private Image cargarImagen(String ruta) {
        return new Image(ruta);
    }

}