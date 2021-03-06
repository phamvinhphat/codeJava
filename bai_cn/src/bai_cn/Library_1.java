package bai_cn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Vector;
import java.sql.SQLException;
/*
 * tao them hai bang mot bang chua cac sach muon mot bang chua sach con 
 * de khi kiem tra no se nhanh hon khi minh de sach muon va sach con trong mot list
 * 
 * 
 * CAN SUA LAI !!!!!
 */


public class Library_1 {
	
	
	String library_2;
	int numberBook = 4;
	Scanner sc = new Scanner(System.in);
	book[] list = new book[numberBook] ; 
	int i;	
	int h = 0, k = 0;
	String list_1 [] = new String[numberBook];
	
	
	public Library_1(String library) {
		library_2 = library;
	}
	
	// create database
	public void csdl()throws SQLException  {
		Connection conn = null;
		try {	
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String cnURL = "jdbc:sqlserver://DESKTOP-APAPJBU:1433;"+"databaseName=Test3;"+"integratedSecurity=true";
			conn = DriverManager.getConnection(cnURL,"sa","1234");
			// crate statement
			Statement stmt = conn.createStatement();
			ResultSet rs2 = stmt.executeQuery("select * from book");
			
			int i = 0;
			while(rs2.next()) {
				list_1[i] = rs2.getString(1);
				i++;
			}
				
			conn.close();
			System.out.print("ket noi thanh cong \n");
		}catch(ClassNotFoundException e) {
			System.out.print("Ket noi that bai");
			}
		}

	
	public void addBook(book book) {
			list[i] = book;
			i++;
	}
	
	
	public void addbook2() {
		for(int i = 0 ;i < numberBook; i++) {
			addBook(new book(list_1[i]));
		}
	}
	
	

	// Update database
	public void update() throws SQLException {
		Connection conn = null;
		try {	
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String cnURL = "jdbc:sqlserver://DESKTOP-APAPJBU:1433;"+"databaseName=Test3;"+"integratedSecurity=true";
			conn = DriverManager.getConnection(cnURL,"sa","1234");
	
			Statement stmt = conn.createStatement();
			String sql [] = new String [list.length]; 
			
			for(int i = 0 ;i<list.length; i++) {
				sql[i] = "update book set name" + "='" + list[i].outputBook_2() + "'" + "where id = "+(i+1)  ;
			}
		
		
			for(int i = 0; i< list.length; i++ ) {
				stmt.executeUpdate(sql[i]);
			}
		
			conn.close();
			System.out.print("ket noi thanh cong \n");
		}catch(ClassNotFoundException e) {
			System.out.print("Ket noi that bai");
			}
	}
	
	
	
	//borrow book 
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
	
	
	// return book
	public void returnBook(String a) {
		for(int i = 0 ; i < numberBook; i++) {
			if(list[i] != null) {
				if(list[i].returned(a)) {
					System.out.println("You successfully returned "+a);
				}
			}
		}
	}
	
	

	
	// print available book
	public void printAvailableBooks() {
		for (int i = 0; i<numberBook; i++) {
			if(list[i] != null) {
				list[i].outputBook();
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
		System.out.println(library_2);
	}
	
	
		
	public static void main(String args[]) throws SQLException {
		Library_1 fistLibrary = new Library_1("10 Main St.");
		Library_1 secondLibrary = new Library_1("228 Liberty St.");
		fistLibrary.csdl();
		
		// Add four books to the first library 
		fistLibrary.addbook2();;
		
		// Print opening hours and the addresses 
		System.out.println("Library hours: ");
		printOpeningHours();
		System.out.println();
				
		System.out.println("Library addresses : ");
		fistLibrary.printAddress();
		secondLibrary.printAddress();
		System.out.println();
				
		
		// Try to borrow The Lords of the Rings from both libraries 
		fistLibrary.printAvailableBooks();
		System.out.println("Borrowing The Lord of the Rings");
		fistLibrary.borrowBook("The Lord of the Rings");
	//	fistLibrary.borrowBook("The Lord of the Rings");
		fistLibrary.borrowBook("The Da Vinci Code");
		fistLibrary.borrowBook("A Tale of Two Cities");
		System.out.println();
		System.out.println("Books available in the second library:");
		secondLibrary.borrowBook("The Lord of the Rings");
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
		fistLibrary.returnBook("The Da Vinci Code");
//		fistLibrary.returnBook("A Tale of Two Cities");
		System.out.println(); 
		
		// Print the titles of available from the first library
		System.out.println("Books available in the first library : ");
		fistLibrary.printAvailableBooks();
		System.out.println();
		
		
		
	//	fistLibrary.saveBook();
		System.out.println("Connection database : \n");
		fistLibrary.update();
		System.out.println();
		

		
		
		
	}
}