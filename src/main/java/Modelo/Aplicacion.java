package Modelo;

import java.util.ArrayList;

public class Aplicacion {

    private ArrayList<Admin> admins;
    private ArrayList<Pelicula> peliculas;
    private ArrayList<Usuario> usuarios;

    public Aplicacion() {
        admins = new ArrayList<>();
        peliculas = new ArrayList<>();
        usuarios = new ArrayList<>();
    }

    public Aplicacion(ArrayList<Pelicula> peliculas) {
        admins = new ArrayList<>();
        this.peliculas = peliculas;
        usuarios = new ArrayList<>();

    }

    public Aplicacion(ArrayList<Pelicula> peliculas, ArrayList<Usuario> usuarios) {
        admins = new ArrayList<>();
        this.peliculas = peliculas;
        this.usuarios = usuarios;

    }

    public void agregarUsuario(String nombre, String contrasena){
        Usuario u = new Usuario(nombre,contrasena);
        usuarios.add(u);
    }



    public ArrayList<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(ArrayList<Admin> admins) {
        this.admins = admins;
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
