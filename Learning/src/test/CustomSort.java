package test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Prson {
	
	public Prson(int age, String name, char IsVip) {
		this.age = age;
		this.name = name;
		this.isVip = IsVip;
	}

	int age;
	String name;
	char isVip;

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

	public char getIsVip() {
		return isVip;
	}

	public void setIsVip(char isVip) {
		this.isVip = isVip;
	}
}

public class CustomSort {
	
	 public static Comparator<Prson> COMPARE_BY_PERSON_NAME = new Comparator<Prson>() {
	        public int compare(Prson one, Prson other) {
	            return one.getName().compareTo(other.getName());
	        }
	    };

	public static void main(String[] args) {
		Prson s1 = new Prson(5, "subir", 'N');
		Prson s2 = new Prson(10, "ajit", 'N');
		Prson s3 = new Prson(7, "piku", 'Y');
		Prson s4 = new Prson(18, "boby", 'Y');

		Map<String, Prson> newMap = new TreeMap<>();
		List<Prson> stulist = new ArrayList<Prson>();
		stulist.add(s1);
		stulist.add(s2);
		stulist.add(s3);
		stulist.add(s4);
		stulist.add(new Prson(11, "kumar", 'Y'));
		stulist.add(new Prson(13, "anjan", 'N'));
		for (Prson person : stulist) {
			String newAge = Integer.toString(person.getAge() * 2);
			newMap.put(newAge, person);
		}
		List<Prson> finalList = new ArrayList<Prson>();
		List<Prson> submitList = new ArrayList<Prson>();
		String order = "newAge,vip,name";
		int midelement = 12;
		int range = 6;
		int limit = 12;
//		System.out.println("The map values are  ::" +Arrays.asList(newMap));
		newMap.forEach((key, value) -> System.out
				.println(key + ": Age is ::" + value.getAge() + " : Name is ::" + value.getName()));
		sortAsPerParameterization(order,stulist,limit,range,newMap,submitList);
	}

	private static List<Prson> sortAsPerParameterization(String order, List<Prson> finalList, int limit, int range,
			Map<String, Prson> newMap,List<Prson> submitList) {
		List<Prson> finalListFromFinal = new ArrayList<Prson>();
		String[] parts = order.split(",");
		System.out.println("Control came here");
		for (String element : parts) {
//			if(element.equalsIgnoreCase("newage")) {
//				sortByNewAge(limit,finalList,range,newMap);
//			}
			if (element.equalsIgnoreCase("vip")) {
				finalListFromFinal.addAll(sortByVipFlg(finalList,submitList));
				finalList.removeAll((sortByVipFlg(finalList,submitList)));
			}
			if (element.equalsIgnoreCase("name")) {
				finalListFromFinal.addAll(sortByName(finalList));
				finalList.removeAll(sortByName(finalList));
			}
		}

		return null;
	}

	private static List<Prson> sortByName(List<Prson> finalList) {
		List<Prson> sortedPerson = new ArrayList<Prson>(finalList);
//				Collections.sort(finalList,CustomSort.COMPARE_BY_PERSON_NAME);
		sortedPerson.sort(CustomSort.COMPARE_BY_PERSON_NAME);
		System.out.println("Sorted person is::");
		for (Prson person : sortedPerson) {
		System.out.println("Person is in submitList :: "+person.getName()+" "+person.getAge() + " " +person.getIsVip());
	}
				return sortedPerson;
	}

	private static List<Prson> sortByVipFlg(List<Prson> finalList, List<Prson> submitList) {
		System.out.println("Control came to vip flag validation");
		List<Prson> tempList = new ArrayList<Prson>();
		for (Prson person : finalList) {
			System.out.println("Finallist opened");
			if (person.getIsVip() == 'Y') {
				System.out.println("Added");
				submitList.add(person);
			} else {
				//tempList.add(person);
			}
//	private static void sortByNewAge(int limit, List<Prson>  finalList, int range,Map<String, Prson> newMap) {
//		for (Map.Entry<String, Prson> entry : newMap.entrySet()) {
//		    String key = entry.getKey();
//		    Prson value = entry.getValue();
//		}
		}
		for (Prson person : tempList) {
			submitList.add(person);
		}
//		System.out.println("Control is here also");
//		for (Prson person : submitList) {
//			System.out.println("Person is in submitList :: "+person.getName()+" "+person.getAge() + " " +person.getIsVip());
//		}
		return submitList;
	}
	
}
