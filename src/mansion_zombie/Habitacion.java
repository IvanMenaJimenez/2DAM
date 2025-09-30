package mansion_zombie;

import java.util.ArrayList;

public class Habitacion {

    ArrayList zombies = new ArrayList();
    int numHabitacion;
    int numIntentosRest;

    public Habitacion(int numHabitacion) {
        this.numHabitacion = numHabitacion;
        zombies.add(new Zombie(numHabitacion));
        numIntentosRest = 3;

    }

    //METODO QUE GENERA UN NUMERO ENTRE 1-100 Y SEGUN EL NUMERO EL USUARIO ENCUENTRA UN OBJETO O HACE RUIDO
    public void Buscar(Superviviente superviviente) {
        int numAl = (int) (Math.random() * 100 + 1);

        if (numAl <= 75) {
            System.out.println("HAS HECHO RUIDO");
            Ruido();

        } else if (numAl > 75 && numAl <= 90) {
            superviviente.botiquin = true;
            System.out.println("HAS ENCONTRADO UN BOTIQUIN");

        } else if (numAl > 90 && numAl <= 95) {
            superviviente.numProtecion = superviviente.numProtecion + 1;
            System.out.println("HAS ENCONTRADO UNA PROTECCION");

        } else if (numAl > 95 && numAl <= 100) {
            superviviente.numArmas = superviviente.numArmas + 1;
            System.out.println("HAS ENCONTRADO UNA ARMA");

        }
        numIntentosRest--;
    }

    //SI EN EL METODO BUSCAR A SALIDO UN NUMERO MENOR AL 76 SE LLAMA A ESTE METODO 
    //GENERA OTRO NUMERO ALEATORIA PUDIENDO GENERAL ZOMBIES EN LA SALA O NO PASAR NADA
    public void Ruido() {
        int numAl = (int) (Math.random() * 100 + 1);

        if (numAl <= 40) {
            System.out.println("NO HAS ALERTADO A NINGUN ZOMBIE");

        } else if (numAl > 40 && numAl <= 80) {
            System.out.println("HAS LLAMADO LA ATENCION DE UN ZOMBIE");
            AñadirZombies(1);

        } else if (numAl > 80 && numAl <= 100) {
            System.out.println("HAS LLAMADO LA ATENCION DE DOS ZOMBIE");
            AñadirZombies(2);

        }
    }

    //METODO QUE AÑADE UN NUEMRO DE ZOMBIES AL ARRAYLIST
    public void AñadirZombies(int num) {
        for (int i = 0; i < num; i++) {
            zombies.add(new Zombie(numHabitacion));
        }
    }

}
