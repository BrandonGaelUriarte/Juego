package Personajes.Jugador;

import java.util.HashMap;
import java.util.Map;

public class Guerrero extends Clase{

    public static String imagen = "/imagenes/Jugador/Jugador1.png";
    private static Map<String, Integer> ataques = new HashMap<>();
    static {
        ataques = crearAtaques();
    }
    public Guerrero(String nombre) {
        super(nombre, 120, 1, ataques, imagen);
    }

    private static Map<String, Integer> crearAtaques(){
        ataques.put("Putazo", 30);
        ataques.put("Morder bolas", 60);
        ataques.put("Nada", 0);
        ataques.put("Verlo feo", 10);
        return ataques;
    }
}
