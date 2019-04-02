package classes;

public class City {
    private int id;
    private String name;

    static int autoId=0;

    public City(String name) {
        autoId++;
        this.id = autoId;
        this.name = name;
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

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
