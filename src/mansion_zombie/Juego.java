/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mansion_zombie;

/**
 *
 * @author ivan.menjim
 */
public class Juego {

    Superviviente superviviente = new Superviviente();
    public Habitacion habitacion;
    int habitacionActual = 0;
    int habitacionMax;

    public void ElegirDificultad(String eleccion) {
        switch (eleccion) {
            case "Facil":
                habitacionMax = 5;
                break;

            case "Normal":
                habitacionMax = 10;
                break;

            case "Dificil":
                habitacionMax = 10;
                break;
        }
    }

    public void avanzar() {
        habitacionActual++;
        if (habitacionActual < habitacionMax) {
            habitacion = new Habitacion(habitacionActual);
        }
    }

    public void iniciarJuego(String dificultad) {
        ElegirDificultad(dificultad);
        avanzar();
    }

    public String Combate() {
        Zombie zombie = (Zombie) habitacion.zombies.get(0);
        int dañoZombie = 0;
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

        return ("TE HAN HECHO " + dañoZombie + " DE DAÑOS \n " + "HAS HECHO " + dañoSuperviviente + " DE DAÑOS");
    }

    public Superviviente getSuperviviente() {
        return superviviente;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public int getHabitacionActual() {
        return habitacionActual;
    }

    public int getHabitacionMax() {
        return habitacionMax;
    }
}
