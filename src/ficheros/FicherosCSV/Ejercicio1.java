/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ficheros.FicherosCSV;

import com.opencsv.CSVWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *
 * @author Jorge Garcia Rodriguez
 */
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Path ruta = Path.of("personas.csv");
        try (var  writer = new CSVWriter(Files.newBufferedWriter(ruta),CSVWriter.DEFAULT_SEPARATOR,CSVWriter.NO_QUOTE_CHARACTER,CSVWriter.DEFAULT_ESCAPE_CHARACTER,CSVWriter.DEFAULT_LINE_END))
        {
            String[] encabezado = {"Nombre", "Edad", "Ciudad"};
                String[] persona1 = {"Juan", "25", "Madrid"};
                String[] persona2 = {"Ana", "30", "Barcelona"};
                String[] persona3 = {"Pedro", "28", "Sevilla"};
                writer.writeNext(encabezado);
                writer.writeNext(persona1);
                writer.writeNext(persona2);
                writer.writeNext(persona3);
                System.out.println("Se ha escrito el fichero");
            }
            catch(IOException e)
        {
            System.out.println("Error de escritura");
        }
        }

    }
