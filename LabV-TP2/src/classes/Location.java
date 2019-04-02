package classes;

import javax.print.attribute.standard.Chromaticity;

public class Location {
    private int id;
    private String name;
    private City city;
    static int autoId=0;

    public Location(String name, City city) {
        autoId++;
        this.id = autoId;
        this.name = name;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city=" + city +
                '}';
    }
}
