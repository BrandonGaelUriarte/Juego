package Personajes.Jugador;

import java.util.HashMap;
import java.util.Map;

public class Arquero extends Clase{

    public static String imagen = "/imagenes/Jugador/Jugador2.png";
    private static Map<String, Integer> ataques = new HashMap<>();
    static {
        ataques = crearAtaques();
    }

    public Arquero(String nombre) {
        super(nombre, 80, 1, ataques, imagen);
    }

    private static Map<String, Integer> crearAtaques(){
        ataques.put("Flecha", 30);
        ataques.put("Flecha mas fuerte", 60);
        ataques.put("Nada", 0);
        ataques.put("Culatazo", 1);
        return ataques;
    }
    
}