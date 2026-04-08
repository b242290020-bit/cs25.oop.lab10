import java.util.*;
import java.util.function.*;

public class StringProcessor {

    public static void processStrings(List<String> strings,
                                      Predicate<String> filter,
                                      Function<String, String> transformer,
                                      Consumer<String> printer) {

        for (String s : strings) {
            if (filter.test(s)) {
                String result = transformer.apply(s);
                printer.accept(result);
            }
        }
    }

    public static void main(String[] args) {

        List<String> words = Arrays.asList("Java", "Програмчлал", "Код");

        // 5-аас урт үгс
        Predicate<String> predicate = s -> s.length() > 5;

        // урвуулах
        Function<String, String> function =
                s -> new StringBuilder(s).reverse().toString();

        // том үсгээр + prefix
        Consumer<String> consumer =
                s -> System.out.println("ГАРШИЛ: " + s.toUpperCase());

        processStrings(words, predicate, function, consumer);
    }
}
