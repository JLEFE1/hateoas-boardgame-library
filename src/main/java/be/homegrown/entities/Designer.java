package be.homegrown.entities;

/**
 * Created by JoLe on 15/05/2017.
 */
public class Designer {

    private String bggId;
    private String name;

    public Designer() {
    }

    public Designer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBggId() {
        return bggId;
    }

    public void setBggId(String bggId) {
        this.bggId = bggId;
    }
}
