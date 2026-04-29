package com.mycompany.jdbc_evidencias_sena;

import com.mycompany.jdbc_evidencias_sena.dao.UsuarioDAO;
import com.mycompany.jdbc_evidencias_sena.modelo.Usuario;
import java.util.List;
import java.util.Scanner;

public class Jdbc_evidencias_sena {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero(scanner, "Seleccione una opcion: ");

            switch (opcion) {
                case 1:
                    insertarUsuario(scanner, usuarioDAO);
                    break;

                case 2:
                    consultarUsuarios(usuarioDAO);
                    break;

                case 3:
                    actualizarUsuario(scanner, usuarioDAO);
                    break;

                case 4:
                    eliminarUsuario(scanner, usuarioDAO);
                    break;

                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opcion no valida. Intente nuevamente.");
                    break;
            }

        } while (opcion != 5);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n===== MODULO DE USUARIOS JDBC =====");
        System.out.println("1. Insertar usuario");
        System.out.println("2. Consultar usuarios");
        System.out.println("3. Actualizar usuario");
        System.out.println("4. Eliminar usuario");
        System.out.println("5. Salir");
    }

    private static void insertarUsuario(Scanner scanner, UsuarioDAO usuarioDAO) {
        System.out.println("\n--- Insertar usuario ---");

        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el correo: ");
        String correo = scanner.nextLine();

        System.out.print("Ingrese la clave: ");
        String clave = scanner.nextLine();

        Usuario usuario = new Usuario(nombre, correo, clave);

        boolean insertado = usuarioDAO.insertarUsuario(usuario);

        if (insertado) {
            System.out.println("Usuario insertado correctamente.");
        } else {
            System.out.println("No se pudo insertar el usuario.");
        }
    }

    private static void consultarUsuarios(UsuarioDAO usuarioDAO) {
        System.out.println("\n--- Listado de usuarios ---");

        List<Usuario> usuarios = usuarioDAO.consultarUsuarios();

        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            for (Usuario usuario : usuarios) {
                System.out.println(usuario);
            }
        }
    }

    private static void actualizarUsuario(Scanner scanner, UsuarioDAO usuarioDAO) {
        System.out.println("\n--- Actualizar usuario ---");

        int id = leerEntero(scanner, "Ingrese el ID del usuario a actualizar: ");

        System.out.print("Ingrese el nuevo nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el nuevo correo: ");
        String correo = scanner.nextLine();

        System.out.print("Ingrese la nueva clave: ");
        String clave = scanner.nextLine();

        Usuario usuario = new Usuario(id, nombre, correo, clave);

        boolean actualizado = usuarioDAO.actualizarUsuario(usuario);

        if (actualizado) {
            System.out.println("Usuario actualizado correctamente.");
        } else {
            System.out.println("No se encontro un usuario con ese ID.");
        }
    }

    private static void eliminarUsuario(Scanner scanner, UsuarioDAO usuarioDAO) {
        System.out.println("\n--- Eliminar usuario ---");

        int id = leerEntero(scanner, "Ingrese el ID del usuario a eliminar: ");

        boolean eliminado = usuarioDAO.eliminarUsuario(id);

        if (eliminado) {
            System.out.println("Usuario eliminado correctamente.");
        } else {
            System.out.println("No se encontro un usuario con ese ID.");
        }
    }

    private static int leerEntero(Scanner scanner, String mensaje) {
        int numero;

        while (true) {
            System.out.print(mensaje);

            if (scanner.hasNextInt()) {
                numero = scanner.nextInt();
                scanner.nextLine();
                return numero;
            } else {
                System.out.println("Debe ingresar un numero valido.");
                scanner.nextLine();
            }
        }
    }
}