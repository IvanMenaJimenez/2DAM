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

    public int getMaxvida() {
        return maxvida;
    }

    public int getVida() {
        return vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getNum_armas() {
        return num_armas;
    }

    public boolean isBotiquin() {
        return botiquin;
    }

    public int getNum_protecion() {
        return num_protecion;
    }

   
    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setNum_armas(int num_armas) {
        this.num_armas = num_armas;
    }

    public void setBotiquin(boolean botiquin) {
        this.botiquin = botiquin;
    }

    public void setNum_protecion(int num_protecion) {
        this.num_protecion = num_protecion;
    }

     @Override
    public String toString() {
        return "Superviviente{" + "maxvida=" + maxvida + ", vida=" + vida + ", ataque=" + ataque + ", num_armas=" + num_armas + ", botiquin=" + botiquin + ", num_protecion=" + num_protecion + '}';
    }

    
    
}
