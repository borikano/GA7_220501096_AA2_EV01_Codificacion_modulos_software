package com.mycompany.jdbc_evidencias_sena.prueba;

import com.mycompany.jdbc_evidencias_sena.dao.UsuarioDAO;
import com.mycompany.jdbc_evidencias_sena.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;

public class PruebaFuegoCrud {

    public static void main(String[] args) {

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        String lotePrueba = String.valueOf(System.currentTimeMillis());

        List<Usuario> usuariosInsertar = new ArrayList<>();
        usuariosInsertar.add(new Usuario("Laura Mendez", "laura.mendez." + lotePrueba + "@example.com", "claveLaura123"));
        usuariosInsertar.add(new Usuario("Andres Torres", "andres.torres." + lotePrueba + "@example.com", "claveAndres123"));
        usuariosInsertar.add(new Usuario("Camila Rojas", "camila.rojas." + lotePrueba + "@example.com", "claveCamila123"));

        List<Usuario> usuariosEncontrados = new ArrayList<>();
        List<Usuario> usuariosActualizados = new ArrayList<>();

        System.out.println("===== PRUEBA DE FUEGO CRUD CON 3 USUARIOS =====");

        System.out.println("\n--- Insertando usuarios ---");

        for (Usuario usuario : usuariosInsertar) {
            boolean insertado = usuarioDAO.insertarUsuario(usuario);

            if (insertado) {
                System.out.println("OK: Usuario insertado -> " + usuario.getNombre());
            } else {
                System.out.println("ERROR: No se pudo insertar -> " + usuario.getNombre());
                return;
            }
        }

        System.out.println("\n--- Consultando usuarios insertados ---");

        List<Usuario> usuariosBaseDatos = usuarioDAO.consultarUsuarios();

        for (Usuario usuario : usuariosInsertar) {
            Usuario usuarioEncontrado = buscarUsuarioPorCorreo(usuariosBaseDatos, usuario.getCorreo());

            if (usuarioEncontrado != null) {
                usuariosEncontrados.add(usuarioEncontrado);
                System.out.println("OK: Usuario encontrado -> " + usuarioEncontrado);
            } else {
                System.out.println("ERROR: No se encontro el usuario -> " + usuario.getCorreo());
                return;
            }
        }

        System.out.println("\n--- Actualizando usuarios ---");

        for (Usuario usuario : usuariosEncontrados) {
            Usuario usuarioActualizado = new Usuario(
                    usuario.getId(),
                    usuario.getNombre() + " Actualizado",
                    generarCorreoActualizado(usuario.getCorreo()),
                    "claveActualizada123"
            );

            boolean actualizado = usuarioDAO.actualizarUsuario(usuarioActualizado);

            if (actualizado) {
                usuariosActualizados.add(usuarioActualizado);
                System.out.println("OK: Usuario actualizado -> ID " + usuarioActualizado.getId());
            } else {
                System.out.println("ERROR: No se pudo actualizar -> ID " + usuarioActualizado.getId());
                return;
            }
        }

        System.out.println("\n--- Verificando actualizaciones ---");

        usuariosBaseDatos = usuarioDAO.consultarUsuarios();

        for (Usuario usuario : usuariosActualizados) {
            Usuario usuarioVerificado = buscarUsuarioPorCorreo(usuariosBaseDatos, usuario.getCorreo());

            if (usuarioVerificado != null) {
                System.out.println("OK: Actualizacion verificada -> " + usuarioVerificado);
            } else {
                System.out.println("ERROR: No se encontro el usuario actualizado -> " + usuario.getCorreo());
                return;
            }
        }

        System.out.println("\n--- Eliminando usuarios de prueba ---");

        for (Usuario usuario : usuariosActualizados) {
            boolean eliminado = usuarioDAO.eliminarUsuario(usuario.getId());

            if (eliminado) {
                System.out.println("OK: Usuario eliminado -> ID " + usuario.getId());
            } else {
                System.out.println("ERROR: No se pudo eliminar -> ID " + usuario.getId());
                return;
            }
        }

        System.out.println("\n--- Verificando eliminacion ---");

        usuariosBaseDatos = usuarioDAO.consultarUsuarios();

        for (Usuario usuario : usuariosActualizados) {
            Usuario usuarioEliminado = buscarUsuarioPorCorreo(usuariosBaseDatos, usuario.getCorreo());

            if (usuarioEliminado == null) {
                System.out.println("OK: Eliminacion verificada -> " + usuario.getCorreo());
            } else {
                System.out.println("ERROR: El usuario aun existe -> " + usuario.getCorreo());
                return;
            }
        }

        System.out.println("\n===== PRUEBA CRUD FINALIZADA CORRECTAMENTE =====");
    }

    private static Usuario buscarUsuarioPorCorreo(List<Usuario> usuarios, String correo) {

        for (Usuario usuario : usuarios) {
            if (usuario.getCorreo().equals(correo)) {
                return usuario;
            }
        }

        return null;
    }

    private static String generarCorreoActualizado(String correoOriginal) {
        return correoOriginal.replace("@example.com", ".actualizado@example.com");
    }
}