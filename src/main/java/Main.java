import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //se lee archivo


        List<Usuario> listaUsuarios = new ArrayList<>();
        List<Pelicula> listaPeliculas = new ArrayList<>();

        inicioSesion(listaUsuarios, listaPeliculas);

        //se sobre escribe los archivos

    }



    private static void inicioSesion(List<Usuario> listaUsuarios, List<Pelicula> listaPeliculas) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("-----------------------------------------------");
        System.out.println("LOGIN");
        System.out.println("Como desea ingresar?");
        System.out.println("[1] Usuario");
        System.out.println("[2] Invitado");
        System.out.println("[3] Crear Nuevo Usuario");
        System.out.println("[0] Salir");

        String respuesta = teclado.next();

        switch (respuesta){
            case "1":
                System.out.println("INGRESE SU NOMBRE DE USUARIO");
                String usuario = teclado.next();

                System.out.println("INGRESE SU CONTRASENA");
                String password = teclado.next();
                boolean confirmacionUsuario = revisarUsuarioYContrasena(usuario, password, listaUsuarios);
                if (confirmacionUsuario){
                    menuUsuarios(usuario);
                }
                else{
                    System.out.println("USUARIO NO ENCONTRADO");
                    inicioSesion(listaUsuarios, listaPeliculas);
                }
                break;
            case "2":
                menuAnonimo();
                break;
            case  "3":
                crearUsuario(listaUsuarios);
                break;
            case "0":
                System.exit(0);
                break;
            default:
                System.out.println("OPCION NO VALIDA");
                inicioSesion(listaUsuarios, listaPeliculas);
                break;
        }
        inicioSesion(listaUsuarios, listaPeliculas);
    }

    private static void crearUsuario(List<Usuario> listaUsuarios) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese su nombre de usuario");
        String userName = teclado.next();
        System.out.println("Ingrese su contrasena");
        String password = teclado.next();
        boolean revisar = revisarUsuario(userName, listaUsuarios);

        if (revisar) {
            System.out.println("USUARIO YA REGISTRADO EN APP");
        }
        else {
            Usuario nuevoUsuario = new Usuario(userName, password);
            listaUsuarios.add(nuevoUsuario);
            System.out.println("USUARIO REGISTRADO");
        }
    }

    private static boolean revisarUsuario(String userName, List<Usuario> listaUsuarios) {
        for (Usuario user: listaUsuarios) {
            if (Objects.equals(userName, user.getUsername())){
                return true;
            }
        }
        return false;
    }

    public static boolean revisarUsuarioYContrasena(String username, String password, List<Usuario> listaUsuarios) {
        for (Usuario user: listaUsuarios) {
            if (Objects.equals(username, user.getUsername())&&Objects.equals(password, user.getPassword())){
                return true;
            }
        }
        return false;
    }

    private static void menuAnonimo(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("MENU");
        System.out.println("Que desea realizar? Ingrese el numero correspondiente");
        System.out.println("[1] Mostrar lista de Peliculas");
        System.out.println("[2] Buscar una pelicula segun un parametro (genero, año, duracion, idioma)");
        System.out.println("[3] Recomendacion aleatoria");
        System.out.println("[0] Salir");
        int respuesta = teclado.nextInt();

        switch (respuesta){
            case 1:
                //mostrarPeliculas();
                break;
            case 2:
                //busquedaPeliculas();
                break;
            case 3:
                //recomendacionAleatoria();
                break;
            case 4:
                break;
            case 0: System.exit(0);
                break;
            default:
                System.out.println("Ingrese una opcion valida");
                menuAnonimo();
                break;
        }
        menuAnonimo();
    }

    private static void menuUsuarios(String usuario){
        Scanner teclado = new Scanner(System.in);
        System.out.println("MENU");
        System.out.println("Que desea realizar? Ingrese el numero correspondiente");
        System.out.println("[1] Mostrar lista de Peliculas");
        System.out.println("[2] Buscar una pelicula segun un parametro (genero, año, duracion, idioma)");
        System.out.println("[3] Recomendacion aleatoria");
        System.out.println("[4] Añadir pelicula");
        System.out.println("[5] Ver peliculas Favoritas");
        System.out.println("[0] Salir");
        int respuesta = teclado.nextInt();

        switch (respuesta){
            case 1:
                //mostrarPeliculas();
                break;
            case 2:
                //busquedaPeliculas();
                break;
            case 3:
                //recomendacionAleatoria();
                break;
            case 4:
                anadirPelicula();
                break;
            case 5:
                //peliculasFavoritas(usuario);
                break;
            case 0: System.exit(0);
                break;
            default:
                System.out.println("Ingrese una opcion valida");
                menuUsuarios(usuario);
                break;
        }
        menuUsuarios(usuario);
    }

    private static void anadirPelicula() {





        //Pelicula nuevaPelicula =new Pelicula();
        //anadirObjeto(nuevaPelicula, "peliculas.json");

    }


    private static void anadirUsuario(Usuario nuevoUsuario, String archivo) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            // Read existing JSON data from file
            List<Usuario> existingData = mapper.readValue(new File(archivo), new TypeReference<>() {
            });

            // Add the new object to the existing collection
            existingData.add(nuevoUsuario);

            // Write the updated collection back to the JSON file
            mapper.writeValue(new File(archivo), existingData);

            System.out.println("Object added to JSON file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

