import java.util.ArrayList;

public class Catalogo {

        private ArrayList<Pelicula> peliculas;



        public Catalogo() {
            this.peliculas = new ArrayList<>();
        }

    public ArrayList<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void agregarPelicula(Pelicula pelicula) {
            peliculas.add(pelicula);
        }

        public void eliminarPelicula(Pelicula pelicula) {
            peliculas.remove(pelicula);
        }

        public void mostrarCatalogo() {
            if (peliculas.isEmpty()) {
                System.out.println("El catálogo está vacío.");
            } else {
                System.out.println("Catálogo de películas:");
                for (Pelicula pelicula : peliculas) {
                    System.out.println(pelicula);
                }
            }
        }

}
