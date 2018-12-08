package test;

import java.util.Arrays;
import java.util.List;

public class StringToList {

	public static void main(String[] args) {
		String abc = "Ab,Ba,cv";
		List<String> abclist = Arrays.asList(abc.split("\\s*,\\s*"));
		System.out.println("The list content is ::");
		for (String foods : abclist) {
			System.out.println("" + foods.toString());
		}
	}

}
