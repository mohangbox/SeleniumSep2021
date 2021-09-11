package week1.day2Assignment;

import java.util.Arrays;

public class Frequencyofnumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 3, 4, 2, 5, 1, 2, 6, 3, 6, 2, 4, 7, 1 };
		int[] arr1 = new int[arr.length];
		int visited = -1;
		Arrays.sort(arr);
//1,1,2,2,2,3,3,4,4,5,6,6,7
		for (int i = 0; i < arr.length; i++) {
			int count = 0;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					count++;

				}
			}

			System.out.println("The freq of the number is " + arr1[i]);
		}
	}

}
