import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {

        //se lee el archivo de usuarios y se convierte en la arraylist que vamos a usar
        ArrayList<Usuario> listaUsuarios = escribirFileEnArrayListUsuarios("fileUsuarios");

        //se lee el archivo de peliculas y se convierte en la arraylist que vamos a usar
        ArrayList<Pelicula> listaPeliculas = escribirFileEnArrayListPeliculas("filePeliculas");



        //inicia el programa
        inicioSesion(listaUsuarios, listaPeliculas);


        //sobreescribe los datos para añadir a los usuarios previamente no registrados
        reescribirDatosUsuarios(listaUsuarios);


        //sobreescribe los datos de las peliculas (si no se añadió alguna pelicula tecnicamente queda igual)
        reescribirDatosPeliculas(listaPeliculas);



    }


    private static void inicioSesion(ArrayList<Usuario> listaUsuarios, ArrayList<Pelicula> listaPeliculas) {
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
                return;
            default:
                System.out.println("OPCION NO VALIDA");
                inicioSesion(listaUsuarios, listaPeliculas);
                break;
        }
        inicioSesion(listaUsuarios, listaPeliculas);
    }

    private static void crearUsuario(ArrayList<Usuario> listaUsuarios) {
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

    private static boolean revisarUsuario(String userName, ArrayList<Usuario> listaUsuarios) {
        for (Usuario user: listaUsuarios) {
            if (Objects.equals(userName, user.getUsername())){
                return true;
            }
        }
        return false;
    }

    public static boolean revisarUsuarioYContrasena(String username, String password, ArrayList<Usuario> listaUsuarios) {
        for (Usuario user: listaUsuarios) {
            if (Objects.equals(username, user.getUsername())&&Objects.equals(password, user.getPassword())){
                return true;
            }
        }
        return false;
    }

    private static void menuAnonimo(){
        boolean salir = true;
        do {
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
                case 0:
                    salir = false;
                    break;
                default:
                    System.out.println("Ingrese una opcion valida");
                    menuAnonimo();
                    break;
            }
            menuAnonimo();
        }while (salir);
    }

    private static void menuUsuarios(String usuario){
        Scanner teclado = new Scanner(System.in);
        System.out.println("MENU");
        System.out.println("Que desea realizar? Ingrese el numero correspondiente");
        System.out.println("[1] Mostrar lista de Peliculas");
        System.out.println("[2] Buscar una pelicula segun un parametro (genero, año, duracion, idioma)");
        System.out.println("[3] Recomendacion aleatoria");
        System.out.println("[4] Ver peliculas Favoritas");
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
            case 0:
                return;
            default:
                System.out.println("Ingrese una opcion valida");
                menuUsuarios(usuario);
                break;
        }
        menuUsuarios(usuario);
    }

    private static void anadirPelicula() {

    }
    private static void reescribirDatosUsuarios(ArrayList<Usuario> listaUsuarios) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            FileWriter fileWriter = new FileWriter("fileUsuarios");
            objectMapper.writeValue(fileWriter, listaUsuarios);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void reescribirDatosPeliculas(ArrayList<Pelicula> listaPeliculas) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            FileWriter fileWriter = new FileWriter("filePeliculas");
            objectMapper.writeValue(fileWriter, listaPeliculas);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<Pelicula> escribirFileEnArrayListPeliculas(String filename) {
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

    private static ArrayList<Usuario> escribirFileEnArrayListUsuarios(String filename) {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<Usuario> arrayList = new ArrayList<>();
        try {
            File file = new File(filename);
            arrayList = objectMapper.readValue(file, new TypeReference<ArrayList<Usuario>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}


