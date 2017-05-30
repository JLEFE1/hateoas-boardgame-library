package be.homegrown.entities;

import java.util.List;

/**
 * Created by JoLe on 16/05/2017.
 */
public class GameTypes {

    private List<Family> boardgamefamily;
    private List<Category> boardgamecategory;
    private List<Subdomain> boardgamesubdomain;
    private List<Mechanic> boardgamemechanic;

    public List<Family> getBoardgamefamily() {
        return boardgamefamily;
    }

    public void setBoardgamefamily(List<Family> boardgamefamily) {
        this.boardgamefamily = boardgamefamily;
    }

    public List<Category> getBoardgamecategory() {
        return boardgamecategory;
    }

    public void setBoardgamecategory(List<Category> boardgamecategory) {
        this.boardgamecategory = boardgamecategory;
    }

    public List<Subdomain> getBoardgamesubdomain() {
        return boardgamesubdomain;
    }

    public void setBoardgamesubdomain(List<Subdomain> boardgamesubdomain) {
        this.boardgamesubdomain = boardgamesubdomain;
    }

    public List<Mechanic> getBoardgamemechanic() {
        return boardgamemechanic;
    }

    public void setBoardgamemechanic(List<Mechanic> boardgamemechanic) {
        this.boardgamemechanic = boardgamemechanic;
    }
}
