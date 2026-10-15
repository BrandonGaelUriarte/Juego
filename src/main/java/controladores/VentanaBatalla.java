package controladores;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import Personajes.Jugador.Clase;
import Personajes.Enemigos.Enemigo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Pelea.PeleaNueva;
import Pelea.Turno;
import Personajes.crearPersonaje;

public class VentanaBatalla {

    @FXML
    private Button Ataque_1;

    @FXML
    private Button Ataque_2;

    @FXML
    private Button Ataque_3;

    @FXML
    private Button Ataque_4;

    @FXML
    private ImageView imagenJugador1;

    @FXML
    private ImageView imagenEnemigo1;

    @FXML
    private ImageView imagenJugador2;

    @FXML
    private ImageView imagenEnemigo2;

    @FXML
    private ImageView imagenJugador3;

    @FXML
    private ImageView imagenEnemigo3;

    @FXML
    private Label LabelJugador1;

    @FXML
    private Label LabelJugador2;

    @FXML
    private Label LabelJugador3;

    @FXML
    private Label LabelEnemigo1;

    @FXML
    private Label LabelEnemigo2;

    @FXML
    private Label LabelEnemigo3;

    @FXML
    private Label LabelVidaJugador1;

    @FXML
    private Label LabelVidaJugador2;

    @FXML
    private Label LabelVidaJugador3;

    @FXML
    private Label LabelVidaEnemigo1;

    @FXML
    private Label LabelVidaEnemigo2;

    @FXML
    private Label LabelVidaEnemigo3;

    @FXML
    private RadioButton enemigoAtacar1;

    @FXML
    private RadioButton enemigoAtacar2;

    @FXML
    private RadioButton enemigoAtacar3;

    @FXML
    private ToggleGroup toggleAtaque;

    List<Button> botones;

    public void configurarBatalla(Clase jugador, Enemigo enemigo,
            Clase jugador2, Enemigo enemigo2,
            Clase jugador3, Enemigo enemigo3) {

        LabelJugador1.setText(jugador.getNombre());
        LabelJugador2.setText(jugador2.getNombre());
        LabelJugador3.setText(jugador3.getNombre());

        LabelEnemigo1.setText(enemigo.getNombre());
        LabelEnemigo2.setText(enemigo2.getNombre());
        LabelEnemigo3.setText(enemigo3.getNombre());

        LabelVidaJugador1.setText(String.valueOf(jugador.getVida()));
        LabelVidaJugador2.setText(String.valueOf(jugador2.getVida()));
        LabelVidaJugador3.setText(String.valueOf(jugador3.getVida()));

        LabelVidaEnemigo1.setText(String.valueOf(enemigo.getVida()));
        LabelVidaEnemigo2.setText(String.valueOf(enemigo2.getVida()));
        LabelVidaEnemigo3.setText(String.valueOf(enemigo3.getVida()));

        imagenJugador1.setImage(cargarImagen(jugador.getImagen()));
        imagenEnemigo1.setImage(cargarImagen(enemigo.getImagen()));

        imagenJugador2.setImage(cargarImagen(jugador2.getImagen()));
        imagenEnemigo2.setImage(cargarImagen(enemigo2.getImagen()));

        imagenJugador3.setImage(cargarImagen(jugador3.getImagen()));
        imagenEnemigo3.setImage(cargarImagen(enemigo3.getImagen()));

        enemigoAtacar1.setText(registro.eneArray.get(0));
        enemigoAtacar2.setText(registro.eneArray.get(1));
        enemigoAtacar3.setText(registro.eneArray.get(2));

        botones = List.of(Ataque_1, Ataque_2, Ataque_3, Ataque_4);
        List<String> llaves = new ArrayList<>(
                crearPersonaje.personajesMap.get(Turno.turnoDePelea.getFirst()).getAtaquesmMap().keySet());
        List<Integer> daño = new ArrayList<>(
                crearPersonaje.personajesMap.get(Turno.turnoDePelea.getFirst()).getAtaquesmMap().values());

        for (int i = 0; i < llaves.size(); i++) {
            botones.get(i).setText(llaves.get(i) + " " + daño.get(i));
        }

        Ataque_1.setOnAction(event -> {
            String ataque = Ataque_1.getText();
            String primerPalabra = ataque.substring(0, ataque.lastIndexOf(" "));
            gestionDeAtaques(crearPersonaje.personajesMap.get(Turno.turnoDePelea.getFirst()), primerPalabra);
        });

        Ataque_2.setOnAction(event -> {
            String ataque = Ataque_2.getText();
            String primerPalabra = ataque.substring(0, ataque.lastIndexOf(" "));
            gestionDeAtaques(crearPersonaje.personajesMap.get(Turno.turnoDePelea.getFirst()), primerPalabra);
        });

        Ataque_3.setOnAction(event -> {
            String ataque = Ataque_3.getText();
            String primerPalabra = ataque.substring(0, ataque.lastIndexOf(" "));
            gestionDeAtaques(crearPersonaje.personajesMap.get(Turno.turnoDePelea.getFirst()), primerPalabra);
        });

        Ataque_4.setOnAction(event -> {
            String ataque = Ataque_4.getText();
            String primerPalabra = ataque.substring(0, ataque.lastIndexOf(" "));
            gestionDeAtaques(crearPersonaje.personajesMap.get(Turno.turnoDePelea.getFirst()), primerPalabra);
        });

    }

    private void gestionDeAtaques(Clase jugador, String ataque) {
        Toggle x = toggleAtaque.getSelectedToggle();
        String pj = ((RadioButton) x).getText();
        Enemigo enemigo = crearPersonaje.enemigoMap.get(pj);

        if (crearPersonaje.personajesMap.containsKey(Turno.turnoDePelea.getFirst())) {
            PeleaNueva.ataqueJugador(jugador, enemigo, ataque);

        }
        if (crearPersonaje.enemigoMap.containsKey(Turno.turnoDePelea.getFirst())) {
            PeleaNueva.ataqueEnemigo(registro.nomArray);
        }
        actualizarBotones();
    }

    private void actualizarBotones() {
        muerto();

        if (crearPersonaje.personajesMap.containsKey(Turno.turnoDePelea.getFirst())) {
            List<String> llaves = new ArrayList<>(
                    crearPersonaje.personajesMap.get(Turno.turnoDePelea.getFirst()).getAtaquesmMap().keySet());
            List<Integer> daño = new ArrayList<>(crearPersonaje.personajesMap.get(Turno.turnoDePelea.getFirst()).getAtaquesmMap().values());

            for (int i = 0; i < llaves.size(); i++) {
                botones.get(i).setText(llaves.get(i) + " " + daño.get(i));
            }
        }
    }

    private void muerto(){
        if (!crearPersonaje.enemigoMap.get(registro.eneArray.get(0)).getAlive()) {
            Turno.turnoDePelea.remove(registro.eneArray.get(0));
            LabelVidaEnemigo1.setText("");
            LabelEnemigo1.setText("Muerto");
            enemigoAtacar1.setDisable(true);
        }else{
            LabelVidaEnemigo1.setText(String.valueOf(crearPersonaje.enemigoMap.get(registro.eneArray.get(0)).getVida()));
        }

        if (!crearPersonaje.enemigoMap.get(registro.eneArray.get(1)).getAlive()) {
            Turno.turnoDePelea.remove(registro.eneArray.get(1));
            LabelVidaEnemigo2.setText("");
            LabelEnemigo2.setText("Muerto");
            enemigoAtacar2.setDisable(true);

        }else{
            LabelVidaEnemigo2.setText(String.valueOf(crearPersonaje.enemigoMap.get(registro.eneArray.get(1)).getVida()));
        }

        if (!crearPersonaje.enemigoMap.get(registro.eneArray.get(2)).getAlive()) {
            Turno.turnoDePelea.remove(registro.eneArray.get(2));
            LabelVidaEnemigo3.setText("");
            LabelEnemigo3.setText("Muerto");
            enemigoAtacar3.setDisable(true);
        }else{
            LabelVidaEnemigo3.setText(String.valueOf(crearPersonaje.enemigoMap.get(registro.eneArray.get(2)).getVida()));
        }
        
        LabelVidaJugador1.setText(String.valueOf(crearPersonaje.personajesMap.get(registro.nomArray.get(0)).getVida()));
        LabelVidaJugador2.setText(String.valueOf(crearPersonaje.personajesMap.get(registro.nomArray.get(1)).getVida()));
        LabelVidaJugador3.setText(String.valueOf(crearPersonaje.personajesMap.get(registro.nomArray.get(2)).getVida()));

        if (!crearPersonaje.enemigoMap.get(registro.eneArray.get(0)).getAlive() && 
            !crearPersonaje.enemigoMap.get(registro.eneArray.get(1)).getAlive() && 
            !crearPersonaje.enemigoMap.get(registro.eneArray.get(2)).getAlive()) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Interfaz/ganar.fxml"));
                Parent root = loader.load();

                Stage stage = (Stage) Ataque_1.getScene().getWindow();
                
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