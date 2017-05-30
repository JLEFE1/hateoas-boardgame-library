package be.homegrown.service;

import be.homegrown.domain.GeekBoardgames;
import be.homegrown.domain.converter.BoardgameConverter;
import be.homegrown.entities.Boardgame;
import be.homegrown.repository.BoardgameRepository;
import be.homegrown.utils.ClassUtils;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by JoLe on 17/05/2017.
 */
@Service
public class BoardgameService {

    private static final Logger log = LoggerFactory.getLogger(BoardgameService.class);

    private BoardgameRepository boardgameRepository;

    private RestTemplate restTemplate = new RestTemplate();

    private final static Integer DEFAULT_LIMIT = 5;

    @Autowired
    public BoardgameService(BoardgameRepository boardgameRepository) {
        this.boardgameRepository = boardgameRepository;
    }

    public Optional<Boardgame> findOne(final String bggId) {
        // TODO: Wath should be returned/thrown
        // An exception or a null value (perhaps empty optional)
        //return .orElse(null);
        return boardgameRepository.findByBggId(bggId);
    }

    public List<Boardgame> findAll() {
        return boardgameRepository.findAll();
    }

    public Iterable<Boardgame> findAll(BooleanExpression filter) {
        return boardgameRepository.findAll(filter);
    }

    public Boardgame insert(Boardgame boardgame) {
        return boardgameRepository.insert(boardgame);
    }

    public Boardgame save(Boardgame boardgame) {
        return boardgameRepository.save(boardgame);
    }

    public void delete(String id) {
        boardgameRepository.delete(id);
    }

    public Boardgame findOnBgg(final String bggId){
        GeekBoardgames games = restTemplate.getForObject("https://www.boardgamegeek.com/xmlapi/boardgame/" + bggId, GeekBoardgames.class);

        log.info("Saved following game: {}", games.toString());

        return BoardgameConverter.convertToBoardgameForDB(games.getGames().get(0));
    }

    public List<Boardgame> searchOnBgg(String query) {
        GeekBoardgames games = restTemplate.getForObject("https://www.boardgamegeek.com/xmlapi/search?search=" + query, GeekBoardgames.class);
        return getFullGameInfoOnBgg(games);
    }

    private List<Boardgame> getFullGameInfoOnBgg(GeekBoardgames games, final Integer limit) {
        return ClassUtils.getStream(games.getGames()).limit(limit).map(game -> findOnBgg(game.getId())).collect(Collectors.toList());

    }

    private List<Boardgame> getFullGameInfoOnBgg(GeekBoardgames games) {
        return getFullGameInfoOnBgg(games, DEFAULT_LIMIT);
    }


    public List<Boardgame> searchOnDb(String query) {
        return boardgameRepository.findByNameContainingIgnoreCase(query).orElse(new ArrayList<>());
    }

}
