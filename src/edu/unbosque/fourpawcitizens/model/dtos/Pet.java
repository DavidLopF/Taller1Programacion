package edu.unbosque.fourpawcitizens.model.dtos;

/**
 * Clase Pet, que permite que contiene los atributos y métodos necesarios para leer el archivo.
 * @author Briannys Ahiram Páez Monserrate, Sergio Eduardo Peña Alméciga, David Leonardo López Forero.
 * @version 5.0
 */
public class Pet {
    private String id;
    private Long microchip;
    private String species;
    private String sex;
    private String size;
    private Boolean potentDangerous;
    private String neighborhood;

    /**
     * Constructor de la clase Pet
     * @param id parámetro de tipo String que almacena el ID de una mascota.
     * @param microchip parámetro de tipo Long que almacena el microchip de una mascota.
     * @param species parámetro de tipo String que almacena la especie de una mascota.
     * @param sex parámetro de tipo String que almacena el sexo de una mascota.
     * @param size parámetro de tipo String que almacena la talla de una mascota.
     * @param potentDangerous parámetro de tipo Boolean que almacena si es peligrosa o no, una mascota.
     * @param neighborhood parámetro de tipo String que almacena la localidad de una mascota.
     */
    public Pet(String id, Long microchip, String species, String sex, String size, Boolean potentDangerous, String neighborhood) {
        this.id = id;
        this.microchip = microchip;
        this.species = species;
        this.sex = sex;
        this.size = size;
        this.potentDangerous = potentDangerous;
        this.neighborhood = neighborhood;
    }


    public String getId() {
        return id;

    }


    /**
     * Gets microchip.
     *
     * @return Value of microchip.
     */
    public Long getMicrochip() {
        return microchip;
    }

    /**
     * Sets new id.
     *
     * @param id New value of id.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets neighborhood.
     *
     * @return Value of neighborhood.
     */
    public String getNeighborhood() {
        return neighborhood;
    }

    /**
     * Sets new size.
     *
     * @param size New value of size.
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * Gets sex.
     *
     * @return Value of sex.
     */
    public String getSex() {
        return sex;
    }

    /**
     * Gets size.
     *
     * @return Value of size.
     */
    public String getSize() {
        return size;
    }

    /**
     * Gets species.
     *
     * @return Value of species.
     */
    public String getSpecies() {
        return species;
    }

    /**
     * Gets potentDangerous.
     *
     * @return Value of potentDangerous.
     */
    public Boolean getPotentDangerous() {
        return potentDangerous;
    }

    /**
     * Sets new species.
     *
     * @param species New value of species.
     */
    public void setSpecies(String species) {
        this.species = species;
    }

    /**
     * Sets new sex.
     *
     * @param sex New value of sex.
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * Sets new potentDangerous.
     *
     * @param potentDangerous New value of potentDangerous.
     */
    public void setPotentDangerous(Boolean potentDangerous) {
        this.potentDangerous = potentDangerous;
    }

    /**
     * Sets new microchip.
     *
     * @param microchip New value of microchip.
     */
    public void setMicrochip(Long microchip) {
        this.microchip = microchip;
    }

    /**
     * Sets new neighborhood.
     *
     * @param neighborhood New value of neighborhood.
     */
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    /**
     * Metodo encargado de retornar todos los atributos de la calse pet en un String
     * @return componente de tipo String
     */

    @Override
    public String toString() {
        return "pets{" +
                "id='" + id + '\'' +
                ", microchip=" + microchip +
                ", species='" + species + '\'' +
                ", sex='" + sex + '\'' +
                ", size='" + size + '\'' +
                ", potentDangerous=" + potentDangerous +
                ", neighborhood='" + neighborhood + '\'' +
                '}';
    }

}
