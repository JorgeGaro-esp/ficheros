/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficheros.FicherosAleatorios.Empleado;

/**
 *
 * @author Jorge Garcia Rodriguez
 */
public class Empleado {
    public static final int TAM_NOMBRE = 20;
    public static final int TAM_REGISTRO = 56;

    private int id;
    private String nombre;
    private int edad;
    private double salario;

    public Empleado(int id, String nombre, int edad, double salario) {
        this.id = id;
        this.nombre = ajustarNombre(nombre);
        this.edad = edad;
        this.salario = salario;
    }

    private String ajustarNombre(String nombre) {
        if (nombre.length() > TAM_NOMBRE) {
            return nombre.substring(0, TAM_NOMBRE);
        }
        return String.format("%-" + TAM_NOMBRE + "s", nombre);
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre.trim() +
               ", Edad: " + edad + ", Salario: " + salario;
    }
}

