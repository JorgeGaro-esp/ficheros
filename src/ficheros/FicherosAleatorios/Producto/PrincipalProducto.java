/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficheros.FicherosAleatorios.Producto;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;
import java.util.Scanner;

public class PrincipalProducto {

    private static final int TREGISTRO = 44; // 4 bytes ID + 40 bytes nombre

    public static void guardarProducto(FileChannel channel, int id, String nombre) throws IOException {

        ByteBuffer buffer = ByteBuffer.allocate(TREGISTRO);

        // ID
        buffer.putInt(id);

        // Nombre (20 chars = 40 bytes)
        String nombre20 = String.format("%-20s", nombre);
        for (int i = 0; i < 20; i++) {
            buffer.putChar(nombre20.charAt(i));
        }

        buffer.flip();

        // Posición = (ID - 1) * tamaño registro
        channel.position((id - 1) * TREGISTRO);
        channel.write(buffer);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion, id;
        String nombre;

        Path ruta = Path.of("productos.dat");

        try (FileChannel channel = FileChannel.open(ruta,
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE,
                StandardOpenOption.READ)) {

            do {
                System.out.println("\n--- GESTIÓN DE PRODUCTOS ---");
                System.out.println("1. Insertar producto");
                System.out.println("2. Modificar producto");
                System.out.println("3. Listar productos");
                System.out.println("4. Salir");
                System.out.print("Opción: ");
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {

                    case 1 -> {
                        System.out.print("Introduzca el id: ");
                        id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Introduzca el nombre: ");
                        nombre = sc.nextLine();

                        guardarProducto(channel, id, nombre);
                        System.out.println("Producto agregado.");
                    }

                    case 2 -> {
                        System.out.print("Introduzca el id: ");
                        id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Introduzca el nuevo nombre: ");
                        nombre = sc.nextLine();

                        guardarProducto(channel, id, nombre);
                        System.out.println("Producto modificado.");
                    }

                    case 3 -> {
                        long tamaño = channel.size();
                        int totalRegistros = (int) (tamaño / TREGISTRO);

                        for (int i = 0; i < totalRegistros; i++) {
                            ByteBuffer buffer = ByteBuffer.allocate(TREGISTRO);

                            channel.position(i * TREGISTRO);
                            channel.read(buffer);
                            buffer.flip();

                            int idLeido = buffer.getInt();

                            StringBuilder nombreLeido = new StringBuilder();
                            for (int j = 0; j < 20; j++) {
                                nombreLeido.append(buffer.getChar());
                            }

                            if (idLeido != 0) {
                                System.out.println("ID: " + idLeido +
                                        " Nombre: " + nombreLeido.toString().trim());
                            }
                        }
                    }

                    case 4 -> System.out.println("Fin del programa.");

                    default -> System.out.println("Opción incorrecta.");
                }

            } while (opcion != 4);

        } catch (IOException e) {
            System.out.println("Error de lectura/escritura");
        }
    }
}

