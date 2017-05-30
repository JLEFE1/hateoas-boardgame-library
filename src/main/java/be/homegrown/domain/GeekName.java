package be.homegrown.domain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

/**
 * Created by JoLe on 15/05/2017.
 */
@XmlRootElement(name = "boardgamecategory")
public class GeekName {

    @XmlAttribute(name = "primary")
    boolean primary;

    @XmlAttribute(name = "sortindex")
    Integer id;

    @XmlValue
    String name;

    public Boolean getPrimary() {
        return primary;
    }

    public String getName() {
        return name;
    }
}
