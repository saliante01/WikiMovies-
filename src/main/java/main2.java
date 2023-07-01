
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

import java.io.IOException;


import java.util.ArrayList;

public class main2 {
    public static void main(String[] args) throws IOException {
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        Pelicula pelicula = new Pelicula("following", "1998",new String[]{"crimen", "noir"} , "christopher nolan", "70", "ingles");
        Pelicula pelicula1 = new Pelicula("memento", "2000", new String[]{"crimen", "noir"},"christopher nolan", "113", "ingles");
        Pelicula pelicula2 = new Pelicula("insomnia", "2002", new String[]{"crimen", "noir"},"christopher nolan", "118", "ingles");
        Pelicula pelicula3 = new Pelicula("batman begins", "2005",new String[]{"crimen", "superheroe"}, "christopher nolan", "140", "ingles");
        Pelicula pelicula4 = new Pelicula("the prestige", "2006",new String[]{"drama", "ciencia ficcion"}, "christopher nolan", "130", "ingles");
        Pelicula pelicula5 = new Pelicula("the dark knight", "2008",new String[]{"crimen", "superheroe"}, "christopher nolan", "152", "ingles");
        Pelicula pelicula6 = new Pelicula("inception", "2010",new String[]{"accion", "suspenso"}, "christopher nolan", "148", "ingles");
        Pelicula pelicula7 = new Pelicula("the dark knight rises", "2012", new String[]{"crimen", "superheroe"}, "christopher nolan", "165", "ingles");
        Pelicula pelicula8 = new Pelicula("interstellar", "2014",new String[]{"ciencia ficcion", "aventura"}, "christopher nolan", "169", "ingles");
        Pelicula pelicula9 = new Pelicula("dunkirk", "2017",new String[]{"guerra", "accion"}, "christopher nolan", "106", "ingles");
        Pelicula pelicula10 = new Pelicula("tenet", "2020",new String[]{"accion", "ciencia ficcion"}, "christopher nolan", "150", "ingles");
        Pelicula pelicula11 = new Pelicula("oppenheimer", "2023",new String[]{"guerra", "biopic"}, "christopher nolan", "180", "ingles");

        peliculas.add(pelicula);
        peliculas.add(pelicula1);
        peliculas.add(pelicula2);
        peliculas.add(pelicula3);
        peliculas.add(pelicula4);
        peliculas.add(pelicula5);
        peliculas.add(pelicula6);
        peliculas.add(pelicula7);
        peliculas.add(pelicula8);
        peliculas.add(pelicula9);
        peliculas.add(pelicula10);
        peliculas.add(pelicula11);

        Usuario luis = new Usuario("luis12", "jajaja");
        Usuario miguel = new Usuario("siper2099", "lego");

        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        listaUsuarios.add(luis);
        listaUsuarios.add(miguel);



    }
    public static void writeArrayListToJsonFile(ArrayList<Usuario> arrayList, String filename) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.writeValue(new File(filename), arrayList);
            System.out.println("ArrayList converted to JSON file: " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Pelicula> readJsonFileToArrayList(String filename) {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<Pelicula> arrayList = new ArrayList<>();

        try {
            File file = new File(filename);
            arrayList = objectMapper.readValue(file, new TypeReference<ArrayList<Pelicula>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }

        return arrayList;
    }
}
