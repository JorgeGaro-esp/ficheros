/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ficheros.FicherosCSV.Libro;

import com.opencsv.CSVWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 *
 * @author Jorge Garcia Rodriguez
 */
public class PrincipalLibro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Libro> libros = List.of(
                new Libro("Cien años de soledad", "Gabriel Garcia Marque", 1967),
                new Libro("1984", "George Orwell", 1949),
                new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", 1605),
                new Libro("El principito", "Antoine de Saint-Exupéry", 1943),
                new Libro("La sombra del viento", "Carlos Ruiz Zafón", 2001)
        );
        Path ruta = Path.of("libros.csv");
        try (var writer = new CSVWriter(Files.newBufferedWriter(ruta),CSVWriter.DEFAULT_SEPARATOR,CSVWriter.NO_QUOTE_CHARACTER,CSVWriter.DEFAULT_ESCAPE_CHARACTER,CSVWriter.DEFAULT_LINE_END)) {
            String[] encabezado = {"Titulo","Autor","Año de publicación"};
            for(Libro libro: libros){
                String [] linea = {libro.getTitulo(),libro.getAutor(),libro.getAnio()+""};
                writer.writeNext(linea);
            }
            System.out.println("Se ha escrito el fichero");
        } catch (IOException e) {
            System.out.println("Error de escritura");
        }
    }

}
