package mansion_zombie;

import java.util.Random;

public class Zombie {

    int vida;
    int ataque;

    public Zombie(int numsala) {
        this.vida = ((int)(Math.random() * 2)) + 2 + (numsala -1) ;
        this.ataque = ((int)(Math.random() * 2)) + 2 + (numsala -1) ;

    }

    @Override
    public String toString() {
        return "Zombie{" + "vida=" + vida + ", ataque=" + ataque + '}';
    }

    

}
