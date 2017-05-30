package be.homegrown.domain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by JoLe on 15/05/2017.
 */
@XmlRootElement(name = "result")
public class GeekResult {

    @XmlAttribute(name = "value")
    String value;

    @XmlAttribute(name = "numvotes")
    Integer numvotes;

    @XmlAttribute(name = "level")
    Integer level;

    public String getValue() {
        return value;
    }

    public Integer getNumvotes() {
        return numvotes;
    }

    public Integer getLevel() {
        return level;
    }
}
