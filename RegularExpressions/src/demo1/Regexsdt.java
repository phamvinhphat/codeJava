package demo1;

import java.util.*;
import java.util.regex.*;
	
/**
 * SU dung regular expressions de : 
 * Kiem tra dinh dang so dien thoai
 * @author phat
 *
 */
public class Regexsdt {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap so dien thoai : ");
		String input = sc.nextLine();
		String regex = "^[(]0[8-9]\\d{1}[)][.]\\d{4}[.]\\d{3}$";
		Pattern pa = Pattern.compile(regex);
		Matcher ma = pa.matcher(input);
		if(ma.find()) {
			System.out.print("So dien dung ");
		} else {
			System.out.print("Sai dinh dang nhap lai ");
		}
		sc.close();
	}
}
