import java.util.*;
import java.util.stream.Collectors;

class Product {
	private String name;
	private double price;
	private String category;

	public Product(String name, double price, String category) {
		this.name = name;
		this.price = price;
		this.category = category;
	}
	// Хэрэгжүүл: getters, toString
}

public class ProductAnalyzer {
	public static Map<String, List<Product>> analyze(List<Product> products) {
		// Хэрэгжүүл: stream ашиглан category-гаар бүлэглэ, 1000₮-с дээш, price-аар
		// эрэмбэл
		return null; // Оруул
	}

	public static void main(String[] args) {
		List<Product> items = Arrays.asList(
				new Product("Гутал", 1500, "Хувцас"),
				new Product("Тоглоом", 800, "Тоглоом"),
				new Product("Цамц", 1200, "Хувцас"));
		// Хэрэгжүүл: analyze дуудаж, хэвлэ
	}
} 
import java.util.*;
import java.util.stream.Collectors;

class Product {
    private String name;
    private double price;
    private String category;

    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // ✔ getters
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    // ✔ toString
    @Override
    public String toString() {
        return name + " (" + (int)price + ")";
    }
}

public class ProductAnalyzer {

    public static Map<String, List<Product>> analyze(List<Product> products) {

        return products.stream()
                // 1000₮-с дээш
                .filter(p -> p.getPrice() > 1000)

                // category-аар group
                .collect(Collectors.groupingBy(
                        Product::getCategory,

                        // дотор нь price буурахаар эрэмбэлэх
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> {
                                    list.sort((a, b) -> Double.compare(b.getPrice(), a.getPrice()));
                                    return list;
                                }
                        )
                ));
    }

    public static void main(String[] args) {

        List<Product> items = Arrays.asList(
                new Product("Гутал", 1500, "Хувцас"),
                new Product("Тоглоом", 800, "Тоглоом"),
                new Product("Цамц", 1200, "Хувцас")
        );

        Map<String, List<Product>> result = analyze(items);

        result.forEach((k, v) ->
                System.out.println(k + ": " + v));
    }
}
