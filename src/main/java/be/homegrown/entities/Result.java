package be.homegrown.entities;

/**
 * Created by JoLe on 16/05/2017.
 */
public class Result {


    private Integer level;
    private Integer numberOfVotes;
    private String value;


    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getNumberOfVotes() {
        return numberOfVotes;
    }

    public void setNumberOfVotes(Integer numberOfVotes) {
        this.numberOfVotes = numberOfVotes;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
