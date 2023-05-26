import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //ArrayList<Usuario> Usuarios = new ArrayList<>();
        //Usuario luis = new Usuario("luis17", "123456");
        inicioSesion();

    }

    private static void inicioSesion() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("LOGIN");
        System.out.println("Como desea ingresar?");
        System.out.println("[1] Usuario ya registrado");
        System.out.println("[2] Invitado");
        System.out.println("[3] Nuevo Usuario");

        int respuesta = teclado.nextInt();

        switch (respuesta){
            case 1:
                if (revisarUsuario()){
                    menuUsuarios();
                }
                else{
                    System.out.println("Usuario no encontrado, reintente");
                    inicioSesion();
                }
                break;
            case 2:
                menuAnonimo();
                break;
            case  3:
                crearUsuario();
                break;
            default:
                System.out.println("Opcion no valida, reintente");
                inicioSesion();
                break;
        }
        inicioSesion();


    }

    private static void crearUsuario() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese su nombre de usuario");
        String userName = teclado.next();
        System.out.println("Ingrese su contrasena");
        String password = teclado.next();
        //añadir funcion comprobar

        Usuario nuevoUsuario = new Usuario(userName,password);

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("usuarios.txt"));
            out.writeObject(nuevoUsuario);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private static boolean revisarUsuario() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese su usuario");
        String userName = teclado.next();

        System.out.println("Ingrese su contrasena");
        String password = teclado.next();


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
        String respuesta = teclado.next();

        switch (respuesta){
            case "1":
                break;
            case "2":
                break;
            case "3":
                break;
            case "4":
                break;
            case "0": System.exit(0);
                break;
            default:
                System.out.println("Ingrese una opcion valida");
                menuAnonimo();
                break;
        }
        menuAnonimo();
    }

    private static void menuUsuarios(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("MENU");
        System.out.println("Que desea realizar? Ingrese el numero correspondiente");
        System.out.println("[1] Mostrar lista de Peliculas");
        System.out.println("[2] Buscar una pelicula segun un parametro (genero, año, duracion, idioma)");
        System.out.println("[3] Recomendacion aleatoria");
        System.out.println("[4] Añadir pelicula");
        System.out.println("[0] Salir");
        String respuesta = teclado.next();

        switch (respuesta){
            case "1":
                break;
            case "2":
                break;
            case "3":
                break;
            case "4":
                break;
            case "0": System.exit(0);
                break;
            default:
                System.out.println("Ingrese una opcion valida");
                menuUsuarios();
                break;
        }
        menuUsuarios();
    }
}

