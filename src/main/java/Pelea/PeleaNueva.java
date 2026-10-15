package Pelea;

import Personajes.Enemigos.Enemigo;
import Personajes.Jugador.Clase;

import java.util.ArrayList;
import java.util.Random;

import Personajes.crearPersonaje;

public class PeleaNueva {
    public static void ataqueJugador(Clase clase, Enemigo enemigo, String Ataque) {
        int daño = clase.ataques.get(Ataque);
        enemigo.recibirDaño(daño);
        Turno.turnoAtaque();
    }

    public static void ataqueEnemigo(ArrayList<String> Jugadores) {
        Random random = new Random();
        int li = random.nextInt(0, 3);
        switch (li) {
            case 0:
                crearPersonaje.personajesMap.get(Jugadores.get(0))
                        .recibirDaño(crearPersonaje.enemigoMap.get(Turno.turnoDePelea.getFirst()).getAtaque());
                break;
            case 1:
                crearPersonaje.personajesMap.get(Jugadores.get(1))
                        .recibirDaño(crearPersonaje.enemigoMap.get(Turno.turnoDePelea.getFirst()).getAtaque());
                break;
            case 2:
                crearPersonaje.personajesMap.get(Jugadores.get(2))
                        .recibirDaño(crearPersonaje.enemigoMap.get(Turno.turnoDePelea.getFirst()).getAtaque());
                break;
            default:
                break;
        }
        Turno.turnoAtaque();
    }
}