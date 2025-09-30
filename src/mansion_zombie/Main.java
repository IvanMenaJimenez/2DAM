package mansion_zombie;

import java.util.Scanner;

public class Main {

    //SEGUN LA DIFICULTAD QUE ELIGAS SE DEVOLVERA EL NUMERO DE RONDAS EN FORMA DE INT
    static public int ElegirDificultad(Scanner sc) {
        int eleccion = 0;
        int dificultad = 0;

        System.out.println("BIENVENIDO A MANSION ZOMBIE. ELIGE UNA DIFICULTAD");
        System.out.println("1:FACIL");
        System.out.println("2:DIFICIL");

        do {

            eleccion = sc.nextInt();

            switch (eleccion) {
                case 1:
                    System.out.println("HAS ELEGIDO LA DIFILCULTAD FACIL");
                    dificultad = 5;
                    break;

                case 2:
                    System.out.println("HAS ELEGIDO LA DIFILCULTAD DIFICIL");
                    dificultad = 10;
                    break;

                default:
                    System.out.println("Introduce un numero correcto");
                    break;
            }

        } while (eleccion != 1 && eleccion != 2);

        return dificultad;
    }

    //COMPROVACION DE QUE ACCIONES PUEDE REALIZAR EL JUGADOR Y SE INPRIMEN EN PANTALLA EN EL CASO QUE PUEDAN HACERSE
    static public void MostrarAccionesDisponibles(Habitacion habitacion, Superviviente superviviente) {

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

    //COMPROVACION DE QUE ACCIONES PUEDE REALIZAR EL JUGADOR Y SEGUN EL NUMERO INTRODUCIDO SE REALIZARAN DEVULVE EL INT QUE EL USUARIO A INTRODUCIDO
    static public int ElegirAccion(Scanner sc, Habitacion habitacion, Superviviente superviviente) {
        int eleccionJugador = sc.nextInt();
        
        if (habitacion.zombies.isEmpty() == false && eleccionJugador == 1) {
            Combate(superviviente, habitacion);

            
        } else if (superviviente.botiquin == true && eleccionJugador == 2) {
            superviviente.UsarBotiquin();

            
        } else if (habitacion.numIntentosRest > 0 && eleccionJugador == 3) {
            habitacion.Buscar(superviviente);

            
        } else if (habitacion.zombies.isEmpty() && eleccionJugador == 4) {
            System.out.println("HAS AVANZADO DE HABITACION!!!");

            
        } else {
            System.out.println("ELIGE UNA OPCION CORRECTA");
            eleccionJugador = 0;
        }

        System.out.println("");
        return eleccionJugador;
    }

    //SE GENERA ALETORIAMENTE EL ATAQUE HECHO Y RECIVIDO HASTA QUE EL ENEMIGO O EL JUGADOR NO TENGAN PUNTOS DE VIDA
    static public void Combate(Superviviente superviviente, Habitacion habitacion) {
        Zombie zombie = (Zombie) habitacion.zombies.get(0);
        int dañoZombie;
        int dañoSuperviviente;

        do {
            System.out.println("\n" + "VIDA SUPERVIVIENTE = " + superviviente.vida);
            System.out.println("VIDA ZOMBIE = " + zombie.vida);
           
            
            //CALCULAR DAÑO CAUSADO POR EL JUGADOR
            dañoSuperviviente = ((int) (Math.random() * (superviviente.ataque + 1))) + superviviente.numArmas;
            System.out.println("\n" + "HAS HECHO " + dañoSuperviviente + " DE DAÑOS");

            
            //COMPROVACION SI EL ENEMIGO A SIDO DERRATODO ASIGNANDO EL VALOR DE VIDA A 0 SI AL RESTAR EL DAÑO LA VIDA ES NEGATIVA
            if ((zombie.vida -= dañoSuperviviente) <= 0) {
                zombie.vida = 0;
                System.out.println("VICTORIA");

            } else {

                //SI EL ENEMIGO NO HA SIDO VENCIDO CALCULAMOS EL DAÑO RECIVIDO POR EL JUGADOR
                dañoZombie = ((int) (Math.random() * (zombie.ataque + 1))) - superviviente.numProtecion;
                System.out.println("TE HAN HECHO " + dañoZombie + " DE DAÑOS");

                //COMPROVACION SI JUGADOR A SIDO DERRATODO ASIGNANDO EL VALOR DE VIDA A 0 SI AL RESTAR EL DAÑO A LA VIDA ES NEGATIVA
                if ((superviviente.vida -= dañoZombie) < 0) {
                    superviviente.vida = 0;
                }               
            }
            
        } while (superviviente.vida != 0 && zombie.vida != 0);

        //ELIMINAR AL ENEMIGO DEL ARRAYLIST SI ESTE ES DERROTADO
        if (zombie.vida == 0) {
            habitacion.zombies.remove(0);
        }
    }

    public static void main(String[] args) {
        Superviviente superviviente = new Superviviente();
        Scanner sc = new Scanner(System.in);
        int eleccionJugador = 0;
        int dificilcultad = ElegirDificultad(sc);

        
        //BUCLE POR CADA SALA EN LA DIFICULTAD ELEGIDA        
        for (int i = 1; i <= dificilcultad; i++) {
            Habitacion habitacion = new Habitacion(i);

            //ACCIONES DENTRO DE LA SALA SOLO PUEDES SALIR DEL BUCLE CUANDO PASES DE SALA O TE MUERAS
            do {
                System.out.println("\n" + superviviente);
                System.out.println("LA HABITACION " + habitacion.numHabitacion + " CONTIENE: " + habitacion.zombies.size() + " ZOMBIES");

                System.out.println("\n" + "ELIGE UNA DE LAS SIGUIENTES ACCIONES:");
                MostrarAccionesDisponibles(habitacion, superviviente);

                eleccionJugador = ElegirAccion(sc, habitacion, superviviente);

            } while (eleccionJugador != 4 && superviviente.vida != 0);

            //SI EL JUGADOR A MUERTO SE SALDRA DEL BUCLE FOR SIN TENER QUE PASAR POR TODAS LAS SALAS
            if (superviviente.vida == 0) {
                System.out.println("HAS MUERTO");
                break;
            }

        }

        //SI EL USUARIO A CONSEGUIDO SOBREVIVIR A TODAS LAS SALAS SE IMPRIME EL MENSAJE
        if (superviviente.vida > 0) {
            System.out.println("HAS SOBREVIVIDO A LA MANSIÓN ZOMBIE");
        }
    }
}
