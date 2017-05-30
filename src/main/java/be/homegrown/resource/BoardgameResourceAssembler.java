package be.homegrown.resource;

import be.homegrown.controller.BoardgameController;
import be.homegrown.entities.Boardgame;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by JoLe on 29/05/2017.
 */
@Component
public class BoardgameResourceAssembler extends ResourceAssemblerSupport<Boardgame, BoardgameResource> {

    public BoardgameResourceAssembler() {
        super(BoardgameController.class, BoardgameResource.class);
    }

    @Override
    public BoardgameResource toResource(Boardgame boardgame) {

        BoardgameResource resource = createResource(boardgame);
        return resource;
    }



    private BoardgameResource createResource(Boardgame boardgame) {
        BoardgameResource resource = new BoardgameResource(boardgame);

        Link link = linkTo(methodOn(BoardgameController.class).findGameByBggId(boardgame.getBggId())).withSelfRel();
        resource.add(link);

        return resource;
    }

}
