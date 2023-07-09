package Main;

import GUI.Inicio;
import Modelo.Aplicacion;
import Modelo.Pelicula;
import Modelo.Usuario;
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

        ArrayList<Usuario> listaUsuarios = escribirFileEnArrayListUsuarios("fileUsuarios");
        ArrayList<Pelicula> listaPeliculas = escribirFileEnArrayListPeliculas("filePeliculas");

        Aplicacion a = new Aplicacion(listaPeliculas,listaUsuarios);
        Inicio i = new Inicio(a);
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


