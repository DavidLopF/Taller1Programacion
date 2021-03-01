package edu.unbosque.fourpawcitizens.model;

import edu.unbosque.fourpawcitizens.model.dtos.Pet;
import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.ArrayList;

/**
 * Clase Manager, que permite cargar los archivos del programa, y realizar métodos para la funcionalidad de estos.
 *
 * @author Briannys Ahiram Páez Monserrate, Sergio Eduardo Peña Alméciga, David Leonardo López Forero.
 * @version 5.0
 */
public class Manager {
    private String ruta = "./Data/pets-citizens.csv"; // Atributo de tipo String que contiene la ruta de CSV.
    private ArrayList<Pet> pets; // Atributo de tipo Arraylist que contiene una lista de mascotas.

    /**
     * Constructor de la clase Manager.
     */
    public Manager() {
        pets = new ArrayList<>();
    }

    /**
     * Método de tipo String que carga el archivo CSV
     *
     * @return componente de tipo String
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
            System.out.println("No se ha podido leer el archivo :(");
        }

        return "El proceso de carga del archivo ha finalizado";
    }

    /**
     * Metodo encargardo de modificar un ID unico para cada objeto de lista tipo pets.
     *
     * @return String confirmando la correcta asignacion de los datos
     */

    public String assingID() {
        String id = "";
        String temp, data;
        System.out.println("- Cargando ID - ");
        System.out.println("Cargando");
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
     *
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
     * Metodo que busca un objeto de la arrayList pets a partir de su número de microchip.
     *
     * @param micro Número del microchip  correspondiente a a la mascota a buscar.
     * @return String con la información del perro, si no se encuentro la mascota retorna un string informando que no se encontro.
     */
    public String findByMicrochip(String micro) {
        String r = "";
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getMicrochip().toString().equals(micro)) {
                r = pets.get(i).toString();
                break;
            } else {
                r = "No se ha encontrado mascota con este microchip " + micro;
            }
        }
        return r;
    }

    /**
     * Metodo que cuenta cuantos objetos del arrayList pets son de una determinada especie.
     *
     * @param especie String con que contiene la especie a buscar.
     * @return numpero de especies encontradas.
     */

    public String countBySpecies(String especie) {
        int cont = 0;
        for (int i = 0; i < pets.size(); i++) {
            if (especie.equals(pets.get(i).getSpecies())) {
                cont++;
            }
        }
        return "EL numero de animales de la especie " + especie + " es " + cont;
    }

    /**
     * Método de tipo String que retorna los ids de los animales según su parámetro de busqueda.
     *
     * @param sex             parametro de tipo String que almacena el sexo de la mascota a buscar.
     * @param species         parametro de tipo String que almacena la especie de la mascota a buscar.
     * @param size            parametro de tipo String que almacena la talla de la mascota a buscar.
     * @param potentDangerous parametro de tipo String que almacena si es peligroso o no, de la mascota a buscar.
     * @return componente de tipo String.
     */
    public String findByMultipleFields(String sex, String species, String size, String potentDangerous) {
        boolean bandera = false;
        if (potentDangerous.equalsIgnoreCase("si")) {
            bandera = true;
        }
        String resultado = "";
        for (Pet mascota : pets) {
            if (mascota.getSex().equalsIgnoreCase(sex) && mascota.getSpecies().equalsIgnoreCase(species) && mascota.getSize().equalsIgnoreCase(size) && mascota.getPotentDangerous() == bandera) {

                //(mascota.getPotentDangerous()&&potentDangerous.equalsIgnoreCase("si")||!!mascota.getPotentDangerous()&&potentDangerous.equalsIgnoreCase("mo"))){
                resultado += mascota.getId();
                resultado += "\n";
            }
        }
        return resultado;
    }

    /**
     * Método de tipo ArrayList que retorna un número dado de animales potencialmente peligrosos de una localidad.
     *
     * @param n            parámetro de tipo int, que almacena la cantidad de buscados.
     * @param top_last     parámetro de tipo String, que almacena si es last o top de csv.
     * @param neighborhood parametro de tipo String, que almacena la localidad.
     * @return componente de tipo ArrayList.
     */
    public ArrayList<Pet> findBypotentDangerousInNeighborhood(int n, String top_last, String neighborhood) {
        int cantidad = n;
        ArrayList<Pet> mascotas = new ArrayList<>();
        int cont = 0;
        int inicio = 0;
        if (neighborhood.equalsIgnoreCase("usaquen")) {
            inicio = 0;
        } else {
            inicio = findfirstNeighborhoodPosition(neighborhood);
        }
        int fin = findLastNeighborhoodPosition(neighborhood);
        if (inicio == -1 || fin == -1) {
            System.out.println("No se encontró la localidad");
            mascotas = null;
        } else if (top_last.equalsIgnoreCase("top")) {
            cont = 0;
            for (int i = inicio; i < (inicio + n); i++) {
                if (pets.get(i).getPotentDangerous()) {
                    cont++;
                    mascotas.add(pets.get(i));
                }
            }
        } else if (top_last.equalsIgnoreCase("last")) {
            if (neighborhood.equalsIgnoreCase("usaquen")) {
                inicio = 0;
            } else {
                inicio = findfirstNeighborhoodPosition(neighborhood);
            }
            fin = findLastNeighborhoodPosition(neighborhood);
            cont = 0;
            for (int i = fin; i > (fin - n); i--) {
                if (pets.get(i).getPotentDangerous()) {
                    cont++;
                    mascotas.add(pets.get(i));
                }
            }

        } else if (top_last.equalsIgnoreCase("last")) {
            if (neighborhood.equalsIgnoreCase("usaquen")) {
                inicio = 0;
            } else {
                inicio = findfirstNeighborhoodPosition(neighborhood);
            }
            fin = findLastNeighborhoodPosition(neighborhood);
            cont = 0;
            for (int i = fin; i > (fin - n); i--) {
                if (pets.get(i).getPotentDangerous()) {
                    cont++;
                    mascotas.add(pets.get(i));
                }
            }
        }
        System.out.println("La cantidad de mascotas se encontró en la localidad: " + neighborhood + " fue " + cont);
        return mascotas;
    }

    /**
     * Método de tipo int que devuelve el último valor dada una localidad.
     *
     * @param localidad parámetro de tipo String que almacena una localidad de una mascota.
     * @return componente de tipo int.
     */
    public int findLastNeighborhoodPosition(String localidad) {
        for (int i = 0; i < 16936; i++) {
            if (pets.get(i).getNeighborhood().equals(localidad.toUpperCase()) && !pets.get(i + 1).getNeighborhood().equals(localidad.toUpperCase())) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Método de tipo int que devuelve el primer valor dada una localidad.
     *
     * @param localidad parámetro de tipo String que almacena una localidad de una mascota.
     * @return componente de tipo int.
     */
    public int findfirstNeighborhoodPosition(String localidad) {
        for (int i = 0; i < 16936; i++) {
            if (pets.get(i).getNeighborhood().equals(localidad.toUpperCase()) && !pets.get(i - 1).getNeighborhood().equals(localidad.toUpperCase())) {

                return i;
            }
        }
        return -1;
    }

    public String menu() {
        String m = ":: Opciones :: " +
                "\n 1. uploadData" +
                "\n 2. assignID" +
                "\n 3. findByMicrochip" +
                "\n 4. countBySpecies" +
                "\n 5. findBypotentDangerousInNeighborhood" +
                "\n 6. findByMultipleFields" +
                "\n 7. Salir";
        return m;
    }

    /**
     * Gets pets.
     *
     * @return Value of pets.
     */
    public ArrayList<Pet> getPets() {
        return pets;
    }

    /**
     * Gets ruta.
     *
     * @return Value of ruta.
     */
    public String getRuta() {
        return ruta;
    }

    /**
     * Sets new pets.
     *
     * @param pets New value of pets.
     */
    public void setPets(ArrayList<Pet> pets) {
        this.pets = pets;
    }

    /**
     * Sets new ruta.
     *
     * @param ruta New value of ruta.
     */
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
}

