package be.homegrown.utils;

import java.util.regex.Pattern;

/**
 * Created by JoLe on 30/05/2017.
 */
public class StringUtils {

    // TODO: Find correct term for "splitSign"
    public static String[] splitBy(final String toSplit, final String splitSign){
        return Pattern.compile(splitSign).splitAsStream(toSplit).toArray(String[]::new);
    }


}
