package Personajes;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import Personajes.Jugador.*;
import Personajes.Enemigos.*;

public class crearPersonaje {
    public static Map<String, Enemigo> enemigoMap = new HashMap<>();
    public static Map<String, Clase> personajesMap = new HashMap<>();

    public static void crearJugador(String nombre, String clase) {
        switch (clase) {
            case "Mago":
                personajesMap.put(nombre, new Mago(nombre));
                break;
            case "Guerrero":
                personajesMap.put(nombre, new Guerrero(nombre));
                break;
            case "Arquero":
                personajesMap.put(nombre, new Arquero(nombre));
                break;
            default:
                break;
        }
    }

    public static String crearEnemigo() {
        Random random = new Random();
        int ii = random.nextInt(0, 3);
        switch (ii) {
            case 0:
                if (!enemigoMap.containsKey("Gigante")) {
                    enemigoMap.put("Gigante", new Gigante());
                    return "Gigante";
                } else if (!enemigoMap.containsKey("Gigante1")) {
                    enemigoMap.put("Gigante1", new Gigante());
                    return "Gigante1";
                } else if (!enemigoMap.containsKey("Gigante2")) {
                    enemigoMap.put("Gigante2", new Gigante());
                    return "Gigante2";
                }

            case 1:
                if (!enemigoMap.containsKey("Vampiro")) {
                    enemigoMap.put("Vampiro", new Vampiro());
                    return "Vampiro";
                } else if (!enemigoMap.containsKey("Vampiro1")) {
                    enemigoMap.put("Vampiro1", new Vampiro());
                    return "Vampiro1";
                } else if (!enemigoMap.containsKey("Vampiro2")) {
                    enemigoMap.put("Vampiro2", new Vampiro());
                    return "Vampiro2";
                }
            case 2:
                if (!enemigoMap.containsKey("Goblin")) {
                    enemigoMap.put("Goblin", new Goblin());
                    return "Goblin";
                }else if (!enemigoMap.containsKey("Goblin1")) {
                    enemigoMap.put("Goblin1", new Goblin());
                    return "Goblin1";
                }else if (!enemigoMap.containsKey("Goblin2")) {
                    enemigoMap.put("Goblin2", new Goblin());
                    return "Goblin2";
                }
                
            default:
                return null;
        }
    }
}