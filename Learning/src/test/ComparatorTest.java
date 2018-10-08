package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class student {
	public student(int age, String name) {
		this.age = age;
		this.name = name;
	}

	int age;
	String name;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

public class ComparatorTest {

	public static void main(String[] args) {
		student s1 = new student(5, "subir");
		student s2 = new student(10, "ajit");
		student s3 = new student(7, "piku");
		student s4 = new student(18, "boby");
		List<student> stulist = new ArrayList<student>();
		stulist.add(s1);
		stulist.add(s2);
		stulist.add(s3);
		stulist.add(s4);
		//String order="Name,Age";
		// Collections.sort(stulist,ComparatorTest.COMPARE_BY_AGE);
		// Collections.sort(stulist, ComparatorTest.COMPARE_BY_NAME);
		Collections.sort(stulist, ComparatorTest.COMPARE_BY_AGE_NAME);
		stulist.forEach(
				student -> System.out.println("Name is ::" + student.getName() + " Age is ::" + student.getAge()));
		// Collections.sort(stulist,ComparatorTest.COMPARE_BY_NAME);
	    //Collections.sort(stulist,ComparatorTest.COMPARE_BY_AGE);
	    //stulist.forEach(student -> System.out.println("Name is ::"+student.getName() + " Age is ::"+student.getAge()));

	}

	public static Comparator<student> COMPARE_BY_NAME = new Comparator<student>() {
		public int compare(student one, student other) {
			return one.getName().compareTo(other.getName());
		}
	};

	public static Comparator<student> COMPARE_BY_AGE = new Comparator<student>() {
		public int compare(student one, student other) {
			return Integer.compare(one.getAge(), new Integer(10));
		}
	};

	// Multiple comparators together
	public static Comparator<student> COMPARE_BY_AGE_NAME = new Comparator<student>() {
		public int compare(student one, student other) {
			int i = one.getName().compareTo(other.getName());
			if (i != 0)
				return i;
			else
				return Integer.compare(one.getAge(), other.getAge());
		}
	};
}
