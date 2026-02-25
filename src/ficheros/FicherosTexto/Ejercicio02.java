/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ficheros.FicherosTexto;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

/**
 *
 * @author Jorge Garcia Rodriguez
 */
public class Ejercicio02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here 

        Path ruta = Path.of("recursos\\Archivo.txt");

        try (BufferedReader br = Files.newBufferedReader(ruta)) {

            String linea;
            while ((linea = br.readLine()) != null) {

                System.out.println(linea.toLowerCase().replace('a', '1').replace('e', '2')
                        .replace('i', '3').replace('o', '4').replace('u', '5'));
            }
        } catch (NoSuchFileException e) {
            System.out.println("Fichero no encontrado");
        } catch (IOException e) {
            System.out.println("Error de lectura");
        }
    }

}
