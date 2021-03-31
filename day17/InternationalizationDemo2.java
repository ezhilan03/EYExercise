package InternExercise.day17;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.Locale;

public class InternationalizationDemo2 {
	public static void main(String[] args) {
		
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("en","US"));
		int num = 2345678;
		System.out.println(numberFormat.format(num));
		
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL,new Locale("en","IN"));
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		
		DateTimeFormatterBuilder dtfb = new DateTimeFormatterBuilder();
		DateTimeFormatter dateTimeFormatter = dtfb.toFormatter(new Locale("en","US"));
		System.out.println(dateTimeFormatter.format(LocalDate.now()));
	}
}
