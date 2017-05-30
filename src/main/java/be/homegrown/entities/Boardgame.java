package be.homegrown.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.net.URI;
import java.util.List;

/**
 * Created by JoLe on 15/05/2017.
 */
@Document(collection = "boardgames")
public class Boardgame {

    @Id
    private String id;

    private String bggId;
    private String name;
    private String description;
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


    public Boardgame() {
    }

    protected Boardgame(List<Designer> designers) {
        this.designers = designers;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Designer> getDesigners() {
        return designers;
    }

    public void setDesigners(List<Designer> designers) {
        this.designers = designers;
    }

    public String getBggId() {
        return bggId;
    }

    public void setBggId(String bggId) {
        this.bggId = bggId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(Integer yearPublished) {
        this.yearPublished = yearPublished;
    }

    public List<Publisher> getPublishers() {
        return publishers;
    }

    public void setPublishers(List<Publisher> publishers) {
        this.publishers = publishers;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public Integer getMinplayers() {
        return minplayers;
    }

    public void setMinplayers(Integer minplayers) {
        this.minplayers = minplayers;
    }

    public Integer getMaxplayers() {
        return maxplayers;
    }

    public void setMaxplayers(Integer maxplayers) {
        this.maxplayers = maxplayers;
    }

    public Integer getPlayingtime() {
        return playingtime;
    }

    public void setPlayingtime(Integer playingtime) {
        this.playingtime = playingtime;
    }

    public Integer getMinplaytime() {
        return minplaytime;
    }

    public void setMinplaytime(Integer minplaytime) {
        this.minplaytime = minplaytime;
    }

    public Integer getMaxplaytime() {
        return maxplaytime;
    }

    public void setMaxplaytime(Integer maxplaytime) {
        this.maxplaytime = maxplaytime;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public URI getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(URI thumbnail) {
        this.thumbnail = thumbnail;
    }

    public URI getImage() {
        return image;
    }

    public void setImage(URI image) {
        this.image = image;
    }

    public GameTypes getGameTypes() {
        return gameTypes;
    }

    public void setGameTypes(GameTypes gameTypes) {
        this.gameTypes = gameTypes;
    }

    public List<Honor> getHonors() {
        return honors;
    }

    public void setHonors(List<Honor> honors) {
        this.honors = honors;
    }

    public List<Version> getVersions() {
        return versions;
    }

    public void setVersions(List<Version> versions) {
        this.versions = versions;
    }

    public List<PodCastEpisode> getPodcasts() {
        return podcasts;
    }

    public void setPodcasts(List<PodCastEpisode> podcasts) {
        this.podcasts = podcasts;
    }

    public List<Expansion> getExpansions() {
        return expansions;
    }

    public void setExpansions(List<Expansion> expansions) {
        this.expansions = expansions;
    }

    public List<Accessory> getAccesories() {
        return accesories;
    }

    public void setAccesories(List<Accessory> accesories) {
        this.accesories = accesories;
    }

    public List<VideoGame> getVideoGames() {
        return videoGames;
    }

    public void setVideoGames(List<VideoGame> videoGames) {
        this.videoGames = videoGames;
    }

    public List<Poll> getPolls() {
        return polls;
    }

    public void setPolls(List<Poll> polls) {
        this.polls = polls;
    }
}