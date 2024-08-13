package GenericUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * Random number Program
	 * @return
	 */
	public int getRandomNumber()
	{
		Random r=new Random();
		int randomnuber = r.nextInt(200);
		return randomnuber;		
	}
	/**
	 * get the system date based on YYYY-DD-MM format
	 * @return
	 */
	public String getSystemDateYYYYDDMM() {
		
		Date dateObj = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(dateObj);
		return date;
	}
	/**
	 * get the Required date based on YYYY-DD-MM format
	 * @return
	 */
	public String getRequriedDateYYYYDDMM(int days) {		 
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
				
	    Calendar cal = sim.getCalendar();
	    cal.add(Calendar.DAY_OF_MONTH,days);
	   String reqDate=  sim.format(cal.getTime());
	return reqDate;
	}


}
