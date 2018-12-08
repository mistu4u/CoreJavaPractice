package test;

import java.util.Arrays;

public class FindMissingNumber {

	public static void main(String[] args) {
		int arr[] = new int[] { 4, 2, 1 };
		Arrays.sort(arr);
		int sum = Arrays.stream(arr).sum();
		int n =4;
		int total = n*(n+1)/2;
		System.out.println("The total is ::"+total+ " the sum is "+sum);
		System.out.println("The missing number is :: "+(total -sum));
	}

}
