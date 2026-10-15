package Personajes.Jugador;
import Personajes.personaje;
import Personajes.Enemigos.Enemigo;

import java.util.HashMap;
import java.util.Map;

import Pelea.Pelea;

public class Clase extends personaje{
    public Map<String, Integer> ataques = new HashMap<>();
    private int experiencia=0;
    public double sigNivel=50;
    public Clase(String nombre, int vida, int nivel, Map<String, Integer> ataques, String imagen) {
        super(nombre, vida, nivel, vida, imagen);
        this.ataques=ataques;
    }

    public void empezarPelea(Clase jugador, Enemigo enemigo){
        Pelea.batalla(jugador, enemigo);
    }

    public void subirNivel(int xpRecibida) {
        this.experiencia+=xpRecibida;
        while (this.experiencia >= this.sigNivel) {
            this.experiencia -= (int) this.sigNivel;
            this.sigNivel*=1.5;
            setNivel(getNivel()+1);
        }
    }

    public void atacar(Enemigo enemigo, int ata){
        enemigo.recibirDaño(ata);
    }

    public int getAtaque(String nombre){
        return ataques.get(nombre);
    }

    public Map<String, Integer> getAtaquesmMap(){
        return this.ataques;
    }
    
}
