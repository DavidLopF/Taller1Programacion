package edu.unbosque.fourpawcitizens.model;

public class pets {

    private String id;
    private long microchip;
    private String species;
    private String sex;
    private String size;

    public pets(String id, long microchip, String species, String sex, String size) {
        this.id = id;
        this.microchip = microchip;
        this.species = species;
        this.sex = sex;
        this.size = size;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getMicrochip() {
        return microchip;
    }

    public void setMicrochip(long microchip) {
        this.microchip = microchip;
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

    @Override
    public String toString() {
        return "pets{" +
                "id='" + id + '\'' +
                ", microchip=" + microchip +
                ", species='" + species + '\'' +
                ", sex='" + sex + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
