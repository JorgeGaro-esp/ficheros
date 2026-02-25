/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ficheros.FicherosTexto;

import static ficheros.FicherosTexto.Ejercicio07.pattern;
import static ficheros.FicherosTexto.Ejercicio07.regex;
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
public class Extras2 {

    /**
     * @param args the command line arguments
     */
    public static boolean validarDNI(String DNI) {
        Matcher matcher = pattern.matcher(DNI);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean comprobarLetraDNI(String DNI) {
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int numero = Integer.parseInt(DNI.substring(0, 8));
        char letra = DNI.charAt(8);
        char letraResto = letras.charAt(numero % 23);
        if (letra == letraResto) {
            return true;
        } else {
            return false;
        }
    }
    static String regex = "^[0-9]{8}[A-HJ-NP-TV-Z]$";
    static Pattern pattern = Pattern.compile(regex);

    public static void main(String[] args) {
        // TODO code application logic here
        Path ruta = Path.of("recursos\\DNIs.txt");

        try (BufferedReader br = Files.newBufferedReader(ruta)) {
            String DNI;

            while ((DNI = br.readLine()) != null) {

                if (validarDNI(DNI) && validarDNI(DNI) && comprobarLetraDNI(DNI)) {
                    System.out.println(DNI);
                }
            }

        } catch (NoSuchFileException e) {
            System.out.println("No se encuentra el fichero");
        } catch (IOException e) {
            System.out.println("Error de lectura en el fichero");
        }

    }

}
