package test;

public class TwentyFourHoursConverter {

	static String result;

	public static void main(String[] args) {
		String s = "12:45:54PM";
		String[] parts = s.split(":");
		String hour = parts[0];
		String minute = parts[1];
		String rest = parts[2];
		String seconds = rest.substring(0, 2);
		System.out.println("The hour is ::" + hour + " minute is :: " + minute + " seconds is :: "
				+ rest.substring(0, 2) + " and last two characters are ::" + rest.substring(2));
		if (s.length() > 10) {
			System.out.println("The length of the passed value is wrong");
		}
		if ((Integer.parseInt(hour) > 23) || (Integer.parseInt(hour) < 0)) {
			System.out.println("The passed timeformat is wrong, 1");
		}
		if ((Integer.parseInt(minute) > 60) || (Integer.parseInt(minute) < 0)) {
			System.out.println("The passed timeformat is wrong, 2");
		}
		if (!rest.substring(2).equals("AM") && !rest.substring(2).equals("PM")) {
			System.out.println("The passed timeformat is wrong, 3");
		}
		if ((Integer.parseInt(hour) == 12) && (rest.substring(2).equals("AM")) && (Integer.parseInt(minute) == 0)
				&& (Integer.parseInt(minute) == 0) && (Integer.parseInt(seconds) == 0)) {
			result = "00:00:00";
		} 
		if(rest.substring(2).equals("PM")){
			if(Integer.parseInt(hour)<12) {
				hour = Integer.toString((Integer.parseInt(hour) + 12));
			}
			else {
				hour = "00";
			}
            result = hour + ":" + minute + ":" + seconds;
            System.out.println("The result is :: " + result);
        }
        else{
            result = hour+":"+minute+":"+seconds;
        }
	}

}
