/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ficheros.ObjetosTexto.Ejercicio05;

import ficheros.ObjetosTexto.Ejercicio04.Vehiculo;
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
public class PrincipalFactura {

    /**
     * @param args the command line arguments
     */
    public static void escribirFichero(List<Factura> facturas) {
        Path path = Path.of("recursos/facturas.dat");

        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {

            for (Factura factura : facturas) {
                oos.writeObject(factura);
            }
            System.out.println("Se ha escrito el fichero");

        } catch (IOException e) {
            System.out.println("Error de escritura");
        }
    }

    public static int leerFichero(String ruta) {
        int total = 0;
        Path path = Path.of(ruta);

        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
            while (true) {
                try {
                    Factura f = (Factura) ois.readObject();
                    System.out.println(f);
                    total++;
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (NoSuchFileException e) {
            System.out.println("No se encontro el fichero");
        } catch (IOException e) {
            System.out.println("Error de lectura");
        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada");
        }
        return total;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        List<Factura> facturas = List.of(new Factura(1,"Luisa",500),
                                         new Factura(2,"Pedro",1500),
                                         new Factura(3,"Juan",2000));
        
        escribirFichero(facturas);
        System.out.println("Numero de facturas leidas: " + leerFichero("recursos/facturas.dat"));
    }

}
