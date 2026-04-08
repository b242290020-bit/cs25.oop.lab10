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
	public String getName() {
		return name;
	// Хэрэгжүүл: getters, toString
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
