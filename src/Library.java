import java.util.*;

class Book {
	private String title;
	private int year;

	public Book(String title, int year) {
		this.title = title;
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	public int getYear() {
		return year;
	}
}

public class Library {
	private List<Book> books = new ArrayList<>();

	public void addBook(String title, int year) {
		books.add(new Book(title, year));
	}

	class BookShelf implements Iterable<Book> {
		private int minYear;

		public BookShelf(int minYear) {
			this.minYear = minYear;
		}

		@Override
		public Iterator<Book> iterator() { 
			return new Iterator<Book>(){
				private int index = 0;

				@Override 
				public boolean hasNext() {
					while (index < books.size ()) {
						if (books.get(index).getYear() >minYear) {
							return true;
						}
						index++;
						return false;
					}
                @Override
                public Book next() {
                    return books.get(index++);
                }
            };
		}
	}

	public BookShelf getRecentBooks(int minYear) {
		return new BookShelf(minYear);
	}
}
