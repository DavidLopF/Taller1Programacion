package edu.unbosque.fourpawcitizens;

import edu.unbosque.fourpawcitizens.model.Manager;

import java.util.Scanner;

public class main {
    public static void main(String args[]) {

        Manager manager = new Manager();
        Scanner leer = new Scanner(System.in);

        System.out.println(".:.:.: BIENVENIDO SEÑOR USUARIO :.:.:.");
        System.out.println(manager.menu());
        String num = "";
        num = "Ingresa la opción";
        System.out.println(num);
        num = leer.nextLine();
        int n = Integer.parseInt(num);
        while (n > 0) {
            if (n == 1) {
                System.out.println(manager.uploadData());
            } else if (n == 2) {
                System.out.println(manager.assingID());
            } else if (n == 3) {

            } else if (n == 4) {

            } else if (n == 5) {

            } else if (n == 6) {

            } else if (n == 7) {

            }
        }

    }
}
