package be.homegrown.resource;

import be.homegrown.entities.*;
import be.homegrown.resource.view.BoardgameView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.hateoas.ResourceSupport;

import java.net.URI;
import java.util.List;

/**
 * Created by JoLe on 29/05/2017.
 */
public class BoardgameResource extends ResourceSupport {

    @JsonView(BoardgameView.Summary.class)
    private String bggId;
    @JsonView(BoardgameView.Summary.class)
    private String name;
    @JsonView(BoardgameView.Summary.class)
    private String description;
    @JsonView(BoardgameView.Summary.class)
    private Integer yearPublished;
    private List<Publisher> publishers;
    private List<Designer> designers;
    private List<Artist> artists;
    private Integer minplayers;
    private Integer maxplayers;
    private Integer playingtime;
    private Integer minplaytime;
    private Integer maxplaytime;
    private Integer age;
    private URI thumbnail;
    private URI image;
    private GameTypes gameTypes;
    private List<Honor> honors;
    private List<Version> versions;
    private List<PodCastEpisode> podcasts;
    private List<Expansion> expansions;
    private List<Accessory> accesories;
    private List<VideoGame> videoGames;
    private List<Poll> polls;

    public BoardgameResource(Boardgame boardgame) {

        this.bggId = boardgame.getBggId();
        this.name = boardgame.getName();
        this.description = boardgame.getDescription();
        this.yearPublished = boardgame.getYearPublished();
        this.publishers = boardgame.getPublishers();
        this.designers = boardgame.getDesigners();
        this.artists = boardgame.getArtists();
        this.minplayers = boardgame.getMinplayers();
        this.maxplayers = boardgame.getMaxplayers();
        this.playingtime = boardgame.getPlayingtime();
        this.minplaytime = boardgame.getMinplaytime();
        this.maxplaytime = boardgame.getMaxplaytime();
        this.age = boardgame.getAge();
        this.thumbnail = boardgame.getThumbnail();
        this.image = boardgame.getImage();
        this.gameTypes = boardgame.getGameTypes();
        this.honors = boardgame.getHonors();
        this.versions = boardgame.getVersions();
        this.podcasts = boardgame.getPodcasts();
        this.expansions = boardgame.getExpansions();
        this.accesories = boardgame.getAccesories();
        this.videoGames = boardgame.getVideoGames();
        this.polls = boardgame.getPolls();
    }

    public String getBggId() {
        return bggId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getYearPublished() {
        return yearPublished;
    }

    public List<Publisher> getPublishers() {
        return publishers;
    }

    public List<Designer> getDesigners() {
        return designers;
    }

    public List<Artist> getArtists() {
        return artists;
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

    public URI getThumbnail() {
        return thumbnail;
    }

    public URI getImage() {
        return image;
    }

    public GameTypes getGameTypes() {
        return gameTypes;
    }

    public List<Honor> getHonors() {
        return honors;
    }

    public List<Version> getVersions() {
        return versions;
    }

    public List<PodCastEpisode> getPodcasts() {
        return podcasts;
    }

    public List<Expansion> getExpansions() {
        return expansions;
    }

    public List<Accessory> getAccesories() {
        return accesories;
    }

    public List<VideoGame> getVideoGames() {
        return videoGames;
    }

    public List<Poll> getPolls() {
        return polls;
    }
}
