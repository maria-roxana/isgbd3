package isgbd.model;

/**
 * Created by maria-roxana on 22.01.2018.
 */
public class Flower {
    Long id;
    String name;
    Long buds;

    public Flower(Long id, String name, Long buds) {
        this.id = id;
        this.name = name;
        this.buds = buds;
    }

    public Flower() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getBuds() {
        return buds;
    }

    public void setBuds(Long buds) {
        this.buds = buds;
    }

    @Override
    public String toString() {
        return name + " -> buds: " + buds;
    }
}
