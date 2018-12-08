package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Person {

	public Person(int age, String name, char IsVip) {
		this.age = age;
		this.name = name;
		this.isVip = IsVip;
	}

	private int age;
	private String name;
	private char isVip;

	public int getAge() {
		return age;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + isVip;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (isVip != other.isVip)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
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

	public char getIsVip() {
		return isVip;
	}

	public void setIsVip(char isVip) {
		this.isVip = isVip;
	}
}

public class CompareByMapValue {
	public static void main(String[] args) {
		Map<Person, Double> newMap = new HashMap<>();
		List<Person> stulist = new ArrayList<Person>();
		Map<Person, Double> newMap1 = new LinkedHashMap<>();
		stulist.add(new Person(5, "subir", 'N'));
		stulist.add(new Person(10, "ajit", 'N'));
		stulist.add(new Person(7, "piku", 'Y'));
		stulist.add(new Person(18, "boby", 'Y'));
		stulist.add(new Person(11, "kumar", 'Y'));
		stulist.add(new Person(13, "anjan", 'N'));
		for (Person person : stulist) {
			double newAge = (person.getAge() * 2.44);
			newMap.put(person, newAge);
		}
		System.out.println("Before Sorting");
		newMap.forEach((key, value) -> System.out.println("New age is " + value + ": Age is ::" + key.getAge()
				+ " : Name is ::" + key.getName() + " : VIP flag is ::" + key.getIsVip()));
		for (double i = 0; i <= 30; i++) {
			for(Entry<Person, Double> e : newMap.entrySet() ) {
				if(i == e.getValue()) {
					System.out.println("I IS ::"+i+" Value in map is "+e.getValue()+" name of the key object is ::"+e.getKey().getName());
					newMap1.put(e.getKey(),i);
				}
			}
		}
		System.out.println("After sorting the new order is");
		newMap1.forEach((key, value) -> System.out.println("New age is " + value + ": Age is ::" + key.getAge()
		+ " : Name is ::" + key.getName() + " : VIP flag is ::" + key.getIsVip()));
	}
}
