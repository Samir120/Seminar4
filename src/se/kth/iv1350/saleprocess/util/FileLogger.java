package se.kth.iv1350.saleprocess.util;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Prints log comments to the file salesprocess-log.txt.
 * @author samiralami
 *
 */
public class FileLogger implements Logger {
	
	private PrintWriter logStream;
	private static final FileLogger INSTANCE = new FileLogger();
	
	/**
	 * Create an intstance of a log file.
	 */
	public FileLogger() {
		try {
			logStream = new PrintWriter(
						new FileWriter("saleprocess-log.txt"), true);
		}
		catch(IOException ioe) {
			System.out.println("Failed to create logger.");
			ioe.printStackTrace();
		}
	}
	
	/**
	 * A getter that return the instance of a log file.
	 * @return
	 */
	public static FileLogger getLogger() {
		return INSTANCE;
	}
	
	/**
	 * Prints log comments to the file.
	 */
	@Override
	public void log(Exception exception) {
		StringBuilder errorMsg = new StringBuilder();
		errorMsg.append("Recorded at " + createTime() + "\n");
		errorMsg.append("The following exception was thrown: ");
		errorMsg.append(exception.getMessage());
		logStream.println(errorMsg);
		exception.printStackTrace(logStream);
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
