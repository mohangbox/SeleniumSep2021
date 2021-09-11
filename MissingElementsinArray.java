package week1.day2Assignment;

import java.util.Arrays;

public class MissingElementsinArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 3, 4, 7, 6, 8 };
		Arrays.sort(arr);
		// 1,2,3,4,6,7,8
		for (int i = 1; i < arr.length; i++) {
			if (i != arr[i - 1]) {
				System.out.println("The missing number is: " + i);
				break;
			}

		}

	}
}
