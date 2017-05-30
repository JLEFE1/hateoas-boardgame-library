package be.homegrown.domain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

/**
 * Created by JoLe on 15/05/2017.
 */
@XmlRootElement(name = "boardgamepublisher")
public class GeekPublisher {
    @XmlAttribute(name = "objectid")
    String id;

    @XmlValue
    String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
