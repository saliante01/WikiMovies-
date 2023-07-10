package Modelo;

import java.util.ArrayList;

/**
 * Clase que guarda y manipula la informacion de los usuarios y las peliculas
 * @author Sebastian
 */

public class Aplicacion {

    private ArrayList<Pelicula> peliculas;
    private ArrayList<Usuario> usuarios;

    public Aplicacion() {
        peliculas = new ArrayList<>();
        usuarios = new ArrayList<>();
    }

    public Aplicacion(ArrayList<Pelicula> peliculas) {
        this.peliculas = peliculas;
        usuarios = new ArrayList<>();

    }

    public Aplicacion(ArrayList<Pelicula> peliculas, ArrayList<Usuario> usuarios) {
       this.peliculas = peliculas;
        this.usuarios = usuarios;

    }


    /**
     * Metodo que agrega un usuario al arraylist de usuarios
     * @param nombre nombre del usuario
     * @param contrasena contraseña del usuario
     * @author Jose
     */
    public void agregarUsuario(String nombre, String contrasena){
        Usuario u = new Usuario(nombre,contrasena);
        usuarios.add(u);
    }


    public ArrayList<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(ArrayList<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
