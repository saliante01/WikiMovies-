package GUI;

import Modelo.Aplicacion;
import Modelo.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;

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

    private Usuario usuarioSeleccionado(String nombreUsuario, String  contrasena) {
        for (Usuario i : aplicacion.getUsuarios()) {
            if (i.getUsername().equals(nombreUsuario) && i.getPassword().equals(contrasena)) {
                return i;
            }
        }
        return null;
    }



    public boolean validarCredenciales(String nombreUsuario, String contrasena) {
        for (Usuario i : aplicacion.getUsuarios()) {
            if (i.getUsername().equals(nombreUsuario) && i.getPassword().equals(contrasena)) {
                return true;
            }
        }
        return false;
    }



}


