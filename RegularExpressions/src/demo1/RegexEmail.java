package demo1;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Su dung regular expressions de :
 * 	kiem tra dinh dang email
 * VD: pvphat12c6ntt@gmail.com
 * @author phat
 *
 */
public class RegexEmail {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nNhap email : ");
		String input = sc.nextLine();
		// + it nhat co  mot chu cai
		// * co khong hoac nhieu 
		String regex = "^[a-zA-Z0-9][a-zA-Z0-9]*@{1}+[a-z]+mail.com$";
		Pattern pa = Pattern.compile(regex);
		Matcher ma = pa.matcher(input);
		if(ma.find()) {
			System.out.print("OK");
		} else {
			System.out.print("\nVUI LONG NHAP LAI EMAIL");
		}
		sc.close();
	}
}

