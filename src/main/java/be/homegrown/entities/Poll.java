package be.homegrown.entities;

import java.util.List;

/**
 * Created by JoLe on 16/05/2017.
 */
public class Poll {

    private String name;
    private String title;
    private Integer totalNumberOfVotes;
    private List<Results> results;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTotalNumberOfVotes() {
        return totalNumberOfVotes;
    }

    public void setTotalNumberOfVotes(Integer totalNumberOfVotes) {
        this.totalNumberOfVotes = totalNumberOfVotes;
    }

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }
}
