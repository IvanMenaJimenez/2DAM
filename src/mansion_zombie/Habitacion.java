package mansion_zombie;

import java.util.ArrayList;

public class Habitacion {

    ArrayList<Zombie> zombies = new ArrayList();
    int numHabitacion;
    int numIntentosRest;

    public Habitacion(int numHabitacion) {
        zombies.add(new Zombie(numHabitacion));
        this.numHabitacion = numHabitacion;
        numIntentosRest = 3;
    }

    public String Buscar(Superviviente superviviente) {
        numIntentosRest--;
        int numAl = (int) (Math.random() * 100 + 1);

        //EL USUARIO HA HECHO RUIDO SE GENERA OTRO NUMERO
        if (numAl <= 75) {
            numAl = (int) (Math.random() * 100 + 1);

            if (numAl > 40 && numAl <= 80) {
                añadirZombies(1);
                return "HAS HECHO RUIDO HAS ATRAIDO A UN ZOMBIE";
            } else if (numAl > 80 && numAl <= 100) {
                añadirZombies(2);
                return "HAS HECHO RUIDO HAS ATRAIDO A DOS ZOMBIE";
            }

            //EL USUARIO HA HECHO RUIDO SE GENERA OTRO NUMERO
        } else if (numAl > 75 && numAl <= 90) {
            superviviente.botiquin = true;
            return "HAS ENCONTADO UN BOTIQUIN";
            
        } else if (numAl > 90 && numAl <= 95) {
            superviviente.num_protecion++;
            return "HAS ENCONTADO UNA PROTECCION";

        } else if (numAl > 95 && numAl <= 100) {
            superviviente.num_armas++;
            return "HAS ENCONTADO UNA ARMA";

        }      
        return "NO HAS ENCONTADO NADA";
    }

    public ArrayList getZombies() {
        return zombies;
    }

    public int getNumHabitacion() {
        return numHabitacion;
    }

    public int getNumIntentosRest() {
        return numIntentosRest;
    }

    public void añadirZombies(int num) {
        for (int i = 0; i < num; i++) {
            zombies.add(new Zombie(numHabitacion));
        }
    }

}
