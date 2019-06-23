package database.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Data {
	private final SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
	java.util.Date data;
	
	public Data(String date) {
		try {
			data = dateFormat.parse(date);
		} catch (ParseException e) {
			System.err.println("Erro formato de data");
		}
	}
	public Data() {
		this.data = new Date();
	}
	public Data(Date date)
	{
		this.data = date;
	}
	
	@Override
	public String toString() {
		return dateFormat.format(data);
	}
}
