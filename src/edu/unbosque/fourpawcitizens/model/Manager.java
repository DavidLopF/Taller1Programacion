package edu.unbosque.fourpawcitizens.model;

import edu.unbosque.fourpawcitizens.model.dtos.Pet;

import java.io.*;
import java.util.ArrayList;

/**
 * @author David Lopez,Briannys Monserrate, Sergio Peña.
 */

public class Manager {

    private String ruta = "./Data/pets-citizens.csv";
    private ArrayList<Pet> pets;

    /**
     * Metodo constructor de la clase manager.
     */
    public Manager() {
        pets = new ArrayList<>();
    }

    /**
     * Metodo encargado de leer el archvo pets-citizens.csv y y crear objetos de la clase pet para agregarlos al arraylist pets.
     *
     * @return String confirmando el correcto cargue de los datos.
     */
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
            return "No se ha podido leer el archivo :(";
        }

        return "El proceso de carga del archivo ha finalizado";
    }

    /**
     * Metodo encargardo de modificar un ID unico para cada objeto de lista tipo pets.
     * @return String confirmando la correcta asignacion de los datos
     */
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
        return "El proceso de asignación de ids ha finalizado";
    }

    /**
     * Metodo encargado de verificar si un string un número (long) de no serlo laza execpcion NumberFormatException
     * @param m String
     * @return Boolean
     */
    private boolean esNumero(String m) {
        try {
            Long.parseLong(m);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }

    }

    /**
     * Gets pets.
     * @return Value of pets.
     */
    public ArrayList<Pet> getPets() {
        return pets;
    }

    /**
     * Sets new pets.
     *
     * @param pets New value of pets.
     */
    public void setPets(ArrayList<Pet> pets) {
        this.pets = pets;
    }
}
