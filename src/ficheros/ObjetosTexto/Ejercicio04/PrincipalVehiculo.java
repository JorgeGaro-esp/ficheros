/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ficheros.ObjetosTexto.Ejercicio04;

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
public class PrincipalVehiculo {

    /**
     * @param vehiculos
     */
    public static void escribirFichero(List<Vehiculo> vehiculos) {
        Path path = Path.of("recursos/vehiculos.dat");

        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {

            for (Vehiculo vehiculo : vehiculos) {
                oos.writeObject(vehiculo);
            }
            System.out.println("Se ha escrito el fichero");

        } catch (IOException e) {
            System.out.println("Error de escritura");
        }
    }

    public static void leerFichero(String ruta) {
        Path path = Path.of(ruta);

        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
            while(true){
                try {
                    Vehiculo v = (Vehiculo) ois.readObject();
                    System.out.println(v);
                } catch (EOFException e ) {
                    break;
                }
            }
        } catch (NoSuchFileException e) {
            System.out.println("No se encontro el fichero");
        } catch (IOException e){
            System.out.println("Error de lectura");
        } catch (ClassNotFoundException e){
            System.out.println("Clase no encontrada");
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        List<Vehiculo> vehiculos = List.of(new Vehiculo("7805FWR", "Citroen", "Picasso"),
                new Vehiculo("3456GHF", "Toyota", "Yaris"));
        escribirFichero(vehiculos);
        leerFichero("recursos/vehiculos.dat");
    }

}
