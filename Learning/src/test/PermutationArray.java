package test;

import java.util.Arrays;

public class PermutationArray {

	public static void main(String[] args) {
		char isPermutated = 'Y';
		int arr[] = new int[] { 4, 2, 1 };
		Arrays.sort(arr);
		System.out.println("the array after sorting is :: ");
		for (int b : arr) {
			System.out.println(b);
		}
		System.out.println("length is :: " + arr.length);
		for (int i = 0; i < arr.length-1; i++) {
			if (arr[i]  != (i + 1)) {
				isPermutated = 'N';
			} 
		}
		System.out.println("The array is permutated (Y for yes and N for No) :: " + isPermutated);
	}

}
