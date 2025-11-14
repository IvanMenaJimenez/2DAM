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

    
    int habitacionActual;
    int habitacionMax;

    public void ElegirDificultad(String eleccion) {
        switch (eleccion) {
            case "Facil":
                habitacionActual = 5;
                break;

            case "Normal":
                habitacionActual = 10;
                break;

            case "Dificil":
                habitacionActual = 10;
                break;
        }
    }
    

    public void iniciarJuego(String dificultad) {
        ElegirDificultad(dificultad);
        avanzar();
    }

    public void avanzar() {
        habitacionActual++;
        if (habitacionActual >= habitacionMax) {

        } else {
            habitacion = new Habitacion(habitacionActual);
        }

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
