package mansion_zombie;

import java.util.ArrayList;

public class Habitacion {

    ArrayList zombies = new ArrayList();
    int numHabitacion;
    int numIntentosRest;

    public Habitacion(int numHabitacion) {
        zombies.add(new Zombie(numHabitacion));
        this.numHabitacion = numHabitacion;
        numIntentosRest = 3;

    }

    public void Buscar(Superviviente superviviente) {
        System.out.println("holaa");
        int numAl = (int) (Math.random() * 100 + 1);

        if (numAl <= 75) {
            numAl = (int) (Math.random() * 100 + 1);
            
            if ( numAl <= 40) {

            } else if (numAl > 40 && numAl <= 80) {
                añadirZombies(1);

            } else if (numAl > 80 && numAl <= 100) {
                añadirZombies(2);

            }

        } else if (numAl > 75 && numAl <= 90) {
            superviviente.botiquin = true;

        } else if (numAl > 90 && numAl <= 95) {
            superviviente.num_protecion = superviviente.num_protecion + 1;

        } else if (numAl > 95 && numAl <= 100) {
            superviviente.num_armas = superviviente.num_armas + 1;
        }

    }

    public void añadirZombies(int num) {
        for (int i = 0; i < num; i++) {
            zombies.add(new Zombie(numHabitacion));
        }
    }

}
