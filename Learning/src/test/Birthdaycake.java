package test;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class Birthdaycake {

	public static int result = 0;

	// Complete the birthdayCakeCandles function below.
	static int birthdayCakeCandles(int[] ar) {
		int max = Arrays.stream(ar).max().getAsInt();
		System.out.println("Max value is :: " + max);
		int keyWithMaxVal = 0;
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 0; i < ar.length; i++) {
			System.out.println("Item number is :: " + i + " value at that item number is ::" + ar[i]);
			if (hm.containsKey(ar[i])) {
				hm.put(ar[i], hm.get(ar[i]) + 1);
			} else {
				hm.put(ar[i], 1);
			}
		}
		System.out.println(Arrays.asList(hm));
		for (Entry<Integer, Integer> entry : hm.entrySet()) { // Itrate through hashmap
			if (entry.getKey() == max) {
				System.out.println("Entered the inner loop");
				System.out.println(entry.getKey()); // Print the key with max value
				keyWithMaxVal = entry.getValue();
			}
		}
		return keyWithMaxVal;
	}

	public static void main(String[] args) throws IOException {
		int[] ar = new int[] { 4, 5, 1, 2, 4, 5, 4, 5, 11, 3, 4 };

		result = birthdayCakeCandles(ar);
		System.out.println("the result is ::" + result);
		String time = "07:05:45PM";
		System.out.println(time.substring(2));
	}
}
