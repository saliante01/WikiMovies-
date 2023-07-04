package GUI;

import Modelo.Aplicacion;
import Modelo.Pelicula;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class VentanaInvitado extends Ventana {
    private Aplicacion aplicacion;
    private JButton buscarPelicula, recomendacion, ver,regresar;
    private JLabel menuUsuarios;

    public VentanaInvitado(Aplicacion aplicacion) {
        super("WikiMovies", 500, 520);
        this.aplicacion = aplicacion;
        generarElementosVentana();

    }

    private void generarElementosVentana() {
        generarMenuUsuario();
        generarVerPeliculas();
        generarBuscarPelicula();
        generarRecomendar();
        generarRegresar();
    }

    private void generarRecomendar() {
        String textoBoton = "Recomendacion";
        this.recomendacion=super.generarBoton(textoBoton, 135, 240, 200, 40);
        this.add(this.recomendacion);
        this.recomendacion.addActionListener(this);
    }

    private void generarRegresar() {
        String textoBoton = "Regresar";
        this.regresar=super.generarBoton(textoBoton, 135, 290, 200, 40);
        this.add(this.regresar);
        this.regresar.addActionListener(this);
    }

    private void generarVerPeliculas() {
        String textoBoton = "Ver peliculas ";
        this.ver =super.generarBoton(textoBoton, 135, 190, 200, 40);
        this.add(this.ver);
        this.ver.addActionListener(this);
    }


    private void generarBuscarPelicula() {
        String textoBoton = "Buscar pelicula";
        this.buscarPelicula=super.generarBoton(textoBoton, 135, 140, 200, 40);
        this.add(this.buscarPelicula);
        this.buscarPelicula.addActionListener(this);
    }


    private void generarMenuUsuario() {
        String textoBienvenida = "Menu Invitado";
        super.generarJLabelEncabezado(this.menuUsuarios, textoBienvenida, 20, 30, 500, 30);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.ver) {
            imprimirPeliculas(aplicacion.getPeliculas());

        }

        if (e.getSource() == this.buscarPelicula){
            VentanaBuscarPelicula ventanaBuscarPelicula = new VentanaBuscarPelicula(aplicacion,0);
            this.dispose();
        }
        if (e.getSource() == this.recomendacion){
            int random = generarNumeroAleatorio(aplicacion.getPeliculas().size()-1);
            JOptionPane.showMessageDialog(this,"Pelicula recomendada: "+aplicacion.getPeliculas().get(random).getTitulo());

        }

        if (e.getSource() == this.regresar){
            Inicio inicio = new Inicio(aplicacion);
            this.dispose();
        }


    }

    public int generarNumeroAleatorio(int cantidad) {
        int numAleatorio = (int)(Math.random()*(cantidad+1));
        return numAleatorio;
    }


    private void imprimirPeliculas(ArrayList<Pelicula> peliculas){

        String[][] datosPeliculas;
        datosPeliculas= new String[peliculas.size()][6];
        for(int i=0; i<peliculas.size(); i++){

            datosPeliculas[i][0]=peliculas.get(i).getTitulo();
            datosPeliculas[i][1]= String.valueOf(peliculas.get(i).getYear());
            datosPeliculas[i][2]=peliculas.get(i).getGenero();
            datosPeliculas[i][3]=peliculas.get(i).getDirector();
            datosPeliculas[i][4]=String.valueOf(peliculas.get(i).getDuracion());
            datosPeliculas[i][5]=peliculas.get(i).getIdioma();

        }
        String[] columnas ={"Titulo","Año","Genero","Director","Duracion","Idioma"};
        VentanaTabla ventanaTabla = new VentanaTabla(datosPeliculas,columnas);

    }

}
