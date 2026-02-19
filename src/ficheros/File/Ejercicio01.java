/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ficheros.File;

import java.io.File;

/**
 *
 * @author Jorge Garcia Rodriguez
 */
public class Ejercicio01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String ruta = "C:/Users";
        
        File directorio = new File(ruta);
        
        if (directorio.exists() && directorio.isDirectory()) {
            
            String[] elementos = directorio.list();
            
            System.out.println("Contenido del directorio: " + ruta);
            
            if (elementos!=null) {
                for (String elemento:elementos) {
                    System.out.println("-" + elemento);
                    
                    
                }
            } else {
                    System.out.println("La ruta no existe");
            }
        }
    }
    
}
