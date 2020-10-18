package lopdate;

import java.time.LocalDate;
import java.util.*;

/**
 * Lop local date
 * 
 */

public class lopLocalDate {
	public static void main(String args[]) {
		LocalDate ld = LocalDate.now();
//		System.out.print("\n"+ld);
//		
//		LocalDate myDate = LocalDate.of(2020, 9, 13);
//		System.out.print("\nMY DATE : "+myDate);
//		
//		
		//myDate = myDate.plusDays(10);
		System.out.print("\n"+ld.getDayOfYear());
	}
}
