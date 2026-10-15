package Personajes.Jugador;

import java.util.HashMap;
import java.util.Map;

public class Mago extends Clase{

    public static String imagen = "/imagenes/Jugador/Jugador3.png";
    private static Map<String, Integer> ataques = new HashMap<>();
    static {
        ataques = crearAtaques();
    }
    public Mago(String nombre) {
        super(nombre, 60, 1, ataques, imagen);
    }

    private static Map<String, Integer> crearAtaques(){
        ataques.put("Insultar a su mama", 30);
        ataques.put("Bola de fuego", 60);
        ataques.put("Nada", 0);
        ataques.put("rayo", 100);
        return ataques;
    }

}
