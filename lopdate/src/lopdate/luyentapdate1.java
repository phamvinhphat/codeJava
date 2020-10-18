package lopdate;

/**
 * Viet chuong trinh tinh so ngay giua hai thoi diem cho truoc
 * 
 * @author ptpha
 *
 */

import java.time.LocalDate;
public class luyentapdate1 {
	public static void main(String args[]) {
		
		LocalDate myDate1 = LocalDate.of(2020, 7, 14);
		
		LocalDate myDate2 = LocalDate.of(2020, 7, 1);
		
		System.out.print("my date 1 : " + myDate1);
		System.out.print("\nmy dete 2 : " + myDate2);
		
		int day1 = myDate1.getDayOfMonth();
		int day2 = myDate2.getDayOfMonth();
		
		int dem = 0 ;
		for(int i=day2 ; day1>i;i++) {
			dem = i;
		}
		System.out.print("\nNumber day : "+dem);
		
		
	}
}
