import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class SystemDataSnippet {

	/**
	 * Method to get the system date and hour
	 * @return System date and hour in format "dd/MM/yyyy HH:mm:ss"
	 */
	public static String getCurrentDateOne() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		return simpleDateFormat.format(date);
	}

	/**
	 * Method to get the system date and hour
	 * @return System date and hour in format "dd/MM/yyyy HH:mm:ss"
	 */
	public static String getCurrentDateTwo() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		return simpleDateFormat.format(calendar.getTime());
	}

	/**
	 * Method to get the system date and hour
	 * @return System date and hour in format "dd/MM/yyyy HH:mm:ss"
	 */
	public static String getCurrentDateThree() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}

	/**
	 * Method to get the system date and hour
	 * @return System date and hour in format "dd/MM/yyyy"
	 */
	public static String getCurrentDateFour() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.now();
		return dtf.format(localDate);
	}

	public static void main(String args[]) {
		System.out.println(getCurrentDateOne());
		System.out.println(getCurrentDateTwo());
		System.out.println(getCurrentDateThree());
		System.out.println(getCurrentDateFour());
	}

}
