/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ficheros.FicherosCSV;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *
 * @author Jorge Garcia Rodriguez
 */
public class Ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Path ruta = Path.of("personas.csv");
        try(var reader = new CSVReader(Files.newBufferedReader(ruta)))
        {
            reader.readNext(); //Encabezado
            String [] linea;
            while((linea=reader.readNext()) != null)
                if(linea.length>=3){
                    String nombre = linea[0];
                    String edad = linea[1];
                    String ciudad = linea[2];
                    System.out.println(nombre+","+edad+","+ciudad);
                }
            
        }catch(IOException | CsvValidationException e){
            System.out.println("Error de lectura o formato");
        }
    }
    
}
