package mansion_zombie;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("holi");
        Scanner sc = new Scanner(System.in);
        Superviviente superviviente = new Superviviente();
        int num;
        int habitacionDificultad = 0;
        
        System.out.println("Bienvenido a macion zombie. Elige una dificultad");
        System.out.println("1:Facil");
        System.out.println("2:Dificil");
        
        do {
            num = sc.nextInt();
            switch (num) {
                case 1:
                    System.out.println("Has elegido la dificultad facil");
                    habitacionDificultad = 5;
                    break;

                case 2:
                    System.out.println("Has elegido la dificultad dificil");
                    habitacionDificultad = 10;
                    break;

                default:
                    System.out.println("Introduce un numero correcto");
                    break;
            }
        } while (num != 1 && num != 2);

        
        for (int i = 1; i <= habitacionDificultad; i++) {
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
            
            
            
            
            elecionJugador = sc.nextInt();
            if (habitacion.zombies.isEmpty() == false && elecionJugador == 1) {

            } else if (superviviente.botiquin == true && elecionJugador == 2) {
                superviviente.UsarBotiquin();
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
