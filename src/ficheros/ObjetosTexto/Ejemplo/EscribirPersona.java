/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ficheros.ObjetosTexto.Ejemplo;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *
 * @author Jorge Garcia Rodriguez
 */
public class EscribirPersona {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Path ruta = Path.of("Personas.dat");

        Persona p1 = new Persona("Luisa", 58);
        Persona p2 = new Persona("Andres", 23);
        Persona p3 = new Persona("Aida", 25);
        Persona p4 = new Persona("Pablo", 48);

        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(ruta))) {
            oos.writeObject(p1);
            oos.writeObject(p2);
            oos.writeObject(p3);
            oos.writeObject(p4);
            System.out.println("Se ha escrito el fichero");
        } catch (IOException e) {
            System.out.println("Error de escritura");
        }
    }

}
