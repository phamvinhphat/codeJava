package controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.io.BufferedWriter;
import java.util.*;
import model.Book;
import model.Reader;
import model.BookReaderManagement;



public class DataController {
	private FileWriter fileWriter;
	private BufferedWriter bufferedWriter;
	private PrintWriter printWriter;
	private Scanner sc;
	
	
	public void openFileToWrite(String fileName) {
		try {
			fileWriter = new FileWriter(fileName,true);
			bufferedWriter = new BufferedWriter(fileWriter);
			printWriter = new PrintWriter(bufferedWriter);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	

	
	
	void writeBookToFile(Book book, String fileName) {
		
		openFileToWrite(fileName);
		printWriter.println(book.getBookID()+" / "+book.getBookName() 
		+book.getAuthor()+" / "+book.getSpecialization()+" / "+book.getPublicYear()
		+" / "+book.getQuantity());
		closeFileAfterWrite(fileName);
	}
	
	void writeReaderToFile(Reader reader, String fileName) {
		openFileToWrite(fileName);
		printWriter.println(reader.getReaderID()+" / "+reader.getFullName()
		+reader.getAddress()+" / "+reader.getPhoneNumberString());
		closeFileAfterWrite(fileName);
	}
	
	void writeBRMToFile(BookReaderManagement BRM, String fileName) {
		
		openFileToWrite(fileName);
		printWriter.println(BRM.getBook().getBookID()+" / "+BRM.getReader().getReaderID()+
				" / "+ BRM.getNumOfBorrow()+" / "+BRM.getState());
		closeFileAfterWrite(fileName);
	}
	
	
	
	void closeFileAfterWrite(String fileName) {
		try {
			printWriter.close();
			bufferedWriter.close();
			fileWriter.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void openFileToReader(String fileName) {
		try {
			sc = new Scanner(Paths.get(fileName),"UTF-8");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void closeFileAfterReader(String fileName) {
		try {
			sc.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<Reader> readReaderFromFile(String fileName){
		openFileToReader(fileName);
		ArrayList<Reader>  readers = new ArrayList<>();
		while(sc.hasNextLine()) {
			String data = sc.nextLine();
			Reader reader = createReaderFromData(data);
			readers.add(reader);
		}
		closeFileAfterReader(fileName);
		return readers;
	}
	
	public Reader createReaderFromData(String data) {
		String [] datas = data.split("/");
		getReader
		Reader reader = new Reader();
		return reader;
	}
	
}
