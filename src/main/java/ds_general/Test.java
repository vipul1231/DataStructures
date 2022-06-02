package ds_general;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test {

	public static final String ONE_ZERO = "0";
	public static final String TWO_ZERO = "00";
	public static final String THREE_ZERO = "000";

	public static void main(String[] args) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-ddHHmm");
		LocalDateTime localDate1 = LocalDateTime.parse("2022-04-151110", dtf);
		LocalDateTime localDate2 = LocalDateTime.parse("2022-04-151415", dtf);


		System.out.println(Duration.between(localDate1, localDate2).toMinutes());

		String s1 = "2";

		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy-MM-ddHHmm");
		LocalDateTime localDate3 = LocalDateTime.parse("2022-04-150110", dtf);
		System.out.println(localDate3);

		System.out.println(getLocalDateTime("22"));
	}


	private static LocalDateTime getLocalDateTime(String time) {
		int length = 4 - time.length();

		if (length == 1) {
			time = ONE_ZERO + time;
		} else if (length == 2) {
			time = TWO_ZERO + time;
		} else if (length == 3) {
			time = THREE_ZERO + time;
		}

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-ddHHmm");
		String todayDate = LocalDate.now() + time;
		return LocalDateTime.parse(todayDate, dtf);
	}

}
