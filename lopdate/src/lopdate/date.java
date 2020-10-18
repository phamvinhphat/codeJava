package lopdate;
import java.util.*;
/**
 * gioi thieu lop Date trong java 
 * @author phat
 *
 */

public class date {
	public static void main(String args[]) {
		long nowOther = System.currentTimeMillis();
		Date now = new Date();
		Date tomorrow = new Date(nowOther+(24*60*60*1000*1000L));
		Date afterday = new Date(nowOther-(24*60*60*1000)*1000L);
		System.out.print("\n"+now);
//		long nowInMs = now.getTime();
//		System.out.print("\n"+nowInMs);
//		System.out.print("\n"+nowOther);
		System.out.print("\n"+tomorrow);
		System.out.print("\n"+afterday);
		System.out.println("\n"+now.after(tomorrow));
		System.out.print("\n"+now.before(tomorrow));
	
		now.toString();
	}
}

