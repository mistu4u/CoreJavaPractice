package test;

public class NextBigWord {

	public static void main(String[] args) {
		String word = "abd";
		String nextBigWord = rearrangeWord(word);
		System.out.println(nextBigWord);
	}

	private static String rearrangeWord(String word) {
		// TODO Auto-generated method stub
		char arr[] = word.toCharArray();
		char wordFound = 'Y';
		String rearrangeWord = "";
		int i = arr.length - 1;
		while (i > 0 && arr[i - 1] >= arr[i]) {
			i--;
		}

		if (i <= 0) {
			rearrangeWord = "no answer";
			wordFound = 'N';
		}
		if (wordFound == 'Y') {
			int j = arr.length - 1;
			System.out.println("i is " + i);
			System.out.println("j is " + j);
			while (arr[j] <= arr[i - 1]) {
				j--;
			}

			char temp = arr[i - 1];
			arr[i - 1] = arr[j];
			arr[j] = temp;

			j = arr.length - 1;

			while (i < j) {
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
		if (wordFound == 'Y') {
			rearrangeWord = new String(arr);
		}
		else {
			rearrangeWord = "no answer";
		}
		return rearrangeWord;
	}

}
