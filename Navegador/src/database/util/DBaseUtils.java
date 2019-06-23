package database.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DBaseUtils {
	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
	/**
	 * Gera uma string da data e hora atual
	 * @return data no formato yyyy/MM/dd HH:mm:ss
	 */
	public static String nowString() {
		String dateNow = DATE_FORMAT.format(new Date());
		return dateNow;
	}
}
