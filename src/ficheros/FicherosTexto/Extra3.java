/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ficheros.FicherosTexto;

import static ficheros.FicherosTexto.Ejercicio07.pattern;
import static ficheros.FicherosTexto.Ejercicio07.regex;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Jorge Garcia Rodriguez
 */
public class Extra3 {

    /**
     * @param args the command line arguments
     */
    static String regexDNI = "^[0-9]{8}[A-HJ-NP-TV-Z]$";
    static String regexNIE = "^[XYZxyz][0-9]{7}[A-HJ-NP-TV-Z]$";

    static Pattern patternDNI = Pattern.compile(regexDNI);
    static Pattern patternNIE = Pattern.compile(regexNIE);

    public static boolean validarFormatoDNI(String DNI) {
        Matcher matcher = patternDNI.matcher(DNI);
        return matcher.matches();
    }

    public static boolean validarFormatoNIE(String NIE) {
        Matcher matcher = patternNIE.matcher(NIE);
        return matcher.matches();
    }

    public static boolean comprobarLetraDNI(String DNI) {
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int numero = Integer.parseInt(DNI.substring(0, 8));
        char letra = DNI.charAt(8);
        char letraCorrecta = letras.charAt(numero % 23);
        return letra == letraCorrecta;
    }

    public static boolean comprobarLetraNIE(String NIE) {
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        NIE = NIE.replace('X', '0').replace('Y', '1').replace('Z', '2');
        int numero = Integer.parseInt(NIE.substring(0, 8));
        char letra = NIE.charAt(8);
        char letraCorrecta = letras.charAt(numero % 23);
        return letra == letraCorrecta;
    }

    public static void main(String[] args) {

        Path rutaLectura = Path.of("recursos/DNI/DNIs.txt");
        Path rutaEscrituraBien = Path.of("recursos/DNI/Correcto.txt");
        Path rutaEscrituraMal = Path.of("recursos/DNI/Incorrecto.txt");

        try (BufferedReader br = Files.newBufferedReader(rutaLectura); BufferedWriter bwCorrectos = Files.newBufferedWriter(rutaEscrituraBien); BufferedWriter bwMal = Files.newBufferedWriter(rutaEscrituraMal)) 
        {
            String DNI;
            while ((DNI = br.readLine()) != null) 
            {
                if (validarFormatoDNI(DNI) && comprobarLetraDNI(DNI)) 
                {
                    bwCorrectos.write(DNI + " - DNI");
                    bwCorrectos.newLine();
                } 
                else if (validarFormatoNIE(DNI) && comprobarLetraNIE(DNI)) 
                {
                    bwCorrectos.write(DNI + " - NIE");
                    bwCorrectos.newLine();
                } 
                else 
                {
                    bwMal.write(DNI);
                    bwMal.newLine();
                }
            }
            System.out.println("Se han escrito los ficheros");
        }
        catch (NoSuchFileException e) 
        {
            System.out.println("No se encuentra el fichero");
        }
        catch (IOException e) 
        {
            System.out.println("Error de lectura en el fichero");
        }

    }

}
