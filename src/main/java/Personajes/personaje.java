package Personajes;

public class personaje {
    private String nombre;
    private int vida;
    private int nivel;
    private boolean alive;
    private int vidaMaxima;
    private String imagen;

    public personaje(String nombre, int vida, int nivel, int vidaMaxima, String imagen) {
        this.nombre = nombre;
        this.vida = vida;
        this.vidaMaxima = vidaMaxima;
        this.nivel = nivel;
        this.alive = true;
        this.imagen = imagen;
    }

    public void recibirDaño(int daño) {
        if (daño < 0) {
            return;
        }
        this.vida -= daño;
        if (this.vida <= 0) {
            this.vida = 0;
            this.alive = false;  
        }
    }

    public void curar(int cura) {
        if (cura < 0) {
            return;
        }
        if (this.vida + cura <= this.vidaMaxima) {
            System.out.println("Recibiste " + cura + " de cura");
            this.vida += + cura;
        } else {
            this.vida = vidaMaxima;
        }
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getVida() {
        return this.vida;
    }

    public int getNivel() {
        return this.nivel;
    }

    public boolean getAlive() {
        return this.alive;
    }

    public String getImagen(){
        return this.imagen;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setNivel(int nivel){
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "Nombre: " + this.nombre +
                "\nNivel: " + this.nivel +
                "\nVida: " + this.vida +
                "\nEstado: " + this.alive;
    }

}