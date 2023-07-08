package Clases;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Pelicula {
    private String titulo;
    private String year;
    private String[] genero;
    private String director;
    private String duracion;
    private String idioma;

    public Pelicula(){}
    public Pelicula(String titulo, String year, String[] genero, String director, String duracion, String idioma) {
        this.titulo = titulo;
        this.year = year;
        this.director = director;
        this.duracion = duracion;
        this.idioma = idioma;
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getYear() {
        return year;
    }



    public String getDirector() {
        return director;
    }

    public String getDuracion() {
        return duracion;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String[] getGenero() {
        return genero;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setDuracion(String duracion) {
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

