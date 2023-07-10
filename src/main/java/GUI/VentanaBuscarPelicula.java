package GUI;

import Modelo.Aplicacion;
import Modelo.Pelicula;
import Modelo.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * Clase que muestra la ventana de buscar peliculas de la aplicacion
 * @author Luis
 */
public class VentanaBuscarPelicula extends Ventana {
    private Aplicacion aplicacion;
    private JLabel titulo;
    private JLabel seleccione;
    private JButton buscar, cancelar;
    private JComboBox variables;
    private JLabel parametro;
    private JTextField campoParametro;
    private Usuario usuario;
    private int aux;

    public VentanaBuscarPelicula(Aplicacion aplicacion,Usuario usuario,int aux) {
        super("WikiMovies", 500, 520);
        this.aplicacion = aplicacion;
        this.usuario = usuario;
        this.aux = aux;
        generarElementosVentana();

    }

    public VentanaBuscarPelicula(Aplicacion aplicacion,int aux) {
        super("WikiMovies", 500, 520);
        this.aplicacion = aplicacion;
        this.aux = aux;
        generarElementosVentana();

    }

    /**
     * Metodo que llama a todas las funciones que generan los JLabel, los
     * JButton, el JComboBox y los JTextFild
     * @author Luis
     */


    private void generarElementosVentana() {
        generarTitulo();
        generarSeleccione();
        generarBuscar();
        generarCancelar();
        generarParametro();
    }

    private void generarParametro() {
        String textoLista = "Parametro: ";
        super.generarJLabel(this.parametro, textoLista, 20, 100, 100, 100);
        this.campoParametro = super.generarJTextField(200, 140, 150, 20);
        this.add(this.campoParametro);

    }

    private void generarCancelar() {
        String textoBotonCancelar = "Cancelar";
        this.cancelar = super.generarBoton(textoBotonCancelar, 275, 300, 150, 100);
        this.add(this.cancelar);
        this.cancelar.addActionListener(this);
    }

    private void generarBuscar() {
        String textoBoton= "Bucar";
        this.buscar = super.generarBoton(textoBoton, 75, 300, 150, 100);
        this.add(this.buscar);
        this.buscar.addActionListener(this);
    }

    private void generarSeleccione() {
        String textoLista = "Variable";
        super.generarJLabel(this.seleccione, textoLista, 20, 50, 300, 100);
        String[] var = {"Titulo","Año","Genero","Director","Duracion","Idioma"};
        this.variables = super.generarListaDesplegable(var, 200,90,150,20);
        this.add(this.variables);
        this.variables.addActionListener(this);


    }

    private void generarTitulo() {
        String textoBienvenida = "Buscar pelicula";
        super.generarJLabelEncabezado(this.titulo, textoBienvenida, 20, 30, 500, 30);
    }

    /**
     * Metodo que activa las funciones de cada boton perteneciente a la ventana de buscar pelicula
     * @param e the event to be processed
     * @author Luis
     */

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.buscar) {
            String var = (String) this.variables.getSelectedItem();
            if (!(busqueda(var,this.campoParametro.getText()))){
                JOptionPane.showMessageDialog(this,"Error");

            }


        }
        if (e.getSource() == this.cancelar) {
            if (aux == 1){
                VentanaMenuUsuario ventanaMenuUsuario = new VentanaMenuUsuario(aplicacion,usuario);
                this.dispose();
            }else {
                Inicio inicio = new Inicio(aplicacion);
                this.dispose();
            }
        }



    }


    /**
     * Metodo que busca que una pelicula segun un parametro de esta
     *
     * @param var define por que parametro de la pelicula se quiere buscar
     * @param text nombre del parametro previamente seleccionado
     * @return bolean que dice si se encontro la pelicula o no
     * @author Jose
     *
     */

    private boolean busqueda(String var, String text) {
        ArrayList<Pelicula> peliculasEncontradas = new ArrayList<>();
        if ("Titulo".equals(var)){
            for (Pelicula i :aplicacion.getPeliculas()){
                if (i.getTitulo().equals(text)){
                    peliculasEncontradas.add(i);
                }
            }

        }
        if ("Año".equals(var)){
            for (Pelicula i :aplicacion.getPeliculas()){
                if (String.valueOf(i.getYear()).equals(text)){
                    peliculasEncontradas.add(i);
                }
            }

        }
        if ("Genero".equals(var)){
            for (Pelicula i :aplicacion.getPeliculas()){
                if (i.getGenero().equals(text)){
                    peliculasEncontradas.add(i);
                }
            }

        }
        if ("Director".equals(var)){
            for (Pelicula i :aplicacion.getPeliculas()){
                if (i.getDirector().equals(text)){
                    peliculasEncontradas.add(i);
                }
            }
        }
        if ("Duracion".equals(var)){
            for (Pelicula i :aplicacion.getPeliculas()){
                if (String.valueOf(i.getDuracion()).equals(text)){
                    peliculasEncontradas.add(i);
                }
            }
        }
        if ("Idioma".equals(var)){
            for (Pelicula i :aplicacion.getPeliculas()){
                if (i.getIdioma().equals(text)){
                    peliculasEncontradas.add(i);
                }
            }

        }
        if (peliculasEncontradas.size() == 0){
            return false;
        }else {

            imprimirPeliculas(peliculasEncontradas);
            return true;
        }
    }


    /**
     * Metodo que toma el arraylist de peliculas y lo transforma en un arreglo para
     * crear la tabla donde se puede ver la informacion de las peliculas
     * @author Luis
     */

    private void imprimirPeliculas(ArrayList<Pelicula> pelis){

        String[][] datosPeliculas;
        datosPeliculas= new String[pelis.size()][6];
        for(int i=0; i<pelis.size(); i++){

            datosPeliculas[i][0]=pelis.get(i).getTitulo();
            datosPeliculas[i][1]= String.valueOf(pelis.get(i).getYear());
            datosPeliculas[i][2]=pelis.get(i).getGenero();
            datosPeliculas[i][3]=pelis.get(i).getDirector();
            datosPeliculas[i][4]= String.valueOf(pelis.get(i).getDuracion());
            datosPeliculas[i][5]=pelis.get(i).getIdioma();

        }
        String[] columnas ={"Titulo","Año","Genero","Director","Duracion","Idioma"};
        VentanaTabla ventanaTabla = new VentanaTabla(datosPeliculas,columnas);

    }


}
