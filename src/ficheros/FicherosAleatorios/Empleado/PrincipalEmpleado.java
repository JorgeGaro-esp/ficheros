/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ficheros.FicherosAleatorios.Empleado;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;
import java.util.Scanner;

public class PrincipalEmpleado {

    private static final int TREGISTRO = 56; // 4 + 40 + 4 + 8

    public static void guardarEmpleado(FileChannel channel, int id, String nombre, int edad, double salario) throws IOException {

        ByteBuffer buffer = ByteBuffer.allocate(TREGISTRO);

        // ID
        buffer.putInt(id);

        // Nombre (20 chars = 40 bytes)
        String nombre20 = String.format("%-20s", nombre);
        for (int i = 0; i < 20; i++) {
            buffer.putChar(nombre20.charAt(i));
        }

        // Edad
        buffer.putInt(edad);

        // Salario
        buffer.putDouble(salario);

        buffer.flip();

        // Posición = (ID - 1) * tamaño registro
        channel.position((id - 1) * TREGISTRO);
        channel.write(buffer);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion, id, edad;
        String nombre;
        double salario;

        Path ruta = Path.of("empleados.dat");

        try (FileChannel channel = FileChannel.open(ruta,
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE,
                StandardOpenOption.READ)) {

            do {
                System.out.println("\n--- GESTIÓN DE EMPLEADOS ---");
                System.out.println("1. Insertar empleado");
                System.out.println("2. Modificar empleado");
                System.out.println("3. Listar empleados");
                System.out.println("4. Salir");
                System.out.print("Opción: ");
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {

                    case 1 -> {
                        System.out.print("ID: ");
                        id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Nombre: ");
                        nombre = sc.nextLine();

                        System.out.print("Edad: ");
                        edad = sc.nextInt();

                        System.out.print("Salario: ");
                        salario = sc.nextDouble();

                        guardarEmpleado(channel, id, nombre, edad, salario);
                        System.out.println("Empleado agregado.");
                    }

                    case 2 -> {
                        System.out.print("ID a modificar: ");
                        id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Nuevo nombre: ");
                        nombre = sc.nextLine();

                        System.out.print("Nueva edad: ");
                        edad = sc.nextInt();

                        System.out.print("Nuevo salario: ");
                        salario = sc.nextDouble();

                        guardarEmpleado(channel, id, nombre, edad, salario);
                        System.out.println("Empleado modificado.");
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

                            int edadLeida = buffer.getInt();
                            double salarioLeido = buffer.getDouble();

                            if (idLeido != 0) {
                                System.out.println("ID: " + idLeido +
                                        " Nombre: " + nombreLeido.toString().trim() +
                                        " Edad: " + edadLeida +
                                        " Salario: " + salarioLeido);
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
