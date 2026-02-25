/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ficheros.ObjetosTexto.Ejemplo;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

/**
 *
 * @author Jorge Garcia Rodriguez
 */
public class LeerPersona {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Path ruta = Path.of("Personas.dat");
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(ruta))) {
            while(true){
                try{
                    Persona p = (Persona) ois.readObject();
                    System.out.println(p.toString());
                }catch(EOFException e){
                    break;
                }
            }
            
        } catch (NoSuchFileException e) {
            System.out.println("No se encontro el fichero");
        } catch (IOException e) {
            System.out.println("Error al leer el fichero");
        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada");
        }
    }

}
