/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficheros.ObjetosTexto.Ejercicio04;

import java.io.Serializable;

/**
 *
 * @author Jorge Garcia Rodriguez
 */
public class Vehiculo implements Serializable {

    private String matricula;
    private String marca;
    private String modelo;

    //Constructor
    public Vehiculo(String matricula, String marca, String modelo) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
    }

    //Getter and Setter
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    //Metodos
    @Override
    public String toString() {
        return "Matricula: " + matricula + ", marca: " + marca + ", modelo: " + modelo;
    }

}
