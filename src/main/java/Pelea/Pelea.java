package Pelea;

import Personajes.Jugador.Clase;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import Personajes.Entrada;
import Personajes.Enemigos.Enemigo;

public class Pelea {
    public static void batalla(Clase jugador, Enemigo enemigo) {
        FileWriter archivo;
        String ataque;
        try {
            archivo = new FileWriter("pelea.txt", true);
            PrintWriter escritor = new PrintWriter(archivo);
        while (enemigo.getAlive() && jugador.getAlive()) {
                System.out.println("seleccione el ataque: "+jugador.getAtaquesmMap());
                ataque = Entrada.leer.nextLine();
                jugador.atacar(enemigo, jugador.getAtaque(ataque));

            try {


                escritor.println("\n==================Turno Aliado====================== " +
                        "\nAtacaste a " + enemigo.getNombre() +
                        "\nLe hiciste " + jugador.getAtaque(ataque) +
                        "\nAl enemigo le queda " + enemigo.getVida() + " de vida");

                if (!enemigo.getAlive()) {
                    break;
                }
                enemigo.atacar(jugador);

                escritor.println("\n==================Turno enemigo====================== " +
                        "\nTe atacaron" +
                        "\nTe hicieron " + enemigo.getAtaque() +
                        "\nTe queda " + jugador.getVida() + " de vida");

                

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        
        if (jugador.getVida() > 0) {
            escritor.println("Ganaste");
        } else {
            escritor.println("Perdiste");
        }
        escritor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}