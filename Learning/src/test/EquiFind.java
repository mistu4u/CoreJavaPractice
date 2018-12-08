package test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class EquiFind {

	public static void main(String[] args) {
		Integer exmapleArray[] = new Integer[] { 1, 2, 3, 4, 4, 5, 5, 65, 4, 43, 43, 42, 1 };
		int mostFrequentedItem = freqtemfinder(exmapleArray);
		int numOfElementsInTheArray = exmapleArray.length;
		System.out.println("Number of elements in the array is :: "+numOfElementsInTheArray);
		if(mostFrequentedItem > numOfElementsInTheArray) {
			System.out.println("Leader of the array is :: "+mostFrequentedItem);
		}
		else {
			System.out.println("This array has no leader");
		}
	}

	public static int freqtemfinder(Integer[] exmapleArray) {
		Map<Integer, Integer> intCount = new HashMap<Integer, Integer>();
		for (Integer i : exmapleArray) {
			if (!intCount.containsKey(i)) {
				intCount.put(i, 1);
			} else {
				intCount.put(i, intCount.get(i) + 1);
			}
		}
		// Get the location of the key having the maximum value
		int maxValueInTheMap = (Collections.max(intCount.values()));
		int keyWithMaxValue = 0;
		System.out.println("The largest value in the map is :: " + maxValueInTheMap);
		//Get the key of that value
		for(Entry<Integer,Integer> entry : intCount.entrySet()) {
			if(entry.getValue() == maxValueInTheMap) {
				keyWithMaxValue = entry.getKey();
				System.out.println(" And the key is :: "+keyWithMaxValue);
			}
		}
		return keyWithMaxValue;
	}

}
