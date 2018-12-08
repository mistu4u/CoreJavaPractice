package interview;


public class SortedList {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6 };
		printSetsWithSumLessThanTen(arr);
	}

	private static void printSetsWithSumLessThanTen(int[] arr) {
		int len  = arr.length;
		int sum = 10;
		int ans = 0;
		//System.out.println("Length of the array is :: "+ len);
		for(int i = 0 ;i <len -2 ;i ++) {
			//System.out.println("Inside I");
			for(int j = i+1; j<len -1; j++) {
				//System.out.println("Inside J");
				for(int k = j+1; k<len; k++ ) {
					//System.out.println("Inside K");
					//System.out.println("arr[i],arr[j] and arr[k] is :: "+ arr[i] + " " + arr[j] + " " + arr[k]);
					if(arr[i] + arr[j] + arr[k] < sum) {
						ans++;
						System.out.println("The triplet is :: "+ arr[i] + " " + arr[j] + " " + arr[k]);
					}
				}
			}
		}
		System.out.println("The number of triplets is :: "+ ans);
	}
}
