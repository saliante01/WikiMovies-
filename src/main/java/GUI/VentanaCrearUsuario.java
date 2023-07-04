package GUI;

import Modelo.Aplicacion;
import Modelo.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class VentanaCrearUsuario extends Ventana{
    private JLabel tituloLogin, usuarios, contrasenas;
    private JTextField campoUsuarios, campoContrasenas;

    private JButton ok, botonCancelar;

    private Aplicacion aplicacion;

    public VentanaCrearUsuario(Aplicacion aplicacion) {
        super("Registro de usuario", 500, 520);
        this.aplicacion = aplicacion;
        generarElementosVentana();
    }



    private void generarElementosVentana() {
        generarTituloLogin();
        generarUsuarios();
        generarContrasenas();
        generarOk();
        generarCancerlar();

    }

    private void generarCancerlar() {
        String textoBotonCancelar = "Cancelar";
        this.botonCancelar = super.generarBoton(textoBotonCancelar, 275, 300, 150, 100);
        this.add(this.botonCancelar);
        this.botonCancelar.addActionListener(this);

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
        String texto = "Nombre de usuario: ";
        super.generarJLabel(this.usuarios, texto, 20, 50, 100, 100);
        this.campoUsuarios = super.generarJTextField(200,90,150,20);
        this.add(this.campoUsuarios);
    }

    private void generarTituloLogin() {
        String textoBienvenida = "Registro de usuario";
        super.generarJLabelEncabezado(this.tituloLogin, textoBienvenida, 20, 30, 500, 30);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.ok) {
            if (this.campoUsuarios.getText().equals("") || this.campoContrasenas.getText().equals("")){
                JOptionPane.showMessageDialog(this,"Error");
                Inicio ventanaMenuBienvenida = new Inicio(aplicacion);
                this.dispose();
            }else {
                JOptionPane.showMessageDialog(this,"Usuario registrado correctamente");
                aplicacion.agregarUsuario(this.campoUsuarios.getText(),this.campoContrasenas.getText());
                Inicio ventanaMenuBienvenida = new Inicio(aplicacion);
                this.dispose();

            }

        }
        if (e.getSource() == this.botonCancelar){
            Inicio ventanaMenuBienvenida = new Inicio(aplicacion);
            this.dispose();
        }

    }
}
