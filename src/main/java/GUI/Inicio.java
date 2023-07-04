package GUI;

import Modelo.Aplicacion;
import Modelo.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Inicio extends Ventana{
    private JLabel titulo;
    private JButton botonUsuario;
    private JButton botonInvitado;
    private JButton crearUsuario;
    private JButton salir;
    private Aplicacion aplicacion;

    public Inicio(Aplicacion a) {
        super("WikiMovies", 500, 520);
        this.aplicacion = a;
        generarElementosVentana();
    }

    private void generarElementosVentana() {
        generarTitulo();
        generarBotonUsuario();
        generarBotonInvitado();
        generarCrearUsuario();
        generarSalir();
    }

    private void generarSalir() {
        String textoBoton = "Salir";
        this.salir = super.generarBoton(textoBoton, 175, 310, 150, 40);
        this.add(this.salir);
        this.salir.addActionListener(this);
    }

    private void generarCrearUsuario() {
        String textoBoton = "Crear usuario";
        this.crearUsuario = super.generarBoton(textoBoton, 175, 240, 150, 40);
        this.add(this.crearUsuario);
        this.crearUsuario.addActionListener(this);
    }

    private void generarBotonInvitado() {
        String textoBoton = "Invitado";
        this.botonInvitado = super.generarBoton(textoBoton, 175, 170, 150, 40);
        this.add(this.botonInvitado);
        this.botonInvitado.addActionListener(this);
    }

    private void generarBotonUsuario() {
        String textoBoton = "Usuario";
        this.botonUsuario = super.generarBoton(textoBoton, 175, 100, 150, 40);
        this.add(this.botonUsuario);
        this.botonUsuario.addActionListener(this);

    }

    private void generarTitulo() {
        String textoBienvenida = "Como desea ingresar?";
        super.generarJLabelEncabezado(this.titulo, textoBienvenida, 20, 30, 500, 30);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonUsuario) {
            VentanaUsuario ventanaUsuario= new VentanaUsuario(aplicacion);
            this.dispose();
        }
        if(e.getSource() == this.botonInvitado){
            VentanaInvitado ventanaInvitado= new VentanaInvitado(aplicacion);
            this.dispose();
        }
        if(e.getSource() == this.crearUsuario){
            VentanaCrearUsuario ventanaCrearUsuario= new VentanaCrearUsuario(aplicacion);
            this.dispose();
        }
        if(e.getSource() == this.salir){
            this.dispose();
        }

    }

}
