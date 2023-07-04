import GUI.Inicio;
import Modelo.Aplicacion;
import Modelo.Pelicula;
import Modelo.Usuario;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Pelicula> peliculas = peli();
        ArrayList<Usuario> usuarios = usua();
        Aplicacion a = new Aplicacion(peliculas,usuarios);
        Inicio i = new Inicio(a);


    }

    private static ArrayList<Usuario> usua() {
        ArrayList<Usuario> aux = new ArrayList<>();
        aux.add(new Usuario("josee","1234"));
        aux.add(new Usuario("juliana","mota"));
        return aux;
    }

    public static ArrayList<Pelicula> peli(){
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        ArrayList<String > genero = new ArrayList<>();
        genero.add("Drama");
        genero.add("Buenarda");
        peliculas.add(new Pelicula("Interestelar",2010,"accion","nolan",200,"Ingles"));
        peliculas.add(new Pelicula("Inception",2010,"drama","nolan",200,"Ingles"));
        peliculas.add(new Pelicula("The prestige",2014,"drama","nolan",200,"Ingles"));

        return peliculas;


    }
}
