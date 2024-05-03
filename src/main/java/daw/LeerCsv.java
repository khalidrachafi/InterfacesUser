/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author khalid
 */
public class LeerCsv {

    public LeerCsv() {
    }

    public void leerUsers() throws IOException {

        List<Users> usuarios = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("usuarios.csv"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    String username = partes[0];
                    String password = partes[1];
                    usuarios.add(new Users(username, password));
                } else {
                    System.out.println("Linea inválida " + linea);
                }
            }
        }

    }

}
