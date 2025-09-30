package mansion_zombie;

public class Superviviente {

    final int maxVida;
    int vida;
    int ataque;
    int numArmas;
    boolean botiquin;
    int numProtecion;

    public Superviviente() {
        this.maxVida = 20;
        this.vida = 20;
        this.ataque = 4;
        this.numArmas = 0;
        this.botiquin = false;
        this.numProtecion = 0;
    }
    
    //METODO QUE CONVIERTE EL ATRIBUTO BOTIQUIN A FALSE Y SUMA CUATRO A LA VIDA
    //SI ESTA ES SUPERIOR AL ATRIBUTO VIDA MAXIMA    
    public void UsarBotiquin() {
        botiquin = false;

        if ((vida += 4) > maxVida) {
            vida = maxVida;
        }
    }

    @Override
    public String toString() {
        return "VIDA = " + vida + " ATAQUE = " + ataque + " ARMAS = " + numArmas + " PROTECCIONES = " + numProtecion + " BOTIQUINES = " + botiquin;
    }
}
