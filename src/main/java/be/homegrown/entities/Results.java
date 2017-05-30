package be.homegrown.entities;

import java.util.List;

/**
 * Created by JoLe on 16/05/2017.
 */
public class Results {


    private String numberOfPlayers;
    private List<Result> results;

    public String getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(String numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
