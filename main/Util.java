package main;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Util {
	public static final int getMaximi(double[] a){
		int result = -1;
		boolean isMaximiSet = false;
		double maximi = 0;
		
		for(int i = 0; i < a.length; i++){
			if(isMaximiSet){
				if(maximi < a[i]){
					maximi = a[i];
					result = i;
				}
			} else {
				maximi = a[i];
				result = i;
				isMaximiSet = true;
			}
		}
		
		if(result == -1){
			throw new ArrayIndexOutOfBoundsException();
		}
		
		return result;
	}
	
	public static String getCurrentTime(){
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return sdf.format(cal.getTime());
	}
}