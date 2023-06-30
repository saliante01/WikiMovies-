import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Pelicula {
    private String titulo;
    private int year;
    private ArrayList<String> genero = new ArrayList<>();
    private String director;
    private int duracion;
    private String idioma;


    public Pelicula(String titulo, int year, String director, int duracion, String idioma) {
        this.titulo = titulo;
        this.year = year;
        this.director = director;
        this.duracion = duracion;
        this.idioma = idioma;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getYear() {
        return year;
    }

    public ArrayList<String> getGenero() {
        return genero;
    }

    public String getDirector() {
        return director;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setGenero(ArrayList<String> genero) {
        this.genero = genero;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }


    public void anadirPelicula(String file_peliculas){
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Read existing JSON data from file
            List<Object> existingData = mapper.readValue(new File(file_peliculas), new TypeReference<>() {});

            // Add the new object to the existing collection
            existingData.add(this);

            // Write the updated collection back to the JSON file
            mapper.writeValue(new File(file_peliculas), existingData);


            System.out.println("Object added to JSON file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

