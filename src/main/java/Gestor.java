import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Gestor {
    private String rutaArchivo;

    public Gestor(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public ArrayList<String> leerArchivo() {
        ArrayList<String> lineas = new ArrayList<>();
        try {
            File archivo = new File(rutaArchivo);
            if (archivo.exists()) {
                Scanner scanner = new Scanner(archivo);
                while (scanner.hasNextLine()) {
                    String linea = scanner.nextLine();
                    lineas.add(linea);
                }
                scanner.close();
            } else {
                System.out.println("El archivo no existe.");
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }
        return lineas;
    }

    public void escribirArchivo(String linea) {
        try {
            FileWriter fileWriter = new FileWriter(rutaArchivo, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(linea);
            printWriter.close();
            System.out.println("La línea se ha agregado al archivo correctamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo.");
        }
    }
}
