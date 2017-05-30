package be.homegrown.domain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by JoLe on 15/05/2017.
 */
@XmlRootElement(name = "poll")
public class GeekPoll {

    @XmlAttribute(name = "name")
    String name;

    @XmlAttribute(name = "title")
    String title;

    @XmlAttribute(name = "totalvotes")
    Integer totalvotes;

    @XmlElement(name = "results")
    List<GeekResults> results;

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public Integer getTotalvotes() {
        return totalvotes;
    }

    public List<GeekResults> getResults() {
        return results;
    }
}
