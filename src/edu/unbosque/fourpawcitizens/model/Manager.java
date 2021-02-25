package edu.unbosque.fourpawcitizens.model;

import edu.unbosque.fourpawcitizens.model.dtos.Pet;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Manager {

    private String ruta = "./Data/pets-citizens.csv";
    private ArrayList<Pet> pets;


    public Manager() {
        pets = new ArrayList<>();
    }

    public void leerDocumento() {
        String linea = "";
        File f = new File(ruta);

        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            linea = br.readLine();
            String[] temp;
            while (linea != null) {
                temp = linea.split(";");
                if(esNumero(temp[0]) && temp.length==6){
                    pets.add(new Pet("No-ID",Long.parseLong(temp[0]),temp[1],temp[2],temp[3], Boolean.valueOf(temp[4]),temp[5]));
                }
                linea = br.readLine();
            }

            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("No se ha podido leer el archivo :(");
        }

    }



    private boolean esNumero(String m) {
        try {
            Long.parseLong(m);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }

    }

}
