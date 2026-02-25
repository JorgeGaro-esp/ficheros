/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ficheros.FicherosTexto;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

/**
 *
 * @author Jorge Garcia Rodriguez
 */
public class Ejercicio04 {

    /**
     * @param args the command line arguments
     */
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        // TODO code application logic here

        Path ruta = Path.of("recursos\\Ejercicio04.txt");

        try (BufferedWriter bw = Files.newBufferedWriter(ruta, StandardOpenOption.APPEND)) {

            String linea;
            do {
                linea = in.nextLine();
                if (linea.equals("FIN")) {
                    break;
                }
                bw.write(linea + "-" + linea.length());
                bw.newLine();

            } while (!linea.equals("FIN"));

        } catch (IOException e) {
            System.out.println("Error de lectura en el fichero");
        }
    }

}
