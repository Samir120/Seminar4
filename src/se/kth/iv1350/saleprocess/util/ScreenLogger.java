package se.kth.iv1350.saleprocess.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Display log comments to the screen.
 * @author samiralami
 *
 */
public class ScreenLogger implements Logger {
	
	private static final ScreenLogger INSTANCE = new ScreenLogger();
	
	/**
	 * A getter that return the instance of a log screen.
	 * @return
	 */
	public static ScreenLogger getLogger() {
		return INSTANCE;
	}
	
	/**
	 * Prints log comments to the screen.
	 */
	@Override
	public void log(Exception exception) {
		StringBuilder errorMsg = new StringBuilder();
		errorMsg.append("Recorded at " + createTime() + "\n");
		errorMsg.append("The following exception was thrown: ");
		errorMsg.append(exception.getMessage());
		System.out.println(errorMsg);
		exception.printStackTrace(System.out);
	}
	
	/**
	 * Creates date and time of log comments.
	 */
	@Override
	public String createTime() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
		return now.format(formatter);
	}
}
