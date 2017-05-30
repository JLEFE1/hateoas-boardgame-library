package be.homegrown.domain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.URI;
import java.util.List;

/**
 * Created by JoLe on 15/05/2017.
 */
@XmlRootElement(name = "boardgame")
public class GeekBoardgame {

    @XmlAttribute(name = "objectid")
    String id;
    @XmlElement(name = "name")
    List<GeekName> name;
    @XmlElement(name = "yearpublished")
    Integer yearpublished;
    @XmlElement(name = "minplayers")
    Integer minplayers;
    @XmlElement(name = "maxplayers")
    Integer maxplayers;
    @XmlElement(name = "playingtime")
    Integer playingtime;
    @XmlElement(name = "minplaytime")
    Integer minplaytime;
    @XmlElement(name = "maxplaytime")
    Integer maxplaytime;
    @XmlElement(name = "age")
    Integer age;
    @XmlElement(name = "description")
    String description;
    @XmlElement(name = "thumbnail")
    URI thumbnail;
    @XmlElement(name = "image")
    URI image;

    @XmlElement(name = "boardgamepublisher")
    List<GeekPublisher> boardgamepublisher;
    @XmlElement(name = "boardgamehonor")
    List<GeekHonor> boardgamehonor;
    @XmlElement(name = "boardgamefamily")
    List<GeekFamily> boardgamefamily;
    @XmlElement(name = "boardgamemechanic")
    List<GeekMechanic> boardgamemechanic;
    @XmlElement(name = "boardgameversion")
    List<GeekVersion> boardgameversion;
    @XmlElement(name = "boardgamepodcastepisode")
    List<GeekPodCastEpisode> boardgamepodcastepisode;
    @XmlElement(name = "boardgamecategory")
    List<GeekCategory> boardgamecategory;
    @XmlElement(name = "boardgameexpansion")
    List<GeekExpansion> boardgameexpansion;
    @XmlElement(name = "boardgameaccessory")
    List<GeekAccessory> boardgameaccessory;
    @XmlElement(name = "videogamebg")
    List<GeekVideoGameBG> videogamebg;
    @XmlElement(name = "boardgameartist")
    List<GeekArtist> boardgameartist;
    @XmlElement(name = "boardgamesubdomain")
    List<GeekSubdomain> boardgamesubdomain;
    @XmlElement(name = "boardgamedesigner")
    List<GeekDesigner> boardgamedesigner;
    @XmlElement(name = "poll")
    List<GeekPoll> poll;

    public String getDescription() {
        return description;
    }

    public List<GeekName> getName() {
        return name;
    }

    public Integer getYearpublished() {
        return yearpublished;
    }

    public String getId() {
        return id;
    }

    public URI getThumbnail() {
        return thumbnail;
    }

    public URI getImage() {
        return image;
    }

    public Integer getMinplayers() {
        return minplayers;
    }

    public Integer getMaxplayers() {
        return maxplayers;
    }

    public Integer getPlayingtime() {
        return playingtime;
    }

    public Integer getMinplaytime() {
        return minplaytime;
    }

    public Integer getMaxplaytime() {
        return maxplaytime;
    }

    public Integer getAge() {
        return age;
    }

    public List<GeekPublisher> getBoardgamepublisher() {
        return boardgamepublisher;
    }

    public List<GeekHonor> getBoardgamehonor() {
        return boardgamehonor;
    }

    public List<GeekFamily> getBoardgamefamily() {
        return boardgamefamily;
    }

    public List<GeekMechanic> getBoardgamemechanic() {
        return boardgamemechanic;
    }

    public List<GeekVersion> getBoardgameversion() {
        return boardgameversion;
    }

    public List<GeekPodCastEpisode> getBoardgamepodcastepisode() {
        return boardgamepodcastepisode;
    }

    public List<GeekCategory> getBoardgamecategory() {
        return boardgamecategory;
    }

    public List<GeekExpansion> getBoardgameexpansion() {
        return boardgameexpansion;
    }

    public List<GeekAccessory> getBoardgameaccessory() {
        return boardgameaccessory;
    }

    public List<GeekVideoGameBG> getVideogamebg() {
        return videogamebg;
    }

    public List<GeekArtist> getBoardgameartist() {
        return boardgameartist;
    }

    public List<GeekSubdomain> getBoardgamesubdomain() {
        return boardgamesubdomain;
    }

    public List<GeekDesigner> getBoardgamedesigner() {
        return boardgamedesigner;
    }

    public List<GeekPoll> getPoll() {
        return poll;
    }
}

