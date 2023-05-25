import java.util.ArrayList;

public class Autenticacion {

        private static ArrayList<Usuario> usuarios;
        private Gestor archivoUsuarios;

        public Autenticacion(String rutaArchivoUsuarios) {
            usuarios = new ArrayList<>();
            archivoUsuarios = new Gestor(rutaArchivoUsuarios);
            cargarUsuarios();
        }

        public void cargarUsuarios() {
        ArrayList<String> lineasUsuarios = archivoUsuarios.leerArchivo();
        for (String linea : lineasUsuarios) {
            String[] partes = linea.split(",");
            if (partes.length == 2) {
                String nombreUsuario = partes[0];
                String contrasena = partes[1];
                Usuario usuario = new Usuario(nombreUsuario, contrasena);
                usuarios.add(usuario);
            } else {
                // La línea no tiene el formato esperado, puedes mostrar una advertencia o realizar alguna acción adecuada
            }
            }
        }

        public static boolean validarCredenciales(String nombreUsuario, String contrasena) {
            for (Usuario usuario : usuarios) {
                if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContrasena().equals(contrasena)) {
                    return true;
                }
            }
            return false;
        }

        public void registrarUsuario(String nombreUsuario, String contrasena) {
            Usuario nuevoUsuario = new Usuario(nombreUsuario, contrasena);
            usuarios.add(nuevoUsuario);
            archivoUsuarios.escribirArchivo(nombreUsuario + "," + contrasena);
        }

    }

