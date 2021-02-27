package edu.unbosque.fourpawcitizens.model.dtos;

public class Pet {

    private String id;
    private Long microchip;
    private String species;
    private String sex;
    private String size;
    private Boolean potentDangerous;
    private String neighborhood;

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

    public void setId(String id) {
        this.id = id;
    }


    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public Long getMicrochip() {
        return microchip;
    }

    public void setMicrochip(Long microchip) {
        this.microchip = microchip;
    }

    public Boolean getPotentDangerous() {
        return potentDangerous;
    }

    public void setPotentDangerous(Boolean potentDangerous) {
        this.potentDangerous = potentDangerous;
    }

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