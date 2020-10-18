package demo1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Tiem kiem gan dung
 * Thay the mot cum ki tu bang mot cum ki tu khac
 * @author phat
 *
 */
public class Regex {
	public static void main(String args[]) {
		String input = "     p        h      a      t";
		String regex = "[\\s]+";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);	
		if(matcher.find()) {
			System.out.print(matcher.replaceAll(" "));
		}	
//			String[] fullname = {"Pham Vinh Phat","Nguyen Hoang Nguyen","Tran Tuan thanh" ,"Pham Thi Huynh Tram",
//		"Pham Le Gia Dai","Vinh Phat"};
	//	for(int i=0;i < fullname.length;i++) {
//			matcher = pattern.matcher(fullname[i]);
//			if(matcher.find()) {
//				System.out.print("\n"+fullname[i]+"\n");
//			}
//		}
	}
}

