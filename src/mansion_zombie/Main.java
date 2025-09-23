package mansion_zombie;

import java.util.Scanner;

public class Main {

  static boolean Combate(Superviviente superviviente, Zombie zombie) {

        do {
         zombie.vida  = zombie.vida -((int) (Math.random() * (superviviente.ataque + 1)));
           
            if (zombie.vida > 0) {
                superviviente.vida -= ((int) (Math.random() * (superviviente.ataque + 1)));
            }
   
            
            
            
        } while (superviviente.vida <= 0 || zombie.vida <= 0);

        if (superviviente.vida == 0) {
            return false;
        } else {
            return true;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Superviviente superviviente = new Superviviente();
        int eleccion;
        int dificultad = 0;

        System.out.println("Bienvenido a macion zombie. Elige una dificultad");
        System.out.println("1:Facil");
        System.out.println("2:Dificil");

        do {
            eleccion = sc.nextInt();
            switch (eleccion) {
                case 1:
                    System.out.println("Has elegido la dificultad facil");
                    dificultad = 5;
                    break;

                case 2:
                    System.out.println("Has elegido la dificultad dificil");
                    dificultad = 10;
                    break;

                default:
                    System.out.println("Introduce un numero correcto");
                    break;
            }
        } while (eleccion != 1 && eleccion != 2);

        for (int i = 1; i <= dificultad; i++) {

            Habitacion habitacion = new Habitacion(i);
            int elecionJugador = 0;

            //  do {
            System.out.println(superviviente);
            System.out.println("* LA HABITACIÓN " + habitacion.numHabitacion + " CONTIENE: " + habitacion.zombies.size() + " ZOMBIES");
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
            System.out.println(superviviente.ataque);
 System.out.println((int) (Math.random() * (superviviente.ataque + 1)));
            elecionJugador = sc.nextInt();
            if (habitacion.zombies.isEmpty() == false && elecionJugador == 1) {
                Combate(superviviente, (Zombie) habitacion.zombies.get(0));
            } else if (superviviente.botiquin == true && elecionJugador == 2) {
                //superviviente.UsarBotiquin();
            } else if (habitacion.numIntentosRest > 0 && elecionJugador == 3) {
                habitacion.Buscar(superviviente);
            } else if (elecionJugador == 4) {
                System.out.println("HAS AVANZADO DE HABITACION!!!");
            } else {
                System.out.println("Elige una opcion correcta");
            }

            // } while (elecionJugador != 4);
        }

    }

}
