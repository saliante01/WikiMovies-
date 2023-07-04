import GUI.VentanaAgregarPeliculas;
import GUI.VentanaInvitado;
import Modelo.Aplicacion;
import Modelo.Pelicula;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestWiki {
    @Test
    public void numAleatorio(){
        // Si el test es valido el metodo si sirve
        Aplicacion a = null;
        VentanaInvitado v = new VentanaInvitado(a);
        boolean numeroAceptable = true;
        int largoArraylist = 23;
        int numObtendio = v.generarNumeroAleatorio(largoArraylist);

        for (int i = 0; i < 1000; i++) {
            if (numObtendio > largoArraylist-1){
                numeroAceptable = false;
                break;
            }
        }
        Assertions.assertTrue(numeroAceptable);

    }

    @Test
    public void testVerificarPeliculaExistente(){
        // Si el test es valido el metodo funciona
        Aplicacion a = new Aplicacion();
        VentanaAgregarPeliculas v = new VentanaAgregarPeliculas(a,null);
        ArrayList<Pelicula> peliculasFavoritas = new ArrayList<>();
        peliculasFavoritas.add(new Pelicula("Batman",2010,"accion","cr7",200,"portugues"));
        peliculasFavoritas.add(new Pelicula("joker",2012,"suspenso","cr7",100,"croata"));

        Pelicula peliculaSeleccionada = new Pelicula("Batman",2010,"accion","cr7",200,"portugues");

        boolean verificacion = v.verificaExistencia(peliculaSeleccionada,peliculasFavoritas);
        Assertions.assertFalse(verificacion);

    }
}
