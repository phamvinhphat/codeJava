import java.util.*;


public class book {
	
	String title;
	String title_2;
	boolean borrowed;
	Scanner sc = new Scanner(System.in); 
	
	public book() {
		
	}

	
	public book(String bookTitle) {
		title = bookTitle;
		title_2 = bookTitle;

	}
	
	
	public void outputBook() {
			System.out.println(title+"\n");
	}
	
	public String getTitle() {
		return title;
	}
	
	public boolean  borrowed_1(String a ) {
		if(title.equalsIgnoreCase(a) == true ) {
			title = "!!! book been borrowed " + a;
			return true;
		}
		return false;
	}
	
	
	public boolean check_borrowed(String a) {
				if(getTitle().equalsIgnoreCase("!!! book been borrowed " + a)) {
					return true;
		}
		return false;
	}
	
	public boolean returned(String a) { 
			if(getTitle().equalsIgnoreCase("!!! book been borrowed " + a) == true) {
				title = title_2;
				return true;
			} 
			return false;
	}
	

	
	public static void main(String args[])  {
		
	book example = new book("The Da Vinci Code"); 
	System.out.println("Title "  + example.getTitle());
	example.outputBook();
	System.out.println("Borrowed ? "+example.check_borrowed("The Da Vinci Code"));
	example.outputBook();
	
	example.borrowed_1("The Da Vinci Code");
	example.outputBook();
	System.out.println("Borrowed? "+example.check_borrowed("The Da Vinci Code"));
	example.outputBook();
	
	example.returned("The Da Vinci Code");
	example.outputBook();
	System.out.println("Borrowed? "+example.check_borrowed("The Da Vinci Code"));	
	}



}
