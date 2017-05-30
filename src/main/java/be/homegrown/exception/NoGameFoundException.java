package be.homegrown.exception;

/**
 * Created by JoLe on 29/05/2017.
 */
public class NoGameFoundException extends Exception {

    public NoGameFoundException(final String bggId){
        super("Game (game id: " + bggId + " ) does not exist.");
    }


}
