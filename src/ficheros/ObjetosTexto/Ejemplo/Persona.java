/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficheros.ObjetosTexto.Ejemplo;

import java.io.Serializable;

/**
 *
 * @author Jorge Garcia Rodriguez
 */
public class Persona implements Serializable{

    private String nombre;
    private int edad;

    //Constructor 
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    //Getters and Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", edad: " + edad;
    }

}
