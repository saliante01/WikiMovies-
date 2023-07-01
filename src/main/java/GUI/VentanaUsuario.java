package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class VentanaUsuario extends Ventana {
    private JLabel tituloLogin, usuarios, contrasenas;
    private JTextField campoUsuarios, campoContrasenas;

    private JButton ok;
    public VentanaUsuario() {
        super("Login", 500, 520);
        generarElementosVentana();

    }

    private void generarElementosVentana() {
        generarTituloLogin();
        generarUsuarios();
        generarContrasenas();
        generarOk();

    }

    private void generarOk() {
        String textoBoton= "Ok";
        this.ok = super.generarBoton(textoBoton, 250, 300, 150, 100);
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
        String texto = "Usuarios: ";
        super.generarJLabel(this.usuarios, texto, 20, 50, 100, 100);
        this.campoUsuarios = super.generarJTextField(200,90,150,20);
        this.add(this.campoUsuarios);
    }

    private void generarTituloLogin() {
        String textoBienvenida = "Login";
        super.generarJLabelEncabezado(this.tituloLogin, textoBienvenida, 20, 30, 500, 30);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.ok) {
            JOptionPane.showMessageDialog(this,"Funciona");
            universidad.agregarCarrera(this.campoNombreCarrera.getText(),this.campoCodigoCarrera.getText(),this.campoCantidadSemestre.getText());
            VentanaMenuBienvenida ventanaMenuBienvenida = new VentanaMenuBienvenida(universidad);
            this.dispose();


        }

    }

}
