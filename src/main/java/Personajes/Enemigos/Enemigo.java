package Personajes.Enemigos;
import Personajes.personaje;
import Personajes.Jugador.Clase;

public class Enemigo extends personaje{
    private int ataque;

    public Enemigo(String nombre, int vida, int nivel, int ataque, int vidaMaxima, String imagen) {
        super(nombre, vida, nivel, vidaMaxima, imagen);
        this.ataque=ataque;
    }

    public void atacar(Clase personaje) {
        personaje.recibirDaño(this.ataque);
    }

    public int getAtaque(){
        return this.ataque;
    }
    
}