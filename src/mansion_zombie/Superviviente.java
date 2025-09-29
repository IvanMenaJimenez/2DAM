package mansion_zombie;

public class Superviviente {

    final int maxvida;
    int vida;
    int ataque;
    int num_armas;
    boolean botiquin;
    int num_protecion;

    public Superviviente() {
        this.maxvida = 20;
        this.vida = 20;
        this.ataque = 4;
        this.num_armas = 0;
        this.botiquin = false;
        this.num_protecion = 0;
    }

    @Override
    public String toString() {
        return "Superviviente{" + "maxvida=" + maxvida + ", vida=" + vida + ", ataque=" + ataque + ", num_armas=" + num_armas + ", botiquin=" + botiquin + ", num_protecion=" + num_protecion + '}';
    }

    public void UsarBotiquin() {
        botiquin = false;

        if ((vida += 4) > maxvida) {
            vida = maxvida;
        }
    }
}
