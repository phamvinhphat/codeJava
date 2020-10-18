package bai_cn;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class Library {

	String library_1;
	int numberBook = 5;
	Scanner sc = new Scanner(System.in);
	book[] list = new book[numberBook] ; 
	book a = new book();
	int i;	

	int h = 0, k = 0;
	
	public Library(String library) {
		library_1 = library;
	}
	
	
	public void addBook(book book) {
			list[i] = book;
			i++;
	}
	
	
	public void borrowBook( String a1) {
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
	
	
		

	
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		// Create two libraries
		Library firstLibrary = new Library("10 Main St.");
		Library secondLibrary = new Library("228 Liberty St.");
		
		// Add four books to the first library 
		firstLibrary.addBook(new book("The Da Vinci Code"));
		firstLibrary.addBook(new book("Le Petit Prince"));
		firstLibrary.addBook(new book("A Tale of Two Cities"));
		firstLibrary.addBook(new book("The Lord of the Rings"));

		// Print opening hours and the addresses 
		System.out.println("Library hours: ");
		printOpeningHours();
		System.out.println();
		
		System.out.println("Library addresses : ");
		firstLibrary.printAddress();
		secondLibrary.printAddress();
		System.out.println();
		
		// Try to borrow The Lords of the Rings from both libraries 
		System.out.println("Borrowing The Lord of the Rings");
		firstLibrary.borrowBook("The Lord of the Rings");
		firstLibrary.borrowBook("The Lord of the Rings");
		firstLibrary.borrowBook("A Tale of Two Cities");
		System.out.println();
		System.out.println("Books available in the second library:");
		secondLibrary.borrowBook("The Lord of the Rings");
		System.out.println();
		
		// Print the titles of all available books from both libraries
		System.out.println("Books available in the first library : ");
		firstLibrary.printAvailableBooks();
		System.out.println();
		System.out.println("Books available in the second library : ");
		secondLibrary.printAvailableBooks();
		System.out.println();
		
		// Return The Lords of the Rings to the first library 
		System.out.println("Returning The Lord of the Rings:");
		firstLibrary.returnBook("The Lord of the Rings");
	
		System.out.println(); 
		
		// Print the titles of available from the first library
		System.out.println("Books available in the first library : ");
		firstLibrary.printAvailableBooks();
		System.out.println();
		
		firstLibrary.returnBook("A Tale of Two Cities");
		firstLibrary.printAvailableBooks();
		
		sc.close();
	}



}
