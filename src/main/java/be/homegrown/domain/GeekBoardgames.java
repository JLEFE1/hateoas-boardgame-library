package be.homegrown.domain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by JoLe on 15/05/2017.
 */
@XmlRootElement(name = "boardgames")
public class GeekBoardgames {

    @XmlAttribute(name = "termsofuse")
    String termsofuse;

    @XmlElement(name = "boardgame")
    List<GeekBoardgame> games;

    public List<GeekBoardgame> getGames() {
        return games;
    }

}
