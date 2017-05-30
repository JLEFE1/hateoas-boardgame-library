package be.homegrown.resource;

import be.homegrown.entities.Boardgame;
import com.fasterxml.jackson.annotation.JsonFilter;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by JoLe on 29/05/2017.
 */

public class BoardgameWrappedResource extends ResourceSupport {

    private final Boardgame boardgame;

    public BoardgameWrappedResource(Boardgame boardgame) {
        this.boardgame = boardgame;
    }

    @JsonFilter("boardgameFilter")
    public Boardgame getBoardgame(){
        return boardgame;
    }

}
