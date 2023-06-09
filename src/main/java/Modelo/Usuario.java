package Modelo;

import java.util.ArrayList;

/**
 * Clase que crea y obtiene la informacion de los usuarios 
 * @author Sebastian
 */
public class Usuario {
    private String username;
    private String password;

    private ArrayList<Pelicula> favoritos;
    public Usuario(){


    }
    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
        favoritos = new ArrayList<>();
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Pelicula> getFavoritos() {
        return favoritos;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFavoritos(ArrayList<Pelicula> favoritos) {
        this.favoritos = favoritos;
    }

    public String toString(){
        String datos = "[Usuario: "+this.getUsername()+", Contrasena: "+this.getPassword()+"]";
        return datos;
    }

}
