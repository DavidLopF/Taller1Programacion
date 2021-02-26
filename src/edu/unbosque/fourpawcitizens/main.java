package edu.unbosque.fourpawcitizens;

import edu.unbosque.fourpawcitizens.model.Manager;

import java.util.Scanner;

/**
 * @author David Lopez ,Briannys Monserrate, Sergio Peña.
 */
public class main {
    public static void main(String args[]) {

        Manager manager = new Manager();
        Scanner leer = new Scanner(System.in);

        System.out.println(".:.:.: BIENVENIDO SEÑOR USUARIO :.:.:.");
        System.out.println(manager.uploadData());
        System.out.println(manager.assingID());


    }
}
