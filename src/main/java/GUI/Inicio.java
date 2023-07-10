package GUI;

import Modelo.Aplicacion;
import Modelo.Usuario;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase que muestra la pestaña de inicio de la aplicacion
 * @author Jose
 */

public class Inicio extends Ventana{
    private JLabel titulo;
    private JButton botonUsuario;
    private JButton botonInvitado;
    private JButton crearUsuario;
    private JButton salir;
    private Aplicacion aplicacion;

    /**
     * Constructor
     * @param a objeto de clase Aplicacion
     * @author Jose
     *
     */
    public Inicio(Aplicacion a) {
        super("WikiMovies", 500, 520);
        this.aplicacion = a;
        generarElementosVentana();
    }

    /**
     * Metodo que llama a todas las funciones que generan los JLabel y los
     * JButton
     * @author Jose
     */

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

    /**
     * Metodo que activa las funciones de cada boton perteneciente a la ventana de inicio
     * @param e the event to be processed
     * @author Jose
     */

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

            try {
                reescribirDatosUsuarios(aplicacion.getUsuarios());
            } catch (JsonProcessingException ex) {
                ex.printStackTrace();
            }
            this.dispose();
        }

    }

    /**
     * Este metodo reescribe el archivo donde se guardaba la informacion de los usuarios y
     * escribe la nueva informacion actualizada con los nuevos usuarios
     * @param listaUsuarios
     * @throws JsonProcessingException
     * @author Luis
     */
    private static void reescribirDatosUsuarios(ArrayList<Usuario> listaUsuarios) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            FileWriter fileWriter = new FileWriter("fileUsuarios");
            objectMapper.writeValue(fileWriter, listaUsuarios);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
