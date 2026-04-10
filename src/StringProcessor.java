import java.util.*;
import java.util.function.*;

public class StringProcessor {
	public static void processStrings(List<String> strings,
			Predicate<String> filter,
			Function<String, String> transformer,
			Consumer<String> printer) {

		for (String s : strings) {
			if (filter.test(s)) {              // filter
				String result = transformer.apply(s); // transform
				printer.accept(result);       // print
			}
		}
	}

	public static void main(String[] args) {
		List<String> words = Arrays.asList("Java", "Програмчлал", "Код");

		// Predicate: 4-с урт үг шүүх
		Predicate<String> filter = s -> s.length() > 4;

		// Function: бүх үгийг том үсэг болгох
		Function<String, String> transformer = s -> s.toUpperCase();

		// Consumer: хэвлэх
		Consumer<String> printer = s -> System.out.println(s);

		// дуудах
		processStrings(words, filter, transformer, printer);
	}
}