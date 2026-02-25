/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ficheros.FicherosTexto;

import static ficheros.FicherosTexto.Ejercicio04.in;
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
public class Ejercicio05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here 

        Path rutaL = Path.of("recursos\\Archivo.txt");
        Path rutaE = Path.of("recursos\\Ejercicio05.txt");

        try (BufferedReader br = Files.newBufferedReader(rutaL); BufferedWriter bw = Files.newBufferedWriter(rutaE)) {

            String lineaL;

            while ((lineaL = br.readLine()) != null) {
                bw.write(lineaL);
                bw.newLine();

            }
        } catch (NoSuchFileException e) {
            System.out.println("Fichero no encontrado");
        } catch (IOException e) {
            System.out.println("Error de lectura");
        }
    }

}
