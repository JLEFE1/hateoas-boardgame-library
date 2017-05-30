package be.homegrown.repository;

import be.homegrown.entities.Boardgame;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by JoLe on 15/05/2017.
 */
@Repository
public interface BoardgameRepository extends MongoRepository<Boardgame, String>, QueryDslPredicateExecutor<Boardgame> {

    Optional<Boardgame> findByBggId(final String bggId);
    Optional<List<Boardgame>> findByNameContainingIgnoreCase(final String name);

}
