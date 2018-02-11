package pe.edu.utp.javawebregionlist.models;

public class Country {
    String id;
    String name;
    Region region;

    public Country() {
    }
    


    public String getId() {
        return id;
    }

    public Country setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Country setName(String name) {
        this.name = name;
        return this;
    }

    public Region getRegion() {
        return region;
    }

    public Country setRegion(Region region) {
        this.region = region;
        return this;
    }
}
