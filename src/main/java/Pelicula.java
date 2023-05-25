public class Pelicula {

        private String titulo;
        private String director;
        private int anio;

        public Pelicula(String titulo, String director, int anio) {
            this.titulo = titulo;
            this.director = director;
            this.anio = anio;
        }

        public String getTitulo() {
            return titulo;
        }

        public String getDirector() {
            return director;
        }

        public int getAnio() {
            return anio;
        }

        public String toString() {
            return "Título: " + titulo + ", Director: " + director + ", Año: " + anio;
        }
        public void setDirector(String director) {
        this.director = director;
        }
        public void setAnio(int anio) {
        this.anio = anio;
        }
        public void setTitulo(String titulo) {
        this.titulo = titulo;
        }
    }

