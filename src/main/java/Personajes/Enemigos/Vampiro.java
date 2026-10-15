package Personajes.Enemigos;
import Personajes.Jugador.Clase;

public class Vampiro extends Enemigo{
    public static String imagen = "/imagenes/Enemigos/Enemigo1.png";
    public Vampiro() {
        super("Vampiro", 75, 1, 30,100, imagen);
    }
    
    @Override
    public void atacar(Clase personaje){
        personaje.curar(this.getAtaque()/2);
    }
}
