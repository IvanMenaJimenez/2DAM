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
        String resultado = "";
        int dañoZombie = 0;
        int dañoSuperviviente;
        Zombie zombie = (Zombie) habitacion.zombies.get(0);

        dañoSuperviviente = ((int) (Math.random() * (superviviente.ataque + 1))) + superviviente.num_armas;
        zombie.vida -= dañoSuperviviente;
        resultado += ("HAS HECHO" + dañoSuperviviente + " DE DAÑO \n");

        if (zombie.vida > 0) {
            dañoZombie = ((int) (Math.random() * (zombie.ataque + 1))) - superviviente.num_protecion;
            superviviente.vida -= dañoZombie;
            resultado += ("TE HAN HECHO " + dañoZombie + " DE DAÑO \n");
        } else {
            habitacion.zombies.remove(0);
            resultado += ("HAS MATADO AL ZOMBIE");
        }

        return resultado;
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
