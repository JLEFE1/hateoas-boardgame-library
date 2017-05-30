package be.homegrown.service;

import be.homegrown.entities.Boardgame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by JoLe on 29/05/2017.
 */
@Service
public class AdminService {

    private final BoardgameService boardgameService;

    @Autowired
    public AdminService(BoardgameService boardgameService){
        this.boardgameService = boardgameService;
    }

    public List<Boardgame> storeBggGameInDb(String bggId) {
        //TODO finish method
        return null;
    }
}
