package mansion_zombie;

import java.util.Scanner;

public class Main {

    int habitacionActual;
    int habitacionMax = 1;

    Superviviente superviviente = new Superviviente();

    public int ElegirDificultad(String eleccion) {
        int dificultad = 0;

        switch (eleccion) {
            case "Facil":
                System.out.println("HAS ELEGIDO LA DIFILCULTAD FACIL");
                habitacionActual = 5;
                break;

            case "Normal":
                System.out.println("HAS ELEGIDO LA DIFILCULTAD DIFICIL");
                habitacionActual = 10;
                break;

            case "Dificil":
                System.out.println("HAS ELEGIDO LA DIFILCULTAD DIFICIL");
                habitacionActual = 10;
                break;
        }

        return dificultad;
    }

    public void MostrarAccionesDisponibles(Habitacion habitacion, Superviviente superviviente) {

        if (habitacion.zombies.isEmpty() == false) {
            System.out.println("1:Pelear");
        } else {

            if (superviviente.botiquin == true) {
                System.out.println("2:Curarte");
            }

            if (habitacion.numIntentosRest > 0) {
                System.out.println("3:Buscar");
            }

            System.out.println("4:Avanzar");
        }
    }

    public void ElegirAccion(int elecionJugador, Habitacion habitacion, Superviviente superviviente) {

        if (habitacion.zombies.isEmpty() == false && elecionJugador == 1) {
            Combate(superviviente, habitacion);

        } else if (superviviente.botiquin == true && elecionJugador == 2) {
            superviviente.UsarBotiquin();

        } else if (habitacion.numIntentosRest > 0 && elecionJugador == 3) {
            habitacion.Buscar(superviviente);

        } else if (elecionJugador == 4) {
            System.out.println("HAS AVANZADO DE HABITACION!!!");

        } else {
            System.out.println("Elige una opcion correcta");
        }
    }

    void Combate(Superviviente superviviente, Habitacion habitacion) {
        Zombie zombie = (Zombie) habitacion.zombies.get(0);
        int dañoZombie;
        int dañoSuperviviente;



            dañoSuperviviente = ((int) (Math.random() * (superviviente.ataque + 1))) + superviviente.num_armas;
            zombie.vida = zombie.vida - dañoSuperviviente;

            System.out.println("HAS HECHO " + dañoSuperviviente + " DE DAÑOS");

            if (zombie.vida > 0) {

                dañoZombie = ((int) (Math.random() * (zombie.ataque + 1))) - superviviente.num_protecion;
                superviviente.vida -= dañoZombie;

                System.out.println("TE HAN HECHO " + dañoZombie + " DE DAÑOS");

            }

        if (zombie.vida <= 0) {
            habitacion.zombies.remove(0);
        }
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main a = new Main();

        for (int i = 1; i <= (a.numeroHabitacion); i++) {

            Habitacion habitacion = new Habitacion(i);
            int elecionJugador = 0;

            do {
                System.out.println("* LA HABITACION " + habitacion.numHabitacion + " CONTIENE: " + habitacion.zombies.size() + " ZOMBIES");
                System.out.println(a.superviviente);
                System.out.println(" ELIGE UNA DE LAS SIGUIENTES ACCIONES:");

                a.MostrarAccionesDisponibles(habitacion, a.superviviente);

                elecionJugador = sc.nextInt();
                a.ElegirAccion(elecionJugador, habitacion, a.superviviente);

            } while (elecionJugador != 4 && a.superviviente.vida > 0);

            if (a.superviviente.vida > 0) {

            } else {
                System.out.println("HAS MUERTO");
                break;
            }

        }

    }
}
