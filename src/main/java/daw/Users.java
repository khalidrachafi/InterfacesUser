/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author khalid
 */
public class Users {
    
    private String username;
    private String password;

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    
    public static Map<String,String> leerUsuariosDesdeCSV() {
        String rutaArchivo = "usuarios.csv";
        Map <String,String> users = new HashMap();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
                        
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                // Verificar que la línea tenga la estructura correcta
                if (partes.length == 2) { 
                    String csvUs = partes[0];
                    String csvContra = partes[1];
                    users.put(csvUs, csvContra);
                } else {
                    System.out.println("Error: formato incorrecto en la línea CSV.");
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        return users;
    }
    
  
    
    public static void escribirNuevoUser(Map<String, String> usuariosContrasenas) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("usuarios.csv", false))) {
            for (Map.Entry<String, String> entry : usuariosContrasenas.entrySet()) {
                bw.write(entry.getKey() + "," + entry.getValue());
                bw.newLine();
            }
            System.out.println("Usuario registrado correctamente en el archivo.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
     
//    public static void escribirNuevoUser(String usuario, String contrasena) {
//        try (BufferedWriter bw = new BufferedWriter(new FileWriter("usuarios.csv", true))) {
//            bw.write(usuario + "," + contrasena);
//            bw.newLine();
//            System.out.println("Usuario registrado correctamente en el archivo.");
//        } catch (IOException e) {
//            System.err.println("Error al escribir en el archivo: " + e.getMessage());
//        }
//    }
    
    
}
