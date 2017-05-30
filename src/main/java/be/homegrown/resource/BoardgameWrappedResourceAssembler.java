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
public class BoardgameWrappedResourceAssembler extends ResourceAssemblerSupport<Boardgame, BoardgameWrappedResource> {

    public BoardgameWrappedResourceAssembler() {
        super(BoardgameController.class, BoardgameWrappedResource.class);
    }

    @Override
    public BoardgameWrappedResource toResource(Boardgame boardgame) {

        BoardgameWrappedResource resource = createResource(boardgame);
        return resource;
    }



    private BoardgameWrappedResource createResource(Boardgame boardgame) {
        BoardgameWrappedResource resource = new BoardgameWrappedResource(boardgame);

        Link link = linkTo(methodOn(BoardgameController.class).findGameByBggId(boardgame.getBggId())).withSelfRel();
        resource.add(link);

        return resource;
    }

}
