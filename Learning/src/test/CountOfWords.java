package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CountOfWords {

	public static void main(String[] args) throws IOException {
		// Create fileinput stream
		FileInputStream fin = new FileInputStream("D:\\Work\\Projects\\TD_for_BC\\eod.sql");
		Scanner sc = new Scanner(fin);
		ArrayList<String> words = new ArrayList<String>();
		ArrayList<Integer> count = new ArrayList<Integer>();
		while (sc.hasNext()) {
			String nextWord = sc.next();
			if (words.contains(nextWord)) {
				int index = words.indexOf(nextWord);
				count.set(index, count.get(index) + 1);
			} else {
				words.add(nextWord);
				count.add(1);
			}
		}
		sc.close();
		fin.close();
		for (int i = 0; i < words.size(); i++) {
			System.out.println(words.get(i) + " occurred " + count.get(i) + " times");
		}
	}
}
