package edu.unbosque.fourpawcitizens.model.dtos;

/**
 * @author David Lopez,Briannys Monserrate, Sergio Peña.
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
     * Metodo constructor de la clase pet, encargado de inicializar todos los atributos de la clase pet.
     * @param id String
     * @param microchip Long
     * @param species String
     * @param sex String
     * @param size String
     * @param potentDangerous Boolean
     * @param neighborhood String
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


    /**
     * Metodo encargado de retornar todos los atributos de la calse pet en un String
     * @return String
     */

    @Override
    public String toString() {
        return
                "iD: " + id +"\n"+
                "species: " + species + "\n" +
                "sex :" + sex + "\n" +
                "size :" + size + '\n' +
                "potentDangerous :" + potentDangerous +"\n"+
                "neighborhood :" + neighborhood + "\n" ;
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
     * Sets new neighborhood.
     *
     * @param neighborhood New value of neighborhood.
     */
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
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
     * Gets potentDangerous.
     *
     * @return Value of potentDangerous.
     */
    public Boolean getPotentDangerous() {
        return potentDangerous;
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
     * Gets id.
     *
     * @return Value of id.
     */
    public String getId() {
        return id;
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
     * Sets new potentDangerous.
     *
     * @param potentDangerous New value of potentDangerous.
     */
    public void setPotentDangerous(Boolean potentDangerous) {
        this.potentDangerous = potentDangerous;
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
     * Gets neighborhood.
     *
     * @return Value of neighborhood.
     */
    public String getNeighborhood() {
        return neighborhood;
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
     * Gets sex.
     *
     * @return Value of sex.
     */
    public String getSex() {
        return sex;
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
}
