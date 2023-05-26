import java.util.ArrayList;

public class peliculas {
    private String titulo;
    private int year;
    private ArrayList<String> genero = new ArrayList<>();
    private String director;
    private int duracion;
    private String idioma;


    public peliculas(String titulo, int year, String director, int duracion, String idioma) {
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
}

