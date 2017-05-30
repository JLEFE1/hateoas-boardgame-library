package be.homegrown.seeder;

import be.homegrown.repository.BoardgameRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by JoLe on 15/05/2017.
 */
@Component
public class DbSeeder implements CommandLineRunner {
    private BoardgameRepository boardgameRepository;

    public DbSeeder(BoardgameRepository boardgameRepository) {
        this.boardgameRepository = boardgameRepository;
    }

    @Override
    public void run(String... strings) throws Exception {


        /*
        Boardgame eclipse = new Boardgame(
                "eclipse",
                130,
                Arrays.asList(
                        new Designer("John"),
                        new Designer("Mary")
                ),
                "Cool game"

        );

        Boardgame mensergerjeniet = new Boardgame(
                "mensergerjeniet",
                5,
                Arrays.asList(
                        new Designer("Joris"),
                        new Designer("Mary")
                ),
                "Boring game"

        );

        */

        /*
        // drop all hotels
        boardgameRepository.deleteAll();

        //add our hotels to the database
        List<Boardgame> boardgames = Arrays.asList(eclipse, mensergerjeniet);
        boardgameRepository.save(boardgames);
        */
    }
}
