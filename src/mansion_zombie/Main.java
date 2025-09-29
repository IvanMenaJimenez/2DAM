package mansion_zombie;

import java.util.Scanner;

public class Main {

    static public int ElegirDificultad(Scanner sc, int dificultad) {
        int eleccion;
        System.out.println("BIENVENIDO A MANSION ZOMBIE. ELIGE UNA DIFICULTAD");
        System.out.println("1:FACIL");
        System.out.println("2:DIFICIL");

        do {

            eleccion = sc.nextInt();

            switch (eleccion) {
                case 1:
                    System.out.println("HAS ELEGIDO LA DIFILCULTAD FACIL");
                    dificultad = 5;

                case 2:
                    System.out.println("HAS ELEGIDO LA DIFILCULTAD DIFICIL");
                    dificultad = 10;

                default:
                    System.out.println("Introduce un numero correcto");
                    break;
            }

        } while (eleccion != 1 && eleccion != 2);

        return dificultad;
    }

    
    static public void ElegirAccion(int elecionJugador, Habitacion habitacion, Superviviente superviviente) {

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

    static void Combate(Superviviente superviviente, Habitacion habitacion) {
        Zombie zombie = (Zombie) habitacion.zombies.get(0);
        int dañoZombie;
        int dañoSuperviviente;

        do {

            dañoSuperviviente = ((int) (Math.random() * (superviviente.ataque + 1))) + superviviente.num_armas;
            zombie.vida = zombie.vida - dañoSuperviviente;

            System.out.println("HAS HECHO " + dañoSuperviviente + " DE DAÑOS");

            if (zombie.vida > 0) {

                dañoZombie = ((int) (Math.random() * (zombie.ataque + 1))) - superviviente.num_protecion;
                superviviente.vida -= dañoZombie;

                System.out.println("TE HAN HECHO " + dañoZombie + " DE DAÑOS");

            }

        } while (superviviente.vida >= 0 && zombie.vida >= 0);

        if (zombie.vida <= 0) {
            habitacion.zombies.remove(0);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dificultad = 0;
        dificultad = ElegirDificultad(sc, dificultad);

        Superviviente superviviente = new Superviviente();

        for (int i = 1; i <= dificultad; i++) {

            Habitacion habitacion = new Habitacion(i);
            int elecionJugador = 0;

            do {

                System.out.println("* LA HABITACION " + habitacion.numHabitacion + " CONTIENE: " + habitacion.zombies.size() + " ZOMBIES");
                System.out.println(superviviente);
                System.out.println(" ELIGE UNA DE LAS SIGUIENTES ACCIONES:");

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

                elecionJugador = sc.nextInt();
                ElegirAccion(elecionJugador, habitacion, superviviente);

            } while (elecionJugador != 4 && superviviente.vida > 0);

            if (superviviente.vida > 0) {

            } else {
                System.out.println("HAS MUERTO");
                break;
            }

        }

    }

}
