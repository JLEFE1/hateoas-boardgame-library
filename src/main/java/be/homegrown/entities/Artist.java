package be.homegrown.entities;

/**
 * Created by JoLe on 16/05/2017.
 */
public class Artist {

    private String bggId;
    private String name;
    private BaseEntity baseEntity;

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

    public BaseEntity getBaseEntity() {
        return baseEntity;
    }

    public void setBaseEntity(BaseEntity baseEntity) {
        this.baseEntity = baseEntity;
    }
}
