/**
 * LocalTime.java
 */
package study.java8.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author jack 2016年8月15日 上午10:19:38
 */
public class LocalTime {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		String ds = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		System.out.println(ds);
		
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt.getHour());
		System.out.println(ldt.getMinute());
		System.out.println(ldt.getSecond());
		
		String dst = ldt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		System.out.println(dst);
		
	}
	
}
