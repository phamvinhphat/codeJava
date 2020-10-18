import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class Library {

	String library_1;
	int numberBook = 5;
	Scanner sc = new Scanner(System.in);
	book[] list = new book[numberBook] ; 
	book a = new book();
	int i;	
	String a1 = null;
	int h = 0, k = 0;
	
	public Library(String library) {
		library_1 = library;
	}
	
	
	public void addBook(book book) {
			list[i] = book;
			i++;
	}
	
	
	public void borrkwBook( String a1) {
		for(int i = 0; i< numberBook; i++) {
			if(list[i] == null) {
				h++;
			} else {
				if(list[i].check_borrowed(a1) == true ) {
					System.out.println("Sorry, this book is already borrowed");
				}  else {
					if(list[i].borrowed_1(a1) == true) {
					System.out.println("You successfully borrowed "+a1);
					}
				}
			}	
		}
		if(h >= numberBook) {
			System.out.println("Sorry, this book is not in our catalog.");
		}
	}
	
	
	public void returnBook(String a) {
		for(int i = 0 ; i < numberBook; i++) {
			if(list[i] != null) {
				if(list[i].returned(a)) {
					System.out.println("You successfully returned "+a);
				}
			}
		}
	}
	
	
	public void printAvailableBooks() {
		for (int i1 = 0; i1<numberBook; i1++) {
			if(list[i1] != null) {
				list[i1].outputBook();
			} else {
				k++;
			}
		}
		if(k >= numberBook) {
			System.out.println("Sorry, this book is not in our catalog.");
			
		}
	}
	
	
	// print opening hours
	public static void printOpeningHours() {
		System.out.println("Libraries are open daily from 9 AM to 5 PM.");
	}
	
	//print addresses
	public void printAddress() {
		System.out.println(library_1);
	}
	
	
		

	
	
	public static void main(String arhs[]) {
		Scanner sc = new Scanner(System.in);
		// Create two libraries
		Library fistLibrary = new Library("10 Main St.");
		Library secondLibrary = new Library("228 Liberty St.");
		
		// Add four books to the first library 
		fistLibrary.addBook(new book("The Da Vinci Code"));
		fistLibrary.addBook(new book("Le Petit Prince"));
		fistLibrary.addBook(new book("A Tale of Two Cities"));
		fistLibrary.addBook(new book("The Lord of the Rings"));

		// Print opening hours and the addresses 
		System.out.println("Library hours: ");
		printOpeningHours();
		System.out.println();
		
		System.out.println("Library addresses : ");
		fistLibrary.printAddress();
		secondLibrary.printAddress();
		System.out.println();
		
		// Try to borrow The Lords of the Rings from both libraries 
		System.out.println("Borrowing The Lord of the Rings");
		fistLibrary.borrkwBook("The Lord of the Rings");
		fistLibrary.borrkwBook("The Lord of the Rings");
		fistLibrary.borrkwBook("A Tale of Two Cities");
		System.out.println();
		System.out.println("Books available in the second library:");
		secondLibrary.borrkwBook("The Lord of the Rings");
		System.out.println();
		
		// Print the titles of all available books from both libraries
		System.out.println("Books available in the first library : ");
		fistLibrary.printAvailableBooks();
		System.out.println();
		System.out.println("Books available in the second library : ");
		secondLibrary.printAvailableBooks();
		System.out.println();
		
		// Return The Lords of the Rings to the first library 
		System.out.println("Returning The Lord of the Rings:");
		fistLibrary.returnBook("The Lord of the Rings");
		System.out.println(); 
		
		// Print the titles of available from the first library
		System.out.println("Books available in the first library : ");
		fistLibrary.printAvailableBooks();
		System.out.println();
		
		fistLibrary.returnBook("A Tale of Two Cities");
		fistLibrary.printAvailableBooks();
		
		sc.close();
	}
}
