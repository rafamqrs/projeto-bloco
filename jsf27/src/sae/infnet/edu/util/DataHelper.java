package sae.infnet.edu.util;

import java.util.Calendar;
import java.util.Date;
/*Classe para tratamento de data */
public class DataHelper {
	/* Metodo que converte de Date para Calendar*/
	public static Calendar dateToCalendar(Date date){ 
		  Calendar cal = Calendar.getInstance();
		  cal.setTime(date);
		  return cal;
	}
}
