package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SortNumbersByBindaryFormat {

	public static void main(String[] args) {
		List<Integer> aList = new ArrayList<Integer>();
		List<Integer> arrangedList = new ArrayList<Integer>();
		aList.add(3);
		aList.add(1);
		aList.add(2);
		aList.add(3);
		arrangedList = rearrange(aList);
		for (Integer x : arrangedList) {
			System.out.println(x);
		}
	}

	public static List<Integer> rearrange(List<Integer> elements) {
		List<Integer> auxList = new ArrayList<Integer>();
		List<Integer> newList = new ArrayList<Integer>();
		for (int i = 0; i < elements.size(); i++) {
			System.out.println("I is "+i);
			System.out.println("elements value is "+elements.get(i));
			auxList.add(countBits(elements.get(i)));
		}
		int len = auxList.size();
		sortByInsertion(elements, auxList, len);
		newList =  new ArrayList<>(new HashSet<Integer>(elements));
		return newList;
	}

	private static void sortByInsertion(List<Integer> elements, List<Integer> auxList, int len) {
		// TODO Auto-generated method stub
		for (int i = 0; i < elements.size(); i++) {
			int firstKey = auxList.get(i);
			int secondKey = elements.get(i);
			int j = i - 1;
			while (j >= 0 && auxList.get(j) < firstKey) {
				int value = auxList.get(j);
				auxList.set(j + 1, value);
				value = elements.get(j);
				elements.set(j + 1, value);
				j = j - 1;
			}
			auxList.set(j + 1, firstKey);
			elements.set(j + 1, secondKey);
		}
	}

	static int countBits(int a) {
		int count = 0;
		while (a > 0) {
			if ((a & 1) > 0)
				count += 1;
			a = a >> 1;
		}
		System.out.println("Count is" + count);
		return count;
	}
}
