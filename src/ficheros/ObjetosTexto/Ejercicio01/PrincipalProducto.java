/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ficheros.ObjetosTexto.Ejercicio01;

import ficheros.ObjetosTexto.Ejemplo.Persona;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.List;

/**
 *
 * @author Jorge Garcia Rodriguez
 */
public class PrincipalProducto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Producto> lista = List.of(new Producto("1", "Tornillo", 5.99), new Producto("2", "Martillo", 15.99), new Producto("3", "Destornillador", 7.50));

        Path path = Path.of("Ejercicio01.dat");

        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path)); ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
            for (Producto producto : lista) {
                oos.writeObject(producto);

            }

            while (true) {
                try {
                    Producto p = (Producto) ois.readObject();
                    System.out.println(p.toString());
                } catch (EOFException e) {
                    break;
                }
            }

        } catch (NoSuchFileException e) {
            System.out.println("No se encontro el archivo");
        } catch (IOException e) {
            System.out.println("Error de lectura y escritura");
        } catch (ClassNotFoundException e) {
            System.out.println("No se encontro la clase");
        }
    }

}
