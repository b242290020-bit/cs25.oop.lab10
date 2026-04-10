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

	// getters
	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public String getCategory() {
		return category;
	}

	// toString
	@Override
	public String toString() {
		return name + " - " + price + "₮";
	}
}

public class ProductAnalyzer {
	public static Map<String, List<Product>> analyze(List<Product> products) {

		return products.stream()
				.filter(p -> p.getPrice() > 1000) // 1000₮-с дээш
				.sorted(Comparator.comparing(Product::getPrice)) // price-аар эрэмбэлэх
				.collect(Collectors.groupingBy(Product::getCategory)); // category-гаар бүлэглэх
	}

	public static void main(String[] args) {
		List<Product> items = Arrays.asList(
				new Product("Гутал", 1500, "Хувцас"),
				new Product("Тоглоом", 800, "Тоглоом"),
				new Product("Цамц", 1200, "Хувцас"));

		Map<String, List<Product>> result = analyze(items);

		// хэвлэх
		for (String category : result.keySet()) {
			System.out.println("Category: " + category);
			for (Product p : result.get(category)) {
				System.out.println("  " + p);
			}
		}
	}
}