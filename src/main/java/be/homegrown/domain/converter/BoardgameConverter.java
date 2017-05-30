package be.homegrown.domain.converter;

import be.homegrown.domain.GeekBoardgame;
import be.homegrown.domain.GeekName;
import be.homegrown.domain.GeekResult;
import be.homegrown.domain.GeekResults;
import be.homegrown.entities.*;
import be.homegrown.utils.ClassUtils;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by JoLe on 16/05/2017.
 */
public class BoardgameConverter {

    private static final String NO_GAME = "No game title was found";


    public static Boardgame convertToBoardgame(GeekBoardgame geekGame){
        return convertToBoardgame.apply(geekGame);
    }

    public static List<Boardgame> convertToBoardgame(List<GeekBoardgame> geekGames){
        return ClassUtils.getStream(geekGames).map(BoardgameConverter::convertToBoardgame).collect(Collectors.toList());
    }

    public static Boardgame convertToBoardgameForDB(GeekBoardgame geekBoardgame) {

        Boardgame boardgame = new Boardgame();

        ClassUtils.setIfNotNull(geekBoardgame::getId, boardgame::setBggId);
        boardgame.setName(ClassUtils.getStream(geekBoardgame.getName())
                .filter(GeekName::getPrimary)
                .findFirst()
                .map(GeekName::getName).orElse(NO_GAME));

        ClassUtils.setIfNotNull(geekBoardgame::getDescription, boardgame::setDescription);
        ClassUtils.setIfNotNull(geekBoardgame::getYearpublished, boardgame::setYearPublished);

        ClassUtils.setIfNotNull(geekBoardgame::getThumbnail, boardgame::setThumbnail);
        ClassUtils.setIfNotNull(geekBoardgame::getImage, boardgame::setImage);

        ClassUtils.setIfNotNull(geekBoardgame::getAge, boardgame::setAge);

        ClassUtils.setIfNotNull(geekBoardgame::getMinplayers, boardgame::setMinplayers);
        ClassUtils.setIfNotNull(geekBoardgame::getMaxplayers, boardgame::setMaxplayers);

        ClassUtils.setIfNotNull(geekBoardgame::getPlayingtime, boardgame::setPlayingtime);
        ClassUtils.setIfNotNull(geekBoardgame::getMinplaytime, boardgame::setMinplaytime);
        ClassUtils.setIfNotNull(geekBoardgame::getMaxplaytime, boardgame::setMaxplaytime);


        boardgame.setGameTypes(setGameTypes(geekBoardgame));

        boardgame.setArtists(ClassUtils.getStream(geekBoardgame.getBoardgameartist()).map(artist -> {
            Artist art = new Artist();
            ClassUtils.setIfNotNull(artist::getId, art::setBggId);
            ClassUtils.setIfNotNull(artist::getName, art::setName);
            return art;
        }).collect(Collectors.toList()));

        boardgame.setDesigners(ClassUtils.getStream(geekBoardgame.getBoardgamedesigner()).map(designer -> {
            Designer des = new Designer();
            ClassUtils.setIfNotNull(designer::getId, des::setBggId);
            ClassUtils.setIfNotNull(designer::getName, des::setName);
            return des;
        }).collect(Collectors.toList()));

        boardgame.setPublishers(ClassUtils.getStream(geekBoardgame.getBoardgamepublisher()).map(publisher -> {
            Publisher pub = new Publisher();
            ClassUtils.setIfNotNull(publisher::getId, pub::setBggId);
            ClassUtils.setIfNotNull(publisher::getName, pub::setName);
            return pub;
        }).collect(Collectors.toList()));

        boardgame.setExpansions(ClassUtils.getStream(geekBoardgame.getBoardgameexpansion()).map(expansion -> {
            Expansion exp = new Expansion();
            ClassUtils.setIfNotNull(expansion::getId, exp::setBggId);
            ClassUtils.setIfNotNull(expansion::getName, exp::setName);
            return exp;
        }).collect(Collectors.toList()));

        boardgame.setAccesories(ClassUtils.getStream(geekBoardgame.getBoardgameaccessory()).map(accesory -> {
            Accessory acc = new Accessory();
            ClassUtils.setIfNotNull(accesory::getId, acc::setBggId);
            ClassUtils.setIfNotNull(accesory::getName, acc::setName);
            return acc;
        }).collect(Collectors.toList()));

        boardgame.setHonors(ClassUtils.getStream(geekBoardgame.getBoardgamehonor()).map(honor -> {
            Honor hon = new Honor();
            ClassUtils.setIfNotNull(honor::getId, hon::setBggId);
            ClassUtils.setIfNotNull(honor::getName, hon::setName);
            return hon;
        }).collect(Collectors.toList()));

        boardgame.setPodcasts(ClassUtils.getStream(geekBoardgame.getBoardgamepodcastepisode()).map(podcast -> {
            PodCastEpisode pod = new PodCastEpisode();
            ClassUtils.setIfNotNull(podcast::getId, pod::setBggId);
            ClassUtils.setIfNotNull(podcast::getName, pod::setName);
            return pod;
        }).collect(Collectors.toList()));

        boardgame.setVersions(ClassUtils.getStream(geekBoardgame.getBoardgameversion()).map(version -> {
            Version ver = new Version();
            ClassUtils.setIfNotNull(version::getId, ver::setBggId);
            ClassUtils.setIfNotNull(version::getName, ver::setName);
            return ver;
        }).collect(Collectors.toList()));

        boardgame.setVideoGames(ClassUtils.getStream(geekBoardgame.getVideogamebg()).map(videoGame -> {
            VideoGame vid = new VideoGame();
            ClassUtils.setIfNotNull(videoGame::getId, vid::setBggId);
            ClassUtils.setIfNotNull(videoGame::getName, vid::setName);
            return vid;
        }).collect(Collectors.toList()));

        boardgame.setPolls(ClassUtils.getStream(geekBoardgame.getPoll()).map(poll -> {
            Poll p = new Poll();
            ClassUtils.setIfNotNull(poll::getName, p::setName);
            ClassUtils.setIfNotNull(poll::getTitle, p::setTitle);
            ClassUtils.setIfNotNull(poll::getTotalvotes, p::setTotalNumberOfVotes);
            p.setResults(setResults(poll.getResults()));
            return p;
        }).collect(Collectors.toList()));

        return boardgame;

    }

    private static List<Results> setResults(List<GeekResults> results) {

        return ClassUtils.getStream(results).map(geekResults -> {
                    Results res = new Results();
            ClassUtils.setIfNotNull(geekResults::getNumplayers, res::setNumberOfPlayers);
            res.setResults(setResult(geekResults.getResult()));
            return res;
                }
        ).collect(Collectors.toList());
    }

    private static List<Result> setResult(List<GeekResult> results) {

        return ClassUtils.getStream(results).map(geekResults -> {
                    Result res = new Result();
                    ClassUtils.setIfNotNull(geekResults::getLevel, res::setLevel);
                    ClassUtils.setIfNotNull(geekResults::getNumvotes, res::setNumberOfVotes);
                    ClassUtils.setIfNotNull(geekResults::getValue, res::setValue);
                    return res;
                }
        ).collect(Collectors.toList());
    }

    private static Function<GeekBoardgame, Boardgame> convertToBoardgame
            = (GeekBoardgame geekGame) -> {
        Boardgame boardgame = new Boardgame();


        ClassUtils.setIfNotNull(geekGame::getDescription, boardgame::setDescription);
        ClassUtils.setIfNotNull(geekGame::getYearpublished, boardgame::setYearPublished);
        ClassUtils.setIfNotNull(geekGame::getId, boardgame::setBggId);
        ClassUtils.setIfNotNull(geekGame::getThumbnail, boardgame::setThumbnail);
        ClassUtils.setIfNotNull(geekGame::getImage, boardgame::setImage);
        boardgame.setName(ClassUtils.getStream(geekGame.getName()
                )
                .filter(GeekName::getPrimary)
                .findFirst()
                .map(GeekName::getName).orElse(NO_GAME));

        return boardgame;
    };

    private static GameTypes setGameTypes(GeekBoardgame game){
        GameTypes types = new GameTypes();

        types.setBoardgamecategory(ClassUtils.getStream(game.getBoardgamecategory()).map(category -> {
            Category cat = new Category();
            ClassUtils.setIfNotNull(category::getId, cat::setBggId);
            ClassUtils.setIfNotNull(category::getName, cat::setName);
            return cat;
        }).collect(Collectors.toList()));

        types.setBoardgamefamily(ClassUtils.getStream(game.getBoardgamefamily()).map(family -> {
            Family fam = new Family();
            ClassUtils.setIfNotNull(family::getId, fam::setBggId);
            ClassUtils.setIfNotNull(family::getName, fam::setName);
            return fam;
        }).collect(Collectors.toList()));

        types.setBoardgamemechanic(ClassUtils.getStream(game.getBoardgamemechanic()).map(mechanic -> {
            Mechanic mech = new Mechanic();
            ClassUtils.setIfNotNull(mechanic::getId, mech::setBggId);
            ClassUtils.setIfNotNull(mechanic::getName, mech::setName);
            return mech;
        }).collect(Collectors.toList()));

        types.setBoardgamesubdomain(ClassUtils.getStream(game.getBoardgamesubdomain()).map(subdomain -> {
            Subdomain sd = new Subdomain();
            ClassUtils.setIfNotNull(subdomain::getId, sd::setBggId);
            ClassUtils.setIfNotNull(subdomain::getName, sd::setName);
            return sd;
        }).collect(Collectors.toList()));

        return types;
    }

}
