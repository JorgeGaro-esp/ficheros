/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ficheros.Ejemplos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

/**
 *
 * @author Jorge Garcia Rodriguez
 */
public class escribirFichero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Path ruta = Path.of("recursos\\Escrito.txt");

        try (BufferedWriter bw = Files.newBufferedWriter(ruta)) {

            bw.write("Esto es una linea");
            bw.newLine();
            bw.write("Esto es una segunda linea");
            bw.newLine();
            System.out.println("Se ha escrito el fichero");

        } catch (IOException e) {
            System.out.println("Error de lectura en el fichero");
        }
    }

}
