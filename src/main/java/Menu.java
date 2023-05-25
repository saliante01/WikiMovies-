
import java.util.ArrayList;

import java.util.Scanner;
public class Menu {
        private static ArrayList<Administrador> administradores = new ArrayList<>();


        private static void crearAdministradores() {
        Administrador admin1 = new Administrador("adminseba", "123455");
        Administrador admin2 = new Administrador("admin2", "contrasena2");
        Administrador admin3 = new Administrador("admin3", "contrasena3");
        administradores.add(admin1);
        administradores.add(admin2);
        administradores.add(admin3);
    }
        private Catalogo catalogoPeliculas;
        private Autenticacion sistemaAutenticacion;
        private Usuario usuarioActual;

        public Menu(String rutaArchivoPeliculas, String rutaArchivoUsuarios) {
            catalogoPeliculas = new Catalogo();
            sistemaAutenticacion = new Autenticacion(rutaArchivoUsuarios);
            cargarPeliculas(rutaArchivoPeliculas);
        }

        public void cargarPeliculas(String rutaArchivoPeliculas) {
            Gestor archivoPeliculas = new Gestor(rutaArchivoPeliculas);
            ArrayList<String> lineasPeliculas = archivoPeliculas.leerArchivo();
            for (String linea : lineasPeliculas) {
                String[] partes = linea.split(",");
                String titulo = partes[0];
                String director = partes[1];
                int anio = Integer.parseInt(partes[2]);
                Pelicula pelicula = new Pelicula(titulo, director, anio);
                catalogoPeliculas.agregarPelicula(pelicula);
            }
        }

        public void iniciarSesion() {

                // Solicitar nombre de usuario y contraseña al usuario
                Scanner scanner = new Scanner(System.in);
                System.out.println("Ingrese su nombre de usuario: ");
                String nombreUsuario = scanner.nextLine();
                System.out.println("Ingrese su contraseña: ");
                String contrasena = scanner.nextLine();

                // Verificar si el usuario es un administrador
                boolean esAdministrador = false;
                for (Administrador admin : administradores) {
                    if (admin.getNombreUsuario().equals(nombreUsuario) && admin.validarContrasena(contrasena)) {
                        esAdministrador = true;
                        break;
                    }
                }

                // Si es administrador, mostrar el menú de administrador
                if (esAdministrador) {
                    mostrarMenuAdministrador();
                } else {
                    // Verificar si las credenciales corresponden a un usuario registrado en el archivo de texto
                    boolean esUsuarioRegistrado = Autenticacion.validarCredenciales(nombreUsuario, contrasena);

                    // Si las credenciales coinciden, mostrar el menú de usuario registrado
                    if (esUsuarioRegistrado) {
                        mostrarMenuUsuarioRegistrado();
                    } else {
                        // Si las credenciales no coinciden, mostrar el menú de usuario anónimo
                        mostrarMenuUsuarioAnonimo();
                    }
                }


        }



        private static void mostrarMenuAdministrador() {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- Menú Administrador ---");
            System.out.println("1. Ver catálogo");
            System.out.println("2. Seleccionar película");
            System.out.println("3. Gestionar películas");
            System.out.println("4. Salir");

            Scanner scanner = new Scanner(System.in);
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Lógica para ver el catálogo de películas
                    break;
                case 2:
                    // Lógica para seleccionar una película
                    break;
                case 3:
                    // Lógica para gestionar las películas (agregar, editar, eliminar)
                    break;
                case 4:
                    salir = true;
                    System.out.println("Sesión administrador finalizada");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        }
    }

        private static void mostrarMenuUsuarioRegistrado() {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- Menú Usuario Registrado ---");
            System.out.println("1. Ver catálogo");
            System.out.println("2. Seleccionar película");
            System.out.println("3. Ver mis películas favoritas");
            System.out.println("4. Salir");

            Scanner scanner = new Scanner(System.in);
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Lógica para ver el catálogo de películas
                    break;
                case 2:
                    // Lógica para seleccionar una película
                    break;
                case 3:
                    // Lógica para ver las películas favoritas del usuario
                    break;
                case 4:
                    salir = true;
                    System.out.println("Sesión usuario registrado finalizada");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        }
    }

    private static void mostrarMenuUsuarioAnonimo() {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- Menú Usuario Anónimo ---");
            System.out.println("1. Ver catálogo");
            System.out.println("2. Salir");

            Scanner scanner = new Scanner(System.in);
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Lógica para ver el catálogo de películas
                    break;
                case 2:
                    salir = true;
                    System.out.println("Sesión usuario anónimo finalizada");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        }
    }

        public void crearCuenta() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("=== Crear Cuenta ===");
            System.out.print("Nombre de usuario: ");
            String nombreUsuario = scanner.nextLine();
            System.out.print("Contraseña: ");
            String contrasena = scanner.nextLine();
            sistemaAutenticacion.registrarUsuario(nombreUsuario, contrasena);
            System.out.println("Cuenta creada exitosamente.");
        }

        public void mostrarCatalogo() {
            System.out.println("=== Catálogo de Películas ===");
            catalogoPeliculas.mostrarCatalogo();
        }

        public void seleccionarPelicula() {
            if (usuarioActual == null) {
                System.out.println("Debes iniciar sesión para seleccionar una película.");
                return;
            }
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingresa el título de la película que deseas seleccionar: ");
            String titulo = scanner.nextLine();
            // Aquí puedes agregar la lógica para seleccionar la película y realizar la acción deseada
            System.out.println("Película seleccionada: " + titulo);
        }

        public void gestionarPeliculas() {
            if (usuarioActual == null || !usuarioActual.getNombreUsuario().equals("adminseba")&&
                    !usuarioActual.getNombreUsuario().equals("admin2") &&
                    !usuarioActual.getNombreUsuario().equals("admin3")) {
                System.out.println("Acceso denegado. Debes iniciar sesión como administrador.");
                return;
            }
            Scanner scanner = new Scanner(System.in);
            System.out.println("=== Gestión de Películas ===");
            System.out.println("1. Agregar película");
            System.out.println("2. Eliminar película");
            System.out.println("3. Editar película");
            System.out.println("4. Volver al menú principal");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el salto de línea
            switch (opcion) {
                case 1:
                    agregarPelicula();
                    break;
                case 2:
                    eliminarPelicula();
                    break;
                case 3:
                    editarPelicula();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opción inválida. Inténtalo de nuevo.");
            }
        }


        public void agregarPelicula() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("=== Agregar Película ===");
            System.out.print("Título: ");
            String titulo = scanner.nextLine();
            System.out.print("Director: ");
            String director = scanner.nextLine();
            System.out.print("Año: ");
            int anio = scanner.nextInt();
            scanner.nextLine(); // Limpiar el salto de línea
            Pelicula pelicula = new Pelicula(titulo, director, anio);
            catalogoPeliculas.agregarPelicula(pelicula);
            Gestor archivoPeliculas = new Gestor("C:\\Users\\sebas\\Desktop\\archivos txt\\Peliculas.txt");
            archivoPeliculas.escribirArchivo(titulo + "," + director + "," + anio);
            System.out.println("Película agregada exitosamente.");
        }

        public void eliminarPelicula() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("=== Eliminar Película ===");
            System.out.print("Título: ");
            String titulo = scanner.nextLine();
            Pelicula pelicula = null;
            for (Pelicula p : catalogoPeliculas.getPeliculas()) {
                if (p.getTitulo().equalsIgnoreCase(titulo)) {
                    pelicula = p;
                    break;
                }
            }
            if (pelicula != null) {
                catalogoPeliculas.eliminarPelicula(pelicula);
                System.out.println("Película eliminada exitosamente.");
            } else {
                System.out.println("No se encontró la película.");
            }
        }

        public void editarPelicula() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("=== Editar Película ===");
            System.out.print("Título de la película a editar: ");
            String titulo = scanner.nextLine();
            Pelicula pelicula = null;
            for (Pelicula p : catalogoPeliculas.getPeliculas()) {
                if (p.getTitulo().equalsIgnoreCase(titulo)) {
                    pelicula = p;
                    break;
                }
            }
            if (pelicula != null) {
                System.out.println("Ingresa los nuevos datos de la película:");
                System.out.print("Nuevo título: ");
                String nuevoTitulo = scanner.nextLine();
                System.out.print("Nuevo director: ");
                String nuevoDirector = scanner.nextLine();
                System.out.print("Nuevo año: ");
                int nuevoAnio = scanner.nextInt();
                pelicula.setTitulo(nuevoTitulo);
                pelicula.setDirector(nuevoDirector);
                pelicula.setAnio(nuevoAnio);
                System.out.println("Película editada exitosamente.");
            } else {
                System.out.println("No se encontró la película.");
            }
        }

        public void ejecutar() {
            Scanner scanner = new Scanner(System.in);
            boolean salir = false;
            while (!salir) {
                System.out.println("=== Menú Principal ===");
                System.out.println("1. Iniciar Sesión");
                System.out.println("2. Crear Cuenta");
                System.out.println("3. Ver Catálogo de Películas");
                System.out.println("4. Seleccionar Película");
                System.out.println("5. Gestionar Películas");
                System.out.println("6. Salir");
                System.out.print("Selecciona una opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el salto de línea
                switch (opcion) {
                    case 1:
                        iniciarSesion();
                        break;
                    case 2:
                        crearCuenta();
                        break;
                    case 3:
                        mostrarCatalogo();
                        break;
                    case 4:
                        seleccionarPelicula();
                        break;
                    case 5:
                        gestionarPeliculas();
                        break;
                    case 6:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción inválida. Inténtalo de nuevo.");
                }
            }
        }
    }

