package Clases;

public class Pelicula {
    private String titulo;
    private int year;
    private String genero;
    private String director;
    private int duracion;
    private String idioma;

    public Pelicula(){}
    public Pelicula(String titulo, int year,String genero, String director, int duracion, String idioma) {
        this.titulo = titulo;
        this.year = year;
        this.genero = genero;
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

    public String getGenero() {
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

    public void setGenero(String genero) {
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

    @Override
    public String toString() {
        return titulo;
    }



    public String data() {
        return "Pelicula{" +
                "titulo='" + titulo + '\'' +
                ", year=" + year +
                ", genero='" + genero + '\'' +
                ", director='" + director + '\'' +
                ", duracion=" + duracion +
                ", idioma='" + idioma + '\'' +
                '}';
    }
}