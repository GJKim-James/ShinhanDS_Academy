package soccer.match.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	// sql.Date => sql.Timestamp
		public static java.sql.Timestamp convertSqlTimestamp(Date dt) {
			return new java.sql.Timestamp(dt.getTime());
		}
	
	// util.Date => sql.Date
	public static java.sql.Date convertSqlDate(Date dt) {
		return new java.sql.Date(dt.getTime());
	}

	public static Date convertDate(String dt) {
		System.out.println("dt : " + dt);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date d = null;
		
		try {
			d = sdf.parse(dt);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println("d : " + d);
		
		return d;
	}
	
	public static String convertString(Date dt) {
		String s = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		s = sdf.format(dt);
		
		return s;
	}

}
