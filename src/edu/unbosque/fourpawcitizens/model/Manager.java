package edu.unbosque.fourpawcitizens.model;

import edu.unbosque.fourpawcitizens.model.dtos.Pet;

import java.io.*;
import java.util.ArrayList;

public class Manager {

    private String ruta = "./Data/pets-citizens.csv";
    private ArrayList<Pet> pets;
    private String[] microChip;


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

            int cont = 0;

            while (linea != null) {
                cont++;
            }
            String r ="";
            for (int i = 0; i < microChip.length ; i++) {
                r += microChip[i] ;
            }

            System.out.println(r);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("No se ha podido leer el archivo :(");
        }

    }
}
