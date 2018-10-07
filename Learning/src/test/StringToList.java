package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringToList {

	public static void main(String[] args) {
		String abc ="Ab,Ba,cv";
		String desc = "AB";
		List<String> abclist= Arrays.asList(abc.split("\\s*,\\s*"));
		System.out.println("the list content is ::");
		for(String foods : abclist) {
			
		}
	}

}
