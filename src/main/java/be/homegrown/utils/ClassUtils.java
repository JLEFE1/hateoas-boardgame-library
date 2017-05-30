package be.homegrown.utils;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Created by JoLe on 16/05/2017.
 */
public class ClassUtils {

    protected ClassUtils() { }

    public static <T> void setIfNotNull(final Supplier<T> getter, final Consumer<T> setter) {

        T t = getter.get();

        if (null != t) {
            setter.accept(t);
        }
    }

    public static <T> Stream<T> getStream(List<T> list) {
        return Optional.ofNullable(list).map(List::stream).orElseGet(Stream::empty);
    }

}
