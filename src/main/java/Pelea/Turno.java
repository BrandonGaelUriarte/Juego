package Pelea;

import java.util.ArrayList;

import controladores.registro;

public class Turno {
    public static ArrayList<String> turnoDePelea = new ArrayList<>();
    
    public static void turnoAtaque(){
        if (turnoDePelea.isEmpty()) {
            turnoDePelea.add(registro.nomArray.get(0));
            turnoDePelea.add(registro.eneArray.get(0));
            turnoDePelea.add(registro.nomArray.get(1));
            turnoDePelea.add(registro.eneArray.get(1));
            turnoDePelea.add(registro.nomArray.get(2));
            turnoDePelea.add(registro.eneArray.get(2));
        }else{
            siguienteTurno(turnoDePelea);
        }
    }

    public static void siguienteTurno(ArrayList<String> turnoDePelea){
        String siguiente = turnoDePelea.getFirst();
        turnoDePelea.removeFirst();
        turnoDePelea.addLast(siguiente);
    }
}