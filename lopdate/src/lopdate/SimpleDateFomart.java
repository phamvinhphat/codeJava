package lopdate;

import java.text.*;
import java.util.*;

/**
 * lop SimpleDateFormat
 * @author phat
 *
 */
public class SimpleDateFomart {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nInput date : ");
		String input = sc.nextLine();
		Date date = new Date();
//		SimpleDateFormat SDF = new 
//				SimpleDateFormat("E M dd/MM/yyyy hh:mm:ss:SSS z G");
//		
		SimpleDateFormat SDF2 = new SimpleDateFormat("dd/MM/yyyy"); 
//		String myTime = SDF2.format(date);
//		System.out.print(myTime);
		try {
			date = SDF2.parse(input);
			System.out.print(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();
				
	}
}

