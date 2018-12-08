package test;

import java.util.Arrays;

public class SmallestPossibleNumber {

	public static void main(String[] args) {
		int[] A = new int[] { 1, 3, 6, 4, 1, 2 };
		int result = solution(A);
		System.out.println(result);
	}

 public static int solution(int[] A) {
		        int[] AN = Arrays.stream(A).filter(n -> n > 0).distinct().sorted().toArray();
		        	int N = AN.length;
		        	int MIN = 1;
		        
				for (int i = 0; i < N; i++) {
				    MIN = i+1;
				    if (AN[i] != MIN) {
				        return MIN;
				    } 
				    else if (MIN == N) {
				        return ++MIN;
				    }
				}
				return MIN;
			}
}

