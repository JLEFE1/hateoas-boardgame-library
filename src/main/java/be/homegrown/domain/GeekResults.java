package be.homegrown.domain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by JoLe on 15/05/2017.
 */
@XmlRootElement(name = "results")
public class GeekResults {

    @XmlAttribute(name = "numplayers")
    String numplayers;

    @XmlElement(name = "result")
    List<GeekResult> result;

    public String getNumplayers() {
        return numplayers;
    }

    public List<GeekResult> getResult() {
        return result;
    }
}
