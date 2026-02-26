/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ficheros.Complementario;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jorge Garcia Rodriguez
 */
public class Ejercicio01 {

    /**
     * @param path
     * @return
     */
    public static Map<String, Integer> leerFichero(Path path) {
        Map<String, Integer> mapa = new HashMap<String, Integer>();
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] componentes = linea.split(",");
                mapa.put(componentes[0], Integer.parseInt(componentes[1]));
            }

        } catch (IOException ex) {
            System.out.println("Error de lectura");;
        }
        return mapa;
    }
    
    public static void aprobados(Map<String, Integer> map){
        Path path = Path.of("Aprobados.txt");
        try(BufferedWriter bw = Files.newBufferedWriter(path)) {
            for (Map.Entry<String, Integer> entrada:map.entrySet()) {
                if(entrada.getValue()>=5){
                    bw.write(entrada.getKey());
                    bw.newLine();
                }
            
        }
        } catch (IOException e) {
            System.out.println("Error de escritura");
        }
    }
    
    public static void operaciones(Map<String, Integer> map){
        //Apartado 1
        System.out.println("--Media--");
        double media = 0;
        int count =0;
        for (Map.Entry<String, Integer> entrada:map.entrySet()) {
            media+=entrada.getValue();
            count++;
        }
        System.out.println(media=media/count);
        //Apartado 2
        System.out.println("--Alumno con mayor nota--");
        int maximo = 0;
        for (Map.Entry<String, Integer> entrada:map.entrySet()) {
            if (entrada.getValue()>maximo) {
                maximo=entrada.getValue();
            }
        }
        for (Map.Entry<String, Integer> entrada:map.entrySet()) {
            if (entrada.getValue().equals(maximo)) {
                System.out.println(entrada);;
            }
        }
        //Apartado 3
        aprobados(map);
        System.out.println("Archivo escrito");
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Path path = Path.of("recursos/Notas.txt");
        operaciones(leerFichero(path));
    }

}
