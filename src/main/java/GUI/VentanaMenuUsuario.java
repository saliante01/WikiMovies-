package GUI;

import Modelo.Aplicacion;
import Modelo.Pelicula;
import Modelo.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 * Clase que muestra la ventana de menu usuario de la aplicacion
 * @author Jose
 */
public class VentanaMenuUsuario extends Ventana{
    private Aplicacion aplicacion;
    private Usuario usuario;
    private JButton agregarPeliculas, verListaPeliculas, buscarPelicula, recomendacion, verFavoritas,regresar;
    private JLabel menuUsuarios;

    public VentanaMenuUsuario(Aplicacion aplicacion, Usuario usuario) {
        super("WikiMovies", 500, 520);
        this.aplicacion = aplicacion;
        this.usuario = usuario;
        generarElementosVentana();

    }

    /**
     * Metodo que llama a todas las funciones que generan los JLabel y los
     * JButton
     * @author Jose
     */

    private void generarElementosVentana() {
        generarMenuUsuario();
        generarAgregarPeliculas();
        generarBuscarPelicula();
        generarReconmendacion();
        generarVerFavoritos();
        generarRegresar();
    }

    private void generarRegresar() {
        String textoBoton = "Regresar";
        this.regresar=super.generarBoton(textoBoton, 135, 340, 200, 40);
        this.add(this.regresar);
        this.regresar.addActionListener(this);
    }

    private void generarVerFavoritos() {
        String textoBoton = "Ver peliculas favoritas";
        this.verFavoritas=super.generarBoton(textoBoton, 135, 290, 200, 40);
        this.add(this.verFavoritas);
        this.verFavoritas.addActionListener(this);
    }

    private void generarReconmendacion() {
        String textoBoton = "Recomendacion aleatoria";
        this.recomendacion=super.generarBoton(textoBoton, 135, 240, 200, 40);
        this.add(this.recomendacion);
        this.recomendacion.addActionListener(this);
    }

    private void generarBuscarPelicula() {
        String textoBoton = "Buscar pelicula";
        this.buscarPelicula=super.generarBoton(textoBoton, 135, 190, 200, 40);
        this.add(this.buscarPelicula);
        this.buscarPelicula.addActionListener(this);
    }

    private void generarAgregarPeliculas() {
        String textoBoton = "Agregar pelicula";
        this.agregarPeliculas=super.generarBoton(textoBoton, 135, 140, 200, 40);
        this.add(this.agregarPeliculas);
        this.agregarPeliculas.addActionListener(this);

    }

    private void generarMenuUsuario() {
        String textoBienvenida = "Menu usuario";
        super.generarJLabelEncabezado(this.menuUsuarios, textoBienvenida, 20, 30, 500, 30);
    }

    /**
     * Metodo que activa las funciones de cada boton perteneciente a la ventana de menu usuario
     * @param e the event to be processed
     * @author Jose
     */

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.agregarPeliculas) {
            VentanaAgregarPeliculas ventanaAgregarPeliculas = new VentanaAgregarPeliculas(aplicacion,usuario);
            this.dispose();

        }
        if (e.getSource() == this.verFavoritas) {
            imprimirPeliculas(usuario.getFavoritos());

        }
        if (e.getSource() == this.recomendacion){
            peliculasRecomendadas();
        }

        if (e.getSource() == this.buscarPelicula){
            VentanaBuscarPelicula ventanaBuscarPelicula = new VentanaBuscarPelicula(aplicacion,usuario,1);
            this.dispose();
        }
        if (e.getSource() == this.regresar){
            Inicio inicio = new Inicio(aplicacion);
            this.dispose();
        }


    }

    /**
     * Metodo que genera una lista de las peliculas recomendadas.
     * Las peliculas recomendadas se basan en el director y genero favorito
     * @author Jose
     */
    private void peliculasRecomendadas() {
        ArrayList<String> directores = new ArrayList<>();
        for (Pelicula i : usuario.getFavoritos()){
            directores.add(i.getDirector());
        }

        ArrayList<String> genero = new ArrayList<>();
        for (Pelicula i : usuario.getFavoritos()){
            genero.add(i.getGenero());
        }
        String directorFavorito = encontrarElementoMasRepetido(directores);
        String generoFavorito = encontrarElementoMasRepetido(genero);

        ArrayList<Pelicula> recomendadas = new ArrayList<>();
        for (Pelicula i : aplicacion.getPeliculas()){
            if (i.getDirector().equals(directorFavorito) && i.getGenero().equals(generoFavorito) && comprobar(i)){
                recomendadas.add(i);
            }
        }
        if (recomendadas.size() == 0){
            JOptionPane.showMessageDialog(this,"Recomendamos ver inception :D");

        }else {
            imprimirPeliculas(recomendadas);
        }
    }

    /**
     * Comprueba si la pelicula que la aplicacion quiere recomendar
     * ya se encuentra en la lista de peliculas favoritas
     * @param peli pelicula que se quiere comprobar
     * @return boolean que dicta si la pelicula se encuentra o no el la lista de favoritos
     * @author Jose
     */
    private boolean comprobar(Pelicula peli) {
        int aux = 0;
        for (Pelicula i : usuario.getFavoritos()){
            if (i == peli){
                aux++;
            }
        }
        if (aux > 0){
            return false;
        }else {
            return true;
        }
    }

    /**
     * Metodo que encuentra el elemento mas repetido en un arraylist,
     * se usa para saber el genero y director favorito del usuario
     * @param palabras arraylist de String que contiene los nombre de los directores o
     * de los generos
     * @return retorna el elemento mas repetido
     * @author Jose
     */
    public static String encontrarElementoMasRepetido(ArrayList<String> palabras) {
        HashMap<String, Integer> contador = new HashMap<>();

        // Contar la frecuencia de las palabras en el ArrayList
        for (int i = 0; i < palabras.size(); i++) {
            String palabra = palabras.get(i);
            if (contador.containsKey(palabra)) {
                contador.put(palabra, contador.get(palabra) + 1);
            } else {
                contador.put(palabra, 1);
            }
        }

        // Encontrar la palabra más repetida
        String elementoMasRepetido = "";
        int maxRepeticiones = 0;

        for (Map.Entry<String, Integer> entry : contador.entrySet()) {
            String palabra = entry.getKey();
            int repeticiones = entry.getValue();

            if (repeticiones > maxRepeticiones) {
                elementoMasRepetido = palabra;
                maxRepeticiones = repeticiones;
            }
        }

        return elementoMasRepetido;
    }

    /**
     * Metodo que toma el arraylist de peliculas y lo transforma en un arreglo para
     * crear la tabla donde se puede ver la informacion de las peliculas
     * @author Luis
     */
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
