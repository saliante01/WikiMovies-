package GUI;

import Modelo.Aplicacion;
import Modelo.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Clase que muestra la ventana de usuario de la aplicacion
 * @author Sebastian
 */
public class VentanaUsuario extends Ventana {
    private JLabel tituloSesion, usuarios, contrasenas;
    private JTextField campoUsuarios, campoContrasenas;
    private Aplicacion aplicacion;

    private JButton ok, cancelar;
    public VentanaUsuario(Aplicacion aplicacion) {
        super("WikiMovies", 500, 520);
        this.aplicacion = aplicacion;
        generarElementosVentana();

    }

    /**
     * Metodo que llama a todas las funciones que generan los JLabel, los
     * JButton y JTextField
     * @author Luis
     */

    private void generarElementosVentana() {
        generarTituloSesion();
        generarUsuarios();
        generarContrasenas();
        generarOk();
        generarCancelar();

    }

    private void generarCancelar() {
        String textoBoton= "Cancelar";
        this.cancelar = super.generarBoton(textoBoton, 275, 300, 150, 100);
        this.add(this.cancelar);
        this.cancelar.addActionListener(this);
    }

    private void generarOk() {
        String textoBoton= "Ok";
        this.ok = super.generarBoton(textoBoton, 75, 300, 150, 100);
        this.add(this.ok);
        this.ok.addActionListener(this);
    }

    private void generarContrasenas() {
        String texto = "Contraseña: ";
        super.generarJLabel(this.contrasenas, texto, 20, 120, 100, 100);
        this.campoContrasenas = super.generarJTextField(200,160,150,20);
        this.add(this.campoContrasenas);
    }

    private void generarUsuarios() {
        String texto = "Usuario: ";
        super.generarJLabel(this.usuarios, texto, 20, 50, 100, 100);
        this.campoUsuarios = super.generarJTextField(200,90,150,20);
        this.add(this.campoUsuarios);
    }

    private void generarTituloSesion() {
        String textoBienvenida = "Inciar Sesion";
        super.generarJLabelEncabezado(this.tituloSesion, textoBienvenida, 20, 30, 500, 30);
    }

    /**
     * Metodo que activa las funciones de cada boton perteneciente a la ventana de usuario
     * @param e the event to be processed
     * @author Sebastian
     */

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.ok) {

            boolean autenticacion = validarCredenciales(campoUsuarios.getText(),campoContrasenas.getText());
            if (autenticacion){
                VentanaMenuUsuario ventanaMenuUsuario= new VentanaMenuUsuario(aplicacion,usuarioSeleccionado(campoUsuarios.getText(),campoContrasenas.getText()));
                this.dispose();
            }else {
                JOptionPane.showMessageDialog(this,"Usuario no encotrado");

            }

        }
        if (e.getSource() == this.cancelar){
            Inicio ventanaMenuBienvenida = new Inicio(aplicacion);
            this.dispose();
        }



    }

    /**
     * Metodo que busca al usuario de la lista de usuarios de la aplicacion segun
     * su nombre y contraseña
     * @param nombreUsuario nombre de usuario del usuario
     * @param contrasena contraseña del usuario
     * @return el usuario que tenga las mismas credenciales
     * @author Sebastian 
     */
    private Usuario usuarioSeleccionado(String nombreUsuario, String  contrasena) {
        for (Usuario i : aplicacion.getUsuarios()) {
            if (i.getUsername().equals(nombreUsuario) && i.getPassword().equals(contrasena)) {
                return i;
            }
        }
        return null;
    }

    /**
     * Metodo que verifica si las credenciales registradas en los JTextField son validas
     * @param nombreUsuario nombre ingresado en el JTextField
     * @param contrasena contraseña ingresada en el JTextField
     * @return boolean que verifica si el nombre y cotraseña son iguales
     * @author Jose
     */

    public boolean validarCredenciales(String nombreUsuario, String contrasena) {
        for (Usuario i : aplicacion.getUsuarios()) {
            if (i.getUsername().equals(nombreUsuario) && i.getPassword().equals(contrasena)) {
                return true;
            }
        }
        return false;
    }



}


