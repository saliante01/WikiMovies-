public class Administrador {
    private String nombreUsuario;
    private String contraseña;

    public Administrador(String nombreUsuario, String contraseña) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public boolean validarContrasena(String contraseña) {
        // Validar la contraseña
        return this.contraseña.equals(contraseña);
    }
}
