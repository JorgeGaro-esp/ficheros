/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficheros.ObjetosTexto.Ejercicio05;

import java.io.Serializable;

/**
 *
 * @author Jorge Garcia Rodriguez
 */
public class Factura implements Serializable{
    
    private int id;
    private String nombre;
    private int total;
    
    //Constructor

    public Factura(int id, String nombre, int total) {
        this.id = id;
        this.nombre = nombre;
        this.total = total;
    }
    
    //Getter and Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    //Metodos

    @Override
    public String toString() {
        return "Id: " + id + ", nombre: " + nombre + ", total: " + total;
    }
    
    
}
