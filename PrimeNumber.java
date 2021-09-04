package week1.day1Assignment;

public class PrimeNumber {

	/*
	 * Goal: To find whether a number is a Prime number or not
	 * 
	 * input: 13 output: 13 is a Prime Number
	 * 
	 * Shortcuts: 1) Print : type: syso, followed by: ctrl + space + enter 2) To
	 * create a 'for' loop: type 'for', followed by ctrl + space + down arrow +
	 * enter 3) To create an 'if' condition: type 'if', followed by ctrl + space
	 * +down arrow + enter
	 * 
	 * What are my learnings from this code? 1) 2) 3)
	 * 
	 */

	public static void main(String[] args) {
		int input = 13;
		boolean flag = false;

		if (input == 0 || input == 1) {
			System.out.println(input + " is not Prime Number");
		} else
			for (int i = 2; i < input / 2; i++) {
				if (input % i == 0) {
					flag = true;
					break;
				}
			}
		if (flag == true) {
			System.out.println(input + " is not Prime Number");
		} else {
			System.out.println(input + " is Prime Number");
		}
	}
}
