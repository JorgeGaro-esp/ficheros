/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ficheros.FicherosDeAccesoSecuencial;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Jorge Garcia Rodriguez
 */
public class Extra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Path ruta = Path.of("recursos\\Extra.txt");
        List<String> lista = List.of("casa", "perro", "casa", "gato", "gato", "sol", "nube", "rio", "sol");

        try (BufferedWriter bw = Files.newBufferedWriter(ruta)) {
            
            Set<String> palabras = new LinkedHashSet<String>(lista);
            Iterator it = palabras.iterator();
            while (it.hasNext()) {
                bw.write(it.next().toString());
                bw.newLine();
            }
            System.out.println("Se ha escrito el fichero");

        } catch (NoSuchFileException e) {
            System.out.println("Fichero no encontrado");
        } catch (IOException e) {
            System.out.println("Error de lectura");
        }
    }

}
