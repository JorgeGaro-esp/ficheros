/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficheros.ObjetosTexto.Ejercicio01;

import java.io.Serializable;

/**
 *
 * @author Jorge Garcia Rodriguez
 */
public class Producto implements Serializable{
    private String codigo;
    private String nombre;
    private double precio;
    
    //Constructor

    public Producto(String codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }
    
    //Getter and Setter

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    //Metodos

    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + '}';
    }
    
}
