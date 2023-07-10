package GUI;

import Modelo.Aplicacion;
import Modelo.Pelicula;
import Modelo.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * Clase que muestra la ventana de agregar peliculas de la aplicacion
 * @author Sebastian
 */

public class VentanaAgregarPeliculas extends Ventana{
    private Aplicacion aplicacion;
    private JLabel peliculaaa;
    private JComboBox peliculas;
    private JButton agregar, cancelar;
    private Usuario usuario;
    public VentanaAgregarPeliculas(Aplicacion aplicacion, Usuario usuario) {
        super("WikiMovies", 500, 520);
        this.aplicacion = aplicacion;
        this.usuario = usuario;
        generarElementosVentana();
    }

    /**
     * Metodo que llama a todas las funciones que generan los JLabel, los
     * JButton y el JComboBox
     * @author Sebastian
     */
    private void generarElementosVentana() {
        imprimirPeliculas();
        generarComboPelicula();
        generarAgregar();
        generarCancelar();

    }
    private void generarCancelar() {
        String textoBotonCancelar = "Cancelar";
        this.cancelar = super.generarBoton(textoBotonCancelar, 275, 300, 150, 100);
        this.add(this.cancelar);
        this.cancelar.addActionListener(this);

    }

    private void generarAgregar() {
        String textoBoton= "Agregar";
        this.agregar = super.generarBoton(textoBoton, 75, 300, 150, 100);
        this.add(this.agregar);
        this.agregar.addActionListener(this);
    }




    private void generarComboPelicula() {
        String textoLista = "Pelicula: ";
        super.generarJLabel(this.peliculaaa, textoLista, 20, 100, 300, 100);
        this.peliculas = super.generarListaDesplegable(aplicacion.getPeliculas().toArray(new Pelicula[0]), 200,140,150,20);
        this.add(this.peliculas);
        this.peliculas.addActionListener(this);

    }

    /**
     * Metodo que toma el arraylist de peliculas y lo transforma en un arreglo para
     * crear la tabla donde se puede ver la informacion de las peliculas
     * @author Luis
     */
    private void imprimirPeliculas(){
        ArrayList<Pelicula> estudiantes= new ArrayList<>();

        String[][] datosPeliculas;
        datosPeliculas= new String[aplicacion.getPeliculas().size()][6];
        for(int i=0; i<aplicacion.getPeliculas().size(); i++){

            datosPeliculas[i][0]=aplicacion.getPeliculas().get(i).getTitulo();
            datosPeliculas[i][1]= String.valueOf(aplicacion.getPeliculas().get(i).getYear());
            datosPeliculas[i][2]=aplicacion.getPeliculas().get(i).getGenero();
            datosPeliculas[i][3]=aplicacion.getPeliculas().get(i).getDirector();
            datosPeliculas[i][4]= String.valueOf(aplicacion.getPeliculas().get(i).getDuracion());
            datosPeliculas[i][5]=aplicacion.getPeliculas().get(i).getIdioma();

        }
        String[] columnas ={"Titulo","Año","Genero","Director","Duracion","Idioma"};
        VentanaTabla ventanaTabla = new VentanaTabla(datosPeliculas,columnas);

    }

    /**
     * Metodo que activa las funciones de cada boton perteneciente a la ventana de agregar pelicula
     * @param e the event to be processed
     * @author Sebastian
     */

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.agregar) {
            Pelicula p = (Pelicula) this.peliculas.getSelectedItem();
            boolean existe = verificaExistencia(p,usuario.getFavoritos());
            if (!existe){
                JOptionPane.showMessageDialog(this,"Pelicula registrada correctamente");
                usuario.getFavoritos().add(p);
            }else {
                JOptionPane.showMessageDialog(this,"La pelicula ya existe en su lista de favoritos");

            }

        }
        if (e.getSource() == this.cancelar){
            VentanaMenuUsuario ventanaMenuUsuario = new VentanaMenuUsuario(aplicacion,usuario);
            this.dispose();
        }

    }

    /**
     * Metodo que verifica que una pelicula ya existe en un arraylist
     * @param p pelicula que se quiere verificar la existencia
     * @param peliculas arraylist donde se verifica la existencia de la pelicula
     * @return bolean que determina si existe la pelicula o no
     * @author Jose
     */

    public boolean verificaExistencia(Pelicula p, ArrayList<Pelicula> peliculas) {
        boolean aux = false;
        for (Pelicula i : peliculas){
            if (p == i){
                aux = true;
                return aux;
            }
        }
        return aux;
    }


}
