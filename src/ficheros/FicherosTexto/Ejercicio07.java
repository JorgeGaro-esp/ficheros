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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Jorge Garcia Rodriguez
 */
public class Ejercicio07 {

    /**
     * @param args the command line arguments
     */
    public static boolean coincide(String palabra) {
        Matcher matcher = pattern.matcher(palabra);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    static String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    static Pattern pattern = Pattern.compile(regex);

    public static void main(String[] args) {
        // TODO code application logic here

        Path ruta = Path.of("recursos\\Correos.txt");

        try (BufferedReader br = Files.newBufferedReader(ruta)) {

            String linea;
            while ((linea = br.readLine()) != null) {
                if (coincide(linea)) 
                    System.out.println(linea);
            }
        } catch (NoSuchFileException e) {
            System.out.println("Fichero no encontrado");
        } catch (IOException e) {
            System.out.println("Error de lectura");
        }
    }

}
