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

    public String uploadData() {
        String linea = "";
        File f = new File(ruta);
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            linea = br.readLine();
            String[] temp;
            while (linea != null) {
                temp = linea.split(";");
                if (esNumero(temp[0]) && temp.length == 6) {
                    if (temp[4].equals("SI")) {
                        pets.add(new Pet("No-ID", Long.parseLong(temp[0]), temp[1], temp[2], temp[3], true, temp[5]));
                    } else if (temp[4].equals("NO")) {
                        pets.add(new Pet("No-ID", Long.parseLong(temp[0]), temp[1], temp[2], temp[3], false, temp[5]));
                    }
                }
                linea = br.readLine();
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("No se ha podido leer el archivo :(");
        }

        return "El proceso de carga del archivo ha finalizado";
    }

    public String assingID() {
        String id = "";
        String temp, data;
        for (int i = 0; i < pets.size(); i++) {
            temp = String.valueOf(pets.get(i).getMicrochip());
            temp = temp.substring(temp.length() - 3, temp.length());
            if (pets.get(i).getPotentDangerous() == true) {
                data = pets.get(i).getSpecies().substring(0, 1) + pets.get(i).getSex().subSequence(0, 1) + pets.get(i).getSize().substring(0, 1) + "T";
            } else {
                data = pets.get(i).getSpecies().substring(0, 1) + pets.get(i).getSex().subSequence(0, 1) + pets.get(i).getSize().substring(0, 1) + "F";
            }
            pets.get(i).setId(temp + "-" + data + "-" + pets.get(i).getNeighborhood());
            int cont = 0;
            for (int j = 0; j < pets.size(); j++) {  // se evalua si hay un Id con el mismo numero
                if (pets.get(i).getId().equals(pets.get(j).getId())) {
                    if (cont == 1) {
                        temp = String.valueOf(pets.get(i).getMicrochip());
                        temp = temp.substring(temp.length() - 4, temp.length());
                        pets.get(i).setId(temp + "-" + data + "-" + pets.get(i).getNeighborhood());
                    } else {
                        cont++;
                    }
                }
            }
        }
        eturn "El proceso de asignación de ids ha finalizado";
    }


    private boolean esNumero(String m) {
        try {
            Long.parseLong(m);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }

    }

    public ArrayList<Pet> getPets() {
        return pets;
    }

    public void setPets(ArrayList<Pet> pets) {
        this.pets = pets;
    }
}
